package fr.gemao.form;

import fr.gemao.entity.Adresse;

public class VerifierSyntaxeAdresse {
	
	/**
	 * Constructeur
	 */
	public VerifierSyntaxeAdresse(){
	}
	
	/**
	 * Méthode permettant de vérifier les informations d'une adresse
	 * @param adresse
	 * @return true si toutes les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Adresse adresse){
		
		boolean isValide = true;
		
		//Vérification de l'idAdresse
		if(adresse.getIdAdresse() < 0){
			System.out.println("L'idAdresse doit être positif...");
			isValide = false;
		}
		
		//Vérification de l'idCommune
		if(adresse.getIdCommune() < 0){
			System.out.println("L'idCommune doit être positif...");
			isValide = false;
		}
		
		//Vérification du numéro de rue
		if(adresse.getNumRue() <= 0){
			System.out.println("Le numéro de rue doit être strictement positif...");
			isValide = false;
		}
		
		return isValide;
	}
}
