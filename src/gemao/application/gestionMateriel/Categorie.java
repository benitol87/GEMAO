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

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", libelleCat="
				+ libelleCat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCategorie ^ (idCategorie >>> 32));
		result = prime * result
				+ ((libelleCat == null) ? 0 : libelleCat.hashCode());
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
		Categorie other = (Categorie) obj;
		if (idCategorie != other.idCategorie)
			return false;
		if (libelleCat == null) {
			if (other.libelleCat != null)
				return false;
		} else if (!libelleCat.equals(other.libelleCat))
			return false;
		return true;
	}
	
	
	
}
