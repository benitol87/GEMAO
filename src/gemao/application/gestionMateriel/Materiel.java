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
