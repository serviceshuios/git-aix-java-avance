package com.ib.bddpersonnesjee.controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.bddpersonnesjee.metier.Personne;
import com.ib.bddpersonnesjee.service.Iservice;
import com.ib.bddpersonnesjee.service.ServiceImpl;

/**
 * Servlet implementation class SupprimerController
 */
@WebServlet("/SupprimerController")
public class SupprimerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// faire appel à la couche service
		Iservice service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1- récupérer le paramètre passé via l'url
		int monId = Integer.parseInt(request.getParameter("id"));
		//2- faire appel à la couche service
		Personne p = service.recupererPersonne(monId);
		service.supprimerPersonne(p);
		//3- faire l'appel à l'affichage
		request.getRequestDispatcher("/ListerPersonnes").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
