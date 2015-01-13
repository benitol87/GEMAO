package fr.gemao.ctrl.materiel;

import java.util.List;

import fr.gemao.entity.materiel.Reparateur;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.gestionMateriel.ReparateurDAO;

public class ReparateurCtrl {

	/**
	 * Permet d'ajouter un reparateur dans la base.
	 * 
	 * @param nom
	 *            le nom du reparateur a rajouter dans la base.
	 */
	public void ajoutReparateur(String nom) {
		if (nom == null) {
			throw new NullPointerException(
					"Le nom du reparateur ne doit pas etre null");
		}

		if (nom == "") {
			throw new IllegalArgumentException(
					"Le nom du reparateur doit etre renseigne");
		}

		Reparateur rep = new Reparateur(0, nom);
		new ReparateurDAO(DAOFactory.getInstance()).create(rep);
	}

	/**
	 * Supprime le Reparateur portant le nom passé en parametre. Si il y a
	 * plusieur Reparateurs, seul le premier est supprimé.
	 * 
	 * @param nom
	 *            le nom du réparateur à supprimer.
	 */
	public void supprimerReparateur(String nom) {
		if (nom == null) {
			throw new NullPointerException(
					"Le nom du reparateur ne doit pas etre null");
		}

		if (nom == "") {
			throw new IllegalArgumentException(
					"Le nom du reparateur doit etre renseigne");
		}

		ReparateurDAO repDAO = new ReparateurDAO(DAOFactory.getInstance());

		List<Reparateur> reps = repDAO.getAll();
		for (Reparateur rep : reps) {
			if (rep.getNom().equals(nom)) {
				repDAO.delete(rep);
				break;
			}
		}
	}
}
