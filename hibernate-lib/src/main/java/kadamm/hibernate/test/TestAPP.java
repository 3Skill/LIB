package kadamm.hibernate.test;

import kadamm.hibernate.dao.*;
import kadamm.hibernate.model.*;

public class TestAPP {
	
	public TestAPP() {
		
	}

	public static void main(String[] args) {
		UsuariDao usuariDao = new UsuariDao();
		
		Usuari usuari = new Usuari("Arzzet", "pepe1234");
		Usuari usuari1 = new Usuari("VMV", "VMerchanHitler");
		Usuari usuari2 = new Usuari("JoseMRN", "Coleta69");
		
		usuariDao.saveUsuari(usuari);
		usuariDao.saveUsuari(usuari1);
		usuariDao.saveUsuari(usuari2);

	}

}