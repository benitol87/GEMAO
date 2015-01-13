package fr.gemao.entity;

import java.util.Calendar;

import fr.gemao.ctrl.personnel.CalculerDateFinContratCtrl;

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
		CalculerDateFinContratCtrl date = new CalculerDateFinContratCtrl();
		
		this.nom = nom;
		this.prenom = prenom;
		this.typeContrat = typeContrat;
		this.jourDebutContrat = jourDebutContrat;
		this.moisDebutContrat = moisDebutContrat;
		this.anneeDebutContrat = anneeDebutContrat;
		this.duree = duree;
		this.dateFin = date.CalculerDateFinContrat(jourDebutContrat, moisDebutContrat, anneeDebutContrat, duree);
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

	/**
	 * Redéfinition de la méthode hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeDebutContrat;
		result = prime * result + anneeFinContrat;
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + duree;
		result = prime * result + jourDebutContrat;
		result = prime * result + jourFinContrat;
		result = prime * result + moisDebutContrat;
		result = prime * result + moisFinContrat;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((typeContrat == null) ? 0 : typeContrat.hashCode());
		return result;
	}

	/**
	 * Redéfinition de la méthode equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrat other = (Contrat) obj;
		if (anneeDebutContrat != other.anneeDebutContrat)
			return false;
		if (anneeFinContrat != other.anneeFinContrat)
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (duree != other.duree)
			return false;
		if (jourDebutContrat != other.jourDebutContrat)
			return false;
		if (jourFinContrat != other.jourFinContrat)
			return false;
		if (moisDebutContrat != other.moisDebutContrat)
			return false;
		if (moisFinContrat != other.moisFinContrat)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (typeContrat == null) {
			if (other.typeContrat != null)
				return false;
		} else if (!typeContrat.equals(other.typeContrat))
			return false;
		return true;
	}
}