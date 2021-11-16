package kadamm.hibernate.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;

import kadamm.hibernate.model.Usuari;
import kadamm.hibernate.util.HibernateUtil;

public class UsuariDao {
	
	public UsuariDao() {
		
	}
	
	public void saveUsuari(Usuari usuari) {
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
	
	public void updateUsuari(Usuari usuari) {
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
	
	public Usuari getUsuariByID(long id) {
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
	
	public void removeUsuari(Usuari usuari) {
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
	
	public Usuari getUsuariByName(String nom) {
		System.out.println("Entrando a la funcion");
		Transaction transaction = null;
		System.out.println("transaccion null");
		Usuari usuari = null;
		System.out.println("Usuario null");
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start the transaction
			transaction = session.beginTransaction();
			System.out.println("Begin transaction");
			System.out.println(nom);
			
			
			// get student object
			usuari = (Usuari) session.createQuery("FROM Usuari WHERE nickName = '"+nom+"'").list().get(0);
			System.out.println("get student object");
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