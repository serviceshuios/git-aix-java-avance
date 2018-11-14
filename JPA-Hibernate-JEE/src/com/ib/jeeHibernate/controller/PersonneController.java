package com.ib.jeeHibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.jeeHibernate.metier.Personne;
import com.ib.jeeHibernate.service.Iservice;
import com.ib.jeeHibernate.service.ServiceImpl;


/**
 * Servlet implementation class PersonneController
 */
@WebServlet("/PersonneController")
public class PersonneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// faire appel à la couche service
	Iservice service = new ServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1- récupération des paramètres
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));

		// 2- appel de la couche service (modèle)
		Personne p = new Personne();
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAge(age);
		service.ajouterPersonne(p);
		// 3- appel à l'affichage
		// 1-récupérer les personnes de la base de données
		/*List<Personne> pers = service.ListerPersonnes();
		request.setAttribute("laListe", pers);
		request.getRequestDispatcher("/personnes.jsp").forward(request, response);*/
		response.sendRedirect(request.getContextPath() + "/ListerPersonnes");
	}

}
