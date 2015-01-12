package fr.gemao.form;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.Personne;



public class VerifierSyntaxePersonne {

	public VerifierSyntaxePersonne() {

	}

	/**
	 * Vérifie les informations d'une personne
	 * 
	 * @param pers
	 * @return true si les informations sont bonnes (cohérentes), false sinon
	 */
	public boolean verifierInformations(Personne pers) {
		String masque;
		Pattern pattern;
		Matcher controler;

		boolean isValide = true;

		/**
		 * Vérification de l'idPersonne
		 */
		if (pers.getIdPersonne() != null && pers.getIdPersonne() < 0) {
			System.out.println("L'idPersonne doit être positif");
			isValide = false;
		}

		/**
		 * Vérification de l'idAdresse
		 *
		 * if (pers.getIdAdresse() n'existe pas){
		 * syso("L'idAdresse n'existe pas"); return false; }
		 */

		/**
		 * Vérification de l'idCommuneNaiss
		 *
		 * if (pers.getIdCommune() n'existe pas){
		 * syso("L'idCommune n'existe pas"); return false; }
		 */

		/**
		 * Vérification du nom Masque à définir
		 */
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(pers.getNom());
		if (!controler.matches()) {
			System.out.println("Le format du nom est invalide");
			isValide = false;
		}

		/**
		 * Vérification du prenom Masque à définir
		 */
		controler = pattern.matcher(pers.getPrenom());
		if (!controler.matches()) {
			System.out.println("Le format du prénom est invalide");
			isValide = false;
		}

		/**
		 * Vérification de la date de naissance
		 */
		Date date = new Date();
		if (pers.getDateNaissance() == null) {
			System.out
					.println("La date d'entrée doit obligatoirement être saisie");
			isValide = false;
		} else if (pers.getDateNaissance().after(date)) {
			System.out
					.println("La date de naissance doit être antérieur à la date actuelle");
			isValide = false;
		}

		/**
		 * Vérification de l'email (Vérifier si le masque est correct)
		 */
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(pers.getEmail());
		if (!controler.matches() && pers.getEmail() != null) {
			System.out.println("Le format de l'email est invalide");
			isValide = false;
		}

		/**
		 * Vérification des téléphone fixe et portable
		 */
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(pers.getTelFixe());
		if (!controler.matches() && pers.getTelFixe() != null) {
			System.out.println("Le format du telephone fixe est invalide");
			isValide = false;
		}
		controler = pattern.matcher(pers.getTelPort());
		if (!controler.matches() && pers.getTelPort() != null) {
			System.out.println("Le format du telephone portable est invalide");
			isValide = false;
		}

		return isValide;
	}

}
