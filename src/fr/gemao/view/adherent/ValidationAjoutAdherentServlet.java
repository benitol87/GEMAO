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
import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.ctrl.adherent.AjouterAdherentCtrl;

import fr.gemao.ctrl.adherent.AjouterFamilleCtrl;
import fr.gemao.ctrl.adherent.AjouterResponsableCtrl;
import fr.gemao.ctrl.administration.ModificationCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.entity.adherent.Adherent;

import fr.gemao.entity.adherent.Famille;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.entity.administration.Modification;
import fr.gemao.view.ConnexionServlet;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ValidationAjoutAdherentServlet
 */
@WebServlet(Pattern.ADHERENT_VALIDATION_AJOUT)
public class ValidationAjoutAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("ajout_adh_adherent");
		Commune commune = (Commune) session.getAttribute("ajout_adh_commune");
		Adresse adresse = (Adresse) session.getAttribute("ajout_adh_adresse");
		Responsable responsable = (Responsable) session
				.getAttribute("ajout_adh_responsable");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateNaissance = formatter.format(adherent.getDateNaissance());
		String dateInscription = formatter.format(adherent.getDateEntree());
		
		request.setAttribute("dateNaissance", dateNaissance);
		request.setAttribute("dateInscription", dateInscription);
		request.setAttribute("adherent", adherent);
		request.setAttribute("commune", commune);
		request.setAttribute("adresse", adresse);
		request.setAttribute("responsable", responsable);

		this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_VALIDATION_AJOUT)
				.forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("ajout_adh_adherent");
		Commune commune = (Commune) session.getAttribute("ajout_adh_commune");
		Adresse adresse = (Adresse) session.getAttribute("ajout_adh_adresse");
		Responsable responsable = (Responsable) session
				.getAttribute("ajout_adh_responsable");
		

		AjouterCommuneCtrl.ajoutCommune(commune);
		adresse.setCommune(commune);


		AjouterAdresseCtrl.ajoutAdresse(adresse);
		
		adherent.setAdresse(adresse);
		
		Famille famille = AjouterFamilleCtrl.AjouterFamile(adherent.getFamille());
		adherent.setFamille(famille);
		

		if (responsable != null) {
			AjouterResponsableCtrl ajouterResponsableCtrl = new AjouterResponsableCtrl();
			ajouterResponsableCtrl.ajouterResponsable(responsable);
			adherent.setResponsable(responsable);
		}

		AjouterPersonneCtrl ajouterPersonneCtrl = new AjouterPersonneCtrl();

		request.setAttribute("adherent", adherent);
		
		if (ajouterPersonneCtrl.exist(adherent) == null) {
			AjouterAdherentCtrl ajouterAdherentCtrl = new AjouterAdherentCtrl();
			if(ajouterAdherentCtrl.ajoutAdherent(adherent)){
				// Succès de l'ajout
				// Archivage de la modification
				new ModificationCtrl().ajouterModification(new Modification(
						0,
						(Personnel) session.getAttribute(ConnexionServlet.ATT_SESSION_USER),
						new Date(),
						"Ajout adhérent : "+adherent.getNom()+" "+adherent.getPrenom()
				));
				
				// Redirection
				this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_CONFIRMATION_AJOUT)
						.forward(request, response);
			}
			else{
				request.setAttribute("dejaInscrit", false);
				this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_ECHEC_AJOUT)
						.forward(request, response);
			}
		} else {
			request.setAttribute("dejaInscrit", true);
			this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_ECHEC_AJOUT)
					.forward(request, response);
		}

		session.setAttribute("ajout_adh_adherent", null);
		session.setAttribute("ajout_adh_commune", null);
		session.setAttribute("ajout_adh_adresse", null);
		session.setAttribute("ajout_adh_responsable", null);
	}
}
