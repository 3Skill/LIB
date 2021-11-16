package kadamm.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import kadamm.hibernate.model.Kahoot;
import kadamm.hibernate.util.HibernateUtil;

public class KahootDao {
    // create method to save a new kahoot in database with hibernate
    public void saveKahoot(Kahoot kahoot) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(kahoot);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    // create method to update a kahoot in database with hibernate
    public void updateKahoot(Kahoot kahoot) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(kahoot);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // create method to delete a kahoot in database with hibernate
    public void removeKahoot(Kahoot kahoot) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(kahoot);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // create method to get a kahoot from database with hibernate by id
    public Kahoot getKahoot(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Kahoot kahoot = null;
        try {
            transaction = session.beginTransaction();
            kahoot = (Kahoot) session.get(Kahoot.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kahoot;
    }

    // create method to get all kahoots from database with hibernate
    public List<Kahoot> getAllKahoots() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Kahoot> kahoots = null;
        try {
            transaction = session.beginTransaction();
            kahoots = (List<Kahoot>)session.createQuery("FROM Kahoot").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kahoots;
    }

    // create method to get a kahoot from database with hibernate by name
    public Kahoot getKahootByName(String name) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Kahoot kahoot = null;
        try {
            transaction = session.beginTransaction();
            kahoot = (Kahoot) session.createQuery("FROM Kahoot WHERE name = :name").setParameter("name", name).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kahoot;
    }
}