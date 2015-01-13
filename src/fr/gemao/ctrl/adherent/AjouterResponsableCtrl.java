package fr.gemao.ctrl.adherent;

import java.sql.Connection;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.form.VerifierSyntaxePersonne;
import fr.gemao.form.adherent.VerifierSyntaxeResponsable;

public class AjouterResponsableCtrl {

	/**
	 * Constructeur
	 */
	public AjouterResponsableCtrl(){
	}
	
	public void ajouterResponsable(Responsable responsable){
		
		VerifierSyntaxeResponsable verifResp = new VerifierSyntaxeResponsable();
		
		if(verifResp.verifierInformations(responsable)){
			
			Responsable test1, test2;

			Connection co = ConnectionMySql.getInstance();
			ResponsableDAO responsableDAO = new ResponsableDAO(co);

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
