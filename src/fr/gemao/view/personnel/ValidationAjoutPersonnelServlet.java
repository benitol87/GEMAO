package fr.gemao.view.personnel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.ctrl.personnel.AjouterPersonnelCtrl;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;
import fr.gemao.view.ResultatServlet;

/**
 * Servlet implementation class ValidationAjoutPersonnelServlet
 */
@WebServlet(Pattern.PERSONNEL_VALIDATION_AJOUT)
public class ValidationAjoutPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Personnel pers = (Personnel) session.getAttribute("ajout_personnel");
		
		request.setAttribute("personnel", pers);
		
		this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_VALIDATION_AJOUT).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Positionnement des attributs relatifs à la commune */
		HttpSession session = request.getSession();
		Personnel pers = (Personnel) session.getAttribute("ajout_personnel");
		AjouterPersonneCtrl ajouterPersonneCtrl = new AjouterPersonneCtrl();
		
		if (ajouterPersonneCtrl.exist(pers) == null) {
			AjouterPersonnelCtrl ajoutPers = new AjouterPersonnelCtrl();
			
			AjouterCommuneCtrl.ajoutCommune(pers.getAdresse().getCommune());
			AjouterAdresseCtrl.ajoutAdresse(pers.getAdresse());
			
			ajoutPers.ajouterPersonnel(pers);
			//session.setAttribute("ajout_personnel", null);
		} else {
			request.setAttribute("dejaInscrit", false);
			this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_ECHEC_AJOUT).forward(request, response);
		}
		
		session.setAttribute("type", request.getParameter("type"));
		session.setAttribute("datedeb", request.getParameter("datedeb"));
		session.setAttribute("datedebEns", request.getParameter("datedebEns"));
		session.setAttribute("duree", request.getParameter("duree"));
		
		request.setAttribute(ResultatServlet.ATTR_TITRE_H1, "Confirmation");
		request.setAttribute(ResultatServlet.ATTR_NOM_BOUTON, "Retour");
		request.setAttribute(ResultatServlet.ATTR_LIEN_BOUTON, Pattern.PERSONNEL_LISTER);
		request.setAttribute(ResultatServlet.ATTR_RESULTAT, "Le personnel " + pers.getNom() + " " +pers.getPrenom() + " a été créé.");

		this.getServletContext().getRequestDispatcher(JSPFile.RESULTAT).forward(request, response);
	}
}