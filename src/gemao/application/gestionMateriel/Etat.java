package gemao.application.gestionMateriel;

public class Etat {
	private final int idEtat;
	private String libelleEtat;
	public Etat(int idEtat, String libelleEtat) {
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	public int getIdEtat() {
		return idEtat;
	}
	
	
}
