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
		
		return isValide;
	}
}