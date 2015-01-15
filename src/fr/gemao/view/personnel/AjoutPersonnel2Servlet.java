package fr.gemao.view.personnel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.entity.Personnel;

/**
 * Servlet implementation class AjoutPersonnel2Servlet
 */
@WebServlet("/personnel/AjoutPersonnel2")
public class AjoutPersonnel2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String VUE = "/WEB-INF/pages/personnel/ajoutPersonnel2.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Personnel perso = (Personnel) session.getAttribute("personnel");
		System.out.println(perso);
		/**
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 */
		String contrat = request.getParameter("type");
		String debcontrat = request.getParameter("datedeb");
	    String duree = request.getParameter("duree");
	    String fincontrat = request.getParameter("datefin");
	    
	    /**
	     * Création du personnel
	     */
	    Date datedeb = new Date();
	    Date datefin = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        try{
        	datedeb = formatter.parse(debcontrat);
        	datefin = formatter.parse(fincontrat);
        } catch (ParseException e) {
			e.printStackTrace();
		}
        Personnel personnel= new Personnel();
        
        /* Transmission à la page JSP en charge de l'affichage des données */
     		this.getServletContext()
     				.getRequestDispatcher(VUE)
     				.forward(request, response);
	}

}
