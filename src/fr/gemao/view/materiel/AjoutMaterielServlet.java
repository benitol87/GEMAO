package fr.gemao.view.materiel;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.entity.materiel.Etat;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.EtatDAO;



@WebServlet("/materiel/AjouterMateriel")
public class AjoutMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	private String VUE = "/WEB-INF/pages/materiel/ajoutMateriel.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Etat> listEtat = new ArrayList<Etat>();
		listEtat = new EtatDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("etat",listEtat);
		
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
