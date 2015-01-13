package fr.gemao.ctrl.personnel;

import java.util.Calendar;

/**
 * Classe CalculerDateFinContratCtrl permettant de calculer la date de fin d'un contrat en fonction d'une date de début et d'une durée de contrat
 * @author Coco
 *
 */
public class CalculerDateFinContratCtrl {
	
	private int jourFinContrat;
	private int moisFinContrat;
	private int anneeFinContrat;
	
	/**
	 * Constructeur
	 */
	public CalculerDateFinContratCtrl() {
		this.jourFinContrat = 0;
		this.moisFinContrat = 0;
		this.anneeFinContrat = 0;
	}
	
	/**
	 * Méthode calculant la date de fin d'un contrat
	 * @param jourDebutContrat : le jour de début du contrat
	 * @param moisDebutContrat : le mois de début du contrat
	 * @param anneeDebutContrat : l'année de début du contrat
	 * @param duree : la durée du contrat
	 * @return dateFin : la date de fin (String)
	 */
	public String CalculerDateFinContrat(int jourDebutContrat, int moisDebutContrat, int anneeDebutContrat, int duree) {
		Calendar cal = Calendar.getInstance();
		String dateFin;
		StringBuilder sb = new StringBuilder();
		
		/* Positionnement du jour, mois et année du début de contrat é l'objet Calendar */
		cal.set(Calendar.DAY_OF_MONTH, jourDebutContrat);
		cal.set(Calendar.MONTH, moisDebutContrat);
		cal.set(Calendar.YEAR, anneeDebutContrat);
		
		/* Ajout de la durée du contrat en mois é l'objet Calendar */
		cal.add(Calendar.MONTH, duree);
		
		/* Affectation de la date de fin de contrat */
		jourFinContrat = cal.get(Calendar.DAY_OF_MONTH);
		moisFinContrat = cal.get(Calendar.MONTH);
		anneeFinContrat = cal.get(Calendar.YEAR);
		
		/* Création de la chaine de caractére de la date de fin */
		sb.append(jourFinContrat)
		.append("/")
		.append(moisFinContrat)
		.append("/")
		.append(anneeFinContrat);
		
		dateFin = sb.toString();
		
		return dateFin;
	}
}