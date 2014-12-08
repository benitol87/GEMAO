package gemao.moduleAdherent.ctrl;

import java.util.Date;

import gemao.entity.Adherent;

public class VerifierAdherentCtrl {
	public VerifierAdherentCtrl() {

	}

	/**
	 * Vérifie les informations d'un adhérent
	 * 
	 * @param adherent
	 * @return true si les informations sont bonne (cohérente), false sinon
	 */
	public boolean verifierInformations(Adherent adherent) {

		/**
		 * Vérification des informations générales aux personnes
		 */
		VerifierPersonneCtrl persCtrl = new VerifierPersonneCtrl();
		if (!persCtrl.verifierInformations(adherent))
			return false;

		/**
		 * Vérification de l'idMotif
		 */

		/**
		 * Vérification de l'idResponsable
		 */

		/**
		 * Vérification des dates d'entrée et sortie
		 */
		Date date = new Date();
		if (adherent.getDateEntree().after(date)) {
			System.out
					.println("La date d'entrée doit être antérieur à la date actuelle");
			return false;
		}
		if (adherent.getDateEntree().after(adherent.getDateSortie())) {
			System.out
					.println("La date de sortie doit être postérieur à la date d'entrée");
			return false;
		}

		/**
		 * Vérification du quotient familiale
		 */
		if (adherent.getQf() < 0.0) {
			System.out
					.println("Le montant du quotient familiale ne peut pas être négatif");
			return false;
		}

		return true;
	}
}
