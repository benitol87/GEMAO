package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.form.adherent.VerifierSyntaxeResponsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsableDAO;

public class AjouterResponsableCtrl {

	/**
	 * Constructeur
	 */
	public AjouterResponsableCtrl(){
	}
	
	/**
	 * Méthode permettant d'ajouter un responsable dans la BD
	 * @param responsable
	 */
	public void ajouterResponsable(Responsable responsable){
		
		VerifierSyntaxeResponsable verifResp = new VerifierSyntaxeResponsable();
		
		if(verifResp.verifierInformations(responsable)){
			
			Responsable test1, test2;

			DAOFactory co = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = co.getResponsableDAO();

			test1 = responsableDAO.create(responsable);
			if (test1 == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				responsable.setIdResponsable(test1.getIdResponsable());
				test2 = responsableDAO.create(responsable);
				if (test2 == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					System.out.println("Le responsable a bien été ajouté.");
				}
			}
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}
	}
}
