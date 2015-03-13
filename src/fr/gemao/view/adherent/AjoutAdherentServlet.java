package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.ctrl.adherent.AjouterAdherentCtrl;
import fr.gemao.ctrl.adherent.AjouterDisciplineCtrl;
import fr.gemao.ctrl.adherent.RecupererDisciplineCtrl;
import fr.gemao.ctrl.personnel.AjouterPersonnelCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.cours.Discipline;
import fr.gemao.entity.util.Civilite;
import fr.gemao.form.adherent.AdherentForm;
import fr.gemao.form.util.Form;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class AjoutAdherent
 */
@WebServlet(Pattern.ADHERENT_AJOUT)
public class AjoutAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		session.setAttribute("ajout_adh_adherent", null);
		session.setAttribute("ajout_adh_commune", null);
		session.setAttribute("ajout_adh_adresse", null);
		session.setAttribute("ajout_adh_responsable", null);

		RecupererDisciplineCtrl recupDisciplineCtrl = new RecupererDisciplineCtrl();
		session.setAttribute("listDiscipline",
				recupDisciplineCtrl.recupererAllDiscipline());

		this.getServletContext()
				.getRequestDispatcher(JSPFile.ADHERENT_AJOUT_ADHERENT)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdherentForm adherentForm = new AdherentForm();
		HttpSession session = request.getSession();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		if (Form.getValeurChamp(request, "nomDiscipline") != null) {
			try {
				AjouterDisciplineCtrl.ajouterDiscipline(Form.getValeurChamp(
						request, "nomDiscipline"));
			} catch (DAOException e) {
				e.printStackTrace();
			}

			RecupererDisciplineCtrl recupDisciplineCtrl = new RecupererDisciplineCtrl();
			session.setAttribute("listDiscipline",
					recupDisciplineCtrl.recupererAllDiscipline());
			
			HashMap<String, String> infos = new HashMap<String, String>();
			
			infos.put("nom", Form.getValeurChamp(request, "nom"));
			infos.put("prenom", Form.getValeurChamp(request, "prenom"));
			infos.put("email", Form.getValeurChamp(request, "email"));
			infos.put("telFixe", Form.getValeurChamp(request, "telFixe"));
			infos.put("telPort", Form.getValeurChamp(request, "telPort"));
			infos.put("dateNaiss", Form.getValeurChamp(request, "dateNaiss"));
			infos.put("dateInscri", Form.getValeurChamp(request, "dateInscri"));
			infos.put("num", Form.getValeurChamp(request, "num"));
			infos.put("rue", Form.getValeurChamp(request, "rue"));
			infos.put("compl", Form.getValeurChamp(request, "compl"));
			infos.put("commune", Form.getValeurChamp(request, "commune"));
			infos.put("codePostal", Form.getValeurChamp(request, "codePostal"));
			infos.put("droitImage", Form.getValeurChamp(request, "droitImage"));
			infos.put("civilite", Form.getValeurChamp(request, "civilite"));
			
			session.setAttribute("infos", infos);
			
			this.getServletContext()
					.getRequestDispatcher(JSPFile.ADHERENT_AJOUT_ADHERENT)
					.forward(request, response);
		} else {
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
				String civilite = request.getParameter("civilite");

				/**
				 * Création de l'adhérent
				 */
				Date dateNaiss = new Date();
				Date dateInscri = new Date();
				try {
					dateNaiss = formatter.parse(dateNaissance);
					dateInscri = formatter.parse(dateInscription);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				List<Discipline> list = new ArrayList<>();
				Adherent adherent = new Adherent(null, null, null, nom, prenom,
						dateNaiss, telFixe, telPortable, email,
						Civilite.MONSIEUR, null, null,
						Boolean.parseBoolean(droitImage), dateInscri, null,
						null, 0.0f, list, null, null);
				if (civilite.equals("F")) {
					adherent.setCivilite(Civilite.MADAME);
				}
				List<Discipline> listDiscipline = adherentForm.getDisciplines();
				adherent.setDisciplines(listDiscipline);

				/**
				 * Réupération des données de la commune
				 */
				String com = adherentForm.getNomCommune();
				Integer codePostal = adherentForm.getCodePostal();

				/**
				 * Création de la commune
				 */
				Commune commune = new Commune(null, codePostal, com, false);
				CommuneDAO communeDAO = DAOFactory.getInstance()
						.getCommuneDAO();
				Commune c = communeDAO.existNomCodePostal(commune);
				if (c != null) {
					commune = c;
				}

				System.out.println(commune);

				/**
				 * Réupération des données de l'adresse
				 */
				String numAdresse = adherentForm.getNumRue();
				String rueAdresse = adherentForm.getNomRue();
				String complAdresse = adherentForm.getInfoCompl();

				/**
				 * Création de l'adresse
				 */
				Adresse adresse = new Adresse(null, null, numAdresse,
						rueAdresse, complAdresse);

				session.setAttribute("ajout_adh_adherent", adherent);
				session.setAttribute("ajout_adh_commune", commune);
				session.setAttribute("ajout_adh_adresse", adresse);

				Calendar dateMineur = Calendar.getInstance();
				dateMineur.set(dateMineur.get(Calendar.YEAR) - 18,
						dateMineur.get(Calendar.MONTH),
						dateMineur.get(Calendar.DAY_OF_MONTH));
				
				AjouterPersonneCtrl ajouterPersonneCtrl = new AjouterPersonneCtrl();
				if (dateNaiss.after(dateMineur.getTime())) {
					response.sendRedirect(request.getContextPath()
							+ Pattern.ADHERENT_AJOUT_RESPONSABLE);
				} else {
					response.sendRedirect(request.getContextPath()
							+ Pattern.ADHERENT_VALIDATION_AJOUT);
				}

			} else {
				System.out.println(adherentForm.getErreurs());
				System.out.println("Erreur !");

				this.getServletContext()
						.getRequestDispatcher(JSPFile.ADHERENT_AJOUT_ADHERENT)
						.forward(request, response);
			}
		}

	}

}
