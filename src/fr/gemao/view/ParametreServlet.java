package fr.gemao.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.ParametreCtrl;
import fr.gemao.entity.Parametre;
import fr.gemao.form.ParametreForm;

/**
 * Servlet implementation class ParametreServlet
 */
@WebServlet("/Parametre")
public class ParametreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE_PARAMETRE = "/WEB-INF/pages/parametre.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_PARAMETRE)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ParametreForm form = new ParametreForm();

		Parametre parametre = form.ajoutParametre(request);
		if (form.getErreurs().isEmpty()) {
			ParametreCtrl parametreCtrl = new ParametreCtrl();
			try {
				parametreCtrl.controlerParametre(parametre);
			} catch (Exception e) {
				form.setErreur("Parametre", e.getMessage());
			}
		} else {

		}
		this.getServletContext().getRequestDispatcher(VUE_PARAMETRE)
				.forward(request, response);
	}

}
