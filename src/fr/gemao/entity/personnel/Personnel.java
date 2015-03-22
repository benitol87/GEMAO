package fr.gemao.entity.personnel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Personne;
import fr.gemao.entity.administration.Profil;
import fr.gemao.entity.util.Civilite;

/**
 * Classe Contrat permettant de créer un personnel (extends Personne)
 * 
 * @author Coco
 *
 */
public class Personnel extends Personne implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Responsabilite> listeResponsabilite;
	private List<Diplome> listeDiplomes;
	private Contrat contrat;
	private String login;
	private String password;
	private int pointsAncien;
	private Profil profil;
	private boolean premiereConnexion;
	private String numeroSS;

	public Personnel() {
	}

	/**
	 * Constructeur de la classe Personnel
	 * 
	 * @param idPersonne
	 *            : l'ID de la personne
	 * @param idAdresse
	 *            : l'ID de l'adresse
	 * @param idCommuneNaiss
	 *            : l'ID de la commune de naissance
	 * @param nom
	 *            : le nom de la personne
	 * @param prenom
	 *            : le prénom de la personne
	 * @param dateNaissance
	 *            : la date de naissance de la personne
	 * @param telFixe
	 *            : le numéro de téléphone fixe de la personne
	 * @param telPort
	 *            : le numéro de téléphone portable de la personne
	 * @param email
	 *            : l'email de la personne
	 * @param listeResponsabilite
	 *            : l'ID des responsabilités
	 * @param contrat
	 *            : l'ID du contrat
	 * @param login
	 *            : le login de la personne
	 * @param password
	 *            : le password de la personne
	 * @param pointsAncien
	 *            : le nombre de points d'ancienneté
	 * @param profil
	 * 			  : le profil du personnel	
	 * @param premiereConnexion
	 * 			  : un booléen valant vrai s'il s'agit de la première
	 * 				connexion de ce membre du personnel
	 */
	public Personnel(Long idPersonne,  Adresse adresse,
			Commune communeNaiss, String nom, String prenom,
			Date dateNaissance, String telFixe, String telPort, String email,
			Civilite civilite, List<Responsabilite> listeResponsabilite,
			List<Diplome> listeDiplome, Contrat contrat, String login,
			String password, int pointsAncien, Profil profil,
			boolean premiereConnexion, boolean membreCA, String numeroSS) {
		super(idPersonne, adresse, communeNaiss, nom, prenom, dateNaissance,
				telFixe, telPort, email, civilite, membreCA);

		this.listeResponsabilite = listeResponsabilite;
		this.listeDiplomes = listeDiplome;
		this.contrat = contrat;
		this.login = login;
		this.password = password;
		this.pointsAncien = pointsAncien;
		this.profil = profil;
		this.premiereConnexion = premiereConnexion;
		this.numeroSS = numeroSS;
	}

	/**
	 * 
	 * @param personne
	 * @param listeResponsabilite
	 * @param contrat
	 * @param login
	 * @param password
	 * @param pointsAncien
	 */
	public Personnel(Personne personne,
			List<Responsabilite> listeResponsabilite,
			List<Diplome> listeDiplome, Contrat contrat, String login,
			String password, Integer pointsAncien, Profil profil, boolean premiereConnexion, String numeroSS) {
		super(personne);

		this.listeResponsabilite = listeResponsabilite;
		this.listeDiplomes = listeDiplome;
		this.contrat = contrat;
		this.login = login;
		this.password = password;
		this.pointsAncien = pointsAncien;
		this.profil = profil;
		this.premiereConnexion = premiereConnexion;
		this.numeroSS = numeroSS;
	}

	/**
	 * Permet de retourner la liste des ID de responsabilités du personnel
	 * 
	 * @return idResponsabilite : la liste des responsabilités
	 */
	public List<Responsabilite> getListeResponsabilite() {
		return listeResponsabilite;
	}

	/**
	 * Permet de retourner l'ID du contrat du personnel
	 * 
	 * @return idContrat : l'ID du contrat
	 */
	public Contrat getContrat() {
		return contrat;
	}

	/**
	 * Permet de retourner le login du personnel
	 * 
	 * @return login : le login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Permet de retourner le password du personnel
	 * 
	 * @return password : le password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Permet de retourner le nombre de points d'ancienneté du personnel
	 * 
	 * @return pointsAncien : le nombre de points
	 */
	public int getPointsAncien() {
		return pointsAncien;
	}

	/**
	 * Permet de positionner une liste d'ID responsabilités
	 * 
	 * @param idResponsabilite
	 *            : la liste de responsabilités
	 */
	public void setListeResponsabilite(List<Responsabilite> listeResponsabilite) {
		this.listeResponsabilite = listeResponsabilite;
	}

	/**
	 * Permet de positionner l'ID du contrat du personnel
	 * 
	 * @param contrat
	 *            : l'ID du contrat
	 */
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	/**
	 * Permet de positionner le login du personnel
	 * 
	 * @param login
	 *            : le login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Permet de positionner le password du personnel
	 * 
	 * @param password
	 *            : le passeword
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Permet de positionner pointsAncien du personnel
	 * 
	 * @param pointsAncien
	 *            : le nombre de points d'ancienneté
	 */
	public void setPointsAncien(int pointsAncien) {
		this.pointsAncien = pointsAncien;
	}
	
	

	/**
	 * @return the listeDiplomes
	 */
	public List<Diplome> getListeDiplomes() {
		return listeDiplomes;
	}

	/**
	 * @param listeDiplomes the listeDiplomes to set
	 */
	public void setListeDiplomes(List<Diplome> listeDiplomes) {
		this.listeDiplomes = listeDiplomes;
	}

	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil the profil to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	

	public String getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}

	public boolean isPremiereConnexion() {
		return premiereConnexion;
	}

	public void setPremiereConnexion(boolean premiereConnexion) {
		this.premiereConnexion = premiereConnexion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
		result = prime * result
				+ ((listeDiplomes == null) ? 0 : listeDiplomes.hashCode());
		result = prime
				* result
				+ ((listeResponsabilite == null) ? 0 : listeResponsabilite
						.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + pointsAncien;
		result = prime * result + ((profil == null) ? 0 : profil.hashCode());
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
		Personnel other = (Personnel) obj;
		if (contrat == null) {
			if (other.contrat != null)
				return false;
		} else if (!contrat.equals(other.contrat))
			return false;
		if (listeDiplomes == null) {
			if (other.listeDiplomes != null)
				return false;
		} else if (!listeDiplomes.equals(other.listeDiplomes))
			return false;
		if (listeResponsabilite == null) {
			if (other.listeResponsabilite != null)
				return false;
		} else if (!listeResponsabilite.equals(other.listeResponsabilite))
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
		if (profil == null) {
			if (other.profil != null)
				return false;
		} else if (!profil.equals(other.profil))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personnel [listeResponsabilite=" + listeResponsabilite
				+ ", listeDiplomes=" + listeDiplomes + ", contrat=" + contrat
				+ ", login=" + login + ", password=" + password
				+ ", pointsAncien=" + pointsAncien + ", profil=" + profil + "]";
	}

	

}