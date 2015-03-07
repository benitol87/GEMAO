package fr.gemao.view.personnel;

import java.io.IOException;
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
import fr.gemao.ctrl.RecupererAdresseCtrl;
import fr.gemao.ctrl.RecupererCommuneCtrl;
import fr.gemao.ctrl.RecupererContratCtrl;
import fr.gemao.ctrl.administration.ModificationCtrl;
import fr.gemao.ctrl.personnel.ModifierPersonnelCtrl;
import fr.gemao.ctrl.personnel.RecupererPersonnelCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Contrat;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;
import fr.gemao.entity.administration.Modification;
import fr.gemao.form.personnel.PersonnelForm;
import fr.gemao.view.ConnexionServlet;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implémentant la classe ModifPersonnelServlet
 */
@WebServlet(Pattern.PERSONNEL_MODIFIER)
public class ModifPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Chargement de la page de modification d'un personnel.
	 * Un paramètre doit être envoyé au doGet pour récupérer la personne concernée par les modifications.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		/* Si le paramètre id est null */
		if(request.getParameter("id") == null){
			this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_LISTER).forward(request, response);
			
		/* Sinon */
		} else {
			long id = Long.parseLong(request.getParameter("id"));
			RecupererPersonnelCtrl recupererPersonnelCtrl = new RecupererPersonnelCtrl();
			Personnel personnel = recupererPersonnelCtrl.recupererPersonnel(id);

			RecupererAdresseCtrl recupererAdresseCtrl = new RecupererAdresseCtrl();
			Adresse adresse = recupererAdresseCtrl.recupererAdresse(personnel.getAdresse().getIdAdresse());

			RecupererCommuneCtrl recupererCommuneCtrl = new RecupererCommuneCtrl();
			Commune commune = recupererCommuneCtrl.recupererCommune(adresse.getCommune().getIdCommune());

			RecupererContratCtrl recupererContratCtrl = new RecupererContratCtrl();
			Contrat contrat = recupererContratCtrl.recupererContrat(personnel.getContrat().getIdContrat());

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateDebutContrat = formatter.format(contrat.getDateDebut());

			String dateFinContrat = null;
			
			/* Si la date de fin du contrat n'est pas null */
			if (contrat.getDateFin() != null) {
				dateFinContrat = formatter.format(contrat.getDateFin());
			}
			
			List<Responsabilite> listeResponsabilite = personnel.getListeResponsabilite();
			
			/* Si la liste des responsabilités est vide */
			if(listeResponsabilite.isEmpty()){
				listeResponsabilite.add(new Responsabilite(0, "Aucune"));
			}
			
			List<Diplome> listeDiplome = personnel.getListeDiplomes();
			
			/* Si la liste des diplômes est vide */
			if(listeDiplome.isEmpty()){
				listeDiplome.add(new Diplome(0, "Aucun"));
			}

			/* Positionnement des attributs */
			session.setAttribute("listeDiplome", listeDiplome);
			session.setAttribute("listeResponsabilite", listeResponsabilite);
			session.setAttribute("personnel", personnel);
			session.setAttribute("adresse", adresse);
			session.setAttribute("commune", commune);
			session.setAttribute("contrat", contrat);
			session.setAttribute("dateDebutContrat", dateDebutContrat);
			session.setAttribute("dateFinContrat", dateFinContrat);
			this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_MODIFIER).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonnelForm form = new PersonnelForm();
		
		form.testerPersonnel(request);
		
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		/* Si le formulaire n'a pas renvoyé d'erreur */
		if (form.getErreurs().isEmpty()) {
			ModifierPersonnelCtrl modifPers = new ModifierPersonnelCtrl();
			AjouterAdresseCtrl ajouterAdr = new AjouterAdresseCtrl();
			AjouterCommuneCtrl ajouterCommune = new AjouterCommuneCtrl();
			
			Personnel pers = null;
			
			/* Si l'objet renvoyé est bien du type Personnel */
			if (session.getAttribute("personnel").getClass() == Personnel.class) {
				pers = (Personnel) session.getAttribute("personnel");
				
				/* Positionnement des attributs du pers à partir des informations du form */
				pers.setTelFixe(form.getTelFixe());
				pers.setTelPort(form.getTelPort());
				pers.setEmail(form.getEmail());
				pers.setAdresse(form.getAdresse());
				pers.setListeDiplomes(form.getListeDiplomes());
				pers.setListeResponsabilite(form.getListeResponsabilite());
				
				/* Positionnement des attributs relatifs à la commune */
				ajouterCommune.ajoutCommune(form.getAdresse().getCommune());
				ajouterAdr.ajoutAdresse(form.getAdresse());
				
				modifPers.modifierPersonnel(pers);
				session.removeAttribute("personnel");
				
				// Archivage
				new ModificationCtrl().ajouterModification(new Modification(
						0,
						(Personnel) session.getAttribute(ConnexionServlet.ATT_SESSION_USER),
						new Date(),
						"Modification personnel : "+pers.getNom()+" "+pers.getPrenom()
				));
				
			} else {
				form.setErreur("Modification", "Problème de session");
			}
		}
		
		/* Si le formulaire ne retourne pas d'erreur */
		if (form.getErreurs().isEmpty()) {
			
			/* On redirige vers la liste des personnels */
			response.sendRedirect(request.getContextPath() + Pattern.PERSONNEL_LISTER);
		} else {
			this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_MODIFIER).forward(request, response);
		}
	}
}