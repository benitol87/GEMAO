package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.PersonneCtrl;
import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.ctrl.adherent.RecupererResponsableCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;

/**
 * Servlet implementation class ModifAdherentServlet
 */
@WebServlet("/adherent/ModifierAdherent")
public class ModifAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_LISTE = "/WEB-INF/pages/adherent/listeAdherents.jsp";
	private static final String VUE = "/WEB-INF/pages/adherent/modifAdherent.jsp";
	
	public final String PARAM_DATE_NAISSANCE = "dateNaissance";
	public final String PARAM_ADHERENT = "adherent";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("id") == null) {
			request.setAttribute("lien", "/adherent/ModifierAdherent");
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			List<Adherent> adherents = recupererAdherentCtrl
					.recupererTousAdherents();
			request.setAttribute("listeAdherents", adherents);
			this.getServletContext().getRequestDispatcher(VUE_LISTE)
					.forward(request, response);
		} else {
			int id = Integer.parseInt(request.getParameter("id")); 
			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
			Adherent adherent = recupererAdherentCtrl.recupererAdherent(id);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateNaissance = formatter
					.format(adherent.getDateNaissance());
			String dateInscription = formatter.format(adherent.getDateEntree());

			request.setAttribute("adherent", adherent);
			request.setAttribute("dateNaissance", dateNaissance);
			request.setAttribute("dateInscription", dateInscription);			
			this.getServletContext().getRequestDispatcher(VUE)
			.forward(request, response);
		}
		
//		HttpSession session = request.getSession();
//		String param = request.getParameter("id");
//		if (param != null) {
//			int idParametre = Integer.parseInt(param);
//			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
//			Adherent adherent = recupererAdherentCtrl.recupererAdherent(idParametre);
//
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//			String dateNaissance = formatter.format(adherent.getDateNaissance());
//
//			if (adherent.getResponsable() != null) {
//				RecupererResponsableCtrl recupererResponsableCtrl = new RecupererResponsableCtrl();
//				Responsable responsable = recupererResponsableCtrl
//						.recupererResponsable(adherent.getResponsable().getIdResponsable());
//				request.setAttribute("responsable", responsable);
//			}
//			
//
//			request.setAttribute(PARAM_ADHERENT, adherent);
//			request.setAttribute(PARAM_DATE_NAISSANCE, dateNaissance);
//			this.getServletContext().getRequestDispatcher(VUE)
//					.forward(request, response);
//		} else {
//			request.setAttribute("type", 2);
//			RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
//			List<Adherent> adherents = recupererAdherentCtrl
//					.recupererTousAdherents();
//			request.setAttribute("listeAdherents", adherents);
//			this.getServletContext().getRequestDispatcher(VUE_LISTE)
//					.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* Transmission � la page JSP en charge de l'affichage des donn�es */
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

}
