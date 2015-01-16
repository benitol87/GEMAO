package fr.gemao.view.materiel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.materiel.EtatCtrl;
import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.materiel.MaterielForm;

@WebServlet("/materiel/ModifierMateriel")
public class ModifierMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE_MODIFICATION = "/WEB-INF/pages/materiel/modifierMateriel.jsp";
	public static final String VUE_LISTE = "/materiel/ListerMateriel";

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
			EtatCtrl etatctrl = new EtatCtrl();

			session.setAttribute("sessionObjectMateriel", mat);
			List<Etat> listEtats = etatctrl.getListeEtat();
			listEtats.remove(mat.getEtat());
			session.setAttribute("listeEtats", listEtats);

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
		MaterielForm form = new MaterielForm();
		form.testerMateriel(request);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		System.out.print(form.getErreurs());
		if (form.getErreurs().isEmpty()) {
			MaterielCtrl matctrl = new MaterielCtrl();
			Materiel mat = null;
			if (session.getAttribute("sessionObjectMateriel").getClass() == Materiel.class) {
				mat = (Materiel) session.getAttribute("sessionObjectMateriel");

				mat.setQuantite(form.getQuantite());
				mat.setObservation(form.getObservation());
				mat.setValeurReap(form.getValRea());
				mat.setDeplacable(form.getDeplacable());

				EtatCtrl etatctrl = new EtatCtrl();
				Etat etat = etatctrl.recupererEtat(form.getEtat());
				mat.setEtat(etat);

				matctrl.modifierMateriel(mat);
				session.removeAttribute("materiel");
				session.removeAttribute("listeEtats");
			} else {
				form.setErreur("Modification", "Probleme de session");
			}
		}
		if (form.getErreurs().isEmpty()) {
			response.sendRedirect(request.getContextPath() + VUE_LISTE);
		} else {
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION)
					.forward(request, response);
		}
	}
}
