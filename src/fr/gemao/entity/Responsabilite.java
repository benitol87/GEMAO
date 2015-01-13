package fr.gemao.entity;

/**
 * Classe Responsabilite
 * @author Coco
 *
 */
public class Responsabilite {
	
	private int idResponsabilite;
	private String libelle;

	/**
	 * Constructeur de la classe Responsabilite
	 * @param idResponsabilite : l'ID de la responsabilité
	 * @param libelle : le libelle de la responsabilité
	 */
	public Responsabilite(int idResponsabilite, String libelle) {
		this.idResponsabilite = idResponsabilite;
		this.libelle = libelle;
	}

	/**
	 * Permet de retourner l'ID de la responsabilité
	 * @return idResponsabilite : l'ID de la responsabilité
	 */
	public int getIdResponsabilite() {
		return idResponsabilite;
	}

	/**
	 * Permet de retourner le libelle
	 * @return libelle : le libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Permet de positionner l'ID de la responsabilité
	 * @param idResponsabilite : le nouveau ID
	 */
	public void setIdResponsabilite(int idResponsabilite) {
		this.idResponsabilite = idResponsabilite;
	}

	/**
	 * Permet de positionner le libelle de la responsabilité
	 * @param libelle : le nouveau libellé
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Redéfinition de la méthode toString
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Responsabilite [idResponsabilite=");
		builder.append(idResponsabilite);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Redéfinition de la méthode hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idResponsabilite;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	/**
	 * Redéfinition de la méthode equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsabilite other = (Responsabilite) obj;
		if (idResponsabilite != other.idResponsabilite)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
}