package gemao.application.gestionMateriel;

import java.sql.Date;

public class Materiel {

	private final long idMateriel;
	private Etat etat;
	private final Categorie categorie;
	private final Marque marque;
	private final String designation;
	private String typeMat;
	private final long numSerie;
	private final Date dateAchat;
	private final float valeurAchat;
	private final float valeurReap;
	private boolean deplacable;
	private String observation;

	/**
	 * Instantiates a new materiel.
	 *
	 * @param idMateriel the id materiel
	 * @param etat the etat
	 * @param categorie the categorie
	 * @param marque the marque
	 * @param designation the designation
	 * @param typeMat the type mat
	 * @param numSerie the num serie
	 * @param dateAchat the date achat
	 * @param valeurAchat the valeur achat
	 * @param valeurReap the valeur reap
	 * @param deplacable the deplacable
	 * @param observation the observation
	 */
	public Materiel(long idMateriel, Etat etat, Categorie categorie,
			Marque marque, String designation, String typeMat, long numSerie,
			Date dateAchat, float valeurAchat, float valeurReap,
			boolean deplacable, String observation) {
		this.idMateriel = idMateriel;
		this.etat = etat;
		this.categorie = categorie;
		this.marque = marque;
		this.designation = designation;
		this.typeMat = typeMat;
		this.numSerie = numSerie;
		this.dateAchat = dateAchat;
		this.valeurAchat = valeurAchat;
		this.valeurReap = valeurReap;
		this.deplacable = deplacable;
		this.observation = observation;
	}
	
	
	
	@Override
	public String toString() {
		return "Materiel [idMateriel=" + idMateriel + ", etat=" + etat
				+ ", categorie=" + categorie + ", marque=" + marque
				+ ", designation=" + designation + ", typeMat=" + typeMat
				+ ", numSerie=" + numSerie + ", dateAchat=" + dateAchat
				+ ", valeurAchat=" + valeurAchat + ", valeurReap=" + valeurReap
				+ ", deplacable=" + deplacable + ", observation=" + observation
				+ "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result
				+ ((dateAchat == null) ? 0 : dateAchat.hashCode());
		result = prime * result + (deplacable ? 1231 : 1237);
		result = prime * result
				+ ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + (int) (idMateriel ^ (idMateriel >>> 32));
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime * result + (int) (numSerie ^ (numSerie >>> 32));
		result = prime * result
				+ ((observation == null) ? 0 : observation.hashCode());
		result = prime * result + ((typeMat == null) ? 0 : typeMat.hashCode());
		result = prime * result + Float.floatToIntBits(valeurAchat);
		result = prime * result + Float.floatToIntBits(valeurReap);
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materiel other = (Materiel) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (dateAchat == null) {
			if (other.dateAchat != null)
				return false;
		} else if (!dateAchat.equals(other.dateAchat))
			return false;
		if (deplacable != other.deplacable)
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idMateriel != other.idMateriel)
			return false;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		if (numSerie != other.numSerie)
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		if (typeMat == null) {
			if (other.typeMat != null)
				return false;
		} else if (!typeMat.equals(other.typeMat))
			return false;
		if (Float.floatToIntBits(valeurAchat) != Float
				.floatToIntBits(other.valeurAchat))
			return false;
		if (Float.floatToIntBits(valeurReap) != Float
				.floatToIntBits(other.valeurReap))
			return false;
		return true;
	}

	/**
	 * Instantiates a new materiel.
	 *
	 * @param m the m
	 */
	public Materiel(Materiel m){
		this(m.getIdMateriel(),
				m.getEtat(),
				m.getCategorie(),
				m.getMarque(),
				m.getDesignation(),
				m.getTypeMat(),
				m.getNumSerie(),
				m.getDateAchat(),
				m.getValeurAchat(),
				m.getValeurReap(),
				m.isDeplacable(),
				m.getObservation());
	}

	/**
	 * Gets the etat.
	 *
	 * @return the etat
	 */
	public Etat getEtat() {
		return etat;
	}

	/**
	 * Sets the etat.
	 *
	 * @param etat the new etat
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	/**
	 * Gets the categorie.
	 *
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Gets the marque.
	 *
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * Gets the type mat.
	 *
	 * @return the type mat
	 */
	public String getTypeMat() {
		return typeMat;
	}

	/**
	 * Sets the type mat.
	 *
	 * @param typeMat the new type mat
	 */
	public void setTypeMat(String typeMat) {
		this.typeMat = typeMat;
	}

	/**
	 * Checks if is deplacable.
	 *
	 * @return true, if is deplacable
	 */
	public boolean isDeplacable() {
		return deplacable;
	}

	/**
	 * Sets the deplacable.
	 *
	 * @param deplacable the new deplacable
	 */
	public void setDeplacable(boolean deplacable) {
		this.deplacable = deplacable;
	}

	/**
	 * Gets the observation.
	 *
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * Sets the observation.
	 *
	 * @param observation the new observation
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * Gets the id materiel.
	 *
	 * @return the id materiel
	 */
	public long getIdMateriel() {
		return idMateriel;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Gets the num serie.
	 *
	 * @return the num serie
	 */
	public long getNumSerie() {
		return numSerie;
	}

	/**
	 * Gets the date achat.
	 *
	 * @return the date achat
	 */
	public Date getDateAchat() {
		return dateAchat;
	}

	/**
	 * Gets the valeur achat.
	 *
	 * @return the valeur achat
	 */
	public float getValeurAchat() {
		return valeurAchat;
	}

	/**
	 * Gets the valeur reap.
	 *
	 * @return the valeur reap
	 */
	public float getValeurReap() {
		return valeurReap;
	}
}
