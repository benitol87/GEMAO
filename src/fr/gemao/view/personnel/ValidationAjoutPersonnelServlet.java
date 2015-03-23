package fr.gemao.view.personnel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.entity.personnel.Personnel;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ValidationAjoutPersonnelServlet
 */
@WebServlet(Pattern.PERSONNEL_VALIDATION_AJOUT)
public class ValidationAjoutPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Personnel pers = (Personnel) session.getAttribute("modif_personnel");
		
		request.setAttribute("personnel", pers);
		session.setAttribute("modif_personnel", null);
		
		this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_VALIDATION_AJOUT).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
