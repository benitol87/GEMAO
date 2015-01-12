package fr.gemao.form.adherent;

import java.util.Date;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.form.VerifierSyntaxePersonne;


public class VerifierSyntaxeAdherent {
	public VerifierSyntaxeAdherent() {

	}

	/**
	 * Vérifie les informations d'un adhérent
	 * 
	 * @param adherent
	 * @return true si les informations sont bonne (cohérente), false sinon
	 */
	public boolean verifierInformations(Adherent adherent) {

		boolean isValide = true;

		/**
		 * Vérification des informations générales aux personnes
		 */
		VerifierSyntaxePersonne persCtrl = new VerifierSyntaxePersonne();
		if (!persCtrl.verifierInformations(adherent))
			isValide = false;

		/**
		 * Vérification de l'idMotif
		 */
		if (adherent.getIdMotif() != null) {
			// if ( adherent.getIdMotif() n'existe pas)
			isValide = false;
		}

		/**
		 * Vérification de l'idResponsable
		 */
		if (adherent.getIdResponsable() != null) {
			// if ( adherent.getIdMotif() n'existe pas)
			isValide = false;
		}

		/**
		 * Vérification des dates d'entrée et sortie
		 */
		Date date = new Date();

		if (adherent.getDateEntree() == null) {
			System.out
					.println("La date d'entrée doit obligatoirement être saisie");
			isValide = false;
		} else {
			if (adherent.getDateEntree().after(date)) {
				System.out
						.println("La date d'entrée doit être antérieur à la date actuelle");
				isValide = false;
			}
			if (adherent.getDateSortie() != null) {
				if (adherent.getDateEntree().after(adherent.getDateSortie())) {
					System.out
							.println("La date de sortie doit être postérieur à la date d'entrée");
					isValide = false;
				}
				if (adherent.getDateSortie().after(date)) {
					System.out
							.println("La date de sortie doit être antérieur à la date actuelle");
					isValide = false;
				}
			}
			if (adherent.getDateEntree().before(adherent.getDateNaissance())) {
				System.out
						.println("La date de naissance doit être antérieur à la date d'entrée");
				isValide = false;
			}
		}

		/**
		 * Vérification du quotient familiale
		 */
		if (adherent.getQf()!=null && adherent.getQf() < 0.0) {
			System.out
					.println("Le montant du quotient familiale ne peut pas être négatif");
			isValide = false;
		}

		return isValide;
	}
}
