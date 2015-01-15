package fr.gemao.entity;

import java.util.Date;

/**
 * Classe Contrat permettant de créer un contrat en récupérant le nom et le prénom d'un personnel
 * @author Coco
 */
public class Contrat {
	private Integer idContrat;
	private int typeContrat;
	private int IdMotifContrat;
	private Date dateDebut;
	private Date dateFin;
	private Date dateRupture;
	
	public Contrat() {
		
	}
	
	

	/**
	 * @param idContrat
	 * @param typeContrat
	 * @param idMotifContrat
	 * @param dateDebut
	 * @param dateFin
	 * @param dateRupture
	 */
	public Contrat(Integer idContrat, int typeContrat, int idMotifContrat,
			Date dateDebut, Date dateFin, Date dateRupture) {
		super();
		this.idContrat = idContrat;
		this.typeContrat = typeContrat;
		IdMotifContrat = idMotifContrat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateRupture = dateRupture;
	}



	/**
	 * @return the idContrat
	 */
	public Integer getIdContrat() {
		return idContrat;
	}



	/**
	 * @param idContrat the idContrat to set
	 */
	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}


	/**
	 * @param typeContrat the typeContrat to set
	 */
	public void setTypeContrat(int typeContrat) {
		this.typeContrat = typeContrat;
	}



	/**
	 * @return the typeContrat
	 */
	public int getTypeContrat() {
		return typeContrat;
	}

	/**
	 * @return the idMotifContrat
	 */
	public int getIdMotifContrat() {
		return IdMotifContrat;
	}



	/**
	 * @param idMotifContrat the idMotifContrat to set
	 */
	public void setIdMotifContrat(int idMotifContrat) {
		IdMotifContrat = idMotifContrat;
	}



	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}



	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}



	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	/**
	 * @return the dateRupture
	 */
	public Date getDateRupture() {
		return dateRupture;
	}



	/**
	 * @param dateRupture the dateRupture to set
	 */
	public void setDateRupture(Date dateRupture) {
		this.dateRupture = dateRupture;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdMotifContrat;
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result
				+ ((dateRupture == null) ? 0 : dateRupture.hashCode());
		result = prime * result
				+ ((idContrat == null) ? 0 : idContrat.hashCode());
		result = prime * result + typeContrat;
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
		Contrat other = (Contrat) obj;
		if (IdMotifContrat != other.IdMotifContrat)
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (dateRupture == null) {
			if (other.dateRupture != null)
				return false;
		} else if (!dateRupture.equals(other.dateRupture))
			return false;
		if (idContrat == null) {
			if (other.idContrat != null)
				return false;
		} else if (!idContrat.equals(other.idContrat))
			return false;
		if (typeContrat != other.typeContrat)
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contrat [idContrat=" + idContrat + ", typeContrat="
				+ typeContrat + ", IdMotifContrat=" + IdMotifContrat
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", dateRupture=" + dateRupture + "]";
	}



	
}