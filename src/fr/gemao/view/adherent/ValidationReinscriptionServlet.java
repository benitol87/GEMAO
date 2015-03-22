package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.ctrl.adherent.AjouterResponsableCtrl;
import fr.gemao.ctrl.adherent.ModifierAdherentCtrl;
import fr.gemao.ctrl.administration.ModificationCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.entity.administration.Modification;
import fr.gemao.view.ConnexionServlet;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

@WebServlet(Pattern.ADHERENT_VALIDATION_REINS)
public class ValidationReinscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("ajout_adh_adherent");
		Commune commune = adherent.getCommuneNaiss();
		Adresse adresse = adherent.getAdresse();
		Responsable responsable = adherent.getResponsable();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateNaissance = formatter.format(adherent.getDateNaissance());
		String dateInscription = formatter.format(adherent.getDateEntree());

		request.setAttribute("dateNaissance", dateNaissance);
		request.setAttribute("dateInscription", dateInscription);
		request.setAttribute("adherent", adherent);
		request.setAttribute("commune", commune);
		request.setAttribute("adresse", adresse);
		request.setAttribute("responsable", responsable);
		System.out.println(adherent);

		this.getServletContext()
				.getRequestDispatcher(JSPFile.ADHERENT_VALIDATION_REINS)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("ajout_adh_adherent");
		Commune commune = adherent.getAdresse().getCommune();
		Adresse adresse = adherent.getAdresse();
		Responsable responsable = adherent.getResponsable();

		AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();

		ajouterCommuneCtrl.ajoutCommune(commune);
		adresse.setCommune(commune);

		AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
		ajouterAdresseCtrl.ajoutAdresse(adresse);

		adherent.setAdresse(adresse);

		if (responsable != null) {
			AjouterResponsableCtrl ajouterResponsableCtrl = new AjouterResponsableCtrl();
			ajouterResponsableCtrl.ajouterResponsable(responsable);
			adherent.setResponsable(responsable);
		}

		adherent.setAPaye(false);

		ModifierAdherentCtrl modifierAdherentCtrl = new ModifierAdherentCtrl();

		request.setAttribute("adherent", adherent);

		if (modifierAdherentCtrl.modifierAdherent(adherent)) {
			// Succès de l'ajout
			// Archivage de la modification
			new ModificationCtrl().ajouterModification(new Modification(0,
					(Personnel) session
							.getAttribute(ConnexionServlet.ATT_SESSION_USER),
					new Date(), "Ajout adhérent : " + adherent.getNom() + " "
							+ adherent.getPrenom()));

			// Redirection
			this.getServletContext()
					.getRequestDispatcher(JSPFile.ADHERENT_CONFIRMATION_AJOUT)
					.forward(request, response);

		} else {
			request.setAttribute("dejaInscrit", false);
			this.getServletContext()
					.getRequestDispatcher(JSPFile.ADHERENT_ECHEC_AJOUT)
					.forward(request, response);
		}

		session.setAttribute("ajout_adh_adherent", null);
		session.setAttribute("ajout_adh_commune", null);
		session.setAttribute("ajout_adh_adresse", null);
		session.setAttribute("ajout_adh_responsable", null);
	}

}
