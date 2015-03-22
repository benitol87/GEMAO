package fr.gemao.ctrl.personnel;

import fr.gemao.entity.Personne;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;
import fr.gemao.sql.PersonnelDAO;

/**
 * La classe ModifierPersonnelCtrl permet de contrôler la modification d'un personnel.
 * 
 * @author Coco
 *
 */
public class ModifierPersonnelCtrl {

	/**
	 * Constructeur
	 */
	public ModifierPersonnelCtrl() {

	}

	/**
	 * Cette méthode permet de vérifier la syntaxe du personnel.
	 * @param personnel : le personnel modifié
	 */
	public long modifierPersonnel(Personnel personnel) {
		AjouterPersonnelCtrl ajoutPersonnel = new AjouterPersonnelCtrl();
		
		//Vérification de la validité des informations
		if (ajoutPersonnel.verifierInformations(personnel)) {
			Personne pers;
			
			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			PersonnelDAO personnelDAO = co.getPersonnelDAO();
			
			//Vérification de l'existance de la personne dans la BD
			if (personneDAO.get(personnel.getIdPersonne()) != null) {
				personneDAO.update(personnel);
				pers = personnelDAO.update(personnel);
				
				if (pers == null) {
					System.out.println("Une erreur est survenue lors de la modification...");
					return -1; 
				} else {
					System.out.println("Le personnel a bien été modifiée.");
					return pers.getIdPersonne();
				}
			} else {
				throw new IllegalArgumentException("Le personnel n'existe pas dans la base...");
			}
		} else {
			System.out.println("Les informations du personnel ne sont pas valides...");
			return -1;
		}
	}
}