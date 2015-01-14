package fr.gemao.view.materiel;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.entity.materiel.Materiel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.CategorieDAO;
import fr.gemao.sql.materiel.DesignationDAO;
import fr.gemao.sql.materiel.MarqueDAO;

@WebServlet("/app/AjouterMateriel")
public class AjoutMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CHAMP_CATEGORIE = "categorie";
	private static final String CHAMP_DESIGNATION = "designation";
	private static final String CHAMP_VALACH = "valeurAch";
	private static final String CHAMP_DATEACH = "dateAch";
	private static final String CHAMP_TYPE = "type";
	private static final String CHAMP_MARQUE = "marque";
	
	private String VUE = "/app/ajoutMateriel.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		String categorie = request.getParameter(CHAMP_CATEGORIE);
		String designation = request.getParameter(CHAMP_DESIGNATION);
		float valAchat = Float.parseFloat(request.getParameter(CHAMP_VALACH));
		String dateAchat = request.getParameter(CHAMP_DATEACH);
		String type = request.getParameter(CHAMP_TYPE);
		String marque = request.getParameter(CHAMP_MARQUE);
		
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
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}
}
