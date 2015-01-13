package fr.gemao.form.adherent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.adherent.Responsable;

public class VerifierSyntaxeResponsable {
	
	/**
	 * Constructeur
	 */
	public VerifierSyntaxeResponsable(){
	}
	
	/**
	 * Méthode permettant de vérifier les informations d'un responsable
	 * @param responsable
	 * @return true si toutes les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Responsable responsable) {
		
		String masque;
		Pattern pattern;
		Matcher controler;
		boolean isValide = true;
		
		//Vérification de l'idResponsable
		if (responsable.getIdResponsable() < 0.0) {
			System.out.println("L'idResponsable doit être positif...");
			isValide = false;
		}
		
		//Vérification du nom
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getNom());
		
		if (!controler.matches()) {
			System.out.println("Le format du nom est invalide...");
			isValide = false;
		}
		
		//Vérification du prénom
		masque = "^[A-Za-z\\-]+$";
		controler = pattern.matcher(responsable.getPrenom());
		
		if (!controler.matches()) {
			System.out.println("Le format du prénom est invalide...");
			isValide = false;
		}
		
		//Vérification du numéro de téléphone
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getTelephone());
		
		if (!controler.matches() && responsable.getTelephone() != null) {
			System.out.println("Le format du numéro de téléphone est invalide...");
			isValide = false;
		}
		
		//Vérification de l'adresse mail
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getEmail());
		
		if (!controler.matches() && responsable.getEmail() != null) {
			System.out.println("Le format de l'adresse email est invalide...");
			isValide = false;
		}
		
		return isValide;
	}
}