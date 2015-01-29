package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.ctrl.adherent.AjouterAdherentCtrl;
import fr.gemao.ctrl.adherent.AjouterResponsableCtrl;
import fr.gemao.ctrl.adherent.CalculerCotisationCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;
import fr.gemao.sql.ResponsableDAO;

/**
 * Servlet implementation class ValidationAjoutAdherentServlet
 */
@WebServlet("/adherent/ValidationAjoutAdherent")
public class ValidationAjoutAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VUE = "/WEB-INF/pages/adherent/validAjoutAdherent.jsp";
	private String VUE_CONFIRMATION = "/WEB-INF/pages/adherent/confirmationAjoutAdherent.jsp";
	private String VUE_ECHEC = "/WEB-INF/pages/adherent/echecAjoutAdherent.jsp";
	private String VUE_ERREUR = "/WEB-INF/pages/erreurs/404.jsp";

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
		Commune communeNaiss = (Commune) session
				.getAttribute("ajout_adh_communeNaiss");
		Adresse adresse = (Adresse) session.getAttribute("ajout_adh_adresse");
		Responsable responsable = (Responsable) session
				.getAttribute("ajout_adh_responsable");

		CalculerCotisationCtrl calculerCotisationCtrl = new CalculerCotisationCtrl();
		System.out.println(adherent);
		adherent.setCotisation(calculerCotisationCtrl
				.calculerCotisations(adherent.getQf()));
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateNaissance = formatter.format(adherent.getDateNaissance());
		String dateInscription = formatter.format(adherent.getDateEntree());
		
		request.setAttribute("dateNaissance", dateNaissance);
		request.setAttribute("dateInscription", dateInscription);
		request.setAttribute("adherent", adherent);
		request.setAttribute("commune", commune);
		request.setAttribute("communeNaiss", communeNaiss);
		request.setAttribute("adresse", adresse);
		request.setAttribute("responsable", responsable);

		this.getServletContext().getRequestDispatcher(VUE)
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
		Commune communeNaiss = (Commune) session
				.getAttribute("ajout_adh_communeNaiss");
		Adresse adresse = (Adresse) session.getAttribute("ajout_adh_adresse");
		Responsable responsable = (Responsable) session
				.getAttribute("ajout_adh_responsable");

		
		AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
		
		ajouterCommuneCtrl.ajoutCommune(communeNaiss);
		adherent.setCommuneNaiss(communeNaiss);


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

		//TODO à modifier : il ne devrait pas y avoir de DAO dans les servlet !
		DAOFactory factory = DAOFactory.getInstance();
		PersonneDAO personneDAO = factory.getPersonneDAO();

		request.setAttribute("adherent", adherent);
		
		if (personneDAO.exist(adherent) == null) {
			AjouterAdherentCtrl ajouterAdherentCtrl = new AjouterAdherentCtrl();
			if(ajouterAdherentCtrl.ajoutAdherent(adherent))
				this.getServletContext().getRequestDispatcher(VUE_CONFIRMATION)
						.forward(request, response);
			else{
				System.out.println("Echec de l'ajout");
				request.setAttribute("dejaInscrit", false);
				this.getServletContext().getRequestDispatcher(VUE_ECHEC)
						.forward(request, response);
			}
		} else {
			System.out.println("La personne existe déja");
			request.setAttribute("dejaInscrit", true);
			this.getServletContext().getRequestDispatcher(VUE_ECHEC)
					.forward(request, response);
		}

		session.setAttribute("ajout_adh_adherent", null);
		session.setAttribute("ajout_adh_commune", null);
		session.setAttribute("ajout_adh_communeNaiss", null);
		session.setAttribute("ajout_adh_adresse", null);
		session.setAttribute("ajout_adh_responsable", null);
	}
}
