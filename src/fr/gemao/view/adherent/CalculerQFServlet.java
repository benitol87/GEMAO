package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.ParametreCtrl;
import fr.gemao.ctrl.adherent.CalculerQuotientCtrl;
import fr.gemao.entity.Parametre;
import fr.gemao.entity.adherent.Adherent;

/**
 * Servlet implementation class CalculerQFServlet
 */
@WebServlet("/adherent/CalculerQF")
public class CalculerQFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/adherent/calculQF.jsp";
	private String VUE_ERREUR = "/WEB-INF/pages/erreurs/404.jsp";
	private String URL_VALIDATION = "/GEMAO/adherent/ValidationAjoutAdherent";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CalculerQuotientCtrl calculerQuotientCtrl = new CalculerQuotientCtrl();

		Float quotient = calculerQuotientCtrl.calculerQuotient(request);
		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("ajout_adh_adherent");
		System.out.println(adherent);
		System.out.println(quotient);
		adherent.setQf(quotient);
		session.setAttribute("ajout_adh_adherent", adherent);

		response.sendRedirect(URL_VALIDATION);

		// float cotisationFormation = 0;
		// float cotisationInstrument = 0;
		//
		// ParametreCtrl parametreCtrl = new ParametreCtrl();
		// Parametre parametre = parametreCtrl.getLast();
		// cotisationFormation = parametre.getTarifFormation();
		//
		// if (quotient <= parametre.getQf_min() - 0.01) {
		// cotisationFormation = cotisationFormation / 2;
		// cotisationInstrument = cotisationInstrument / 2;
		// } else if (quotient >= parametre.getQf_min()
		// && quotient <= parametre.getQf_max() - 0.01) {
		// cotisationFormation = cotisationFormation * 2 / 3;
		// cotisationInstrument = cotisationInstrument * 2 / 3;
		// } else if (quotient > parametre.getQf_max()) {
		// cotisationFormation = cotisationFormation;
		// cotisationInstrument = cotisationInstrument;
		// } else {
		// cotisationFormation = 0;
		// cotisationInstrument = 0;
		// }
		//
		// request.setAttribute("cotisationFormation", cotisationFormation);
		// request.setAttribute("cotisationInstrument", cotisationInstrument);
		// this.getServletContext().getRequestDispatcher(VUE)
		// .forward(request, response);
	}

}
