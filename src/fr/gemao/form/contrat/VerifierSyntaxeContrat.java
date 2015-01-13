package fr.gemao.form.contrat;

import java.util.Calendar;

import fr.gemao.entity.Contrat;

/**
 * Classe de vérification de la classe Contrat
 * @author Coco
 *
 */
public class VerifierSyntaxeContrat {
	
	private boolean isValide;
	private int anneeMin;
	private int anneeMax;
	
	/**
	 * Constructeur
	 */
	public VerifierSyntaxeContrat() {
		this.isValide = true;
		Calendar cal = Calendar.getInstance();
		anneeMin = Calendar.YEAR - 100;
		anneeMax = Calendar.YEAR;
	}
	
	/**
	 * Permet de vérifier les informations d'un contrat
	 * @param contrat : le contrat à vérifier
	 * @return isValide : true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Contrat contrat) {
		
		/**
		 * Vérification du nom sur le contrat
		 */
		if (contrat.getNom() == null) {
			System.out.println("Le nom sur le contrat ne peut pas être null");
			isValide = false;
		}
		
		/**
		 * Vérification du prénom sur le contrat
		 */
		if (contrat.getPrenom() == null) {
			System.out.println("Le prénom sur le contrat ne peut pas être null");
			isValide = false;
		}
		
		/**
		 * Vérification du type de contrat
		 */
		if (contrat.getTypeContrat() == null) {
			System.out.println("Le type de contrat ne peut pas être null");
			isValide = false;
		}
		
		/**
		 * Vérification du jour de début du contrat
		 */
		if (contrat.getJourDebutContrat() < 1 || contrat.getJourDebutContrat() > 31) {
			System.out.println("Le jour de début de contrat doit être compris entre 1 et 31");
			isValide = false;
		}
		
		/**
		 * Vérification du mois de début du contrat
		 */
		if (contrat.getMoisDebutContrat() < 1 || contrat.getMoisDebutContrat() > 12) {
			System.out.println("Le mois de début de contrat doit être compris entre 1 et 12");
			isValide = false;
		}
		
		/**
		 * Vérification de l'année de début du contrat
		 */
		if (contrat.getAnneeDebutContrat() < Calendar.YEAR - 100 || contrat.getAnneeDebutContrat() > Calendar.YEAR) {
			System.out.println("L'année de début de contrat doit être compris entre " + anneeMin + " et " + anneeMax);
			isValide = false;
		}
		
		/**
		 * Vérification du jour de fin du contrat
		 */
		if (contrat.getJourFinContrat() < 1 || contrat.getJourFinContrat() > 31) {
			System.out.println("Le jour de fin de contrat doit être compris entre 1 et 31");
			isValide = false;
		}
		
		/**
		 * Vérification du mois de fin du contrat
		 */
		if (contrat.getMoisFinContrat() < 1 || contrat.getMoisFinContrat() > 12) {
			System.out.println("Le mois de fin de contrat doit être compris entre 1 et 12");
			isValide = false;
		}
		
		/**
		 * Vérification de l'année de fin du contrat
		 */
		if (contrat.getAnneeFinContrat() < contrat.getAnneeDebutContrat()) {
			System.out.println("L'année de fin de contrat ne peut pas être inférieure à l'année de début de contrat");
			isValide = false;
		}
		
		return isValide;
	}
}