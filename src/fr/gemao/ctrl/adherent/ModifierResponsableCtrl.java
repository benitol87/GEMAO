package fr.gemao.ctrl.adherent;

import java.sql.Connection;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.form.adherent.VerifierSyntaxeAdherent;
import fr.gemao.form.adherent.VerifierSyntaxeResponsable;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.PersonneDAO;

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
			
			Connection co = ConnectionMySql.getInstance();
			ResponsableDAO responsableDAO = new ResponsableDAO(co);
			
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