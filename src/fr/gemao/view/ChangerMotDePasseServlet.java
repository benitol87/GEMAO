package fr.gemao.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.ChangerMotDePasseCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.form.ChangerMotDePasseForm;

/**
 * Servlet implementation class ChangerMotDePasseServlet
 */
@WebServlet(Pattern.CHANGER_MOT_DE_PASSE)
public class ChangerMotDePasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static String ATTR_FORM = "form", ATTR_RESULTAT = "resultat",
    		ATTR_LIEN_BOUTON="lienBouton", ATTR_NOM_BOUTON = "nomBouton",
    		VALEUR_LIEN_BOUTON="/";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Première arrivée sur la page : on affiche le formulaire
		request.getRequestDispatcher(JSPFile.CHANGER_MOT_DE_PASSE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Le formulaire vient d'être envoyé
		ChangerMotDePasseForm form = new ChangerMotDePasseForm(request);
		
		if(form.getErreurs().isEmpty()){
			ChangerMotDePasseCtrl ctrl = new ChangerMotDePasseCtrl();
			
			// Contrôle de la validité de l'ancien mot de passe
			String login = ((Personnel)request.getSession().getAttribute(ConnexionServlet.ATT_SESSION_USER)).getLogin();
			if(ctrl.controlerMotDePasse(login, form.getAncienMotDePasse())){
				// Modification du mot de passe
				if(!ctrl.changerMotDePasse(login, form.getNouveauMotDePasse())){
					form.setErreur(ChangerMotDePasseForm.ERREUR_NOUVEAUX_MDP, "Un problème est intervenu lors de la modification du mot de passe.");
				}
			} else {
				form.setErreur(ChangerMotDePasseForm.ERREUR_ANCIEN_MDP, "Le mot de passe saisi est incorrect");
			}
			
			
		}
		
		if(form.getErreurs().isEmpty()){
			request.setAttribute(ATTR_LIEN_BOUTON, VALEUR_LIEN_BOUTON);
			request.setAttribute(ATTR_NOM_BOUTON, "Retour");
			request.setAttribute(ATTR_RESULTAT, "Le changement de mot de passe a bien été effectué.");
			request.getRequestDispatcher(JSPFile.RESULTAT).forward(request, response);
		} else {
			// Retour au formulaire
			request.setAttribute(ATTR_FORM, form);
			request.getRequestDispatcher(JSPFile.CHANGER_MOT_DE_PASSE).forward(request, response);
		}
		
	}

}
