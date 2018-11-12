package com.ib.bddpersonnesjee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ib.bddpersonnesjee.metier.Personne;


public class DaoImpl implements Idao {

	// informations d'acc�s � la base de donn�es
	String url="jdbc:mysql://localhost:3306/personnes" + 
			"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	String login="root";
	String mdp="";
	
	//initialisation des variables java permettant de dialoguer avec la BDD 
	//connecter � la base de donn�es
	Connection cn = null;
	// executer la requ�te
	PreparedStatement st=null;
	// r�cup�rer le r�sultat de la requ�te
	ResultSet rs = null;
	
	@Override
	public int ajouterPersonne(Personne p) {
		
		try {
			//1- Charger le driver : plus obligatoire dans les versions r�centes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Cr�er la connexion � la base de donn�es
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Pr�parer la requ�te
			String sql="INSERT INTO personne(nom,prenom,age) VALUES(?,?,?)";
			//4- Cr�er l'objet statement
			st=cn.prepareStatement(sql);
			 //-- passage de param�tres ----
			st.setString(1, p.getNom());
			st.setString(2, p.getPrenom());
			st.setInt(3, p.getAge());
			//-- fin passage de param�tres---
			
			//5- Ex�cuter la requ�te
			st.executeUpdate();
			//6- R�cup�rer le r�sultat de la requ�te (lorsqu'on a fait un select)
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
			//1- Charger le driver : plus obligatoire dans les versions r�centes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Cr�er la connexion � la base de donn�es
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Pr�parer la requ�te
			String sql="UPDATE personne SET nom=?, prenom=?, age=? where id=?";
			//4- Cr�er l'objet statement
			st=cn.prepareStatement(sql);
			 //-- passage de param�tres ----
			st.setString(1, p.getNom());
			st.setString(2, p.getPrenom());
			st.setInt(3, p.getAge());
			st.setInt(4, p.getId());
			//5- Ex�cuter la requ�te
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
			//1- Charger le driver : plus obligatoire dans les versions r�centes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Cr�er la connexion � la base de donn�es
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Pr�parer la requ�te
			String sql="DELETE FROM personne where id = ?";
			//4- Cr�er l'objet statement
			st=cn.prepareStatement(sql);
			//--- passage de param�tre ----
			st.setInt(1, p.getId());
			// execution de la requ�te
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
			//1- Charger le driver : plus obligatoire dans les versions r�centes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Cr�er la connexion � la base de donn�es
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Pr�parer la requ�te
			String sql="SELECT * FROM personne where id = ?";
			//4- Cr�er l'objet statement
			st=cn.prepareStatement(sql);
			//--- passage de param�tre ----
			st.setInt(1, numero);
			//excuter la requ�te
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
			//1- Charger le driver : plus obligatoire dans les versions r�centes du connecteur mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2-Cr�er la connexion � la base de donn�es
			cn = DriverManager.getConnection(url, login, mdp);
			//3- Pr�parer la requ�te
			String sql="SELECT * FROM personne";
			//4- Cr�er l'objet statement
			st=cn.prepareStatement(sql);
			//5- Ex�cuter la requ�te
			rs=st.executeQuery();
			//6- r�cup�ration du r�sultat
				while(rs.next()) {
					// cr�er un objet de type personne
					Personne p = new Personne();
					p.setId(rs.getInt("id"));
					p.setNom(rs.getString("nom"));
					p.setPrenom(rs.getString("prenom"));
					p.setAge(rs.getInt("age"));
					// ajouter l'objet cr�� � la liste personnes
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
