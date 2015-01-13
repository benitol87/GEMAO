package fr.gemao.entity;

public class Adresse {
	private int idAdresse;
	private int idCommune;
	private int numRue;
	private String nomRue;
	private String infoCompl;
	
	public Adresse(int idAdresse, int idCommune, int numRue, String nomRue,
			String infoCompl) {
		super();
		this.idAdresse = idAdresse;
		this.idCommune = idCommune;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.infoCompl = infoCompl;
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(int idCommune) {
		this.idCommune = idCommune;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getInfoCompl() {
		return infoCompl;
	}

	public void setInfoCompl(String infoCompl) {
		this.infoCompl = infoCompl;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", idCommune=" + idCommune
				+ ", numRue=" + numRue + ", nomRue=" + nomRue + ", infoCompl="
				+ infoCompl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAdresse;
		result = prime * result + idCommune;
		result = prime * result
				+ ((infoCompl == null) ? 0 : infoCompl.hashCode());
		result = prime * result + ((nomRue == null) ? 0 : nomRue.hashCode());
		result = prime * result + numRue;
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
		Adresse other = (Adresse) obj;
		if (idAdresse != other.idAdresse)
			return false;
		if (idCommune != other.idCommune)
			return false;
		if (infoCompl == null) {
			if (other.infoCompl != null)
				return false;
		} else if (!infoCompl.equals(other.infoCompl))
			return false;
		if (nomRue == null) {
			if (other.nomRue != null)
				return false;
		} else if (!nomRue.equals(other.nomRue))
			return false;
		if (numRue != other.numRue)
			return false;
		return true;
	}
	
	
}
