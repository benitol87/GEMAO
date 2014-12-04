package gemao.application.gestionMateriel;

public class Materiel {

	private final long idMateriel;
	private Etat etat;
	private final Categorie categorie;
	private final Marque marque;
	private final String designation;
	private String typeMat;
	private final long numSerie;
	private final String dateAchat;
	private final float valeurAchat;
	private final float valeurReap;
	private boolean deplacable;
	private String observation;

	public Materiel(long idMateriel, Etat etat, Categorie categorie,
			Marque marque, String designation, String typeMat, long numSerie,
			String dateAchat, float valeurAchat, float valeurReap,
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

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public String getTypeMat() {
		return typeMat;
	}

	public void setTypeMat(String typeMat) {
		this.typeMat = typeMat;
	}

	public boolean isDeplacable() {
		return deplacable;
	}

	public void setDeplacable(boolean deplacable) {
		this.deplacable = deplacable;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public long getIdMateriel() {
		return idMateriel;
	}

	public String getDesignation() {
		return designation;
	}

	public long getNumSerie() {
		return numSerie;
	}

	public String getDateAchat() {
		return dateAchat;
	}

	public float getValeurAchat() {
		return valeurAchat;
	}

	public float getValeurReap() {
		return valeurReap;
	}
}
