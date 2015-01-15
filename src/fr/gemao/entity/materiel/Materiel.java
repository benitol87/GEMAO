package fr.gemao.entity.materiel;

import java.sql.Date;

public class Materiel {

	private Long idMateriel;
	private Etat etat;
	private Categorie categorie;
	private Marque marque;
	private Designation designation;
	private String typeMat;
	private long numSerie;
	private Date dateAchat;
	private float valeurAchat;
	private float valeurReap;
	private boolean deplacable;
	private String observation;
	private int quantite;
	
	public Materiel() {
		this.idMateriel = null;
	}

	/**
	 * Constructeur d'un objet Materiel
	 * 
	 * @param idMateriel : l'ID du matériel
	 * @param etat : l'état
	 * @param categorie : la catégorie
	 * @param marque : la marque
	 * @param designation : la désignation
	 * @param typeMat : le type
	 * @param numSerie : le numéro de série
	 * @param dateAchat : la date d'achat
	 * @param valeurAchat : la valeur d'achat
	 * @param valeurReap : la valeur de ré-approvisionnement
	 * @param deplacable : si le matériel est déplaçable ou non
	 * @param observation : l'observation
	 * @param quantite : la quantité
	 */
	public Materiel(Long idMateriel, Etat etat, Categorie categorie,
			Marque marque, Designation designation, String typeMat, long numSerie,
			Date dateAchat, float valeurAchat, float valeurReap,
			boolean deplacable, String observation, int quantite) {
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
		this.quantite = quantite;
	}

	/**
	 * Constructeur d'un objet Materiel
	 * @param m : le matériel (objet)
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
				m.getObservation(),
				m.getQuantite());
	}
	
	public Long getIdMateriel() {
		return idMateriel;
	}

	public Etat getEtat() {
		return etat;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public Designation getDesignation() {
		return designation;
	}

	public String getTypeMat() {
		return typeMat;
	}

	public long getNumSerie() {
		return numSerie;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public float getValeurAchat() {
		return valeurAchat;
	}

	public float getValeurReap() {
		return valeurReap;
	}

	public boolean isDeplacable() {
		return deplacable;
	}

	public String getObservation() {
		return observation;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setIdMateriel(Long idMateriel) {
		this.idMateriel = idMateriel;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public void setTypeMat(String typeMat) {
		this.typeMat = typeMat;
	}

	public void setNumSerie(long numSerie) {
		this.numSerie = numSerie;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public void setValeurAchat(float valeurAchat) {
		this.valeurAchat = valeurAchat;
	}

	public void setValeurReap(float valeurReap) {
		this.valeurReap = valeurReap;
	}

	public void setDeplacable(boolean deplacable) {
		this.deplacable = deplacable;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * Redéfinition de la méthode hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((dateAchat == null) ? 0 : dateAchat.hashCode());
		result = prime * result + (deplacable ? 1231 : 1237);
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((idMateriel == null) ? 0 : idMateriel.hashCode());
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime * result + (int) (numSerie ^ (numSerie >>> 32));
		result = prime * result + ((observation == null) ? 0 : observation.hashCode());
		result = prime * result + quantite;
		result = prime * result + ((typeMat == null) ? 0 : typeMat.hashCode());
		result = prime * result + Float.floatToIntBits(valeurAchat);
		result = prime * result + Float.floatToIntBits(valeurReap);
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
		if (idMateriel == null) {
			if (other.idMateriel != null)
				return false;
		} else if (!idMateriel.equals(other.idMateriel))
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
		if (quantite != other.quantite)
			return false;
		if (typeMat == null) {
			if (other.typeMat != null)
				return false;
		} else if (!typeMat.equals(other.typeMat))
			return false;
		if (Float.floatToIntBits(valeurAchat) != Float.floatToIntBits(other.valeurAchat))
			return false;
		if (Float.floatToIntBits(valeurReap) != Float.floatToIntBits(other.valeurReap))
			return false;
		return true;
	}	

	/**
	 * Redéfinition de la méthode toString
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Materiel [idMateriel=");
		builder.append(idMateriel);
		builder.append(", etat=");
		builder.append(etat);
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append(", marque=");
		builder.append(marque);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", typeMat=");
		builder.append(typeMat);
		builder.append(", numSerie=");
		builder.append(numSerie);
		builder.append(", dateAchat=");
		builder.append(dateAchat);
		builder.append(", valeurAchat=");
		builder.append(valeurAchat);
		builder.append(", valeurReap=");
		builder.append(valeurReap);
		builder.append(", deplacable=");
		builder.append(deplacable);
		builder.append(", observation=");
		builder.append(observation);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append("]");
		return builder.toString();
	}
}