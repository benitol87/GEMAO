package fr.gemao.view.adherent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.ParametreCtrl;
import fr.gemao.ctrl.adherent.CalculerQuotientCtrl;
import fr.gemao.ctrl.adherent.ModifierAdherentCtrl;
import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.entity.Parametre;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ModifierQFServlet
 */
@WebServlet(Pattern.ADHERENT_MODIFER_QF)
public class ModifierQFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null) {
			request.setAttribute("lien", "/adherent/ConsulteAdherent");
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			List<Adherent> adherents = recupererAdherentCtrl
					.recupererTousAdherents();
			ParametreCtrl parametreCtrl = new ParametreCtrl();
			Parametre param = parametreCtrl.getLast();
			request.setAttribute("params", param);
			request.setAttribute("listeAdherents", adherents);
			this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_LISTER)
					.forward(request, response);
		} else {

			int id = Integer.parseInt(request.getParameter("id"));
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			Adherent adherent = recupererAdherentCtrl.recupererAdherent(id);
			
			HttpSession session = request.getSession();

			session.setAttribute("modif_QF_adherent", adherent);

			this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_CALCUL_QF)
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalculerQuotientCtrl calculerQuotientCtrl = new CalculerQuotientCtrl();
		Float quotient = calculerQuotientCtrl.calculerQuotient(request);
		if (quotient != null) {

			HttpSession session = request.getSession();
			
			Adherent adherent = (Adherent) session.getAttribute("modif_QF_adherent");
			adherent.setQf(quotient);			
			
			if(ModifierAdherentCtrl.modifierAdherent(adherent))
				request.setAttribute("modifOK", true);
			else
				request.setAttribute("modifOK", false);
			
			request.setAttribute("adherent", adherent);
			session.setAttribute("modif_QF_adherent", null);
			ParametreCtrl parametreCtrl = new ParametreCtrl();
			Parametre param = parametreCtrl.getLast();
			request.setAttribute("params", param);
			
			this.getServletContext()
			.getRequestDispatcher(JSPFile.ADHERENT_CONFIRMATION_MODIFICATION_QF)
			.forward(request, response);
		} else {
			request.setAttribute("erreurPers", true);
			this.getServletContext()
					.getRequestDispatcher(JSPFile.ADHERENT_CALCUL_QF)
					.forward(request, response);
		}
	}

}
