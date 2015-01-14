package fr.gemao.view.materiel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.ConnexionCtrl;
import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.materiel.ModifierMaterielFournitureForm;

@WebServlet("/materiel/ModifierMaterielFourniture")
public class ModifierMaterielFournitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/materiel/modifierMaterielFourniture.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MaterielCtrl matctrl = new MaterielCtrl();
		Materiel mat = matctrl.recupererMateriel(3);

		request.setAttribute("materiel", mat);

		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ModifierMaterielFournitureForm form = new ModifierMaterielFournitureForm();
		form.testerMateriel(request);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		/**
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Utilisateur à la session, sinon suppression du bean de la session.
		 */
		if (form.getErreurs().isEmpty()) {
			try {
				MaterielCtrl matctrl = new MaterielCtrl();
				Materiel mat = matctrl.recupererMateriel(3);
				// ajout de la quantité a rajouter
				mat.setObservation(form.getObservation());
				matctrl.modifierMateriel(mat);
			} catch (Exception e) {
				form.setErreur("Connexion", e.getMessage());
			}
		}
	}
}
