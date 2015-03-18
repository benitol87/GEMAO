package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.adherent.RecupererDisciplineCtrl;
import fr.gemao.entity.cours.Discipline;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ListerDisciplinesServlet
 */
@WebServlet(Pattern.ADHERENT_LISTE_DISCIPLINES)
public class ListerDisciplinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		RecupererDisciplineCtrl recupDisciplineCtrl = new RecupererDisciplineCtrl();
		session.setAttribute("listDiscipline",
				recupDisciplineCtrl.recupererAllDiscipline());

		this.getServletContext()
				.getRequestDispatcher(JSPFile.ADHERENT_LISTE_DISCIPLINES)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
