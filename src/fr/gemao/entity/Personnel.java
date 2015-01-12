package fr.gemao.entity;

/**
 * Classe Contrat permettant de créer un personnel
 * @author Coco
 *
 */
public class Personnel {
	
	private String nom;
	private String prenom;
	private int jourNaiss;
	private int moisNaiss;
	private int anneeNaiss;
	private String telFix;
	private String telPort;
	private String mail;
	private String addresse;
	private String ville;
	private String cp;
	private String diplome;
	private String fonction;
	
	/**
	 * Constructeur de la classe Personnel
	 * @param nom
	 * 		Le nom de la personne
	 * @param prenom
	 * 		Le prénom de la personne
	 * @param jourNaiss
	 * 		Le jour de naissance de la personne
	 * @param moisNaiss
	 * 		Le mois de naissance de la personne
	 * @param anneeNaiss
	 * 		L'année de naissance de la personne
	 * @param telFix
	 * 		Le numéro de téléphone fix de la personne
	 * @param telPort
	 * 		Le numéro de téléphone portable de la personne
	 * @param addresse
	 * 		L'adresse physique de la personne
	 * @param mail
	 * 		L'adresse mail de la personne
	 * @param ville
	 * 		La ville où habite la personne
	 * @param cp
	 * 		Le code postal où habite la personne
	 * @param diplome
	 * 		Le diplôme détenu par la personne
	 * @param fonction
	 * 		La fonction exercée par la personne
	 */
	public Personnel(String nom, String prenom, int jourNaiss, int moisNaiss, int anneeNaiss, String telFix, String telPort, String addresse, String mail, String ville, String cp, String diplome, String fonction) {
		this.nom = nom;
		this.prenom = prenom;
		this.jourNaiss = jourNaiss;
		this.moisNaiss = moisNaiss;
		this.anneeNaiss = anneeNaiss;
		this.telFix = telFix;
		this.telPort = telPort;
		this.mail = mail;
		this.addresse = addresse;
		this.ville = ville;
		this.cp = cp;
		this.diplome = diplome;
		this.fonction = fonction;
	}

	/**
	 * Méthode permettant de retourner le nom de la personne
	 * @return nom
	 * 		Le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode permettant de retourner le prénom de la personne
	 * @return prenom
	 * 		Le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode permettant de retourner le jour de naissance de la personne
	 * @return jourNaiss
	 * 		Le jour de naissance de la personne
	 */
	public int getJourNaiss() {
		return jourNaiss;
	}

	/**
	 * Méthode permettant de retourner le mois de naissance de la personne
	 * @return moisNaiss
	 * 		Le mois de naissance de la personne
	 */
	public int getMoisNaiss() {
		return moisNaiss;
	}

	/**
	 * Méthode permettant de retourner l'année de naissance de la personne
	 * @return anneeNaiss
	 * 		L'année de naissance de la personne
	 */
	public int getAnneeNaiss() {
		return anneeNaiss;
	}

	/**
	 * Méthode permettant de retourner le numéro de téléphone fixe de la personne
	 * @return telFix
	 * 		Le numéro de téléphone fixe de la personne
	 */
	public String getTelFix() {
		return telFix;
	}

	/**
	 * Méthode permettant de retourner le numéro de téléphone portable de la personne
	 * @return telPort
	 * 		Le numéro de téléphone portable de la personne
	 */
	public String getTelPort() {
		return telPort;
	}

	/**
	 * Méthode permettant de retourner l'adresse mail de la personne
	 * @return mail
	 * 		L'adresse mail de la personne
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Méthode permettant de retourner l'adresse physique de la personne
	 * @return adresse
	 * 		L'adresse physique de la personne
	 */
	public String getAddresse() {
		return addresse;
	}

	/**
	 * Méthode permettant de retourner la ville où habite la personne
	 * @return ville
	 * 		La ville où habite la personne
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Méthode permettant de retourner le code postal où habite la personne
	 * @return cp
	 * 		Le code postal de la personne
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Méthode permettant de retourner le diplôme détenu par la personne
	 * @return diplome
	 * 		Le diplôme détenu par la personne
	 */
	public String getDiplome() {
		return diplome;
	}

	/**
	 * Méthode permettant de retourner la fonction exercée par la personne
	 * @return fonction
	 * 		La fonction exercée par la personne
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * Méthode permettant de modifier le nom de la personne
	 * @param nom
	 * 		Le nouveau nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode permettant de modifier le prénom de la personne
	 * @param prenom
	 * 		Le nouveau prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Méthode permettant de modifier le jour de naissance de la personne
	 * @param jourNaiss
	 * 		Le nouveau jour de naissance de la personne
	 */
	public void setJourNaiss(int jourNaiss) {
		this.jourNaiss = jourNaiss;
	}

