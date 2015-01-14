package fr.gemao.ctrl;

import fr.gemao.entity.Personne;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class ModifierPersonneCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierPersonneCtrl(){
	}
	
	public long modifierPersonne(Personne personne){
		AjouterPersonneCtrl ajoutPersonne = new AjouterPersonneCtrl();
		
		if(ajoutPersonne.verifierInformations(personne)){
			Personne pers;
			
			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			
			pers = personneDAO.update(personne);
			if(pers == null){
				System.out.println("Une erreur est survenue lors de la modification...");
				return -1;
			}
			else{
					System.out.println("La personne a bien été modifiée.");
					return pers.getIdPersonne();
			}
			
		}
		else{
			System.out.println("Les informations de la personne ne sont pas valides...");
			return -1;
		}	
	}

}
