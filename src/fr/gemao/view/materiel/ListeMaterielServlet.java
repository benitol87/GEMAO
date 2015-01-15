package fr.gemao.view.materiel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Materiel;

@WebServlet("/materiel/ListerMateriel")
public class ListeMaterielServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static String VUE = "/WEB-INF/pages/materiel/listerMateriel.jsp";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		MaterielCtrl materielCtrl = new MaterielCtrl();
		List<Materiel> materiels = materielCtrl.recupererTousMateriels();
		
		request.setAttribute("listeMateriels", materiels);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			
		   String idMateriel = request.getParameter( "materiel" );
		   session.setAttribute("idMateriel",idMateriel);
		
	}

}
