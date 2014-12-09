package gemao.entity;

import java.util.Date;

public class Adherent extends Personne{
	private Integer idMotif;
	private Long idResponsable;
	private boolean droitImage;
	private Date dateEntree;
	private Date dateSortie;
	private float qf;
	
	
	/**
	 * Construit un Adh�rent
	 * @param idPersonne
	 * @param idAdresse
	 * @param idCommuneNaiss
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param telFixe
	 * @param telPort
	 * @param email
	 * @param idMotif
	 * @param idResponsable
	 * @param droitImage
	 * @param dateEntree
	 * @param dateSortie
	 * @param qf 
	 */
	public Adherent(long idPersonne, long idAdresse, long idCommuneNaiss,
			String nom, String prenom, Date dateNaissance, String telFixe,
			String telPort, String email, int idMotif, long idResponsable,
			boolean droitImage, Date dateEntree, Date dateSortie, float qf) {
		super(idPersonne, idAdresse, idCommuneNaiss, nom, prenom,
				dateNaissance, telFixe, telPort, email);
		this.idMotif = idMotif;
		this.idResponsable = idResponsable;
		this.droitImage = droitImage;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.qf = qf;
	}
	
	/**
	 * Construit un Adh�rent.
	 * @param personne
	 * @param idMotif
	 * @param idResponsable
	 * @param droitImage
	 * @param dateEntree
	 * @param dateSortie
	 * @param qf
	 */
	public Adherent(Personne personne, int idMotif, long idResponsable,
			boolean droitImage, Date dateEntree, Date dateSortie, float qf){
		super(personne);
		this.idMotif = idMotif;
		this.idResponsable = idResponsable;
		this.droitImage = droitImage;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.qf = qf;
	}


	/**
	 * @return the idMotif
	 */
	public Integer getIdMotif() {
		return idMotif;
	}


	/**
	 * @param idMotif the idMotif to set
	 */
	public void setIdMotif(int idMotif) {
		this.idMotif = idMotif;
	}


	/**
	 * @return the idResponsable
	 */
	public Long getIdResponsable() {
		return idResponsable;
	}


	/**
	 * @param idResponsable the idResponsable to set
	 */
	public void setIdResponsable(long idResponsable) {
		this.idResponsable = idResponsable;
	}


	/**
	 * @return the droitImage
	 */
	public boolean isDroitImage() {
		return droitImage;
	}


	/**
	 * @param droitImage the droitImage to set
	 */
	public void setDroitImage(boolean droitImage) {
		this.droitImage = droitImage;
	}


	/**
	 * @return the dateEntree
	 */
	public Date getDateEntree() {
		return dateEntree;
	}


	/**
	 * @param dateEntree the dateEntree to set
	 */
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}


	/**
	 * @return the dateSortie
	 */
	public Date getDateSortie() {
		return dateSortie;
	}


	/**
	 * @param dateSortie the dateSortie to set
	 */
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}


	/**
	 * @return the qf
	 */
	public float getQf() {
		return qf;
	}

	/**
	 * @param qf the qf to set
	 */
	public void setQf(float qf) {
		this.qf = qf;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adherent [idMotif=");
		builder.append(idMotif);
		builder.append(", idResponsable=");
		builder.append(idResponsable);
		builder.append(", droitImage=");
		builder.append(droitImage);
		builder.append(", dateEntree=");
		builder.append(dateEntree);
		builder.append(", dateSortie=");
		builder.append(dateSortie);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dateEntree == null) ? 0 : dateEntree.hashCode());
		result = prime * result
				+ ((dateSortie == null) ? 0 : dateSortie.hashCode());
		result = prime * result + (droitImage ? 1231 : 1237);
		result = prime * result + idMotif;
		result = prime * result
				+ (int) (idResponsable ^ (idResponsable >>> 32));
		result = prime * result + Float.floatToIntBits(qf);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adherent other = (Adherent) obj;
		if (dateEntree == null) {
			if (other.dateEntree != null)
				return false;
		} else if (!dateEntree.equals(other.dateEntree))
			return false;
		if (dateSortie == null) {
			if (other.dateSortie != null)
				return false;
		} else if (!dateSortie.equals(other.dateSortie))
			return false;
		if (droitImage != other.droitImage)
			return false;
		if (idMotif != other.idMotif)
			return false;
		if (idResponsable != other.idResponsable)
			return false;
		if (Float.floatToIntBits(qf) != Float.floatToIntBits(other.qf))
			return false;
		return true;
	}
	
}
