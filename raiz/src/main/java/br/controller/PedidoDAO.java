/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.model.Cliente;
import br.model.Pedido;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author azaroth
 */
public class PedidoDAO {
    
    public Session session;

    public PedidoDAO() {
    }

    public void inserir(Pedido pedido) {
        session = (Session) HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(pedido);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }


    @SuppressWarnings("unchecked")
    public List<Pedido> listar() {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cri = session.createCriteria(Pedido.class);
            return cri.list();
        } finally {
            session.close();

        }
    }
    
}
