package gemao.application.gestionMateriel;

public class Categorie {
	private final long idCategorie;
	private final String libelleCat;
	
	public Categorie(long l, String libelleCat) {
		this.idCategorie = l;
		this.libelleCat = libelleCat;
	}

	public Categorie(Categorie categorie){
		this(categorie.getIdCategorie(),categorie.getLibelleCat());
	}
	public long getIdCategorie() {
		return idCategorie;
	}

	public String getLibelleCat() {
		return libelleCat;
	}
	
}
