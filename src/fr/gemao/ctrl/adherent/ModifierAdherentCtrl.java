package fr.gemao.ctrl.adherent;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class ModifierAdherentCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierAdherentCtrl(){
		
	}
	
	/**
	 * Méthode permettant de modifier un adhérent
	 * @param adherent
	 */
	public void modifierAdherent(Adherent adherent){
		AjouterAdherentCtrl ajoutAdherent = new AjouterAdherentCtrl();
		
		if(ajoutAdherent.verifierInformations(adherent)){
			Personne pers;
			Adherent adh;
			
			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			AdherentDAO adherentDAO = co.getAdherentDAO();
			
			pers = personneDAO.update(adherent);
			if(pers == null){
				System.out.println("Une erreur est survenue lors de la modification...");
			}
			else{
				adherent.setIdResponsable(pers.getIdPersonne());
				adh = adherentDAO.update(adherent);
				if(adh == null){
					System.out.println("Une erreur est survenue lors de la modification...");
				}
				else{
					System.out.println("Le responsable a bien été modifié.");
				}
			}
			
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}	
	}

}
