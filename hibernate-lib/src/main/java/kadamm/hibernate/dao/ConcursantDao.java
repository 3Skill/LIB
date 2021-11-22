package kadamm.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import kadamm.hibernate.model.Concursant;
import kadamm.hibernate.util.HibernateUtil;

public class ConcursantDao {
    
    public ConcursantDao() {
    }

    public Concursant getConcursantById(long id) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Concursant concursant = session.get(Concursant.class, id);
        session.close();
        return concursant;
    }

    public void saveConcursant(Concursant concursant) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(concursant);
        transaction.commit();
        session.close();
    }

    public void updateConcursant(Concursant concursant) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(concursant);
        transaction.commit();
        session.close();
    }

    public void deleteConcursant(Concursant concursant) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(concursant);
        transaction.commit();
        session.close();
    }

    public List<Concursant> getAllConcursants() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<Concursant> concursants = session.createQuery("from Concursant").list();
        session.close();
        return concursants;
    }
    
    public List<Concursant> getConcursantsByName(String name) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<Concursant> concursants = session.createQuery("from Concursant where concursantName = '" + name + "'").list();
        session.close();
        return concursants;
    }
    
    public List<Concursant> getConcursantsByConcursId(int id) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<Concursant> concursants = session.createQuery("from Concursant where concursId = '" + id + "'").list();
        session.close();
        return concursants;
    }
    
}
