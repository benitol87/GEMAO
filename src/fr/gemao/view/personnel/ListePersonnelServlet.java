package fr.gemao.view.personnel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.personnel.RecupererPersonnelCtrl;
import fr.gemao.entity.Personnel;

/**
 * Servlet implementation class ListePersonnelServlet
 */
@WebServlet("/personnel/ListePersonnel")
public class ListePersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_LISTEPERSONNELS = "/WEB-INF/pages/personnel/listePersonnel.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RecupererPersonnelCtrl recupererPersonnelCtrl = new RecupererPersonnelCtrl();
		List<Personnel> personnels = recupererPersonnelCtrl.recupererTousPersonnels();
		request.setAttribute("listePersonnels", personnels);
		this.getServletContext().getRequestDispatcher( VUE_LISTEPERSONNELS ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
