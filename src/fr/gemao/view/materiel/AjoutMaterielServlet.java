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
		
		String etat = request.getParameter("etat");
		String categorie = request.getParameter("categorie");
		String designation = request.getParameter("designation");
		float valAchat = Float.parseFloat(request.getParameter("ValeurAch"));
		float valReap = Float.parseFloat(request.getParameter("valRea"));
		String dateAchat = request.getParameter("dateAch");
		String type = request.getParameter("type");
		String marque = request.getParameter("marque");
		String observation = request.getParameter("observation");
		String numSerie = request.getParameter("numSerie");
		String quantite = request.getParameter("quantite");
		
		Materiel materiel = new Materiel();
		
		EtatDAO etatDAO = new EtatDAO(DAOFactory.getInstance());
		materiel.setEtat(etatDAO.get(Long.parseLong(etat)));
		
		CategorieDAO catDAO = new CategorieDAO(DAOFactory.getInstance());
		materiel.setCategorie(catDAO.get(Long.parseLong(categorie)));
		
		DesignationDAO desDAO = new DesignationDAO(DAOFactory.getInstance());
		materiel.setDesignation(desDAO.get(Long.parseLong(designation)));
		
		materiel.setValeurAchat(valAchat);
		materiel.setValeurReap(valReap);
		materiel.setObservation(observation);
		materiel.setNumSerie(numSerie);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			materiel.setDateAchat(new java.sql.Date(formatter.parse(dateAchat).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		materiel.setTypeMat(type);
		
		System.out.println(marque);
		MarqueDAO marqDAO = new MarqueDAO(DAOFactory.getInstance());
		materiel.setMarque(marqDAO.get(Long.parseLong(marque)));
		System.out.println(materiel);
		
		MaterielCtrl matCtrl = new MaterielCtrl();
		matCtrl.ajoutMateriel(materiel.getEtat(), materiel.getCategorie(),
				materiel.getMarque(), materiel.getDesignation(),
				materiel.getTypeMat(), materiel.getNumSerie(), materiel.getDateAchat(),
				materiel.getValeurAchat(), materiel.getValeurReap(),materiel.isDeplacable(),materiel.getObservation(), Integer.parseInt(quantite) );
		
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}
}
