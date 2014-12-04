package gemao.application.gestionMateriel;

public class Marque {
	private final long idMarque;
	private String nomMarque;
	
	public Marque(long idMarque, String nomMarque) {
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public long getIdMarque() {
		return idMarque;
	}
	
	
}
