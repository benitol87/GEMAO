package fr.gemao.view.cours;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

@WebServlet(Pattern.COURS_AJOUTEDT)
public class AjouterEDTServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		List<String> jour = new ArrayList<String>();
		jour.add("");
		jour.add("Lundi");
		jour.add("Mardi");
		jour.add("Mercredi");
		jour.add("Jeudi");
		jour.add("Vendredi");
		request.setAttribute("Jour", jour);
        this.getServletContext().getRequestDispatcher( JSPFile.COURS_AJOUTEDT ).forward( request, response );
	}

}
