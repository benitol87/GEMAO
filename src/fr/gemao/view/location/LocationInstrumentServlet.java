package fr.gemao.view.location;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.materiel.CategorieCtrl;
import fr.gemao.ctrl.materiel.DesignationCtrl;
import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.form.location.LocationForm;

/**
 * Servlet implementation class locationInstrumentServlet
 */
@WebServlet("/location/locationInstrument")
public class LocationInstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private String VUE = "/WEB-INF/pages/location/locationInstrument.jsp";
	
	private final String PARAM_ID_CATEGORIE = "idCategorie";
	private final String PARAM_NOM_CATEGORIE = "nomCategorie";
	private final String PARAM_LISTE_CATEGORIE	= "listeCategorie";
	private final String PARAM_LISTE_DESIGNATION	= "listeDesignation";
	private final String PARAM_LISTE_ADHERENT		= "listeAdherent";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1er passage : choix de la catégorie
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
		
		LocationForm locationForm = new LocationForm(request);
		HttpSession session = request.getSession();
		CategorieCtrl categorieCtrl = new CategorieCtrl();
		DesignationCtrl designationCtrl = new DesignationCtrl();
		
		if(locationForm.getCategorie()!=null){
			int idCategorie = Integer.parseInt(locationForm.getCategorie());
			// 2ème passage :	la catégorie vient d'être choisie,
			// 					choix de la désignation
			
			// Mise du numéro de la catégorie dans la session
			session.setAttribute(PARAM_ID_CATEGORIE, idCategorie);
			
			request.setAttribute(PARAM_NOM_CATEGORIE, categorieCtrl.recupererCategorie(idCategorie).getLibelleCat());
			
			// Récupération de la liste 
			List<Designation> listeDesignation = designationCtrl.recupererToutesDesignations();
			request.setAttribute(PARAM_LISTE_DESIGNATION, listeDesignation);
		} else if(locationForm.getDesignation()!=null){
			// 3ème passage :	la désignation vient d'être choisie,
			// 					choix de l'instrument
			
		} else {
			// Dernier passage : Toutes les informations ont été choisies
			
		}
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
