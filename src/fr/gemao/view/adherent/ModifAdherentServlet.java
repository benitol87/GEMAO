package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.PersonneCtrl;
import fr.gemao.entity.Personnel;

/**
 * Servlet implementation class ModifAdherentServlet
 */
@WebServlet("/adherent/ModifierAdherent")
public class ModifAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_LISTE = "/GEMAO/adherent/listerAdherent";
	
	private String VUE = "/WEB-INF/pages/adherent/modifAdherent.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String param = request.getParameter("id");
        if (param != null) {
			 int idParametre = Integer.parseInt(param);
			 
			 
			 this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		 } else {
			 response.sendRedirect(VUE_LISTE);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Transmission � la page JSP en charge de l'affichage des donn�es */
		this.getServletContext()
				.getRequestDispatcher(VUE)
				.forward(request, response);
	}

}
