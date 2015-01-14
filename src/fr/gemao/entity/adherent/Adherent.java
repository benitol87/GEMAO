package fr.gemao.entity.adherent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.gemao.entity.Discipline;
import fr.gemao.entity.Personne;
import fr.gemao.entity.util.Civilite;

public class Adherent extends Personne {
	private Integer idMotif;
	private Long idResponsable;
	private boolean droitImage;
	private Date dateEntree;
	private Date dateSortie;
	private Float qf;
	private float cotisation;
	private List<Discipline> disciplines;

	public Adherent() {
		disciplines = new ArrayList<>();
	}

	/**
	 * Construit un Adh�rent
	 * 
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
	 * @param cotisation
	 * @param disciplines
	 */
	public Adherent(Long idPersonne, Long idAdresse, Long idCommuneNaiss,
			String nom, String prenom, Date dateNaissance, String telFixe,
			String telPort, String email, Civilite civilite, Integer idMotif,
			Long idResponsable, boolean droitImage, Date dateEntree,
			Date dateSortie, Float qf, float cotisation,
			List<Discipline> disciplines) {
		super(idPersonne, idAdresse, idCommuneNaiss, nom, prenom,
				dateNaissance, telFixe, telPort, email, civilite);
		this.idMotif = idMotif;
		this.idResponsable = idResponsable;
		this.droitImage = droitImage;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.qf = qf;
		this.cotisation = cotisation;
		if(disciplines == null){
			disciplines = new ArrayList<>();
		}
	}

	/**
	 * Construit un Adh�rent.
	 * 
	 * @param personne
	 * @param idMotif
	 * @param idResponsable
	 * @param droitImage
	 * @param dateEntree
	 * @param dateSortie
	 * @param qf
	 */
	public Adherent(Personne personne, Integer idMotif, Long idResponsable,
			boolean droitImage, Date dateEntree, Date dateSortie, Float qf,
			float cotisation, List<Discipline> disciplines) {
		super(personne);
		this.idMotif = idMotif;
		this.idResponsable = idResponsable;
		this.droitImage = droitImage;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.qf = qf;
		this.cotisation = cotisation;
		if(disciplines == null){
			disciplines = new ArrayList<>();
		}
	}

	/**
	 * @return the idMotif
	 */
	public Integer getIdMotif() {
		return idMotif;
	}

	/**
	 * @param idMotif
	 *            the idMotif to set
	 */
	public void setIdMotif(Integer idMotif) {
		this.idMotif = idMotif;
	}

	/**
	 * @return the idResponsable
	 */
	public Long getIdResponsable() {
		return idResponsable;
	}

	/**
	 * @param idResponsable
	 *            the idResponsable to set
	 */
	public void setIdResponsable(Long idResponsable) {
		this.idResponsable = idResponsable;
	}

	/**
	 * @return the droitImage
	 */
	public boolean isDroitImage() {
		return droitImage;
	}

	/**
	 * @param droitImage
	 *            the droitImage to set
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
	 * @param dateEntree
	 *            the dateEntree to set
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
	 * @param dateSortie
	 *            the dateSortie to set
	 */
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	/**
	 * @return the qf
	 */
	public Float getQf() {
		return qf;
	}

	/**
	 * @param qf
	 *            the qf to set
	 */
	public void setQf(float qf) {
		this.qf = qf;
	}

	public Float getCotisation() {
		return cotisation;
	}

	public void setCotisation(float cotisation) {
		this.cotisation = cotisation;
	}

	/**
	 * @return the disciplines
	 */
	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	/**
	 * @param disciplines
	 *            the disciplines to set
	 */
	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adherent [");
		builder.append(super.toString());
		builder.append(", idMotif=");
		builder.append(idMotif);
		builder.append(", idResponsable=");
		builder.append(idResponsable);
		builder.append(", droitImage=");
		builder.append(droitImage);
		builder.append(", dateEntree=");
		builder.append(dateEntree);
		builder.append(", dateSortie=");
		builder.append(dateSortie);
		builder.append(", qf=");
		builder.append(qf);
		builder.append(", cotisation=");
		builder.append(cotisation);
		builder.append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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
