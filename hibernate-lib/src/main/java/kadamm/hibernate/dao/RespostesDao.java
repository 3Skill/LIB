package kadamm.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import kadamm.hibernate.model.Concursant;
import kadamm.hibernate.model.Preguntes;
import kadamm.hibernate.model.Respostes;
import kadamm.hibernate.model.Usuari;
import kadamm.hibernate.util.HibernateUtil;

public class RespostesDao {

 // Create a method to save a Respostes object
 public void saveResposta(Respostes resposta) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction tx = null;
     try {
         tx = session.beginTransaction();
         session.save(resposta);
         tx.commit();
     } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
     } finally {
         session.close();
     }
 }

 // Create a method to update a Respostes object
 public void updateResposta(Respostes resposta) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction tx = null;
     try {
         tx = session.beginTransaction();
         session.update(resposta);
         tx.commit();
     } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
     } finally {
         session.close();
     }
 }

 // Create a method to delete a Respostes object
 public void removeResposta(Respostes resposta) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction tx = null;
     try {
         tx = session.beginTransaction();
         session.delete(resposta);
         tx.commit();
     } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
     } finally {
         session.close();
     }
 }

 // Create a method to get a Respostes object
 public Respostes getRespostaByID(long id) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     Respostes resposta = null;
     try {
    	 resposta = (Respostes) session.get(Respostes.class, id);
     } catch (HibernateException e) {
         e.printStackTrace();
     } finally {
         session.close();
     }
     return resposta;
 }
 
 public Respostes getRespostaByText(String text) {
 	Transaction transaction = null;
 	Respostes resposta = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			resposta = (Respostes) session.createQuery("from Respostes where descripcio = '" + text + "'").list().get(0);
			transaction.commit();
		} catch (HibernateException he) {
			// TODO Auto-generated catch block
			he.printStackTrace();
		}
     return resposta;

 }
 
 public List<Respostes> getRespostesByPreguntaId(long id){
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 List<Respostes> respostes = null;
	 try {
		 respostes = session.createQuery("from Respostes where preguntes = " + id).list();
//    	 respostes = (List<Respostes>)session.get(Respostes.class, id);
//		 respostes = (List<Respostes>) session.createQuery("FROM respostes WHERE idPreguntes = :idPreguntes").setParameter("idPreguntes", id).list();
     } catch (HibernateException e) {
         e.printStackTrace();
     } finally {
         session.close();
     }
     return respostes;
 }
 
// // Create a method to get the correct Respostes object
// public Respostes getRespostaCorrecta(Preguntes pregunta) {
//     Session session = HibernateUtil.getSessionFactory().openSession();
//     Respostes r = null;
//     try {
//         r = (Respostes) session.get(Respostes.class, id);
////    	 r = (Respostes) session.createQuery("FROM Respostes WHERE idPreguntes = '"+pregunta.getIdPreguntes()+"' AND respostaCorrecta = '"+true+"'").list().get(0);
//     } catch (HibernateException e) {
//         e.printStackTrace();
//     } finally {
//         session.close();
//     }
//     return r;
// }





}
