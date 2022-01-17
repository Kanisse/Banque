package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Model.DataUsers;
import Model.Users;


/**
 * Servlet implementation class TraitementUsers
 */
@WebServlet("/TraitementUsers")
public class TraitementUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitementUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp=null;
		disp=request.getRequestDispatcher("Acceuil.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session =request.getSession();
		String log=request.getParameter("login");
		String pass=request.getParameter("password");

		RequestDispatcher disp=null;
		DataUsers bd=new DataUsers();
		ArrayList <Users> liste=new ArrayList<Users>();
		
		liste =bd.RechercheUser(log,pass );
		
		if(liste.size()!=0)
		{
		session.setAttribute("liste",liste);
		disp=request.getRequestDispatcher("Acceuil.jsp");
		disp.forward(request, response);
		
		}else
		{	response.sendRedirect("Log_error.jsp");
			
		}
		
	}

}
