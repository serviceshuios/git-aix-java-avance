package com.ib.jeeHibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.jeeHibernate.metier.Personne;
import com.ib.jeeHibernate.service.Iservice;
import com.ib.jeeHibernate.service.ServiceImpl;


/**
 * Servlet implementation class ListerPersonnes
 */
@WebServlet("/ListerPersonnes")
public class ListerPersonnes extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	// faire appel à la couche service
	Iservice service = new ServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerPersonnes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1-récupérer les personnes de la base de données
		List<Personne> pers = service.ListerPersonnes();
		//2- mettre la liste dans une variable
				//laListe=pers
		request.setAttribute("laListe", pers); 
		//3- envoyer cette variable à la jsp pour affichage
		request.getRequestDispatcher("/personnes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
