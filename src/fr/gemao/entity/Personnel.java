package fr.gemao.entity;

import java.util.Date;
import java.util.List;

/**
 * Classe Contrat permettant de créer un personnel (extends Personne)
 * @author Coco
 *
 */
public class Personnel extends Personne {
		
	private List<Integer> idResponsabilite;
	private Integer idContrat;
	private String login;
	private String password;
	private int pointsAncien;
	
	/**
	 * Constructeur de la classe Personnel
	 * @param idPersonne : l'ID de la personne
	 * @param idAdresse : l'ID de l'adresse
	 * @param idCommuneNaiss : l'ID de la commune de naissance
	 * @param nom : le nom de la personne
	 * @param prenom : le prénom de la personne
	 * @param dateNaissance : la date de naissance de la personne
	 * @param telFixe : le numéro de téléphone fixe de la personne
	 * @param telPort : le numéro de téléphone portable de la personne
	 * @param email : l'email de la personne
	 * @param idResponsabilite : l'ID des responsabilités
	 * @param idContrat : l'ID du contrat
	 * @param login : le login de la personne
	 * @param password : le password de la personne
	 * @param pointsAncien : le nombre de points d'ancienneté
	 */
	public Personnel(Long idPersonne, Long idAdresse, Long idCommuneNaiss, String nom, String prenom, Date dateNaissance, String telFixe, String telPort, String email, List<Integer> idResponsabilite, Integer idContrat, String login, String password, int pointsAncien) {
		super(idPersonne, idAdresse, idCommuneNaiss, nom, prenom, dateNaissance, telFixe, telPort, email);
		
		this.idResponsabilite = idResponsabilite;
		this.idContrat = idContrat;
		this.login = login;
		this.password = password;
		this.pointsAncien = pointsAncien;
	}

	/**
	 * Permet de retourner la liste des ID de responsabilités du personnel
	 * @return idResponsabilite : la liste des responsabilités
	 */
	public List<Integer> getIdResponsabilite() {
		return idResponsabilite;
	}

	/**
	 * Permet de retourner l'ID du contrat du personnel
	 * @return idContrat : l'ID du contrat
	 */
	public Integer getIdContrat() {
		return idContrat;
	}

	/**
	 * Permet de retourner le login du personnel
	 * @return login : le login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Permet de retourner le password du personnel
	 * @return password : le password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Permet de retourner le nombre de points d'ancienneté du personnel
	 * @return pointsAncien : le nombre de points
	 */
	public int getPointsAncien() {
		return pointsAncien;
	}

	/**
	 * Permet de positionner une liste d'ID responsabilités
	 * @param idResponsabilite : la liste de responsabilités
	 */
	public void setIdResponsabilite(List<Integer> idResponsabilite) {
		this.idResponsabilite = idResponsabilite;
	}

	/**
	 * Permet de positionner l'ID du contrat du personnel
	 * @param idContrat : l'ID du contrat
	 */
	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	/**
	 * Permet de positionner le login du personnel
	 * @param login : le login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Permet de positionner le password du personnel
	 * @param password : le passeword
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Permet de positionner pointsAncien du personnel
	 * @param pointsAncien : le nombre de points d'ancienneté
	 */
	public void setPointsAncien(int pointsAncien) {
		this.pointsAncien = pointsAncien;
	}

	/**
	 * Redéfinition de la méthode hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idContrat == null) ? 0 : idContrat.hashCode());
		result = prime
				* result
				+ ((idResponsabilite == null) ? 0 : idResponsabilite.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + pointsAncien;
		return result;
	}

	/**
	 * Redéfinition de la méthode equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnel other = (Personnel) obj;
		if (idContrat == null) {
			if (other.idContrat != null)
				return false;
		} else if (!idContrat.equals(other.idContrat))
			return false;
		if (idResponsabilite == null) {
			if (other.idResponsabilite != null)
				return false;
		} else if (!idResponsabilite.equals(other.idResponsabilite))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pointsAncien != other.pointsAncien)
			return false;
		return true;
	}
}