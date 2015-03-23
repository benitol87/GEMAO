package fr.gemao.ctrl.adherent;

import fr.gemao.ctrl.ModifierPersonneCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.AdherentDAO;

/**
 * La classe ModifierAdherentCtrl permet de contrôler la modification d'un adhérent
 * 
 * @author Coco
 *
 */
public class ModifierAdherentCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierAdherentCtrl() {
		
	}
	
	/**
	 * Méthode permettant de modifier un adhérent.
	 * La méthode vérifie avant si les informations sont valides.
	 * @param adherent : l'adhérent à modifier
	 */
	public static boolean modifierAdherent(Adherent adherent) {
		//Vérification de la validité des informations
		if (AjouterAdherentCtrl.verifierInformations(adherent)) {
			ModifierPersonneCtrl modifPers = new ModifierPersonneCtrl();
			
			//Vérification de la modification de la personne
			if (modifPers.modifierPersonne(adherent) != -1) {
				Adherent adh;
				
				DAOFactory co = DAOFactory.getInstance();
				AdherentDAO adherentDAO = co.getAdherentDAO();
				
				adh = adherentDAO.update(adherent);
				
				if(adh == null) {
					System.out.println("Une erreur est survenue lors de la modification.");
				} else {
					System.out.println("L'adhérent a bien été modifié.");
					return true;
				}
			} else {
				System.out.println("Une erreur est survenue lors de la modification");
			}	
		} else {
			System.out.println("Les informations de l'adhérent ne sont pas valides");
		}
		return false;
	}
}