package fr.gemao.ctrl.personnel;

import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.entity.Personnel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonnelDAO;

/**
 * La classe AjouterPersonnelCtrl permet de contrôler l'ajout d'un personnel.
 * 
 * @author Thomas
 *
 */
public class AjouterPersonnelCtrl {

	/**
	 * Constructeur
	 */
	public AjouterPersonnelCtrl() {

	}

	/**
	 * Permet de vérifier les informations d'un personnel
	 * @param personnel : le personnel à vérifier
	 * @return true si la syntaxe du personnel est valide, false, sinon
	 */
	public boolean verifierInformations(Personnel personnel){
		//A implémenter
		return true;
	}

	/**
	 * Méthode permettant d'ajouter un personnel dans la base de données
	 * @param personnel : le personnel à ajouter
	 */
	public void ajouterPersonnel(Personnel personnel) {
		
		if (this.verifierInformations(personnel)) {
			AjouterPersonneCtrl ajoutPers = new AjouterPersonneCtrl();
			
			if (ajoutPers.ajoutPersonne(personnel) != -1) {
				Personnel pers;
				
				DAOFactory co = DAOFactory.getInstance();
				PersonnelDAO personnelDAO = co.getPersonnelDAO();
				
				pers = personnelDAO.create(personnel);
				
				if (pers == null) {
					System.out.println("Une erreur est survenue lors de l'insertion");
				} else {
					System.out.println("Le personnel a bien été ajouté");
				}
			} else {
				System.out.println("Une erreur est survenue lors de l'insertion");
			}
		} else {
			System.out.println("Les informations du personnel ne sont pas valides");
		}
	}
}