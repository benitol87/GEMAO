package fr.gemao.view.personnel;

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
import fr.gemao.ctrl.PersonneCtrl;
import fr.gemao.ctrl.RecupererAdresseCtrl;
import fr.gemao.ctrl.RecupererCommuneCtrl;
import fr.gemao.ctrl.RecupererContratCtrl;
import fr.gemao.ctrl.personnel.ModifierPersonnelCtrl;
import fr.gemao.ctrl.personnel.RecupererPersonnelCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Contrat;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personne;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;
import fr.gemao.form.personnel.PersonnelForm;

/**
 * Servlet implementation class ModifPersonnelServlet
 */
@WebServlet("/personnel/ModifPersonnel")
public class ModifPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_MODIFICATION = "/WEB-INF/pages/personnel/modifPersonnel.jsp";
	public static final String VUE_LISTE = "/personnel/ListePersonnel";

	/**
	 * Chargement de la page de modification. Le parametre idPersonne doit etre
	 * envoyé pour le doGet (l'id correspond a celui de la personne à modifier.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String param = request.getParameter("idPersonne");
		
		if(request.getParameter("id") == null){
			this.getServletContext().getRequestDispatcher(VUE_LISTE).forward(request, response);
		} else {
			long id = Long.parseLong(request.getParameter("id"));
			RecupererPersonnelCtrl recupererPersonnelCtrl = new RecupererPersonnelCtrl();
			Personnel personnel = recupererPersonnelCtrl.recupererPersonnel(id);

			RecupererAdresseCtrl recupererAdresseCtrl = new RecupererAdresseCtrl();
			Adresse adresse = recupererAdresseCtrl.recupererAdresse(personnel
					.getAdresse().getIdAdresse());

			RecupererCommuneCtrl recupererCommuneCtrl = new RecupererCommuneCtrl();
			Commune commune = recupererCommuneCtrl.recupererCommune(adresse
					.getCommune().getIdCommune());

			RecupererContratCtrl recupererContratCtrl = new RecupererContratCtrl();
			Contrat contrat = recupererContratCtrl.recupererContrat(personnel
					.getContrat().getIdContrat());

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateDebutContrat = formatter.format(contrat.getDateDebut());

			String dateFinContrat = null;
			if (contrat.getDateFin() != null) {
				dateFinContrat = formatter.format(contrat.getDateFin());
			}
			
			List<Responsabilite> listeResponsabilite = personnel.getListeResponsabilite();
			if(listeResponsabilite.isEmpty()){
				listeResponsabilite.add(new Responsabilite(0, "Aucune"));
			}
			
			List<Diplome> listeDiplome = personnel.getListeDiplomes();
			if(listeDiplome.isEmpty()){
				listeDiplome.add(new Diplome(0, "Aucun"));
			}

			session.setAttribute("listeDiplome", listeDiplome);
			session.setAttribute("listeResponsabilite", listeResponsabilite);
			session.setAttribute("personnel", personnel);
			session.setAttribute("adresse", adresse);
			session.setAttribute("commune", commune);
			session.setAttribute("contrat", contrat);
			session.setAttribute("dateDebutContrat", dateDebutContrat);
			session.setAttribute("dateFinContrat", dateFinContrat);
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION).forward(request, response);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		long id = Long.parseLong(request.getParameter("id"));
		
		RecupererPersonnelCtrl recupererPersonneCtrl = new RecupererPersonnelCtrl();
		Personne personne = recupererPersonneCtrl.recupererPersonnel(id);
		
		PersonnelForm form = new PersonnelForm();
		
		form.testerPersonnel(request);
		
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		
		
		if (form.getErreurs().isEmpty()) {
			PersonneCtrl persCtrl = new PersonneCtrl();
			ModifierPersonnelCtrl modifPers = new ModifierPersonnelCtrl();
			AjouterAdresseCtrl ajouterAdr = new AjouterAdresseCtrl();
			AjouterCommuneCtrl ajouterCommune = new AjouterCommuneCtrl();
			
			Personnel pers = null;
			
			if (session.getAttribute("personnel").getClass() == Personnel.class) {
				pers = (Personnel) session.getAttribute("personnel");
				
				pers.setTelFixe(form.getTelFixe());
				pers.setTelPort(form.getTelPort());
				pers.setEmail(form.getEmail());
				pers.setAdresse(form.getAdresse());
				pers.setListeDiplomes(form.getListeDiplomes());
				pers.setListeResponsabilite(form.getListeResponsabilite());
				
				ajouterCommune.ajoutCommune(form.getAdresse().getCommune());
				ajouterAdr.ajoutAdresse(form.getAdresse());
				
				modifPers.modifierPersonnel(pers);
				
				session.removeAttribute("personnel");
			} else {
				form.setErreur("Modification", "Problème de session");
			}
		}
		
		if (form.getErreurs().isEmpty()) {
			response.sendRedirect(request.getContextPath() + VUE_LISTE);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION).forward(request, response);
		}
	}
}