package com.ib.demoJPA.presentation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ib.demoJPA.metier.Adresse;
import com.ib.demoJPA.metier.Contact;
import com.ib.demoJPA.metier.Film;
import com.ib.demoJPA.metier.LongMetrage;
import com.ib.demoJPA.metier.Telefilm;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 : Ouvrir unité de persistence JPA : 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		//2- Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//3-réalisation de la requête
		//Test ajout
		/*Adresse a = new Adresse();
		a.setCodePostal("31000");
		a.setRue("11 rue saragosse");
		a.setVille("Toulouse");
		em.persist(a);
		
		Contact c =new Contact();
		c.setNom("ZEC2");
		c.setPrenom("UNION2");
		c.setEmail("zecunion2@gmail.com");
		c.setAdresse(a);	
		em.persist(c);*/
		// Test récupération
		/*Adresse a1 = em.find(Adresse.class, 3);
		System.out.println(a1);
		// Test mise à jour
		a1.setVille("Aix en provence");
		a1.setCodePostal("13090");
		em.merge(a1);
		System.out.println(a1);*/
		//Test suppression
		/*Contact c1 = em.find(Contact.class, 2);
		em.remove(c1);*/
		/*Film f = new Film();
		f.setNomFilm("Alien");
		em.persist(f);
		
		Film f2 = new Film();
		f2.setNomFilm("la mémoire dans la peau");
		em.persist(f2);
		
		Film f3 = new Film();
		f3.setNomFilm("le livre d'elite");
		em.persist(f3);*/
		/*LongMetrage lm = new LongMetrage();
		lm.setCinema("UGC");
		lm.setNomFilm("aladeux");
		em.persist(lm);
		
		Telefilm tf = new Telefilm();
		tf.setNomFilm("joséphine ange gardien");
		tf.setChaine("TF1");
		em.persist(tf);*/
		// liste des films
		Query query = em.createQuery("Select f FROM Film f");
		List<Film> mesFilms = query.getResultList();
		
		for (Film film : mesFilms) {
			System.out.println(film);
		}
		
		//4- Fermeture de la transaction
		tx.commit();
		//5- Fermeture de l'unité de persistence
		em.close();
		emf.close();
		
	}

}
