package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.ctrl.adherent.RecupererResponsableCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;

/**
 * Servlet implementation class ConsulteAdherentServlet
 */
@WebServlet("/ConsulteAdherent")
public class ConsulteAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/pages/adherent/consulteAdherent.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
		Adherent adherent = recupererAdherentCtrl.recupererAdherent(id);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateNaissance = formatter.format(adherent.getDateNaissance());

		if (adherent.getIdResponsable() != null) {
			RecupererResponsableCtrl recupererResponsableCtrl = new RecupererResponsableCtrl();
			Responsable responsable = recupererResponsableCtrl
					.recupererResponsable(adherent.getIdResponsable());
			request.setAttribute("responsable", responsable);
		}

		request.setAttribute("adherent", adherent);
		request.setAttribute("dateNaissance", dateNaissance);
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
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
