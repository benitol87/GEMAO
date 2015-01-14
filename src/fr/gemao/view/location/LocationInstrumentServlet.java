package fr.gemao.view.location;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.ctrl.materiel.CategorieCtrl;
import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Materiel;

/**
 * Servlet implementation class locationInstrumentServlet
 */
@WebServlet("/location/locationInstrument")
public class LocationInstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String VUE = "/WEB-INF/pages/location/locationInstrument.jsp";
	
	private String PARAM_LISTE_CATEGORIE	= "listeCategorie";
	private String PARAM_LISTE_DESIGNATION	= "listeDesignation";
	private String PARAM_LISTE_ADHERENT		= "listeAdherent";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CategorieCtrl categorieCtrl = new CategorieCtrl();
		List<Categorie> listeCategorie = categorieCtrl.recupererToutesCategories();
		
		
		
		
		request.setAttribute(PARAM_LISTE_CATEGORIE, listeCategorie);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
