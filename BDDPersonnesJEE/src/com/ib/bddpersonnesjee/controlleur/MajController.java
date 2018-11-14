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
 * Servlet implementation class MajController
 */
@WebServlet("/MajController")
public class MajController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Iservice service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Personne p = new Personne();
		p.setId(id);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAge(age);
		
		service.modifierPersonne(p);
		request.getRequestDispatcher("/ListerPersonnes").forward(request, response);

		
	}

}
