package fr.gemao.entity;

import java.util.Calendar;

/**
 * Classe Contrat permettant de créer un contrat en récupérant le nom et le prénom d'un personnel
 * @author Coco
 */
public class Contrat {
	private String nom;
	private String prenom;
	private String typeContrat;
	private int jourDebutContrat;
	private int moisDebutContrat;
	private int anneeDebutContrat;
	private int jourFinContrat;
	private int moisFinContrat;
	private int anneeFinContrat;
	private int duree;
	private String dateFin;
	
	/**
	 * Constructeur de la classe Contrat
	 * @param nom : récupération du nom de la personne
	 * @param prenom : récupération du prénom de la personne
	 * @param typeContrat : le type de contrat
	 * @param jourDebutContrat : jour de début du contrat
	 * @param moisDebutContrat : mois de début du contrat
	 * @param anneeDebutContrat : année de début du contrat
	 * @param duree : durée du Contrat
	 */
	public Contrat(String nom, String prenom, String typeContrat, int jourDebutContrat, int moisDebutContrat, int anneeDebutContrat, int duree) {
		this.nom = nom;
		this.prenom = prenom;
		this.typeContrat = typeContrat;
		this.jourDebutContrat = jourDebutContrat;
		this.moisDebutContrat = moisDebutContrat;
		this.anneeDebutContrat = anneeDebutContrat;
		this.duree = duree;
		this.dateFin = calculerDateFin(jourDebutContrat, moisDebutContrat, anneeDebutContrat, duree);
	}

	/**
	 * Permet de retourner le nom de la personne
	 * @return nom : le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Permet de retourner le prénom de la personne
	 * @return prenom : le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Permet de retourner le type de contrat
	 * @return typeContrat : le type du contrat
	 */
	public String getTypeContrat() {
		return typeContrat;
	}

	/**
	 * Permet de retourner le jour de début du contrat
	 * @return jourDebutContrat : le jour de début du contrat
	 */
	public int getJourDebutContrat() {
		return jourDebutContrat;
	}

	/**
	 * Permet de retourner le mois de début du contrat
	 * @return moisDebutContrat : le mois de début du contrat
	 */
	public int getMoisDebutContrat() {
		return moisDebutContrat;
	}

	/**
	 * Permet de retourner l'année de début du contrat
	 * @return anneeDebutContrat : l'année de début du contrat
	 */
	public int getAnneeDebutContrat() {
		return anneeDebutContrat;
	}
	
	/**
	 * Permet de retourner le jour de fin du contrat
	 * @return jourFinContrat : le jour de début du contrat
	 */
	public int getJourFinContrat() {
		return jourFinContrat;
	}

	/**
	 * Permet de retourner le mois de fin du contrat
	 * @return moisFinContrat : le mois de fin du contrat
	 */
	public int getMoisFinContrat() {
		return moisFinContrat;
	}

	/**
	 * Permet de retourner l'année de fin du contrat
	 * @return anneeFinContrat : l'année de fin du contrat
	 */
	public int getAnneeFinContrat() {
		return anneeFinContrat;
	}

	/**
	 * Permet de retourner la durée du contrat en mois
	 * @return duree : la durée du contrat en mois
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Permet de retourner la date de fin du contrat si le contrat est de type "CDD"
	 * @return dateFin : la date de fin de la forme : jj/mm/aaaa
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * Permet de modifier le nom de la personne
	 * @param nom : le nouveau nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Permet de modifier le prénom de la personne
	 * @param prenom : le nouveau prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Permet de modifier le type de contrat de la personne
	 * @param typeContrat : le nouveau type de contrat
	 */
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	/**
	 * Permet de modifier le jour de début du contrat
	 * @param jourDebutContrat : le nouveau jour de début du contrat
	 */
	public void setJourDebutContrat(int jourDebutContrat) {
		this.jourDebutContrat = jourDebutContrat;
	}

	/**
	 * Permet de modifier le mois de début du contrat
	 * @param moisDebutContrat : le nouveau mois de début du contrat
	 */
	public void setMoisDebutContrat(int moisDebutContrat) {
		this.moisDebutContrat = moisDebutContrat;
	}

	/**
	 * Permet de modifier l'année de début du contrat
	 * @param anneeDebutContrat : la nouvelle année de début du contrat
	 */
	public void setAnneeDebutContrat(int anneeDebutContrat) {
		this.anneeDebutContrat = anneeDebutContrat;
	}
	
	/**
	 * Permet de modifier le jour de fin du contrat
	 * @param jourFinContrat : le nouveau jour de fin du contrat
	 */
	public void setJourFinContrat(int jourFinContrat) {
		this.jourFinContrat = jourFinContrat;
	}

	/**
	 * Permet de modifier le mois de fin du contrat
	 * @param moisFinContrat : le nouveau mois de fin du contrat
	 */
	public void setMoisFinContrat(int moisFinContrat) {
		this.moisFinContrat = moisFinContrat;
	}

	/**
	 * Permet de modifier l'année de fin du contrat
	 * @param anneeFinContrat : la nouvelle année de fin du contrat
	 */
	public void setAnneeFinContrat(int anneeFinContrat) {
		this.anneeFinContrat = anneeFinContrat;
	}

	/**
	 * Permet de modifier la durée du contrat
	 * @param duree : la nouvelle durée du contrat
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Permet de modifier la date de fin du contrat (automatiquement calculée)
	 * @param dateFin : la nouvelle date de fin du contrat
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * Permet de calculer la date de fin du contrat en fonction du jour, du mois et de l'année de début du contrat
	 * @param jourDebutContrat : le jour de début du contrat
	 * @param moisDebutContrat : le moisr de début du contrat
	 * @param anneeDebutContrat : l'année de début du contrat
	 * @param duree : la durée du contrat en mois
	 * @return : retourne une chaine de caractére correspondant é la date de fin du contrat si il est du type "CDD"
	 */
	public String calculerDateFin(int jourDebutContrat, int moisDebutContrat, int anneeDebutContrat, int duree) {
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

	/**
	 * Redéfintion de la méthode toString permettant d'afficher les caractéristiques d'un contrat
	 */
	@Override
	public String toString() {
		String personnel;
		StringBuilder sb = new StringBuilder();
		
		/* Concaténation de la chaine StringBuilder */
		sb.append("Contrat : \n")
		.append("Nom : ")
		.append(this.nom)
		.append("\nPrénom : ")
		.append(this.prenom)
		.append("\nType de contrat : ")
		.append(this.typeContrat)
		.append("\nDate de début du contrat : ")
		.append(this.jourDebutContrat)
		.append("/")
		.append(this.moisDebutContrat)
		.append("/")
		.append(this.anneeDebutContrat);
		
		/* Si le contrat est du type "CDI" ou "Bénévolat" */
		if (this.typeContrat == "CDI" || this.typeContrat == "Bénévolat") {
			sb.append("\nPas de date de fin de contrat");
		}
		
		/* Si le contrat est du type "CDD" */
		if (this.typeContrat == "CDD") {
			sb.append("\nDurée du contrat : ")
			.append(this.duree)
			.append(" mois")
			.append("\nDate de fin du contrat : ")
			.append(this.dateFin);
		}
		
		personnel = sb.toString();
		
		return personnel;
	}
}