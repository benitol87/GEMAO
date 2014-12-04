package gemao.application.gestionMateriel;

public class Categorie {
	private final int idCategorie;
	private final String libelleCat;
	
	/**
	 * Instantiates a new categorie.
	 *
	 * @param l the l
	 * @param libelleCat the libelle cat
	 */
	public Categorie(int l, String libelleCat) {
		this.idCategorie = l;
		this.libelleCat = libelleCat;
	}

	/**
	 * Instantiates a new categorie.
	 *
	 * @param categorie the categorie
	 */
	public Categorie(Categorie categorie){
		this(categorie.getIdCategorie(),categorie.getLibelleCat());
	}
	
	/**
	 * Gets the id categorie.
	 *
	 * @return the id categorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * Gets the libelle cat.
	 *
	 * @return the libelle cat
	 */
	public String getLibelleCat() {
		return libelleCat;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", libelleCat="
				+ libelleCat + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCategorie ^ (idCategorie >>> 32));
		result = prime * result
				+ ((libelleCat == null) ? 0 : libelleCat.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
