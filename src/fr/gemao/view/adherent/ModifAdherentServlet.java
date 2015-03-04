package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.ctrl.adherent.AjouterDisciplineCtrl;
import fr.gemao.ctrl.adherent.ModifierAdherentCtrl;
import fr.gemao.ctrl.adherent.ModifierResponsableCtrl;
import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.ctrl.adherent.RecupererDisciplineCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.entity.cours.Discipline;
import fr.gemao.entity.util.Civilite;
import fr.gemao.form.adherent.AdherentForm;
import fr.gemao.form.util.Form;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ModifAdherentServlet
 */
@WebServlet(Pattern.ADHERENT_MODIFIER)
public class ModifAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final String PARAM_DATE_NAISSANCE = "dateNaissance";
	public final String PARAM_ADHERENT = "adherent";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("modif_adh_adherent", null);

		if (request.getParameter("id") == null) {
			request.setAttribute("lien", Pattern.ADHERENT_MODIFIER);
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			List<Adherent> adherents = recupererAdherentCtrl
					.recupererTousAdherents();
			request.setAttribute("listeAdherents", adherents);
			this.getServletContext()
					.getRequestDispatcher(Pattern.ADHERENT_LISTER)
					.forward(request, response);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			Adherent adherent = recupererAdherentCtrl.recupererAdherent(id);

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateNaissance = formatter
					.format(adherent.getDateNaissance());
			String dateInscription = formatter.format(adherent.getDateEntree());

			session.setAttribute("modif_adh_adherent", adherent);
			request.setAttribute("adherent", adherent);
			request.setAttribute("dateNaissance", dateNaissance);
			request.setAttribute("dateInscription", dateInscription);
			RecupererDisciplineCtrl recupDisciplineCtrl = new RecupererDisciplineCtrl();
			session.setAttribute("listDiscipline",
					recupDisciplineCtrl.recupererAllDiscipline());
			this.getServletContext()
					.getRequestDispatcher(JSPFile.ADHERENT_MODIFIER_ADHERENT)
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("modif_adh_adherent");

		if (Form.getValeurChamp(request, "nomDiscipline") != null) {
			try {
				AjouterDisciplineCtrl.ajouterDiscipline(Form.getValeurChamp(
						request, "nomDiscipline"));
			} catch (DAOException e) {
				e.printStackTrace();
				System.out.println("La discipline existe déjà");
			}

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateNaissance = formatter
					.format(adherent.getDateNaissance());
			String dateInscription = formatter.format(adherent.getDateEntree());

			session.setAttribute("modif_adh_adherent", adherent);
			request.setAttribute("adherent", adherent);
			request.setAttribute("dateNaissance", dateNaissance);
			request.setAttribute("dateInscription", dateInscription);
			RecupererDisciplineCtrl recupDisciplineCtrl = new RecupererDisciplineCtrl();
			session.setAttribute("listDiscipline",
					recupDisciplineCtrl.recupererAllDiscipline());
			this.getServletContext()
					.getRequestDispatcher(JSPFile.ADHERENT_MODIFIER_ADHERENT)
					.forward(request, response);
		} else {
			AdherentForm adherentForm = new AdherentForm();

			adherentForm.testerAdherent(request);

			if (adherentForm.getErreurs().isEmpty()) {

				String nom = adherentForm.getNom();
				adherent.setNom(nom);
				String prenom = adherentForm.getPrenom();
				adherent.setPrenom(prenom);

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date dateNaiss = null;
				Date dateEntree = null;
				try {
					dateNaiss = formatter
							.parse(adherentForm.getDateNaissance());
					dateEntree = formatter.parse(adherentForm.getDateEntree());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				adherent.setDateNaissance(dateNaiss);
				adherent.setDateEntree(dateEntree);

				String civilite = request.getParameter("civilite");
				if (civilite.equals("F")) {
					adherent.setCivilite(Civilite.MADAME);
				} else {
					adherent.setCivilite(Civilite.MONSIEUR);
				}

				String telFixe = request.getParameter("telFixe");
				adherent.setTelFixe(telFixe);
				String telPort = request.getParameter("telPort");
				adherent.setTelPort(telPort);
				String email = request.getParameter("email");
				adherent.setEmail(email);

				String nomCommune = request.getParameter("commune");
				Integer codePostal = Integer.parseInt(request
						.getParameter("codePostal"));
				Commune commune = new Commune(null, codePostal, nomCommune,
						false);

				AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
				ajouterCommuneCtrl.ajoutCommune(commune);

				AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
				Adresse adresse = new Adresse();
				String numRue = request.getParameter("num");
				adresse.setNumRue(numRue);
				String nomRue = request.getParameter("rue");
				adresse.setNomRue(nomRue);
				String infoCompl = request.getParameter("compl");
				adresse.setInfoCompl(infoCompl);
				adresse.setCommune(commune);
				ajouterAdresseCtrl.ajoutAdresse(adresse);

				adherent.setAdresse(adresse);

				List<Discipline> listDiscipline = adherentForm
						.lireDisciplines(request);
				adherent.setDisciplines(listDiscipline);
				

				String droitImage = request.getParameter("droitImage");
				adherent.setDroitImage(Boolean.parseBoolean(droitImage));
				
				
				float cotisation = Float.parseFloat(request.getParameter("cotisation"));
				adherent.setCotisation(cotisation);


				if (adherent.getResponsable() != null) {
					Responsable responsable = adherent.getResponsable();
					String nomResp = request.getParameter("nomResp");
					responsable.setNom(nomResp);
					String prenomResp = request.getParameter("prenomResp");
					responsable.setPrenom(prenomResp);
					String telResp = request.getParameter("telResp");
					responsable.setTelephone(telResp);
					String emailResp = request.getParameter("emailResp");
					responsable.setEmail(emailResp);

					ModifierResponsableCtrl modifierResponsableCtrl = new ModifierResponsableCtrl();
					modifierResponsableCtrl.modifierResponsable(responsable);
				}

				session.setAttribute("modif_adh_adherent", adherent);
				response.sendRedirect(request.getContextPath()
						+ Pattern.ADHERENT_VALIDATION_MODIF);
			} else {
				System.out.println(adherentForm.getErreurs());
				System.out.println("Erreur !");

				this.getServletContext()
						.getRequestDispatcher(JSPFile.ADHERENT_LISTER)
						.forward(request, response);
			}
		}
	}
}
