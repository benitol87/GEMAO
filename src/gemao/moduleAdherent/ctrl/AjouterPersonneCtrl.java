package gemao.moduleAdherent.ctrl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gemao.entity.Personne;

public class AjouterPersonneCtrl {

	public AjouterPersonneCtrl() {

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

		/**
		 * Vérification de l'idPersonne
		 */

		/**
		 * Vérification de l'idAdresse
		 */

		/**
		 * Vérification de l'idCommuneNaiss
		 */

		/**
		 * Vérification du nom
		 */

		/**
		 * Vérification du prenom
		 */

		/**
		 * Vérification de la date de naissance
		 */
		Date date = new Date();
		if (pers.getDateNaissance().after(date)) {
			System.out
					.println("La date de naissance doit être antérieur à la date actuelle");
			return false;
		}

		/**
		 * Vérification de l'email
		 */
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(pers.getEmail());
		if (!controler.matches() && pers.getEmail() != "") {
			System.out.println("Le format de l'email est invalide");
			return false;
		}

		/**
		 * Vérification des téléphone fixe et portable
		 */
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(pers.getTelFixe());
		if (!controler.matches() && pers.getTelFixe() != "") {
			System.out.println("Le format du telephone fixe est invalide");
			return false;
		}
		controler = pattern.matcher(pers.getTelPort());
		if (!controler.matches() && pers.getTelPort() != "") {
			System.out.println("Le format du telephone portable est invalide");
			return false;
		}

		return true;
	}

}
