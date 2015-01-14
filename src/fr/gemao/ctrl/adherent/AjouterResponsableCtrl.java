package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsableDAO;

public class AjouterResponsableCtrl {

	/**
	 * Constructeur
	 */
	public AjouterResponsableCtrl(){
	}
	
	public boolean verifierInformations(Responsable responsable){
		//A implémenter
		return true;
	}
	
	/**
	 * Méthode permettant d'ajouter un responsable dans la BD
	 * @param responsable
	 */
	public void ajouterResponsable(Responsable responsable){
		if(this.verifierInformations(responsable)){
			
			Responsable test;

			DAOFactory co = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = co.getResponsableDAO();

			test = responsableDAO.create(responsable);
			if (test == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				responsable.setIdResponsable(test.getIdResponsable());
				System.out.println("Le responsable a bien été ajouté.");
			}
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}
	}
}
