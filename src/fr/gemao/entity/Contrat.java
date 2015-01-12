package fr.gemao.entity;

import java.util.Calendar;

/**
 * Classe Contrat permettant de cr�er un contrat en r�cup�rant le nom et le pr�nom d'un personnel
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
	 * @param nom : r�cup�ration du nom de la personne
	 * @param prenom : r�cup�ration du pr�nom de la personne
	 * @param typeContrat : le type de contrat
	 * @param jourDebutContrat : jour de d�but du contrat
	 * @param moisDebutContrat : mois de d�but du contrat
	 * @param anneeDebutContrat : ann�e de d�but du contrat
	 * @param duree : dur�e du Contrat
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
	 * Permet de retourner le pr�nom de la personne
	 * @return prenom : le pr�nom de la personne
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
	 * Permet de retourner le jour de d�but du contrat
	 * @return jourDebutContrat : le jour de d�but du contrat
	 */
	public int getJourDebutContrat() {
		return jourDebutContrat;
	}

	/**
	 * Permet de retourner le mois de d�but du contrat
	 * @return moisDebutContrat : le mois de d�but du contrat
	 */
	public int getMoisDebutContrat() {
		return moisDebutContrat;
	}

	/**
	 * Permet de retourner l'ann�e de d�but du contrat
	 * @return anneeDebutContrat : l'ann�e de d�but du contrat
	 */
	public int getAnneeDebutContrat() {
		return anneeDebutContrat;
	}
	
	/**
	 * Permet de retourner le jour de fin du contrat
	 * @return jourFinContrat : le jour de d�but du contrat
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
	 * Permet de retourner l'ann�e de fin du contrat
	 * @return anneeFinContrat : l'ann�e de fin du contrat
	 */
	public int getAnneeFinContrat() {
		return anneeFinContrat;
	}

	/**
	 * Permet de retourner la dur�e du contrat en mois
	 * @return duree : la dur�e du contrat en mois
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
	 * Permet de modifier le pr�nom de la personne
	 * @param prenom : le nouveau pr�nom de la personne
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
	 * Permet de modifier le jour de d�but du contrat
	 * @param jourDebutContrat : le nouveau jour de d�but du contrat
	 */
	public void setJourDebutContrat(int jourDebutContrat) {
		this.jourDebutContrat = jourDebutContrat;
	}

	/**
	 * Permet de modifier le mois de d�but du contrat
	 * @param moisDebutContrat : le nouveau mois de d�but du contrat
	 */
	public void setMoisDebutContrat(int moisDebutContrat) {
		this.moisDebutContrat = moisDebutContrat;
	}

	/**
	 * Permet de modifier l'ann�e de d�but du contrat
	 * @param anneeDebutContrat : la nouvelle ann�e de d�but du contrat
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
	 * Permet de modifier l'ann�e de fin du contrat
	 * @param anneeFinContrat : la nouvelle ann�e de fin du contrat
	 */
	public void setAnneeFinContrat(int anneeFinContrat) {
		this.anneeFinContrat = anneeFinContrat;
	}

	/**
	 * Permet de modifier la dur�e du contrat
	 * @param duree : la nouvelle dur�e du contrat
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Permet de modifier la date de fin du contrat (automatiquement calcul�e)
	 * @param dateFin : la nouvelle date de fin du contrat
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * Permet de calculer la date de fin du contrat en fonction du jour, du mois et de l'ann�e de d�but du contrat
	 * @param jourDebutContrat : le jour de d�but du contrat
	 * @param moisDebutContrat : le moisr de d�but du contrat
	 * @param anneeDebutContrat : l'ann�e de d�but du contrat
	 * @param duree : la dur�e du contrat en mois
	 * @return : retourne une chaine de caract�re correspondant � la date de fin du contrat si il est du type "CDD"
	 */
	public String calculerDateFin(int jourDebutContrat, int moisDebutContrat, int anneeDebutContrat, int duree) {
		Calendar cal = Calendar.getInstance();
		String dateFin;
		StringBuilder sb = new StringBuilder();
		
		/* Positionnement du jour, mois et ann�e du d�but de contrat � l'objet Calendar */
		cal.set(Calendar.DAY_OF_MONTH, jourDebutContrat);
		cal.set(Calendar.MONTH, moisDebutContrat);
		cal.set(Calendar.YEAR, anneeDebutContrat);
		
		/* Ajout de la dur�e du contrat en mois � l'objet Calendar */
		cal.add(Calendar.MONTH, duree);
		
		/* Affectation de la date de fin de contrat */
		jourFinContrat = cal.get(Calendar.DAY_OF_MONTH);
		moisFinContrat = cal.get(Calendar.MONTH);
		anneeFinContrat = cal.get(Calendar.YEAR);
		
		/* Cr�ation de la chaine de caract�re de la date de fin */
		sb.append(jourFinContrat)
		.append("/")
		.append(moisFinContrat)
		.append("/")
		.append(anneeFinContrat);
		
		dateFin = sb.toString();
		
		return dateFin;
	}

	/**
	 * Red�fintion de la m�thode toString permettant d'afficher les caract�ristiques d'un contrat
	 */
	@Override
	public String toString() {
		String personnel;
		StringBuilder sb = new StringBuilder();
		
		/* Concat�nation de la chaine StringBuilder */
		sb.append("Contrat : \n")
		.append("Nom : ")
		.append(this.nom)
		.append("\nPr�nom : ")
		.append(this.prenom)
		.append("\nType de contrat : ")
		.append(this.typeContrat)
		.append("\nDate de d�but du contrat : ")
		.append(this.jourDebutContrat)
		.append("/")
		.append(this.moisDebutContrat)
		.append("/")
		.append(this.anneeDebutContrat);
		
		/* Si le contrat est du type "CDI" ou "B�n�volat" */
		if (this.typeContrat == "CDI" || this.typeContrat == "B�n�volat") {
			sb.append("\nPas de date de fin de contrat");
		}
		
		/* Si le contrat est du type "CDD" */
		if (this.typeContrat == "CDD") {
			sb.append("\nDur�e du contrat : ")
			.append(this.duree)
			.append(" mois")
			.append("\nDate de fin du contrat : ")
			.append(this.dateFin);
		}
		
		personnel = sb.toString();
		
		return personnel;
	}
}