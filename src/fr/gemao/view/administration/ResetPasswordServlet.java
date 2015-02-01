package fr.gemao.view.administration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.ChangerMotDePasseCtrl;
import fr.gemao.ctrl.personnel.RecupererPersonnelCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.form.util.Form;
import fr.gemao.util.Password;
import fr.gemao.view.ConnexionServlet;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet(Pattern.ADMINISTRATION_RESET_PASSWORD)
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String ATTR_LISTE_PERSONNEL = "listePersonnel",
			ATTR_PERSONNE = "personne",
			ATTR_ERREUR = "erreur",
			CHAMP_ID_PERSONNEL = "idPersonne",
			CHAMP_CACHE = "id",
			CHAMP_MOT_DE_PASSE = "password";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1er passage : on envoie juste la liste du personnel et on affiche la vue
		RecupererPersonnelCtrl ctrl = new RecupererPersonnelCtrl();
		request.setAttribute(ATTR_LISTE_PERSONNEL, ctrl.recupererTousPersonnels());
		request.getRequestDispatcher(JSPFile.ADMINISTRATION_RESET_PASSWORD).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecupererPersonnelCtrl recupPersonneCtrl = new RecupererPersonnelCtrl();
		ChangerMotDePasseCtrl changerMdpCtrl = new ChangerMotDePasseCtrl();
		
		long id = Long.parseLong(Form.getValeurChamp(request, CHAMP_ID_PERSONNEL));
		Personnel personne = recupPersonneCtrl.recupererPersonnel(id);
		
		if(Form.getValeurChamp(request, CHAMP_CACHE)==null){
			// Envoi déclenché par la liste déroulante
			request.setAttribute(ATTR_LISTE_PERSONNEL, recupPersonneCtrl.recupererTousPersonnels());
			request.setAttribute(CHAMP_ID_PERSONNEL, Form.getValeurChamp(request, CHAMP_ID_PERSONNEL));
		} else {
			// Clic sur le bouton 'Valider'
			
			// Test du mot de passe de la personne effectuant la modification
			String password = Form.getValeurChamp(request, CHAMP_MOT_DE_PASSE);
			String login = ((Personnel)request.getSession().getAttribute(ConnexionServlet.ATT_SESSION_USER)).getLogin();
			
			if(!changerMdpCtrl.controlerMotDePasse(login, password)){
				//Mot de passe incorrect
				request.setAttribute(ATTR_ERREUR, "Le mot de passe saisi est incorrect.");
				request.setAttribute(ATTR_LISTE_PERSONNEL, recupPersonneCtrl.recupererTousPersonnels());
				request.setAttribute(CHAMP_ID_PERSONNEL, Form.getValeurChamp(request, CHAMP_ID_PERSONNEL));
			} else {
				// Modification du mot de passe
				personne.setPassword(Password.generatePassword());
				if(!changerMdpCtrl.changerMotDePasse(personne)){
					request.setAttribute(ATTR_ERREUR, "Un problème est survenu lors du changement de mot de passe.");
					request.setAttribute(ATTR_LISTE_PERSONNEL, recupPersonneCtrl.recupererTousPersonnels());
					request.setAttribute(CHAMP_ID_PERSONNEL, Form.getValeurChamp(request, CHAMP_ID_PERSONNEL));
				}
			}
		}
		
		request.setAttribute(ATTR_PERSONNE, personne);
		request.getRequestDispatcher(JSPFile.ADMINISTRATION_RESET_PASSWORD).forward(request, response);
	}

}
