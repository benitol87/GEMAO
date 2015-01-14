package fr.gemao.entity;

public class Adresse {
	private Integer idAdresse;
	private Integer idCommune;
	private Integer numRue;
	private String nomRue;
	private String infoCompl;
	
	public Adresse() {
	}
	
	public Adresse(Integer idAdresse, Integer idCommune, Integer numRue, String nomRue,
			String infoCompl) {
		super();
		this.idAdresse = idAdresse;
		this.idCommune = idCommune;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.infoCompl = infoCompl;
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public Integer getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(Integer idCommune) {
		this.idCommune = idCommune;
	}

	public Integer getNumRue() {
		return numRue;
	}

	public void setNumRue(Integer numRue) {
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
		final Integer prime = 31;
		Integer result = 1;
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
