package com.ib.demoJPA.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 : Ouvrir unité de persistence JPA : 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
	}

}
