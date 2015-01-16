package fr.gemao.view.personnel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.Config;
import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;
import fr.gemao.entity.util.Civilite;

/**
 * Servlet implementation class AjoutPersonnelServlet
 */
@WebServlet("/personnel/AjoutPersonnel")
public class AjoutPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/personnel/ajoutPersonnel.jsp";
	private String VUE_PAGE2 = "/WEB-INF/pages/personnel/ajoutPersonnel2.jsp";

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
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 *
		 */
		HttpSession session = request.getSession();
		 
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("date");
		String telFixe = request.getParameter("fixe");
		String telPortable = request.getParameter("portable");
		String mail = request.getParameter("email");
		String numrue = request.getParameter("numRue");
		String nomrue = request.getParameter("nomRue");
		String codePostal = request.getParameter("code");
		String ville = request.getParameter("ville");
		String diplome = request.getParameter("diplome");
		String fonction = request.getParameter("fonction");
		String civilite = request.getParameter("civilite");
		String infoComplementaire = request.getParameter("infoComplem");

		/**
		 * Création du personnel
		 * TODO manque diplome et fonction
		 */
		
		List<Responsabilite> list = new ArrayList<>();
		List<Diplome> listdi = new ArrayList<>();

		/**
		 * Création de la commune
		 */
		AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
		Commune commune = new Commune(null, Integer.parseInt(codePostal), ville, false);
		ajouterCommuneCtrl.ajoutCommune(commune);
		
		/**
		 * Création de l'adresse
		 */
		Adresse adrss = new Adresse(null, commune, Integer.parseInt(numrue), nomrue,
				infoComplementaire);
		AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
		ajouterAdresseCtrl.ajoutAdresse(adrss);

		Personnel personnel = new Personnel();
		personnel.setAdresse(adrss);
		if(civilite == "Monsieur"){
			personnel.setCivilite(Civilite.MONSIEUR);
		}
		if(civilite == "Madame"){
			personnel.setCivilite(Civilite.MADAME);
		}
		personnel.setCommuneNaiss(commune);
		personnel.setEmail(mail);
		personnel.setListeDiplomes(listdi);
		personnel.setListeResponsabilite(list);
		personnel.setNom(nom);
		personnel.setPrenom(prenom);
		personnel.setTelFixe(telFixe);
		personnel.setTelPort(telPortable);	
		personnel.setPassword(Config.MOTDEPASSE);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		try {
			personnel.setDateNaissance(new java.sql.Date(formatter.parse(dateNaissance)
					.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		session.setAttribute("personnel", personnel);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_PAGE2)
				.forward(request, response);
	}

}
