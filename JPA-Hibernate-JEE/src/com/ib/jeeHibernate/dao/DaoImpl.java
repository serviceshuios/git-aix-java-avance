package com.ib.jeeHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ib.jeeHibernate.metier.Personne;

public class DaoImpl implements Idao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-jee-pu");

	     //puis dans chaque m�thode
		//1- d�clarer entityManager pour faire des requ�tes
		//2- d�clarer une transaction si n�cessaire
		//3- d�buter la transaction si n�cessaire
		//4- effectuer l'op�ration
		//5- valider l'op�ration si n�cessaire
		//6- fermer entityManager
	@Override
	public int ajouterPersonne(Personne p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		em.close();
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int modifierPersonne(Personne p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(p);
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public void supprimerPersonne(Personne p) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Personne pers = em.find(Personne.class, p.getId());
			em.remove(pers);
			tx.commit();
			em.close();
	}

	@Override
	public Personne recupererPersonne(int numero) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Personne p = em.find(Personne.class, numero);
		tx.commit();
		em.close();
		return p;
	}

	@Override
	public List<Personne> ListerPersonnes() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("SELECT p FROM Personne p");
		List<Personne> pers = query.getResultList();
		return pers;
	}
	
}
