package com.ib.architecture.metier;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	private int numeroTransaction;
	private double montant;
	private Date date;
	public int getNumeroTransaction() {
		return numeroTransaction;
	}
	public void setNumeroTransaction(int numeroTransaction) {
		this.numeroTransaction = numeroTransaction;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [numeroTransaction=" + numeroTransaction + ", montant=" + montant + ", date=" + date + "]";
	}

}
