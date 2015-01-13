package fr.gemao.ctrl.materiel;

import java.util.List;

import fr.gemao.entity.materiel.Categorie;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.CategorieDAO;

public class CategorieCtrl {
	/**
	 * Permet d'ajouter une categorie dans la base de donees
	 * 
	 * @param libelle
	 *            le libelle de la categorie a rajouter.
	 */
	public static void ajoutCategorie(String libelle) {

		if (libelle == null) {
			throw new NullPointerException("Le libelle ne peut etre null");
		}
		if (libelle == "") {
			throw new NullPointerException("Le libelle ne doit pas etre vide");
		}
		Categorie categorie = new Categorie(0, libelle);

		new CategorieDAO(DAOFactory.getInstance()).create(categorie);
	}

	/**
	 * Permet de supprimer une categorie de la base. Si plusieurs categories
	 * sont presentes avec le meme libelle, seule la premiere sera supprimee.
	 * 
	 * @param libelle
	 *            le libelle de la categorie a supprimer.
	 */
	public static void supprimerCategorie(String libelle) {

		if (libelle == null) {
			throw new NullPointerException("Le libelle ne peut etre null");
		}
		if (libelle == "") {
			throw new NullPointerException("Le libelle ne doit pas etre vide");
		}

		CategorieDAO catdao = new CategorieDAO(DAOFactory.getInstance());

		List<Categorie> cats = catdao.getAll();
		for (Categorie cat : cats) {
			if (cat.getLibelleCat().equals(libelle)) {
				catdao.delete(cat);
				break;
			}
		}
	}
}
