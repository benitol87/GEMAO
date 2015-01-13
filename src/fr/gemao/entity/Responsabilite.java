package fr.gemao.entity;

public class Responsabilite {
	
	private int idResponsabilite;
	private String libelle;

	public Responsabilite(int idResponsabilite, String libelle) {
		this.idResponsabilite = idResponsabilite;
		this.libelle = libelle;
	}

	public int getIdResponsabilite() {
		return idResponsabilite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setIdResponsabilite(int idResponsabilite) {
		this.idResponsabilite = idResponsabilite;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idResponsabilite;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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