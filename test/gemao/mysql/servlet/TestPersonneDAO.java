package gemao.mysql.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.entity.Personne;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;
import fr.gemao.sql.config.InitialisationDaoFactory;

@WebServlet(name = "PersonneDAO", urlPatterns = "/testPersonneDAO")
public class TestPersonneDAO extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = (DAOFactory) getServletContext().getAttribute(
				InitialisationDaoFactory.ATT_DAO_FACTORY);
		
		PersonneDAO personneDAO = factory.getPersonneDAO();

		// On recup�re la personne dans la base avec l'id = 1
		Personne personne = personneDAO.get(1);
		System.out.println(personne);

		// Si on cherche une personne qui n'existe pas un obtient null
		Personne personneNull = personneDAO.get(0);
		System.out.println(personneNull);

		// Pour obtenir tous les adh�rent
		List<Personne> liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for (Personne p : liste) {
			System.out.println(p);
		}

		System.out.println("\nAjout");
		// Pour ajouter une personne � la base on creer l'objet correspondant
		// N.B l'id est �gale � 0 car auto incr�mentation
		Personne personneAdd = new Personne(0L, 1L, 1L, "Test", "Riri",
				new Date(), "0504030201", "0605040302", "riri@unilim.fr");
		// On ajoute � la base la personne, on r�cup�re la personne
		// effectivement ajouter
		Personne rs = personneDAO.create(personneAdd);
		System.out.println(rs);

		// Pour mettre � jour on passe une Personne avec l'id correspondant avec
		// les nouvelle
		// informations
		rs.setNom("DuChemoile");
		rs = personneDAO.update(rs);
		System.out.println("\n Mise � jour !");
		System.out.println(rs);

		liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for (Personne p : liste) {
			System.out.println(p);
		}

		// Pour supprimer il suffit de passer en param�tre la personne avec l'id
		// correspondant
		// N.B l'objet peut �tre vide mis � part pour l'id
		System.out.println("\nSuppression");
		try {
			personneDAO.delete(rs);
		} catch (UnsupportedOperationException uOe) {
			uOe.printStackTrace();
		}

		liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for (Personne p : liste) {
			System.out.println(p);
		}
	}
}
