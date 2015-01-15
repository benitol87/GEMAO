package gemao.mysql;

import java.util.List;

import fr.gemao.entity.materiel.Designation;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.DesignationDAO;

public class TestDesignationDAO {
	public static void main(String[] args) {
		// On recupere une instance de Connection a la base
		DAOFactory co = DAOFactory.getInstance();
		// On creer un Objet DesignationDAO qui gere les operations sur la base
		DesignationDAO designationDAO = new DesignationDAO(co);

		// On recupere la designation dans la base avec l'id = 1
		Designation designation = designationDAO.get(1);
		System.out.println(designation);

		// Si on cherche une designation qui n'existe pas, on obtient null
		Designation designationNull = designationDAO.get(0);
		System.out.println(designationNull);

		// Pour obtenir toutes les designations
		List<Designation> liste = designationDAO.getAll();
		System.out.println("\n Designations : ");
		for (Designation d : liste) {
			System.out.println(d);
		}

		System.out.println("\nAjout");
		// Pour ajouter une designation a la base on cree l'objet correspondant
		// N.B l'id est egale a 0 car auto incrementation
		Designation designationAdd = new Designation(0, "Designation 1");
		// On ajoute a la base la designation, on recupere la designation
		// effectivement ajoutee
		Designation rs = designationDAO.create(designationAdd);
		System.out.println(rs);

		// Pour obtenir toutes les designations
		liste = designationDAO.getAll();
		System.out.println("\n Designations : ");
		for (Designation d : liste) {
			System.out.println(d);
		}

		// Pour supprimer il suffit de passer en parametre la designation avec
		// l'id correspondant
		// N.B l'objet peut etre vide mis e part pour l'id
		System.out.println("\nSuppression");
		try {
			designationDAO.delete(rs);
		} catch (UnsupportedOperationException uOe) {
			uOe.printStackTrace();
		}

		liste = designationDAO.getAll();
		System.out.println("\n Designations : ");
		for (Designation d : liste) {
			System.out.println(d);
		}
	}
}
