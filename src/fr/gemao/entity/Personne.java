package fr.gemao.entity;

import java.util.Date;

import fr.gemao.entity.util.Civilite;

public class Personne {

	private Long idPersonne;
	private Integer idAdresse;
	private Integer idCommuneNaiss;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String telFixe;
	private String telPort;
	private String email;
	private Civilite civilite;
	
	public Personne() {
	}

	/**
	 * Construit une Personne
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
	 * @param civilite
	 */
	public Personne(Long idPersonne, Integer idAdresse, Integer idCommuneNaiss,
			String nom, String prenom, Date dateNaissance, String telFixe,
			String telPort, String email, Civilite civilite) {
		this.idPersonne = idPersonne;
		this.idAdresse = idAdresse;
		this.idCommuneNaiss = idCommuneNaiss;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telFixe = telFixe;
		this.telPort = telPort;
		this.email = email;
		this.civilite = civilite;
	}

	/**
	 * Construit une Personne � partir d'une personne.
	 * 
	 * @param personne
	 */
	public Personne(Personne personne) {
		this(personne.getIdPersonne(), personne.getIdAdresse(), personne
				.getIdCommuneNaiss(), personne.getNom(), personne.getPrenom(),
				personne.getDateNaissance(), personne.getTelFixe(), personne
						.getTelPort(), personne.getEmail(), personne.getCivilite());
	}

	/**
	 * @return the idPersonne
	 */
	public Long getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne
	 *            the idPersonne to set
	 */
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return the idAdresse
	 */
	public Integer getIdAdresse() {
		return idAdresse;
	}

	/**
	 * @param idAdresse
	 *            the idAdresse to set
	 */
	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	/**
	 * @return the idCommuneNaiss
	 */
	public Integer getIdCommuneNaiss() {
		return idCommuneNaiss;
	}

	/**
	 * @param idCommuneNaiss
	 *            the idCommuneNaiss to set
	 */
	public void setIdCommuneNaiss(Integer idCommuneNaiss) {
		this.idCommuneNaiss = idCommuneNaiss;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the telFixe
	 */
	public String getTelFixe() {
		return telFixe;
	}

	/**
	 * @param telFixe
	 *            the telFixe to set
	 */
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	/**
	 * @return the telPort
	 */
	public String getTelPort() {
		return telPort;
	}

	/**
	 * @param telPort
	 *            the telPort to set
	 */
	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idAdresse ^ (idAdresse >>> 32));
		result = prime * result
				+ (int) (idCommuneNaiss ^ (idCommuneNaiss >>> 32));
		result = prime * result + (int) (idPersonne ^ (idPersonne >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telFixe == null) ? 0 : telFixe.hashCode());
		result = prime * result + ((telPort == null) ? 0 : telPort.hashCode());
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
		Personne other = (Personne) obj;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAdresse != other.idAdresse)
			return false;
		if (idCommuneNaiss != other.idCommuneNaiss)
			return false;
		if (idPersonne != other.idPersonne)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telFixe == null) {
			if (other.telFixe != null)
				return false;
		} else if (!telFixe.equals(other.telFixe))
			return false;
		if (telPort == null) {
			if (other.telPort != null)
				return false;
		} else if (!telPort.equals(other.telPort))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [idPersonne=");
		builder.append(idPersonne);
		builder.append(", idAdresse=");
		builder.append(idAdresse);
		builder.append(", idCommuneNaiss=");
		builder.append(idCommuneNaiss);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", telFixe=");
		builder.append(telFixe);
		builder.append(", telPort=");
		builder.append(telPort);
		builder.append(", email=");
		builder.append(email);
		builder.append(", civilite=");
		builder.append(civilite);
		builder.append("]");
		return builder.toString();
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

}
