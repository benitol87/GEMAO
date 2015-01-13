package fr.gemao.ctrl.personnel;

import java.sql.Connection;

import fr.gemao.ctrl.adherent.PersonnelDAO;
import fr.gemao.ctrl.adherent.PersonneDAO;
import fr.gemao.entity.Personne;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.form.personnel.VerifierSyntaxePersonnel;

/**
 * La classe AjouterPersonnelCtrl permet de contrôler l'ajout d'un personnel.
 * @author Thomas
 *
 */
public class AjouterPersonnelCtrl {
	
	/**
	 * Le controleur de AjouterPersonnelCtrl
	 */
	public AjouterPersonnelCtrl(){
		
	}
	
	/**
	 * Méthode permettant d'ajouter un personnel dans la base de données
	 * @param personnel : le personnel à ajouter
	 */
	public static void ajouterPersonnel(Personnel personnel) {
		
		if (personnel == null) {
			throw new IllegalArgumentException("Le personnel ne peut pas être null");
		}
	}
	
	public static void ajouterPersonnelSyntaxe(Personnel personnel){
		VerifierSyntaxePersonnel verifperso = new VerifierSyntaxePersonnel();
		
		if (verifperso.verifierInformations(personnel)) {
			Personne test1;
			Personnel test2;
		
		Connection co = ConnectionMySql.getInstance();
		PersonneDAO personneDAO = new PersonneDAO(co);
		PersonnelDAO personnelDAO = new PersonnelDAO(co);
		
		test1 = personneDAO.create(personnel);
		if (test1 == null){
			System.out.println("Une erreur est survenue lors de l'insertion");
		} else {
			personnel.setIdPersonne(test1.getIdPersonne());
			test2 = personnelDAO.create(personnel);
			if (test2 == null){
				System.out.println("Une erreur est survenue lors de l'insertion");
			} else {
				System.out.println("L'adhérent à bien été ajouté");
			}
		}
	} else {
		System.out
				.println("Les informations de l'adhérent ne sont pas valide");
		}
	}
}

