package fr.gemao.view.administration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.personnel.RecupererPersonnelCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.form.util.Form;
import fr.gemao.sql.DAOFactory;
import fr.gemao.util.Password;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/administration/ReinitMotDePasse")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String ATTR_LISTE_PERSONNEL = "listePersonnel",
			ATTR_PERSONNE = "personne",
			VUE = "/WEB-INF/pages/administration/resetPassword.jsp",
			CHAMP_ID_PERSONNEL = "idPersonne",
			CHAMP_CACHE = "id";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1er passage : on envoie juste la liste du personnel et on affiche la vue
		RecupererPersonnelCtrl ctrl = new RecupererPersonnelCtrl();
		request.setAttribute(ATTR_LISTE_PERSONNEL, ctrl.recupererTousPersonnels());
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecupererPersonnelCtrl ctrl = new RecupererPersonnelCtrl();
		
		long id = Long.parseLong(Form.getValeurChamp(request, CHAMP_ID_PERSONNEL));
		Personnel personne = ctrl.recupererPersonnel(id);
		
		if(Form.getValeurChamp(request, CHAMP_CACHE)==null){
			// Envoi déclenché par la liste déroulante
			request.setAttribute(ATTR_LISTE_PERSONNEL, ctrl.recupererTousPersonnels());
			request.setAttribute(CHAMP_ID_PERSONNEL, Form.getValeurChamp(request, CHAMP_ID_PERSONNEL));
		} else {
			// TODO Modifier le mot de passe dans la base
			personne.setPassword(Password.generatePassword());
		}
		
		request.setAttribute(ATTR_PERSONNE, personne);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

}
