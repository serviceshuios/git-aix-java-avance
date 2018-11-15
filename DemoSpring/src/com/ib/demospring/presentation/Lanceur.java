package com.ib.demospring.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ib.demospring.metier.Developpeur;
import com.ib.demospring.metier.SocieteDevLogiciel;

public class Lanceur {

	public static void main(String[] args) {
		// 1- charger le conteneur spring
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2- récupération des beans
		Developpeur developpeur = context.getBean("dev1", Developpeur.class);
		Developpeur developpeur2 = context.getBean("dev2", Developpeur.class);
		SocieteDevLogiciel societe = context.getBean("societe", SocieteDevLogiciel.class);
		//3- utilisation des beans récupérés
		developpeur2.setNom("zec");
		developpeur2.setAnneesExperience(40);
		System.out.println(developpeur);
		System.out.println(developpeur2);
		System.out.println(societe);
		//4- fermeture du contexte spring
		context.close();

	}

}
