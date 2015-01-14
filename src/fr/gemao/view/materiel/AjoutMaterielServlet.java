package fr.gemao.view.materiel;

import java.io.IOException;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Marque;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.CategorieDAO;
import fr.gemao.sql.materiel.DesignationDAO;
import fr.gemao.sql.materiel.EtatDAO;
import fr.gemao.sql.materiel.MarqueDAO;
import fr.gemao.sql.materiel.MaterielDAO;



@WebServlet("/materiel/AjouterMateriel")
public class AjoutMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	private static String VUE = "/WEB-INF/pages/materiel/ajoutMateriel.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> listCat = new ArrayList<Categorie>();
		listCat = new CategorieDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_CATEGORIE",listCat);
		
		List<Etat> listEtat = new ArrayList<Etat>();
		listEtat = new EtatDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_ETAT",listEtat);
		
		List<Designation> listDes = new ArrayList<Designation>();
		listDes = new DesignationDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_DESIGNATION",listDes);
		
		List<Marque> listMarque = new ArrayList<Marque>();
		listMarque = new MarqueDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_MARQUE",listMarque);
		
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String categorie = request.getParameter("categorie");
		String designation = request.getParameter("designation");
		float valAchat = Float.parseFloat(request.getParameter("valeurAch"));
		String dateAchat = request.getParameter("dateAch");
		String type = request.getParameter("type");
		String marque = request.getParameter("marque");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		Materiel materiel = new Materiel();
		CategorieDAO catDAO = new CategorieDAO(DAOFactory.getInstance());
		materiel.setCategorie(catDAO.get(categorie));
		DesignationDAO desDAO = new DesignationDAO(DAOFactory.getInstance());
		materiel.setDesignation(desDAO.get(designation));
		materiel.setValeurAchat(valAchat);
		try {
			materiel.setDateAchat((Date) sdf.parse(dateAchat));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MarqueDAO marqDAO = new MarqueDAO(DAOFactory.getInstance());
		materiel.setTypeMat(type);
		materiel.setMarque(marqDAO.get(marque));
		
		MaterielCtrl matCtrl = new MaterielCtrl();
		matCtrl.ajoutMateriel(materiel.getEtat(), materiel.getCategorie(),
				materiel.getMarque(), materiel.getDesignation(),
				materiel.getTypeMat(), materiel.getNumSerie(), materiel.getDateAchat(),
				materiel.getValeurAchat(), materiel.getValeurReap(),materiel.isDeplacable(),materiel.getObservation() );
		
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}
}
