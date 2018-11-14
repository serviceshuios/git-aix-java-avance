package com.ib.jeeHibernate.service;

import java.util.List;

import com.ib.jeeHibernate.metier.Personne;


public interface Iservice {
	/**
	 * méthode d'ajout d'une personne en base de données
	 * @param p personne à ajouter
	 * @return 1 si ok et 0 si pas ok
	 */
	public int ajouterPersonne(Personne p);
	/**
	 * méthode de modification d'une transaction en base de données
	 * @param p personne à modifier
	 * @return 1 si ok et 0 si pas ok
	 */
	public int modifierPersonne(Personne p);
	/**
	 * méthode de suppression d'une personne en base de données
	 * @param p personne à supprimer
	 */
	public void supprimerPersonne(Personne p);
	/**
	 * méthode de récupération de la personne à partir de son identifiant
	 * @param numero identifiant de la personne
	 * @return Personne 
	 */
	public Personne recupererPersonne(int numero);
	/**
	 * méthode de listage des personnes
	 * @return toutes les personnes
	 */
	public List<Personne> ListerPersonnes();
	
}
