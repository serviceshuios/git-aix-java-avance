package com.ib.jeeHibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.jeeHibernate.service.Iservice;
import com.ib.jeeHibernate.service.ServiceImpl;



/**
 * Servlet implementation class RecupController
 */
@WebServlet("/RecupController")
public class RecupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Iservice service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("pers", service.recupererPersonne(id));
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
