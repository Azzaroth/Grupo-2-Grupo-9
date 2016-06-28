package br.controller;

import br.model.Produto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author azaroth
 */
public class ProdutoDAO {

    public Session session;

    public ProdutoDAO() {
    }

    public void inserir(Produto produto) {
        session = (Session) HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(produto);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }

    public void alterar(Produto produto) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(produto);
            session.getTransaction().commit();
        } finally {
            session.close();

        }
    }

    public void excluir(Produto produto) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(produto);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }

    @SuppressWarnings("unchecked")
    public List<Produto> listar() {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cri = session.createCriteria(Produto.class);
            return cri.list();
        } finally {
            session.close();

        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Produto> listarEspecifico(String categoria) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria cri = session.createCriteria(Produto.class);
            cri.add(Restrictions.like("categoria",categoria));
            return cri.list();
        } finally {
            session.close();

        }
    }
    
    @SuppressWarnings("unchecked")
    public String getNomeProduto(Long id) {System.out.println("id: "+id);
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria cri = session.createCriteria(Produto.class);
            //cri.add(Restrictions.like("id",id));
            //Produto p = (Produto) cri.uniqueResult();
            //System.out.println(p.getModelo());
            //return p.getModelo();
            return ""+id;
        } finally {
            session.close();

        }
    }

}
