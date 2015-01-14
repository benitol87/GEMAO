package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.entity.adherent.Adherent;

/**
 * Servlet implementation class ConsulteAdherentServlet
 */
@WebServlet("/ConsulteAdherent")
public class ConsulteAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VUE_CONSULTEADHERENT = "/consulteAdherent.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
		Adherent adherent = recupererAdherentCtrl.recupererAdherent(id);
		
		this.getServletContext().getRequestDispatcher( VUE_CONSULTEADHERENT ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
