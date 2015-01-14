package fr.gemao.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.ConnexionCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.form.ConnexionForm;


/**
 * Servlet implementation class Connexion
 */
@WebServlet(name="Connexion", urlPatterns={"/Connexion"})
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_USER = "personnel";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionObjectPersonnel";
	public static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";
	public static final String VUE_ACCUEIL = "/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE_CONNEXION ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Personnel personnel = form.connecterPersonnel( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();


		/**
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Utilisateur à la session, sinon suppression du bean de la session.
		 */
		if (form.getErreurs().isEmpty()) {
			ConnexionCtrl connexionCtrl = new ConnexionCtrl();
			try {
				personnel = connexionCtrl.controlerPersonnel(form.getLogin(), form.getMotDePasse());
			} catch (Exception e) {
				form.setErreur("Connexion", e.getMessage());
				personnel = new Personnel();
				personnel.setLogin(form.getLogin());
			}
		}
		
		if (form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_USER, personnel);
			// L'utilisateur voit la redirection
			response.sendRedirect(request.getContextPath() + VUE_ACCUEIL);
		} else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_USER, personnel);
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION)
					.forward(request, response);
		}

	}

}
