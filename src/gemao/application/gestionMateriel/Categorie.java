package materiel;

public class Categorie {
	private final int idCategorie;
	private final String libelleCat;
	private string asupprimer;
	
	public Categorie(int idCategorie, String libelleCat) {
		this.idCategorie = idCategorie;
		this.libelleCat = libelleCat;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public String getLibelleCat() {
		return libelleCat;
	}
	
}
