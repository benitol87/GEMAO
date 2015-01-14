package fr.gemao.form.adherent;

import java.util.HashMap;
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
	private static final String CHAMP_DATENAISSANCE = "dateNaissance";
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
	
	//Discipline (à modifier !)
	private static final String CHAMP_DISCIPLINE = "discipline";
	private static final String CHAMP_CLASSE = "classe";
	
	/**
	 * Variables récupérées via le formulaire d'ajout d'un adhérent
	 */
	//Informations relatives à la personne
	private String nom;
	private String prenom;
	private String dateNaissance;
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
	private String droitImage;
	
	//Discipline
	private String discipline;
	private String classe;
	
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
	
	public String getDateNaissance(){
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
	
	public String getDroitImage(){
		return this.droitImage;
	}
	
	//A modifier !
	public String getDiscipline(){
		return this.discipline;
	}
	
	//A modifier !
	public String getClasse(){
		return this.classe;
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
	
	/**
	 * Méthode permettant de valider le numéro de rue de l'adhérent
	 * @param numRue
	 * @throws Exception
	 */
	private void validationNumRue(Integer numRue) throws Exception {
		if (numRue == null || numRue.equals("") || numRue <= 0) {
			throw new Exception("Merci de saisir un numéro de rue valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le nom de la rue de l'adhérent
	 * @param nomRue
	 * @throws Exception
	 */
	private void validationNomRue(String nomRue) throws Exception {
		if (nomRue == null || nomRue.equals("")) {
			throw new Exception("Merci de saisir un nom de rue valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le code postal de l'adhérent
	 * @param codePostal
	 * @throws Exception
	 */
	private void validationCodePostal(Integer codePostal) throws Exception {
		if (codePostal == null || codePostal.equals("")) {
			throw new Exception("Merci de saisir un code postal valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le nom de la commune de l'adhérent
	 * @param nomCommune
	 * @throws Exception
	 */
	private void validationNomCommune(String nomCommune) throws Exception {
		if (nomCommune == null || nomCommune.equals("")) {
			throw new Exception("Merci de saisir un nom de commune valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le droit à l'image de l'adhérent
	 * @param droitImage
	 * @throws Exception
	 */
	private void validationDroitImage(String droitImage) throws Exception {
		if (droitImage == null || droitImage.equals("")) {
			throw new Exception("Merci de spécifier le droit à l'image.");
		}
	}
	
	/**
	 * Méthode permettant de valider la/les discipline(s) de l'adhérent
	 * @param disciplines
	 * @throws Exception
	 */
	//A modifier !
	private void validationDiscipline(String discipline) throws Exception {
		if (discipline == null || discipline.equals("")) {
			throw new Exception("Merci de saisir au moins une discipline.");
		}
	}
	
	/**
	 * Méthode permettant de valider la/les classe(s) de l'adhérent
	 * @param classes
	 * @throws Exception
	 */
	//A modifier !
	private void validationClasse(String classe) throws Exception {
		if (classe == null || classe.equals("")) {
			throw new Exception("Merci de saisir au moins une classe.");
		}
	}
	
	public void testerAdherent(HttpServletRequest request) {

		//Récupération des champs du formulaire
		nom = getValeurChamp(request, CHAMP_NOM);
		prenom = getValeurChamp(request, CHAMP_PRENOM);
		dateNaissance = getValeurChamp(request, CHAMP_DATENAISSANCE);
		telFixe = getValeurChamp(request, CHAMP_TELFIXE);
		telPort = getValeurChamp(request, CHAMP_TELPORT);
		email = getValeurChamp(request, CHAMP_EMAIL);
		numRue = Integer.parseInt(getValeurChamp(request, CHAMP_NUMRUE));
		nomRue = getValeurChamp(request, CHAMP_NOMRUE);
		infoCompl = getValeurChamp(request, CHAMP_INFOCOMPL);
		codePostal = Integer.parseInt(getValeurChamp(request, CHAMP_CODEPOSTAL));
		nomCommune = getValeurChamp(request, CHAMP_NOMCOMMUNE);
		droitImage = getValeurChamp(request, CHAMP_DROITIMAGE);
		discipline = getValeurChamp(request, CHAMP_DISCIPLINE);
		classe = getValeurChamp(request, CHAMP_CLASSE);

		//Validation du champ nom
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		
		//Validation du champ prénom
				try {
					validationPrenom(prenom);
				} catch (Exception e) {
					setErreur(CHAMP_PRENOM, e.getMessage());
				}

		//Validation du champ date de naissance
		try {
			validationDateNaissance(dateNaissance);
		} catch (Exception e) {
			setErreur(CHAMP_DATENAISSANCE, e.getMessage());
		}	
		
		//Validation du champ téléphone fixe
		try {
			validationTelFixe(telFixe);
		} catch (Exception e) {
			setErreur(CHAMP_TELFIXE, e.getMessage());
		}
		
		//Validation du champ téléphone portable
		try {
			validationTelPort(telPort);
		} catch (Exception e) {
			setErreur(CHAMP_TELPORT, e.getMessage());
		}
		
		//Validation du champ email
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		
		//Validation du champ numéro de rue
		try {
			validationNumRue(numRue);
		} catch (Exception e) {
			setErreur(CHAMP_NUMRUE, e.getMessage());
		}
		
		//Validation du champ nom de rue
		try {
			validationNomRue(nomRue);
		} catch (Exception e) {
			setErreur(CHAMP_NOMRUE, e.getMessage());
		}
		
		//Validation du champ code postal
		try {
			validationCodePostal(codePostal);
		} catch (Exception e) {
			setErreur(CHAMP_CODEPOSTAL, e.getMessage());
		}
		
		//Validation du champ nom de commune
		try {
			validationNomCommune(nomCommune);
		} catch (Exception e) {
			setErreur(CHAMP_NOMCOMMUNE, e.getMessage());
		}
		
		//Validation du champ prénom
		try {
			validationDroitImage(droitImage);
		} catch (Exception e) {
			setErreur(CHAMP_DROITIMAGE, e.getMessage());
		}
		
		//Validation du champ discipline (A modifier !)
		try {
			validationDiscipline(discipline);
		} catch (Exception e) {
			setErreur(CHAMP_DISCIPLINE, e.getMessage());
		}
		
		//Validation du champ classe (A modifier !)
		try {
			validationClasse(classe);
		} catch (Exception e) {
			setErreur(CHAMP_CLASSE, e.getMessage());
		}
	}
}