package gemao.application.gestionMateriel;

public class Marque {
	private final int idMarque;
	private String nomMarque;
	
	public Marque(int idMarque, String nomMarque) {
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public int getIdMarque() {
		return idMarque;
	}
	
	
}
