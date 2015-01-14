
package fr.gemao.view.personnel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjoutPersonnelServlet
 */
@WebServlet("/AjoutPersonnel")
public class AjoutPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String VUE = "/WEB-INF/pages/personnel/ajoutPersonnel.jsp";

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
		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 */
		/*String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        String dateNaissance = request.getParameter( "date" );
        String telFixe = request.getParameter( "fixe" );
        String telPortable = request.getParameter( "portable" );
        String mail = request.getParameter("email");
        String numAdresse = request.getParameter("num");
        String codePostal = request.getParameter("code");
        String ville = request.getParameter("ville");
        String diplome = request.getParameter("diplome");
        String fonction = request.getParameter("fonction");
        
        String contrat = request.getParameter("type");
        String debcontrat = request.getParameter("datedeb");
        String duree = request.getParameter("duree");
        String fincontrat = request.getParameter("datefin");
        */
        
		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext()
				.getRequestDispatcher(VUE)
				.forward(request, response);
	}

}

