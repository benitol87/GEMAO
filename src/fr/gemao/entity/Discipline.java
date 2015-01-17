package fr.gemao.entity;

import java.io.Serializable;

public class Discipline implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDiscipline;
	private String nom; 
	
	/**
	 * @param idDiscipline
	 * @param nom
	 */
	public Discipline(Integer idDiscipline, String nom) {
		super();
		this.idDiscipline = idDiscipline;
		this.nom = nom;
	}

	public Integer getIdDiscipline() {
		return idDiscipline;
	}

	public void setIdDiscipline(Integer idDiscipline) {
		this.idDiscipline = idDiscipline;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDiscipline == null) ? 0 : idDiscipline.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Discipline other = (Discipline) obj;
		if (idDiscipline == null) {
			if (other.idDiscipline != null)
				return false;
		} else if (!idDiscipline.equals(other.idDiscipline))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discipline [idDiscipline=" + idDiscipline + ", nom=" + nom
				+ "]";
	}
	
	
}
