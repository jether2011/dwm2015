/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.dao;

import br.unisal.hibernateutil.HibernateUtil;
import br.unisal.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jether
 */
public class PessoaDao {

    public void insert(Pessoa s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PessoaDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public void update(Pessoa s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PessoaDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Pessoa> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Pessoa> sensores = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Pessoa");
            sensores = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PessoaDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return sensores;
    }

    public Pessoa getById(Pessoa s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Pessoa sensor = new Pessoa();
        try {
            tx.begin();
            Query query = session
                    .createQuery("FROM Pessoa WHERE idPessoa = :id");
            query.setParameter("id", s.getIdPessoa());
            sensor = (Pessoa) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PessoaDao.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return sensor;
    }

    public void remove(Pessoa s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PessoaDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

}
