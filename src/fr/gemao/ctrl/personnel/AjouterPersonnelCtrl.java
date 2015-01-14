package fr.gemao.ctrl.personnel;

import fr.gemao.entity.Personne;
import fr.gemao.entity.Personnel;
import fr.gemao.form.personnel.PersonnelForm;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;
import fr.gemao.sql.PersonnelDAO;

/**
 * La classe AjouterPersonnelCtrl permet de contrôler l'ajout d'un personnel.
 * 
 * @author Thomas
 *
 */
public class AjouterPersonnelCtrl {

	/**
	 * Le controleur de AjouterPersonnelCtrl
	 */
	public AjouterPersonnelCtrl() {

	}

	/**
	 * Méthode permettant d'ajouter un personnel dans la base de données
	 * 
	 * @param personnel
	 *            : le personnel à ajouter
	 */
	public static void ajouterPersonnel(Personnel personnel) {

		if (personnel == null) {
			throw new IllegalArgumentException(
					"Le personnel ne peut pas être null");
		}
	}

	/**
	 * Méthode permettant de vérifier la syntaxe du personnel.
	 * 
	 * @param personnel
	 *            : Le personnel ajouté.
	 */
	public static void ajouterPersonnelSyntaxe(Personnel personnel) {
		PersonnelForm verifperso = new PersonnelForm();

		if (verifperso.verifierInformations(personnel)) {
			Personne test1;
			Personnel test2;

			DAOFactory factory = DAOFactory.getInstance();
			PersonneDAO personneDAO = factory.getPersonneDAO();
			PersonnelDAO personnelDAO = factory.getPersonnelDAO();

			test1 = personneDAO.create(personnel);
			if (test1 == null) {
				System.out
						.println("Une erreur est survenue lors de l'insertion");
			} else {
				personnel.setIdPersonne(test1.getIdPersonne());
				test2 = personnelDAO.create(personnel);
				if (test2 == null) {
					System.out
							.println("Une erreur est survenue lors de l'insertion");
				} else {
					System.out.println("L'adhérent à bien été ajouté");
				}
			}
		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valide");
		}
	}
}
