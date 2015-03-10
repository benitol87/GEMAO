package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;
import fr.gemao.sql.adherent.AdherentDAO;

public class DesinscrireAdherentCtrl {

	public DesinscrireAdherentCtrl(){
	}
	
	public void desinscrireAdherent(Adherent adherent){

		//Vérification de l'existance de la personne
		DAOFactory co = DAOFactory.getInstance();
		PersonneDAO personneDAO = new PersonneDAO(co);
		if (personneDAO.exist(adherent) != null) {
			AdherentDAO adherentDAO = new AdherentDAO(co);
			
			//Mise à jour
			Adherent adh = adherentDAO.update(adherent);		
			if(adh == null) {
				System.out.println("Une erreur est survenue lors de la désinscription.");
			} else {
				System.out.println("L'adhérent a bien été désinscrit.");
			}
		}
		else{
			System.out.println("L'adhérent n'existe pas dans la base...");
		}
	}
}
