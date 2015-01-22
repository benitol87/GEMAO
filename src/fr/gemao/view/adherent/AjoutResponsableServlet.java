package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.entity.Commune;
import fr.gemao.entity.adherent.Responsable;

/**
 * Servlet implementation class AjoutResponsableServlet
 */
@WebServlet("/adherent/AjoutResponsable")
public class AjoutResponsableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/adherent/ajoutResponsable.jsp";
	private String URL_QF = "/GEMAO/adherent/CalculerQF";
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
		HttpSession session = request.getSession();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		Responsable responsable = new Responsable(null, nom, prenom, tel, email);
		System.out.println("Ajout resp " + responsable);

		session.setAttribute("ajout_adh_responsable", responsable);
		Commune commune = (Commune) session.getAttribute("ajout_adh_commune"); 

		if(commune.isAvantage()){
			response.sendRedirect(URL_QF);
		}else{
			response.sendRedirect(URL_VALIDATION);
		}
	}

}
