package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.entity.Discipline;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.util.Civilite;
import fr.gemao.form.VerifierSyntaxePersonne;

/**
 * Servlet implementation class AjoutAdherent
 */
@WebServlet("/AjoutAdherent")
public class AjoutAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/adherent/ajoutAdherent.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 */
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("dateNaiss");
		String telFixe = request.getParameter("telFixe");
		String telPortable = request.getParameter("telPort");
		String email = request.getParameter("email");
		String comNaiss = request.getParameter("comNaiss");
		String codePostNaiss = request.getParameter("codePostNaiss");
		String numAdresse = request.getParameter("num");
		String rueAdresse = request.getParameter("rue");
		String complAdresse = request.getParameter("compl");
		String commune = request.getParameter("num");
		String codePostal = request.getParameter("codePostal");
		String droitImage = request.getParameter("droitImage");
		String dateInscription = request.getParameter("dateInscri");

		Date dateNaiss = new Date();
		Date dateInscri = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		try {
			dateNaiss = formatter.parse(dateNaissance);
			dateInscri = formatter.parse(dateInscription);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Discipline> list = new ArrayList<>();
		Adherent adherent = new Adherent(null, null, null, nom, prenom,
				dateNaiss, telFixe, telPortable, email, Civilite.MONSIEUR,
				null, null, Boolean.parseBoolean(droitImage), dateInscri, null,
				null, 0.0f, list);
		VerifierSyntaxePersonne verifierSyntaxePersonne = new VerifierSyntaxePersonne();
		verifierSyntaxePersonne.verifierInformations(adherent);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

}
