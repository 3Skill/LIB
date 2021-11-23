package kadamm.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import kadamm.hibernate.model.Concurs;
import kadamm.hibernate.model.Concursant;
import kadamm.hibernate.util.HibernateUtil;

public class ConcursDao {
    
    
    public ConcursDao() {
    }
    
    public void addConcurs(Concurs concurs, List<Concursant> concursants) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(concurs);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void updateConcurs(Concurs concurs) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(concurs);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public Concurs getConcursById(int id) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Concurs concurs = null;
        try {
            tx = session.beginTransaction();
            concurs = (Concurs) session.get(Concurs.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return concurs;
    }
    
    public void deleteConcurs(Concurs concurs) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(concurs);
            tx.commit();
            
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            
        } finally {
            session.close();
            
        }
        
    }

	public void addConcurs(Concurs concurs) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(concurs);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}   
}
