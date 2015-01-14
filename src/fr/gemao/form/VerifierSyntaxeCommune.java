package fr.gemao.form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.Commune;

public class VerifierSyntaxeCommune {
	
	/**
	 * Constructeur
	 */
	public VerifierSyntaxeCommune(){
	}
	
	/**
	 * Méthode permettant de vérifier les informations d'une commune
	 * @param commune
	 * @return true si toutes les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Commune commune){
		
		boolean isValide = true;
		String masque;
		Pattern pattern;
		Matcher controler;
		
		//Vérification de l'idCommune
		if(commune.getIdCommune() < 0){
			System.out.println("L'idCommune doit être positif...");
			isValide = false;
		}
		
		//Vérification du code postal
		if(commune.getCodePostal() <= 0){
			System.out.println("Le code postal doit être strictement positif...");
			isValide = false;
		}
		
		//Vérification du nom de commune
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(commune.getNomCommune());
		if (!controler.matches()) {
			System.out.println("Le format du nom de la commune est invalide...");
			isValide = false;
		}

		return isValide;
	}
}
