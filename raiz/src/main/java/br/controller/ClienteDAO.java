/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.model.Cliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author azaroth
 */
public class ClienteDAO {

    public Session session;

    public ClienteDAO() {
    }

    public void inserir(Cliente cliente) {
        session = (Session) HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }

    public void alterar(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(cliente);
            session.getTransaction().commit();
        } finally {
            session.close();

        }
    }
    
    public Cliente validar(String email, String password) {
        session = HibernateUtil.getSessionFactory().openSession();
        Cliente cli = null;
        try {
            Cliente test = null;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria c = session.createCriteria(Cliente.class);
            c.add(Restrictions.like("email",email));
            test = (Cliente) c.uniqueResult();
            System.out.println(test.getEmail());
            if (test.getSenha().equals(password)) cli = test;
            session.getTransaction().commit();
        }
        catch(NullPointerException e){
            return null;
        }
        finally {
            session.close();
        }
        if (cli == null) return null;
        return cli;
    }

    public void excluir(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> listar() {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cri = session.createCriteria(Cliente.class);
            return cri.list();
        } finally {
            session.close();

        }
    }

}
