package fr.gemao.form.adherent;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe pour la validation du formulaire d'ajout d'un adhérent
 * @author claire
 *
 */
public class AdherentForm {

	/**
	 * Champs du formulaire d'ajout d'un adhérent
	 */
	//Informations relatives à la personne
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_DATENAISS = "dateNaissance";
	private static final String CHAMP_TELFIXE = "telFixe";
	private static final String CHAMP_TELPORT = "telPort";
	private static final String CHAMP_EMAIL = "email";
	
	//Adresse
	private static final String CHAMP_NUMRUE = "numRue";
	private static final String CHAMP_NOMRUE = "nomRue";
	private static final String CHAMP_INFOCOMPL = "infoCompl";
	
	//Commune
	private static final String CHAMP_CODEPOSTAL = "codePostal";
	private static final String CHAMP_NOMCOMMUNE = "nomCommune";
	
	//Droit à l'image
	private static final String CHAMP_DROITIMAGE = "droitImage";
	
	//Discipline
	private static final String CHAMP_DISCIPLINE = "discipline";
	private static final String CHAMP_CLASSE = "classe";
	
	/**
	 * Variables récupérées via le formulaire d'ajout d'un adhérent
	 */
	//Informations relatives à la personne
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String telFixe;
	private String telPort;
	private String email;
	
	//Adresse
	private Integer numRue;
	private String nomRue;
	private String infoCompl;
	
	//Commune
	private Integer codePostal;
	private String nomCommune;
	
	//Droit à l'image
	private boolean droitImage;
	
	//Discipline
	private List<String> disciplines;
	private List<String> classes;
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public String getResultat(){
		return this.resultat;
	}
	
	public Map<String, String> getErreurs(){
		return this.erreurs;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	public Date getDateNaissance(){
		return this.dateNaissance;
	}
	
	public String getTelFixe(){
		return this.telFixe;
	}
	
	public String getTelPort(){
		return this.telPort;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public Integer getNumRue(){
		return this.numRue;
	}
	
	public String getNomRue(){
		return this.nomRue;
	}
	
	public String getInfoCompl(){
		return this.infoCompl;
	}
	
	public Integer getCodePostal(){
		return this.codePostal;
	}
	
	public String getNomCommune(){
		return this.nomCommune;
	}
	
	public boolean getDroitImage(){
		return this.droitImage;
	}
	
	public List<String> getDisciplines(){
		return this.disciplines;
	}
	
	public List<String> getClasses(){
		return this.classes;
	}
	
	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request,
			String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
	
	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}
	
	/**
	 * Méthode permettant de valider le nom de l'adhérent
	 * @param nom
	 * @throws Exception
	 */
	private void validationNom(String nom) throws Exception {
		if (nom == null || nom.equals("")) {
			throw new Exception("Merci de saisir un nom valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le prénom de l'adhérent
	 * @param prenom
	 * @throws Exception
	 */
	private void validationPrenom(String prenom) throws Exception {
		if (prenom == null || prenom.equals("")) {
			throw new Exception("Merci de saisir un nom valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider la date de naissance de l'adhérent
	 * @param dateNaissance
	 * @throws Exception
	 */
	private void validationDateNaissance(String dateNaissance) throws Exception {
		if (dateNaissance == null || dateNaissance.equals("")) {
			throw new Exception("Merci de saisir une date de naissance valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le numéro de téléphone fixe de l'adhérent
	 * @param telFixe
	 * @throws Exception
	 */
	private void validationTelFixe(String telFixe) throws Exception {
		if (telFixe == null || telFixe.equals("")) {
			throw new Exception("Merci de saisir un numéro de téléphone fixe valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le numéro de téléphone portable de l'adhérent
	 * @param telPort
	 * @throws Exception
	 */
	private void validationTelPort(String telPort) throws Exception {
		if (telPort == null || telPort.equals("")) {
			throw new Exception("Merci de saisir un numéro de téléphone portable valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider l'adresse email de l'adhérent
	 * @param email
	 * @throws Exception
	 */
	private void validationEmail(String email) throws Exception {
		if (email == null || email.equals("")) {
			throw new Exception("Merci de saisir une adresse email valide.");
		}
	}
}
