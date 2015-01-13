package fr.gemao.ctrl.personnel;

import fr.gemao.entity.Personnel;

/**
 * Classe AjouterPersonnelCtrl
 * @author Coco
 *
 */
public class AjouterPersonnelCtrl {

	/**
	 * Constructeur
	 */
	public AjouterPersonnelCtrl() {
		
	}
	
	/**
	 * Méthode permettant d'ajouter un personnel dans la base de données
	 * @param personnel : le personnel à ajouter
	 */
	public static void ajouterPersonnel(Personnel personnel) {
		
		if (personnel == null) {
			throw new IllegalArgumentException("Le personnel ne peut pas être null");
		}
		
	}
}