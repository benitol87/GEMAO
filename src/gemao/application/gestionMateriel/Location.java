package materiel;

public class Location {
	private final Personne personne;
	private final Materiel materiel;
	private final Etat etatDebut;
	private final Etat etatFin;
	private final String dateEmprunt;
	private final String dateRetour;
	private final int duree;
	private float montant;
	public Location(Personne personne, Materiel materiel, Etat etatDebut,
			Etat etatFin, String dateEmprunt, String dateRetour, int duree,
			float montant) {
		this.personne = personne;
		this.materiel = materiel;
		this.etatDebut = etatDebut;
		this.etatFin = etatFin;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.duree = duree;
		this.montant = montant;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Personne getPersonne() {
		return personne;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public Etat getEtatDebut() {
		return etatDebut;
	}
	public Etat getEtatFin() {
		return etatFin;
	}
	public String getDateEmprunt() {
		return dateEmprunt;
	}
	public String getDateRetour() {
		return dateRetour;
	}
	public int getDuree() {
		return duree;
	}
}
