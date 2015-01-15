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
import javax.servlet.http.HttpSession;

import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Discipline;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.util.Civilite;
import fr.gemao.form.adherent.AdherentForm;

/**
 * Servlet implementation class AjoutAdherent
 */
@WebServlet("/adherent/AjoutAdherent")
public class AjoutAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/adherent/ajoutAdherent.jsp";
	private String URL_RESPONSABLE = "/GEMAO/adherent/AjoutResponsable";
	private String URL_VALIDATION = "/GEMAO/adherent/ValidationAjoutAdherent";

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

		AdherentForm adherentForm = new AdherentForm();

		adherentForm.testerAdherent(request);

		if (adherentForm.getErreurs().isEmpty()) {

			/**
			 * Recuperation des données concernant l'adhérent
			 */
			String nom = adherentForm.getNom();
			String prenom = adherentForm.getPrenom();
			String dateNaissance = adherentForm.getDateNaissance();
			String telFixe = adherentForm.getTelFixe();
			String telPortable = adherentForm.getTelPort();
			String email = adherentForm.getEmail();
			String droitImage = adherentForm.getDroitImage();
			String dateInscription = adherentForm.getDateEntree();

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
					null, null, Boolean.parseBoolean(droitImage), dateInscri,
					null, null, 0.0f, list);

			/**
			 * Réupération des données de la commune de naissance
			 */
			String comNaiss = adherentForm.getComNaiss();
			String codePostNaiss = adherentForm.getCodePostNaiss();

			/**
			 * Création de la commune de naissance (la récupère dans la base ou
			 * l'ajoute)
			 */
			// DAOFactory factory = DAOFactory.getInstance();
			// CommuneDAO communeDAO = factory.getCommuneDAO();

			Commune communeNaiss = new Commune(null,
					Integer.parseInt(codePostNaiss), comNaiss, false);
			// if (communeDAO.existNomCodePostal(communeNaiss) == null) {
			// AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
			// ajouterCommuneCtrl.ajoutCommune(communeNaiss);
			// }
			// communeNaiss = communeDAO.existNomCodePostal(communeNaiss);

			/**
			 * Réupération des données de la commune
			 */
			String com = adherentForm.getNomCommune();
			Integer codePostal = adherentForm.getCodePostal();

			/**
			 * Création de la commune (la récupère dans la base ou l'ajoute)
			 */
			Commune commune = new Commune(null, codePostal, com, false);
			// if (communeDAO.existNomCodePostal(commune) == null) {
			// AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
			// ajouterCommuneCtrl.ajoutCommune(commune);
			// }
			// commune = communeDAO.existNomCodePostal(commune);

			/**
			 * Réupération des données de l'adresse
			 */
			Integer numAdresse = adherentForm.getNumRue();
			String rueAdresse = adherentForm.getNomRue();
			String complAdresse = adherentForm.getInfoCompl();

			/**
			 * Création de l'adresse (la récupère dans la base ou l'ajoute)
			 */
			Adresse adresse = new Adresse(null, null, numAdresse, rueAdresse,
					complAdresse);

			// AdresseDAO adresseDAO = factory.getAdresseDAO();
			// if (adresseDAO.exist(adresse) == null) {
			// AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
			// ajouterAdresseCtrl.ajoutAdresse(adresse);
			// }
			// adresse = adresseDAO.exist(adresse);
			//
			// adherent.setIdCommuneNaiss(communeNaiss.getIdCommune());
			// adherent.setIdAdresse(adresse.getIdAdresse());

			HttpSession session = request.getSession();
			session.setAttribute("ajout_adh_adherent", adherent);
			session.setAttribute("ajout_adh_communeNaiss", communeNaiss);
			session.setAttribute("ajout_adh_commune", commune);
			session.setAttribute("ajout_adh_adresse", adresse);

			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.get(Calendar.YEAR) - 18,
					calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));

			if (dateNaiss.after(calendar.getTime())) {
				response.sendRedirect(URL_RESPONSABLE);
			} else {
				response.sendRedirect(URL_VALIDATION);
			}

		} else {
			System.out.println(adherentForm.getErreurs());
			System.out.println("Erreur !");

			/* Transmission à la page JSP en charge de l'affichage des données */
			this.getServletContext().getRequestDispatcher(VUE)
					.forward(request, response);
		}
	}

}
