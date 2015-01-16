package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.ctrl.adherent.RecupererResponsableCtrl;
import fr.gemao.entity.Discipline;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DisciplineDAO;

/**
 * Servlet implementation class ConsulteAdherentServlet
 */
@WebServlet("/adherent/ConsulteAdherent")
public class ConsulteAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/pages/adherent/consulteAdherent.jsp";
	public final String PARAM_DATE_NAISSANCE = "dateNaissance";
	public final String PARAM_DATE_INSCRIPTION = "dateInscription";
	public final String PARAM_ADHERENT = "adherent";
	
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

		String dateInscription = formatter.format(adherent.getDateEntree());

//		if (adherent.getResponsable() != null) {
//			RecupererResponsableCtrl recupererResponsableCtrl = new RecupererResponsableCtrl();
//			Responsable responsable = recupererResponsableCtrl
//					.recupererResponsable(adherent.getResponsable().getIdResponsable());
//			request.setAttribute("responsable", responsable);
//		}
		

		request.setAttribute(PARAM_ADHERENT, adherent);
		request.setAttribute(PARAM_DATE_NAISSANCE, dateNaissance);
		request.setAttribute(PARAM_DATE_INSCRIPTION, dateInscription);
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

}
