package com.ib.bddpersonnesjee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ib.bddpersonnesjee.metier.Personne;


public class DaoImpl implements Idao {

	// informations d'accès à la base de données
	String url="jdbc:mysql://localhost:3306/personnes" + 
			"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	String login="root";
	String mdp="";
	
	//initialisation des variables java permettant de dialoguer avec la BDD 
	//connecter à la base de données
	Connection cn = null;
	// executer la requête
	PreparedStatement st=null;
	// récupérer le résultat de la requête
	ResultSet rs = null;
	
	@Override
	public int ajouterPersonne(Personne p) {
		
		try {
			//1- Charger le driver : plus obligatoire dans les versions récentes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Créer la connexion à la base de données
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Préparer la requête
			String sql="INSERT INTO personne(nom,prenom,age) VALUES(?,?,?)";
			//4- Créer l'objet statement
			st=cn.prepareStatement(sql);
			 //-- passage de paramètres ----
			st.setString(1, p.getNom());
			st.setString(2, p.getPrenom());
			st.setInt(3, p.getAge());
			//-- fin passage de paramètres---
			
			//5- Exécuter la requête
			st.executeUpdate();
			//6- Récupérer le résultat de la requête (lorsqu'on a fait un select)
			//7- fermer la connection 
			cn.close();
			//ajout OK retourne 1
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// ajout KO retourne 0
			return 0;
		}
		
	}

	@Override
	public int modifierPersonne(Personne p) {
		try {
			//1- Charger le driver : plus obligatoire dans les versions récentes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Créer la connexion à la base de données
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Préparer la requête
			String sql="UPDATE personne SET nom=?, prenom=?, age=? where id=?";
			//4- Créer l'objet statement
			st=cn.prepareStatement(sql);
			 //-- passage de paramètres ----
			st.setString(1, p.getNom());
			st.setString(2, p.getPrenom());
			st.setInt(3, p.getAge());
			st.setInt(4, p.getId());
			//5- Exécuter la requête
			st.executeUpdate();
			//7- fermer la connection 
			cn.close();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		try {
			//1- Charger le driver : plus obligatoire dans les versions récentes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Créer la connexion à la base de données
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Préparer la requête
			String sql="DELETE FROM personne where id = ?";
			//4- Créer l'objet statement
			st=cn.prepareStatement(sql);
			//--- passage de paramètre ----
			st.setInt(1, p.getId());
			// execution de la requête
			st.executeUpdate();
			
			cn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Personne recupererPersonne(int numero) {
		Personne p = new Personne();
		try {
			//1- Charger le driver : plus obligatoire dans les versions récentes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Créer la connexion à la base de données
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Préparer la requête
			String sql="SELECT * FROM personne where id = ?";
			//4- Créer l'objet statement
			st=cn.prepareStatement(sql);
			//--- passage de paramètre ----
			st.setInt(1, numero);
			//excuter la requête
			rs=st.executeQuery();
			
				rs.next();
				p.setId(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
		cn.close();
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Personne> ListerPersonnes() {
		List<Personne> personnes = new ArrayList<Personne>();
		try {
			//1- Charger le driver : plus obligatoire dans les versions récentes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Créer la connexion à la base de données
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Préparer la requête
			String sql="SELECT * FROM personne";
			//4- Créer l'objet statement
			st=cn.prepareStatement(sql);
			//5- Exécuter la requête
			rs=st.executeQuery();
			//6- récupération du résultat
				while(rs.next()) {
					// créer un objet de type personne
					Personne p = new Personne();
					p.setId(rs.getInt("id"));
					p.setNom(rs.getString("nom"));
					p.setPrenom(rs.getString("prenom"));
					p.setAge(rs.getInt("age"));
					// ajouter l'objet créé à la liste personnes
					personnes.add(p);
				}
			//7- fermer la connection 
			cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return personnes;
	}

}
