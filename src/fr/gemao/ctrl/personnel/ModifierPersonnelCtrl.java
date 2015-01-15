package fr.gemao.ctrl.personnel;

import fr.gemao.ctrl.ModifierPersonneCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.sql.DAOFactory;
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
	public static void modifierPersonnel(Personnel personnel) {
		AjouterPersonnelCtrl ajoutPersonnel = new AjouterPersonnelCtrl();
		
		if (ajoutPersonnel.verifierInformations(personnel)) {
			ModifierPersonneCtrl modifPers = new ModifierPersonneCtrl();
			
			if (modifPers.modifierPersonne(personnel) != -1) {
				Personnel pers;
				
				DAOFactory co = DAOFactory.getInstance();
				PersonnelDAO personnelDAO = co.getPersonnelDAO();
				
				pers = personnelDAO.update(personnel);
				
				if (pers == null) {
					System.out.println("Une erreur est survenue lors de la modification");
				} else {
					System.out.println("Le personnel a bien été modifié");
				}
			} else {
				System.out.println("Une erreur est survenue lors de la modification");
			}
		} else {
			System.out.println("Les informations du personnel ne sont pas valides");
		}
	}
}