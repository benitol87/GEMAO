package fr.gemao.ctrl.personnel;

import fr.gemao.entity.Personne;
import fr.gemao.entity.Personnel;
import fr.gemao.form.personnel.VerifierSyntaxePersonnel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;
import fr.gemao.sql.PersonnelDAO;

/**
 * La classe ModifierPersonnelCtrl permet de contrôler la modification du
 * personnel.
 * 
 * @author Thomas
 *
 */
public class ModifierPersonnelCtrl {

	/**
	 * Le constructeur de ModifierPersonnelCtrl.
	 */
	public ModifierPersonnelCtrl() {

	}

	/**
	 * Cette méthode permet de vérifier la syntaxe du personnel.
	 * 
	 * @param personnel
	 *            : le personnel modifié
	 */
	public static void modifierPersonnelSyntaxe(Personnel personnel) {
		VerifierSyntaxePersonnel verifperso = new VerifierSyntaxePersonnel();

		if (verifperso.verifierInformations(personnel)) {
			Personne test1;
			Personnel test2;

			DAOFactory factory = DAOFactory.getInstance();
			PersonneDAO personneDAO = factory.getPersonneDAO();
			PersonnelDAO personnelDAO = factory.getPersonnelDAO();

			test1 = personneDAO.update(personnel);
			if (test1 == null) {
				System.out
						.println("Une erreur est survenue lors de la modification");
			} else {
				personnel.setIdPersonne(test1.getIdPersonne());
				test2 = personnelDAO.update(personnel);
				if (test2 == null) {
					System.out
							.println("Une erreur est survenue lors de la modification");
				} else {
					System.out.println("Le personnel à bien été modifié");
				}
			}
		} else {
			System.out
					.println("Les informations du personnel ne sont pas valides");
		}
	}
}
