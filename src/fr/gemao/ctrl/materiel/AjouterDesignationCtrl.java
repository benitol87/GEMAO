package fr.gemao.ctrl.materiel;

import java.sql.Connection;

import fr.gemao.entity.materiel.Designation;


public class AjouterDesignationCtrl {
	public AjouterDesignationCtrl(){
		
	}
	
	public void ajoutDesignation(Designation designation){
		VerifierSyntaxeDesignation verifDesignation = new verifierSyntaxeDesignation();
		
		if(verifDesignation.verifierInformation(designation)){
			
			Designation test;
			
			Connection co = ConnectionMySql.getInstance();
			DesignationDAO designationDAO = new DesignationDAO(co);
			
			test=designationDAO.create(designation);
			if(test == null){
				System.out.println("Une erreur est survenue lors de l'insertion");
			}else {
				System.out.println("la designation à bien été ajouté");
			}
			
		}else {
			System.out
			.println("Les informations de la designation ne sont pas valide");
		}
		
	}
}
