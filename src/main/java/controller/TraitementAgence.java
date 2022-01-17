package controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Agence;
import Model.DataAgence;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class TraitementAgence
 */
@WebServlet("/TraitementAgence")
public class TraitementAgence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitementAgence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		RequestDispatcher disp=null;
		String lien =request.getParameter("lien");
		int id=(Integer.parseInt(request.getParameter("libelle")));
		DataAgence bd=new DataAgence();
		ArrayList <Agence> liste=new ArrayList<Agence>();
		
		
		if(lien.equals("aff")) {


		liste =bd.AfficheListe();
		request.setAttribute("liste",liste);
		 disp = request.getRequestDispatcher("AfficheAgence.jsp");
		disp.forward(request, response);
		
		}		
		else if(lien.equals("supp")) {
			
			bd.SupprimerAgence(id);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("AfficheAgence.jsp");
			disp.forward(request, response);
			
			//System.out.println("C'est une tentative de suppression de l'agence numéro "+id);
		}
		else if(lien.equals("modif")) {
			
			Agence a=bd.RechercherAgence(id);
			request.setAttribute("a", a);
			disp=request.getRequestDispatcher("modifAgence.jsp");
			disp.forward(request, response);
			//System.out.println("C'est une tentative de modification de l'agence numéro "+id);
		}
		
		if(lien.equals("add")) {
		request.getRequestDispatcher("AddAgence.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Agence> liste=new ArrayList<Agence>();
		RequestDispatcher disp=null;
		
		String nom =request.getParameter("NomAgence");
		String adresse=request.getParameter("AdresseAgence");
		DataAgence db=new DataAgence();
		Agence a =new Agence();
		String boutton =request.getParameter("boutton");
		
		if(boutton.equals("Ajouter")) {
		a.setNomAg(nom);
		a.setAdresseAg(adresse);
		db.AjouterAgence(a);
		liste=db.AfficheListe();
		request.setAttribute("liste",liste);
		disp=request.getRequestDispatcher("AfficheAgence.jsp");
		disp.forward(request, response);
		}
		else if(boutton.equals("Modifier")) {
			
				
			int id =Integer.parseInt(request.getParameter("id"));
			db.ModifierAgence(a,id);
			liste=db.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("AfficheAgence.jsp");
			disp.forward(request, response);
		}
		
		
		
	}

}
