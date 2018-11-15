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
	 * méthode d'ajout d'une transaction en base de données
	 * @param t transaction à ajouter
	 * @return 1 si ok et 0 si pas ok
	 */
	public int ajouterTransaction(Transaction t);
	/**
	 * méthode de modification d'une transaction en base de données
	 * @param t transaction à modifier
	 * @return 1 si ok et 0 si pas ok
	 */
	public int modifierTransaction(Transaction t);
	/**
	 * méthode de suppression d'une transaction en base de données
	 * @param t transaction à supprimer
	 */
	public void supprimerTransaction(Transaction t);
	/**
	 * méthode de récupération de la transaction à partir de son identifiant
	 * @param numero identifiant de la transaction
	 * @return Transaction 
	 */
	public Transaction recupererTransaction(int numero);
	/**
	 * méthode de listage des transactions
	 * @return toutes les transactions
	 */
	public List<Transaction> ListerTransaction();
}
