package com.ib.jeeHibernate.service;

import java.util.List;

import com.ib.jeeHibernate.metier.Personne;


public interface Iservice {
	/**
	 * m�thode d'ajout d'une personne en base de donn�es
	 * @param p personne � ajouter
	 * @return 1 si ok et 0 si pas ok
	 */
	public int ajouterPersonne(Personne p);
	/**
	 * m�thode de modification d'une transaction en base de donn�es
	 * @param p personne � modifier
	 * @return 1 si ok et 0 si pas ok
	 */
	public int modifierPersonne(Personne p);
	/**
	 * m�thode de suppression d'une personne en base de donn�es
	 * @param p personne � supprimer
	 */
	public void supprimerPersonne(Personne p);
	/**
	 * m�thode de r�cup�ration de la personne � partir de son identifiant
	 * @param numero identifiant de la personne
	 * @return Personne 
	 */
	public Personne recupererPersonne(int numero);
	/**
	 * m�thode de listage des personnes
	 * @return toutes les personnes
	 */
	public List<Personne> ListerPersonnes();
	
}
