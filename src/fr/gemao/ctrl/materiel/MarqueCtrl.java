package fr.gemao.ctrl.materiel;

import fr.gemao.entity.materiel.Marque;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.gestionMateriel.MarqueDAO;

public class MarqueCtrl {
	/**
	 * Permet d'ajouter une marque dans la base de données.
	 * 
	 * @param nomMarque
	 *            le nom de la marque a rajouter dans la base.
	 */
	public static void ajouterMarque(String nomMarque) {
		if (nomMarque == null) {
			throw new NullPointerException(
					"Le nom de la marque ne peut etre vide.");
		}
		
		if(nomMarque == ""){
			throw new IllegalArgumentException(
					"Le nom de la marque doit etre renseigne");
		}
		
		Marque marque = new Marque(0, nomMarque);
		new MarqueDAO(DAOFactory.getInstance()).create(marque);
	}

	/**
	 * Permet de supprimer une marque de la base.
	 * 
	 * @param nomMarque
	 *            le nom de la marque a supprimer.
	 */
	public static void supprimerMarque(String nomMarque) {
		if (nomMarque == null) {
			throw new NullPointerException(
					"Le nom de la marque ne peut etre vide.");
		}
		if(nomMarque == ""){
			throw new IllegalArgumentException(
					"Le nom de la marque doit etre renseigne");
		}
		MarqueDAO marquedao = new MarqueDAO(DAOFactory.getInstance());
		Marque marque = marquedao.get(nomMarque);
		marquedao.delete(marque);
	}
}
