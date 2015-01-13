package fr.gemao.entity;

import java.util.Date;

/**
 * Classe Contrat permettant de créer un contrat en récupérant le nom et le prénom d'un personnel
 * @author Coco
 */
public class Contrat {
	private String nom;
	private String prenom;
	private String typeContrat;
	private Date dateDebut;
	private Date dateFin;
	
	/**
	 * Constructeur de la classe Contrat
	 * @param nom : récupération du nom de la personne
	 * @param prenom : récupération du prénom de la personne
	 * @param typeContrat : le type du contrat
	 * @param dateDebut : la date de début du contrat
	 * @param dateFin : la date de fin du contrat
	 */
	public Contrat(String nom, String prenom, String typeContrat, Date dateDebut, Date dateFin) {		
		this.nom = nom;
		this.prenom = prenom;
		this.typeContrat = typeContrat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
	 * Permet de retourner la date de début du contrat
	 * @return dateDebut : la date de début du contrat
	 */
	public Date getDateDebut() {
		return dateDebut;
	}
	
	/**
	 * Permet de retourner la date de fin du contrat si le contrat est de type "CDD"
	 * @return dateFin : la date de fin du contrat
	 */
	public Date getDateFin() {
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
	 * Permet de modifier la date de début du contrat
	 * @param dateDebut : la nouvelle date de début du contrat
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Permet de modifier la date de fin du contrat (automatiquement calculée)
	 * @param dateFin : la nouvelle date de fin du contrat
	 */
	public void setDateFin(Date dateFin) {
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
		.append(this.dateDebut);
		
		/* Si le contrat est du type "CDI" ou "Bénévolat" */
		if (this.typeContrat == "CDI" || this.typeContrat == "Bénévolat") {
			sb.append("\nPas de date de fin de contrat");
		}
		
		/* Si le contrat est du type "CDD" */
		if (this.typeContrat == "CDD") {
			sb.append("\nDate de fin du contrat : ")
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
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result
				+ ((typeContrat == null) ? 0 : typeContrat.hashCode());
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
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
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