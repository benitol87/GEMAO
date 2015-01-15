package fr.gemao.view.personnel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.PersonneCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.form.personnel.ModifierPersonnelForm;

/**
 * Servlet implementation class ModifPersonnelServlet
 */
@WebServlet("/personnel/ModifPersonnel")
public class ModifPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_MODIFICATION = "/WEB-INF/pages/personnel/modifPersonnel.jsp";
	public static final String VUE_LISTE = "/WEB-INF/pages/personnel/listePersonnel.jsp";

	/**
	 * Chargement de la page de modification. Le parametre idPersonne doit etre
	 * envoyé pour le doGet (l'id correspond a celui de la personne à modifier.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 
		 String param = request.getParameter("idPersonne");
		 
		 if (param != null) {
			 int idParametre = Integer.parseInt(param);
			 PersonneCtrl persCtrl = new PersonneCtrl();
			 Personnel pers = persCtrl.recupererPersonnel(idParametre);
			 
			 session.setAttribute("sessionObjectPersonnel", pers);
			 
			 this.getServletContext().getRequestDispatcher(VUE_MODIFICATION).forward(request, response);
		 } else {
			 this.getServletContext().getRequestDispatcher(VUE_LISTE).forward(request, response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		ModifierPersonnelForm form = new ModifierPersonnelForm();
		
		form.testerPersonnel(request);
		
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		if (form.getErreurs().isEmpty()) {
			PersonneCtrl persCtrl = new PersonneCtrl();
			Personnel pers = null;
			
			if (session.getAttribute("personnel").getClass() == Personnel.class) {
				pers = (Personnel) session.getAttribute("personnel");
				session.removeAttribute("personnel");
			} else {
				form.setErreur("Modification", "Problème de session");
			}
		}
		
		if (form.getErreurs().isEmpty()) {
			response.sendRedirect(request.getContextPath() + VUE_LISTE);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION).forward(request, response);
		}
	}
}