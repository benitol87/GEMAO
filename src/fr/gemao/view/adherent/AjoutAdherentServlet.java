package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Discipline;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.util.Civilite;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;

/**
 * Servlet implementation class AjoutAdherent
 */
@WebServlet("/adherent/AjoutAdherent")
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
		/**
		 * Recuperation des données concernant l'adhérent
		 */
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("dateNaiss");
		String telFixe = request.getParameter("telFixe");
		String telPortable = request.getParameter("telPort");
		String email = request.getParameter("email");
		String droitImage = request.getParameter("droitImage");
		String dateInscription = request.getParameter("dateInscri");

		/**
		 * Création de l'adhérent
		 */
		Date dateNaiss = new Date();
		Date dateInscri = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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

		/**
		 * Réupération des données de la commune de naissance
		 */
		String comNaiss = request.getParameter("comNaiss");
		String codePostNaiss = request.getParameter("codePostNaiss");

		/**
		 * Création de la commune de naissance (la récupère dans la base ou
		 * l'ajoute)
		 */
		DAOFactory factory = DAOFactory.getInstance();
		CommuneDAO communeDAO = factory.getCommuneDAO();

		Commune communeNaiss = new Commune(null,
				Integer.parseInt(codePostNaiss), comNaiss, false);
		if (communeDAO.existNomCodePostal(communeNaiss) == null) {
			AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
			ajouterCommuneCtrl.ajoutCommune(communeNaiss);
			System.out.println("test1");
		}
		communeNaiss = communeDAO.existNomCodePostal(communeNaiss);
		
		/**
		 * Réupération des données de la commune
		 */
		String com = request.getParameter("commune");
		String codePostal = request.getParameter("codePostal");

		/**
		 * Création de la commune (la récupère dans la base ou l'ajoute)
		 */
		Commune commune = new Commune(null, Integer.parseInt(codePostal), com,
				false);
		if (communeDAO.existNomCodePostal(commune) == null) {
//			AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
//			ajouterCommuneCtrl.ajoutCommune(commune);
			System.out.println("test2");
		}
//		commune = communeDAO.existNomCodePostal(commune);
		
		/**
		 * Réupération des données de l'adresse
		 */
		String numAdresse = request.getParameter("num");
		String rueAdresse = request.getParameter("rue");
		String complAdresse = request.getParameter("compl");

		/**
		 * Création de l'adresse (la récupère dans la base ou l'ajoute)
		 */
		Adresse adresse = new Adresse(null, commune.getIdCommune(),
				Integer.parseInt(numAdresse), rueAdresse, complAdresse);

		AdresseDAO adresseDAO = factory.getAdresseDAO();
		if (adresseDAO.exist(adresse) == null) {
//			AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
//			ajouterAdresseCtrl.ajoutAdresse(adresse);
			System.out.println("test3");

		}
//		adresse = adresseDAO.exist(adresse);

//		adherent.setIdCommuneNaiss(communeNaiss.getIdCommune());
//		adherent.setIdAdresse(adresse.getIdAdresse());
//		
		System.out.println(adherent);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

}