	/**
	 * Méthode permettant de modifier le mois de naissance de la personne
	 * @param moisNaiss
	 * 		Le nouveau mois de naissance de la personne
	 */
	public void setMoisNaiss(int moisNaiss) {
		this.moisNaiss = moisNaiss;
	}

	/**
	 * Méthode permettant de modifier l'année de naissance de la personne
	 * @param anneeNaiss
	 * 		La nouvelle année de naissance de la personne
	 */
	public void setAnneeNaiss(int anneeNaiss) {
		this.anneeNaiss = anneeNaiss;
	}

	/**
	 * Méthode permettant de modifier le numéro de téléphone fixe de la personne
	 * @param telFix
	 * 		Le nouveau numéro de téléphone fixe de la personne
	 */
	public void setTelFix(String telFix) {
		this.telFix = telFix;
	}
	
	/**
	 * Méthode permettant de modifier le numéro de téléphone portable de la personne
	 * @param telPort
	 * 		Le nouveau numéro de téléphone portable de la personne
	 */
	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}
	
	/**
	 * Méthode permettant de modifier l'adresse mail de la personne
	 * @param mail
	 * 		La nouvelle adresse mail de la personne
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}	

	/**
	 * Méthode permettant de modifier l'adresse physique de la personne
	 * @param addresse
	 * 		La nouvelle adresse physique de la personne
	 */
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	/**
	 * Méthode permettant de modifier la ville où habite la personne
	 * @param ville
	 * 		La nouvelle ville où habite la personne
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Méthode permettant de modifier le code postal où habite la personne
	 * @param cp
	 * 		Le nouveau code postal de la personne
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Méthode permettant de modifier le diplôme détenu par la personne
	 * @param diplome
	 * 		Le nouveau diplôme de la personne
	 */
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	/**
	 * Méthode permettant de modifier la fonction exercée par la personne
	 * @param fonction
	 * 		La nouvelle fonction de la personne
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	/**
	 * Redéfintion de la méthode toString permettant d'afficher les caractéristiques d'un personnel
	 */
	@Override
	public String toString() {
		String personnel;
		StringBuilder sb = new StringBuilder();
		
		/* Concaténation de la chaine StringBuilder */
		sb.append("Personnel : \n")
		.append("Nom : ")
		.append(this.nom)
		.append("\nPrénom : ")
		.append(this.prenom)
		.append("\nDate de naissance : ")
		.append(this.jourNaiss)
		.append("/")
		.append(this.moisNaiss)
		.append("/")
		.append(this.anneeNaiss)
		.append("\nTéléphone fixe : ")
		.append(this.telFix)
		.append("\nTéléphone portable : ")
		.append(this.telPort)
		.append("\nAdresse mail : ")
		.append(this.mail)
		.append("\nAdresse : ")
		.append(this.addresse)
		.append("\nVille : ")
		.append(this.ville)
		.append("\nCode Postal : ")
		.append(this.cp)
		.append("\nDiplôme : ")
		.append(this.diplome)
		.append("\nFonction : ")
		.append(this.fonction);
		
		personnel = sb.toString();
		
		return personnel;
	}

	/**
	 * Redéfinition de la méthode hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addresse == null) ? 0 : addresse.hashCode());
		result = prime * result + anneeNaiss;
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((diplome == null) ? 0 : diplome.hashCode());
		result = prime * result
				+ ((fonction == null) ? 0 : fonction.hashCode());
		result = prime * result + jourNaiss;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + moisNaiss;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telFix == null) ? 0 : telFix.hashCode());
		result = prime * result + ((telPort == null) ? 0 : telPort.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	/**
	 * Redéfinition de la méthode Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnel other = (Personnel) obj;
		if (addresse == null) {
			if (other.addresse != null)
				return false;
		} else if (!addresse.equals(other.addresse))
			return false;
		if (anneeNaiss != other.anneeNaiss)
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (diplome == null) {
			if (other.diplome != null)
				return false;
		} else if (!diplome.equals(other.diplome))
			return false;
		if (fonction == null) {
			if (other.fonction != null)
				return false;
		} else if (!fonction.equals(other.fonction))
			return false;
		if (jourNaiss != other.jourNaiss)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (moisNaiss != other.moisNaiss)
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
		if (telFix == null) {
			if (other.telFix != null)
				return false;
		} else if (!telFix.equals(other.telFix))
			return false;
		if (telPort == null) {
			if (other.telPort != null)
				return false;
		} else if (!telPort.equals(other.telPort))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
}