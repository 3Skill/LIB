package kadamm.hibernate.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import kadamm.hibernate.model.Preguntes;
import kadamm.hibernate.model.Usuari;
import kadamm.hibernate.util.HibernateUtil;

public class PreguntesDao {
    // Create method to save preguntes into database with hibernate
    public void savePregunta(Preguntes preguntes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(preguntes);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Create method to update preguntes into database with hibernate
    public void updatePregunta(Preguntes preguntes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(preguntes);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Create method to delete preguntes into database with hibernate
    public void removePregunta(Preguntes preguntes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(preguntes);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Create method to get preguntes from database with hibernate
    public Preguntes getPreguntaById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Preguntes preguntes = null;
        try {
            preguntes = (Preguntes) session.get(Preguntes.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return preguntes;
    }
    
    public Preguntes getPregunta(String text) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Preguntes preguntes = null;
        try {
            preguntes = (Preguntes) session.createQuery("FROM Preguntes WHERE descripcio = '"+text+"'").list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return preguntes;
    }

    // Create method to get all preguntes from database with hibernate
    public List<Preguntes> getAllPreguntes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Preguntes> preguntes = null;
        try {
            preguntes = (List<Preguntes>)session.createQuery("from Preguntes").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return preguntes;
    }

    // Create method to get all preguntes that belogns to a kahoot from database with hibernate
    public List<Preguntes> getAllPreguntesByKahoot(long idKahoot) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Preguntes> preguntes = new ArrayList<Preguntes>();
        try {
            preguntes = (List<Preguntes>)session.createQuery("from Preguntes where idKahoot = " + idKahoot).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return preguntes;
    }
    
    public List<Preguntes> getAllPreguntesByKahootName(String titolKahoot) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Preguntes> preguntes = new ArrayList<Preguntes>();
        try {
            preguntes = (List<Preguntes>)session.createQuery("from Preguntes INNER JOIN Kahoot on Preguntes.idKahoot = Kahoot.idKahoot where Kahoot.nom = " + titolKahoot).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return preguntes;
    }
    
    public List<Preguntes> getAllPreguntesWithoutKahoot() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Preguntes> preguntes = new ArrayList<Preguntes>();
        try {
            preguntes = (List<Preguntes>)session.createQuery("from Preguntes where idKahoot = NULL").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return preguntes;
    }


}
