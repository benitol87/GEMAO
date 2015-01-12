package fr.gemao.entity.materiel;

import java.sql.Date;

import fr.gemao.entity.Personne;



// TODO: Auto-generated Javadoc
/**
 * The Class Location.
 */
public class Location {
	
	/** The personne. */
	private final Personne personne;
	
	/** The materiel. */
	private final Materiel materiel;
	
	/** The etat debut. */
	private final Etat etatDebut;
	
	/** The etat fin. */
	private final Etat etatFin;
	
	/** The date emprunt. */
	private final Date dateEmprunt;
	
	/** The date retour. */
	private final Date dateRetour;
	
	/** The duree. */
	private final int duree;
	
	/** The montant. */
	private float montant;
	
	/** The reparation. */
	private final Reparation reparation;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateEmprunt == null) ? 0 : dateEmprunt.hashCode());
		result = prime * result
				+ ((dateRetour == null) ? 0 : dateRetour.hashCode());
		result = prime * result + duree;
		result = prime * result
				+ ((etatDebut == null) ? 0 : etatDebut.hashCode());
		result = prime * result + ((etatFin == null) ? 0 : etatFin.hashCode());
		result = prime * result
				+ ((materiel == null) ? 0 : materiel.hashCode());
		result = prime * result + Float.floatToIntBits(montant);
		result = prime * result
				+ ((personne == null) ? 0 : personne.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (dateEmprunt == null) {
			if (other.dateEmprunt != null)
				return false;
		} else if (!dateEmprunt.equals(other.dateEmprunt))
			return false;
		if (dateRetour == null) {
			if (other.dateRetour != null)
				return false;
		} else if (!dateRetour.equals(other.dateRetour))
			return false;
		if (duree != other.duree)
			return false;
		if (etatDebut == null) {
			if (other.etatDebut != null)
				return false;
		} else if (!etatDebut.equals(other.etatDebut))
			return false;
		if (etatFin == null) {
			if (other.etatFin != null)
				return false;
		} else if (!etatFin.equals(other.etatFin))
			return false;
		if (materiel == null) {
			if (other.materiel != null)
				return false;
		} else if (!materiel.equals(other.materiel))
			return false;
		if (Float.floatToIntBits(montant) != Float
				.floatToIntBits(other.montant))
			return false;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [personne=" + personne + ", materiel=" + materiel
				+ ", etatDebut=" + etatDebut + ", etatFin=" + etatFin
				+ ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour
				+ ", duree=" + duree + ", montant=" + montant + "]";
	}

	
	
	/**
	 * Instantiates a new location.
	 *
	 * @param personne the personne
	 * @param materiel the materiel
	 * @param etatDebut the etat debut
	 * @param etatFin the etat fin
	 * @param dateEmprunt the date emprunt
	 * @param dateRetour the date retour
	 * @param duree the duree
	 * @param montant the montant
	 * @param reparation the reparation
	 */
	public Location(Personne personne, Materiel materiel, Etat etatDebut,
			Etat etatFin, Date dateEmprunt, Date dateRetour, int duree,
			float montant, Reparation reparation) {
		this.personne = personne;
		this.materiel = materiel;
		this.etatDebut = etatDebut;
		this.etatFin = etatFin;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.duree = duree;
		this.montant = montant;
		this.reparation = reparation;
	}

	/**
	 * Gets the montant.
	 *
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * Sets the montant.
	 *
	 * @param montant the new montant
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

	/**
	 * Gets the personne.
	 *
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * Gets the materiel.
	 *
	 * @return the materiel
	 */
	public Materiel getMateriel() {
		return materiel;
	}

	/**
	 * Gets the etat debut.
	 *
	 * @return the etat debut
	 */
	public Etat getEtatDebut() {
		return etatDebut;
	}

	/**
	 * Gets the etat fin.
	 *
	 * @return the etat fin
	 */
	public Etat getEtatFin() {
		return etatFin;
	}

	/**
	 * Gets the date emprunt.
	 *
	 * @return the date emprunt
	 */
	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	/**
	 * Gets the date retour.
	 *
	 * @return the date retour
	 */
	public Date getDateRetour() {
		return dateRetour;
	}

	/**
	 * Gets the duree.
	 *
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}
}
