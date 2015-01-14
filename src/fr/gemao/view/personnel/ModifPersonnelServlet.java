package fr.gemao.view.personnel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifPersonnelServlet
 */
@WebServlet("/ModifPersonnel")
public class ModifPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String VUE = "/WEB-INF/pages/personnel/modifPersonnel.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
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
