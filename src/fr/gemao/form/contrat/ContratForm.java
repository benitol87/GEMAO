package fr.gemao.form.contrat;

import java.util.Calendar;

import fr.gemao.entity.Contrat;

/**
 * Classe de vérification de la classe Contrat
 * @author Coco
 *
 */
public class ContratForm {
	
	/* Calendrier */
	
	
	/* Boolean */
	private boolean isValide = true;
	
	/**
	 * Constructeur
	 */
	public ContratForm() {
		this.isValide = true;
	}
	
	/**
	 * Permet de vérifier les informations d'un contrat
	 * @param contrat : le contrat à vérifier
	 * @return isValide : true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Contrat contrat) {
		
		/* Affectation des Calendar avec les dates du contrat */
		Calendar calDebut = Calendar.getInstance();
		Calendar calFin = Calendar.getInstance();
		
		/* Vérification du nom sur le contrat */
		if (contrat.getNom() == null) {
			System.out.println("Le nom sur le contrat ne peut pas être null");
			isValide = false;
		}
		
		/* Vérification du prénom sur le contrat */
		if (contrat.getPrenom() == null) {
			System.out.println("Le prénom sur le contrat ne peut pas être null");
			isValide = false;
		}
		
		/* Vérification du type de contrat */
		if (contrat.getTypeContrat() == null) {
			System.out.println("Le type de contrat ne peut pas être null");
			isValide = false;
		}
		
		/* Vérification de la date de début du contrat */
		if (contrat.getDateDebut() == null) {
			System.out.println("La date de début du contrat ne peut pas être null");
			isValide = false;
		}
		
		/* Vérification de la date de fin du contrat */
		if (contrat.getDateFin() == null) {
			System.out.println("La date de fin du contrat ne peut pas être null");
			isValide = false;
		}
		
		/* Vérification de l'année du contrat */
		if (contrat.getDateDebut() != null || contrat.getDateFin() != null) {
			
			calDebut.setTime(contrat.getDateDebut());
			calFin.setTime(contrat.getDateFin());
			
			if (calFin.YEAR < calDebut.YEAR) {
				System.out.println("L'année de fin du contrat doit être supérieure à l'année de début du contrat");
				isValide = false;
			}
		}
		
		return isValide;
	}
}