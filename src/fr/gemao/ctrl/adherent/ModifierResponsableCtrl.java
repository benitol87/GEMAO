package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.ResponsableDAO;

public class ModifierResponsableCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierResponsableCtrl(){
	}
	
	/**
	 * Méthode permettant de modifier un responsable dans la BD.
	 * La modification a lieu seulement si les informations du responsable sont valides et si le responsable existe déjà dans la base.
	 * @param responsable
	 * @return 
	 */
	public static boolean modifierResponsable(Responsable responsable){
		AjouterResponsableCtrl ajoutResp = new AjouterResponsableCtrl();
		
		//Vérification de la validité des informations du responsable
		if(ajoutResp.verifierInformations(responsable)){
			Responsable resp;
			
			DAOFactory co = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = co.getResponsableDAO();
			
			//On modifie uniquement si le responsable existe déjà dans la base
			if(responsableDAO.exist(responsable) != null){
				resp = responsableDAO.update(responsable);
				if(resp == null){
					System.out.println("Une erreur est survenue lors de la modification...");
				}
				else{
					System.out.println("Le responsable a bien été modifié.");
					return true;
				}
			}
			else{
				responsable.setIdResponsable(null);
				ajoutResp.ajouterResponsable(responsable);
			}			
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}	
		return false;
	}
}