package com.ib.architecture.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ib.architecture.metier.Transaction;
import com.ib.architecture.service.Iservice;
import com.ib.architecture.service.ServiceImpl;
/**
 * Classe de lancement du programme
 * @author ib
 *
 */
public class Lanceur {
	/**
	 * méthode main
	 * @param args paramètres de lancement
	 */
	public static void main(String[] args) {
		//- initialiser le conteneur
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//- récupérer les beans
		Transaction t = context.getBean("transaction", Transaction.class);
		Iservice service = context.getBean("serviceImpl", ServiceImpl.class);
		//- utiliser les beans
		service.ajouterTransaction(t);
		//- fermer le contexte
		context.close();
	}

}
