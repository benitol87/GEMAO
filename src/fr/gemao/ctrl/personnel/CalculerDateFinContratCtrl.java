package fr.gemao.ctrl.personnel;

import java.util.Calendar;

public class CalculerDateFinContratCtrl {
	
	public CalculerDateFinContratCtrl() {
		
	}
	
	public void CalculerDateFinContrat(int jourDebutContrat, int moisDebutContrat, int anneeDebutContrat, int duree) {
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
