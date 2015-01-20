package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.ctrl.adherent.ModifierAdherentCtrl;
import fr.gemao.ctrl.adherent.ModifierResponsableCtrl;
import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.ctrl.adherent.RecupererDisciplineCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Discipline;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.form.adherent.AdherentForm;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsableDAO;

/**
 * Servlet implementation class ModifAdherentServlet
 */
@WebServlet("/adherent/ModifierAdherent")
public class ModifAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_LISTE = "/adherent/ListeAdherents";
	private static final String VUE = "/WEB-INF/pages/adherent/modifAdherent.jsp";

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
			request.setAttribute("lien", "/adherent/ModifierAdherent");
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			List<Adherent> adherents = recupererAdherentCtrl
					.recupererTousAdherents();
			request.setAttribute("listeAdherents", adherents);
			this.getServletContext().getRequestDispatcher(VUE_LISTE)
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
			this.getServletContext().getRequestDispatcher(VUE)
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

		String telFixe = request.getParameter("telFixe");
		adherent.setTelFixe(telFixe);
		String telPort = request.getParameter("telPort");
		adherent.setTelPort(telPort);
		String email = request.getParameter("email");
		adherent.setEmail(email);

		String nomCommune = request.getParameter("commune");
		Integer codePostal = Integer.parseInt(request
				.getParameter("codePostal"));
		Commune commune = new Commune(null, codePostal, nomCommune, false);

		AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
		ajouterCommuneCtrl.ajoutCommune(commune);
		
		AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
		Adresse adresse = new Adresse();
		Integer numRue = Integer.parseInt(request.getParameter("num"));
		adresse.setNumRue(numRue);
		String nomRue = request.getParameter("rue");
		adresse.setNomRue(nomRue);
		String infoCompl = request.getParameter("compl");
		adresse.setInfoCompl(infoCompl);
		adresse.setCommune(commune);
		ajouterAdresseCtrl.ajoutAdresse(adresse);

		adherent.setAdresse(adresse);
		
		AdherentForm adherentForm = new AdherentForm();
		List<Discipline> listDiscipline = adherentForm.lireDisciplines(request);
		adherent.setDisciplines(listDiscipline);

		String droitImage = request.getParameter("droitImage");
		adherent.setDroitImage(Boolean.parseBoolean(droitImage));

		if (adherent.getResponsable() != null) {
			Responsable responsable = adherent.getResponsable();
			System.out.println(responsable);
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

		ModifierAdherentCtrl modifierAdherentCtrl = new ModifierAdherentCtrl();
		System.out.println(adherent);
		modifierAdherentCtrl.modifierAdherent(adherent);

		session.setAttribute("modif_adh_adherent", null);
		response.sendRedirect(request.getContextPath() + VUE_LISTE);

	}
}
