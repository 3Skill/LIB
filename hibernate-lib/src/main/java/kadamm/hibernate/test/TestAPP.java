package kadamm.hibernate.test;

import kadamm.hibernate.dao.UsuariDao;
import kadamm.hibernate.model.Usuari;

public class TestAPP {
	
	public TestAPP() {
		
	}

	public static void main(String[] args) {
		UsuariDao usuariDao = new UsuariDao();
		
		Usuari usuari = new Usuari("Arzzet", "pepe1234");
		Usuari usuari1 = new Usuari("VMV", "VMerchanHitler");
		Usuari usuari2 = new Usuari("JoseMRN", "Coleta69");

		
		usuariDao.guardarUsuari(usuari);
		usuariDao.guardarUsuari(usuari1);
		usuariDao.guardarUsuari(usuari2);
		
		usuari2.setNickName("JoseColeta");
		
		usuariDao.actualitzarUsuari(usuari2);
		
//		Usuari usuariRecuperat = usuariDao.recuperarUsuariPerID(1);
//		System.out.println(usuariRecuperat.getNickName()+ " " + usuariRecuperat.getPassword());
		
		Usuari usuariPerNom;
		try {
			usuariPerNom = usuariDao.recuperarUsuariPerNom("Arzzet");
			System.out.println(usuariPerNom.getNickName()+ " " + usuariPerNom.getPassword());
		} catch (IllegalStateException e) {
			System.out.println("El usuario no existe");
			
		}
		
		
		

	}

}