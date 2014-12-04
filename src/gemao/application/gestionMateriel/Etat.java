package gemao.application.gestionMateriel;

public class Etat {
	private final long idEtat;
	private String libelleEtat;
	public Etat(long idEtat, String libelleEtat) {
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	public long getIdEtat() {
		return idEtat;
	}
	
	
}
