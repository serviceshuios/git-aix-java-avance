package com.ib.architecture.dao;

import java.util.List;

import com.ib.architecture.metier.Transaction;
/**
 * interface dao
 * @author ib
 *
 */
public interface Idao {
	/**
	 * m�thode d'ajout d'une transaction en base de donn�es
	 * @param t transaction � ajouter
	 * @return 1 si ok et 0 si pas ok
	 */
	public int ajouterTransaction(Transaction t);
	/**
	 * m�thode de modification d'une transaction en base de donn�es
	 * @param t transaction � modifier
	 * @return 1 si ok et 0 si pas ok
	 */
	public int modifierTransaction(Transaction t);
	/**
	 * m�thode de suppression d'une transaction en base de donn�es
	 * @param t transaction � supprimer
	 */
	public void supprimerTransaction(Transaction t);
	/**
	 * m�thode de r�cup�ration de la transaction � partir de son identifiant
	 * @param numero identifiant de la transaction
	 * @return Transaction 
	 */
	public Transaction recupererTransaction(int numero);
	/**
	 * m�thode de listage des transactions
	 * @return toutes les transactions
	 */
	public List<Transaction> ListerTransaction();
}
