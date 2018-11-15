package com.ib.demospring.metier;

public class Developpeur {
	private String nom;
	private int anneesExperience;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAnneesExperience() {
		return anneesExperience;
	}
	public void setAnneesExperience(int anneesExperience) {
		this.anneesExperience = anneesExperience;
	}
	@Override
	public String toString() {
		return "Developpeur [nom=" + nom + ", anneesExperience=" + anneesExperience + "]";
	}

}
