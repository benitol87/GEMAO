package fr.gemao.view.materiel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.materiel.ModifierMaterielFournitureForm;

@WebServlet("/materiel/ModifierMaterielFourniture")
public class ModifierMaterielFournitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE_MODIFICATION = "/WEB-INF/pages/materiel/modifierMaterielFourniture.jsp";
	public static final String VUE_LISTE = "/WEB-INF/pages/materiel/listerMateriel";

	/**
	 * Chargement de la page de modification. Le parametre idMateriel doit etre
	 * envoyé pour le doGet (l'id correspond a celui du materiel a modifier.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String param = request.getParameter("idMateriel");

		if (param != null) {
			int idParametre = Integer.parseInt(param);
			MaterielCtrl matctrl = new MaterielCtrl();
			Materiel mat = matctrl.recupererMateriel(idParametre);

			session.setAttribute("materiel", mat);
			request.setAttribute("materiel", mat);

			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION)
					.forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_LISTE)
					.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ModifierMaterielFournitureForm form = new ModifierMaterielFournitureForm();
		form.testerMateriel(request);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		if (form.getErreurs().isEmpty()) {

			MaterielCtrl matctrl = new MaterielCtrl();
			Materiel mat = null;
			if (session.getAttribute("materiel").getClass() == Materiel.class) {
				mat = (Materiel) session.getAttribute("materiel");
				mat.setQuantite(form.getQuantite());
				mat.setObservation(form.getObservation());
				matctrl.modifierMateriel(mat);
				session.removeAttribute("materiel");
			} else {
				form.setErreur("Modification", "Probleme de session");
			}
		}
		if (form.getErreurs().isEmpty()) {
			response.sendRedirect(request.getContextPath() + VUE_LISTE);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION)
					.forward(request, response);
		}
	}
}
