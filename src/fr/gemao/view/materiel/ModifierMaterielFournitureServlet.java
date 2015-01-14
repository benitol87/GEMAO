package fr.gemao.view.materiel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Materiel;

@WebServlet("/materiel/ModifierMaterielFourniture")
public class ModifierMaterielFournitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/materiel/modifierMaterielFourniture.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MaterielCtrl matctrl = new MaterielCtrl();
		Materiel mat = matctrl.recupererMateriel(3);

		// tester mat

		request.setAttribute("materiel", mat);

		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}
}
