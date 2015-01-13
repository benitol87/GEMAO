package fr.gemao.ctrl.personnel;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe CalculerDateFinContratCtrl permettant de calculer la date de fin d'un contrat en fonction d'une date de début et d'une durée de contrat
 * @author Coco
 *
 */
public class CalculerDateFinContratCtrl {
	
	private Date dateFin;
	
	/**
	 * Constructeur
	 */
	public CalculerDateFinContratCtrl() {
		
	}
	
	/**
	 * Méthode calculant la date de fin d'un contrat
	 * @param jourDebutContrat : le jour de début du contrat
	 * @param moisDebutContrat : le mois de début du contrat
	 * @param anneeDebutContrat : l'année de début du contrat
	 * @param duree : la durée du contrat
	 * @return dateFin : la date de fin (String)
	 */
	public Date CalculerDateFinContrat(Date dateDebut, int duree) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateDebut);
		
		/* Ajout de la durée du contrat en mois à l'objet Calendar */
		cal.add(Calendar.MONTH, duree);
		
		dateFin = cal.getTime();
				
		return dateFin;
	}
}