package gemao.moduleAdherent.ctrl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gemao.entity.Personne;

public class VerifierPersonneCtrl {

	public VerifierPersonneCtrl() {

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
		if (pers.getIdPersonne() != null && pers.getIdPersonne() < 0) {
			System.out.println("L'idPersonne doit être positif");
			return false;
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

		/**
		 * Vérification du prenom Masque à définir
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
		 * Vérification de l'email (Vérifier si le masque est correct)
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
