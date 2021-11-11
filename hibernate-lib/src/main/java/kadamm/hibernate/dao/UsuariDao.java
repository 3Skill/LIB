package kadamm.hibernate.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;

import kadamm.hibernate.model.Usuari;
import kadamm.hibernate.util.HibernateUtil;

public class UsuariDao {
	
	public UsuariDao() {
		
	}
	
	public void guardarUsuari(Usuari usuari) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start the transaction
			transaction = session.beginTransaction();
			
			// save student object
			session.save(usuari);
			
			// commit the transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void actualitzarUsuari(Usuari usuari) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start the transaction
			transaction = session.beginTransaction();
			
			
			// update student object
			session.saveOrUpdate(usuari);
			
			// commit the transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Usuari recuperarUsuariPerID(long id) {
		Transaction transaction = null;
		Usuari student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object
			student = session.get(Usuari.class, id);
//			student = session.load(Student.class, id);
			
			// commit the transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}
	
	public void eliminarUsuari(Usuari usuari) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start the transaction
			transaction = session.beginTransaction();
			

			session.delete(usuari);

			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Usuari recuperarUsuariPerNom(String nom) {
		Transaction transaction = null;
		Usuari usuari = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object
			usuari = (Usuari) session.createQuery("from Usuari where nickName = '"+nom+"'").list().get(0);
//			student = session.load(Student.class, id);
			
			// commit the transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return usuari;
	}
	
	

}