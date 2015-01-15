package fr.gemao.ctrl.adherent;

import fr.gemao.ctrl.ModifierPersonneCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;

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
	 * Méthode permettant de modifier un adhérent
	 * @param adherent : l'adhérent modifié
	 */
	public void modifierAdherent(Adherent adherent) {
		AjouterAdherentCtrl ajoutAdherent = new AjouterAdherentCtrl();
		
		if (ajoutAdherent.verifierInformations(adherent)) {
			ModifierPersonneCtrl modifPers = new ModifierPersonneCtrl();
			
			if (modifPers.modifierPersonne(adherent) != -1) {
				Adherent adh;
				
				DAOFactory co = DAOFactory.getInstance();
				AdherentDAO adherentDAO = co.getAdherentDAO();
				
				adh = adherentDAO.update(adherent);
				
				if(adh == null) {
					System.out.println("Une erreur est survenue lors de la modification.");
				} else {
					System.out.println("L'adhérent a bien été modifié.");
				}
			} else {
				System.out.println("Une erreur est survenue lors de la modification");
			}	
		} else {
			System.out.println("Les informations de l'adhérent ne sont pas valides");
		}	
	}
}