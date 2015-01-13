package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.form.adherent.VerifierSyntaxeResponsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsableDAO;

public class ModifierResponsableCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierResponsableCtrl(){
	}
	
	/**
	 * Méthode permettant de modifier un responsable dans la BD
	 * @param responsable
	 */
	public void modifierResponsable(Responsable responsable){
		VerifierSyntaxeResponsable verifResp = new VerifierSyntaxeResponsable();
		
		if(verifResp.verifierInformations(responsable)){
			Responsable test1, test2;
			
			DAOFactory factory = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = factory.getResponsableDAO();
			
			test1 = responsableDAO.update(responsable);
			if(test1 == null){
				System.out.println("Une erreur est survenue lors de la modification...");
			}
			else{
				responsable.setIdResponsable(test1.getIdResponsable());
				test2 = responsableDAO.update(responsable);
				if(test2 == null){
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