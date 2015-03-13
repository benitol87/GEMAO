package fr.gemao.ctrl.adherent;

import fr.gemao.entity.cours.Discipline;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.cours.DisciplineDAO;

public class AjouterDisciplineCtrl {

	/**
	 * Méthode permettant d'ajouter un responsable dans la BD. La méthode
	 * vérifie la validité des informations et si la personne n'existe pas déjà
	 * dans la base avant l'ajout.
	 * 
	 * @param responsable
	 */
	/*public static void ajouterDiscipline(String discipline) {

		Discipline disc = new Discipline(null, discipline);

		DAOFactory co = DAOFactory.getInstance();
		DisciplineDAO disciplineDAO = co.getDisciplineDAO();

		// Vérification de l'inexistance de la discipline dans la base
		if (disciplineDAO.exist(disc) == null) {
			disc = disciplineDAO.create(disc);
			if (disc == null) {
				System.out
						.println("Une erreur est survenue lors de l'insertion...");
			} else {
				System.out.println("La discipline a bien été ajouté.");
			}
		} else {
			System.out.println(
					"La discipline existe déjà dans la base...");
		}

	}*/
}
