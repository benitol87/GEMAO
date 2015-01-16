package fr.gemao.form.adherent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.gemao.entity.Discipline;

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
	private static final String CHAMP_DATENAISS = "dateNaiss";
	private static final String CHAMP_CODEPOSTNAISS = "codePostNaiss";
	private static final String CHAMP_COMNAISS = "comNaiss";
	private static final String CHAMP_TELFIXE = "telFixe";
	private static final String CHAMP_TELPORT = "telPort";
	private static final String CHAMP_EMAIL = "email";
	
	//Adresse
	private static final String CHAMP_NUM = "num";
	private static final String CHAMP_RUE = "rue";
	private static final String CHAMP_COMPL = "compl";
	
	//Commune
	private static final String CHAMP_CODEPOSTAL = "codePostal";
	private static final String CHAMP_COMMUNE = "commune";
	
	//Droit à l'image
	private static final String CHAMP_DROITIMAGE = "droitImage";
	
	//Discipline (à modifier !)
	private static final String CHAMP_DISCIPLINES = "disciplines";
	/*private static final String CHAMP_CLASSES = "classes";*/
	
	//Inscription
	private static final String CHAMP_DATEINSCRI = "dateInscri";
	
	/**
	 * Variables récupérées via le formulaire d'ajout d'un adhérent
	 */
	//Informations relatives à la personne
	private String nom;
	private String prenom;
	private String dateNaissance;
	private Integer codePostNaiss;
	private String comNaiss;
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
	private List<Discipline> disciplines;
	/*private List<Classe> classes;*/
	
	//Inscription
	private String dateEntree;
	
	//Gestion des erreurs
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	//Format des dates
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
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
	
	public Integer getCodePostNaiss(){
		return this.codePostNaiss;
	}
	
	public String getComNaiss(){
		return this.comNaiss;
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
	public List<Discipline> getDisciplines(){
		return this.disciplines;
	}
	
	//A modifier !
	/*public List<Classe> getClasses(){
		return this.classes;
	}*/
	
	public String getDateEntree(){
		return this.dateEntree;
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
		Date dateNaiss = new Date();
		try {
			dateNaiss = dateFormat.parse(dateNaissance);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dateNaissance == null || dateNaissance.equals("") || dateNaiss.after(new Date())) {
			throw new Exception("Merci de saisir une date de naissance valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le code postal de naissance de l'adhérent
	 * @param codePostNaiss
	 * @throws Exception
	 */
	private void validationCodePostNaiss(Integer codePostNaiss) throws Exception {
		if (codePostNaiss == null || codePostNaiss.equals("")) {
			throw new Exception("Merci de saisir un code postal de naissance valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider la commune de naissance de l'adhérent
	 * @param comNaiss
	 * @throws Exception
	 */
	private void validationComNaiss(String comNaiss) throws Exception {
		if (comNaiss == null || comNaiss.equals("")) {
			throw new Exception("Merci de saisir une commune de naissance valide.");
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
	private void validationDisciplines(List<Discipline> disciplines) throws Exception {
		if (disciplines.isEmpty() || disciplines == null) {
			throw new Exception("Merci de saisir au moins une discipline.");
		}
	}
	
	/**
	 * Méthode permettant de valider la/les classe(s) de l'adhérent
	 * @param classes
	 * @throws Exception
	 *//*
	//A modifier !
	private void validationClasses(List<Classe> classes) throws Exception {
		if (classes.isEmpty() || classes == null) {
			throw new Exception("Merci de saisir au moins une classe.");
		}
	}*/
	
	/**
	 * Méthode permettant de valider la date d'entrée de l'adhérent
	 * @param dateEntree
	 * @throws Exception
	 */
	private void validationDateEntree(String dateEntree) throws Exception {
		Date dateInsc = new Date();
		try {
			dateInsc = dateFormat.parse(dateEntree);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dateNaiss = new Date();
		try {
			dateNaiss = dateFormat.parse(dateNaissance);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dateEntree == null || dateEntree.equals("") || dateInsc.after(new Date()) || dateInsc.before(dateNaiss)) {
			throw new Exception("Merci de spécifier une date d'inscription valide.");
		}
	}
	
	public void testerAdherent(HttpServletRequest request) {

		//Récupération des champs du formulaire
		nom = getValeurChamp(request, CHAMP_NOM);
		prenom = getValeurChamp(request, CHAMP_PRENOM);
		dateNaissance = getValeurChamp(request, CHAMP_DATENAISS);
		codePostNaiss = Integer.parseInt(getValeurChamp(request, CHAMP_CODEPOSTNAISS));
		comNaiss = getValeurChamp(request, CHAMP_COMNAISS);
		telFixe = getValeurChamp(request, CHAMP_TELFIXE);
		telPort = getValeurChamp(request, CHAMP_TELPORT);
		email = getValeurChamp(request, CHAMP_EMAIL);
		numRue = Integer.parseInt(getValeurChamp(request, CHAMP_NUM));
		nomRue = getValeurChamp(request, CHAMP_RUE);
		infoCompl = getValeurChamp(request, CHAMP_COMPL);
		codePostal = Integer.parseInt(getValeurChamp(request, CHAMP_CODEPOSTAL));
		nomCommune = getValeurChamp(request, CHAMP_COMMUNE);
		droitImage = getValeurChamp(request, CHAMP_DROITIMAGE);
		String str = null;
		Discipline disc;
		int i = 1;
		
		do {
			str = getValeurChamp(request, CHAMP_DISCIPLINES+i);
			i++;
			
			if (str != null && !str.equals("")) {
				disc = new Discipline(null, str);
				disciplines.add(disc);
			}
			
		} while(str != null);
		
		/*str = null;
		Classe clas;
		i = 1;
		
		do {
			str = getValeurChamp(request, CHAMP_CLASSES+i);
			i++;
			
			if (str != null && !str.equals("")) {
				clas = new Classe(null, str);
				classes.add(clas);
			}
			
		} while(str != null);*/
		dateEntree = getValeurChamp(request, CHAMP_DATEINSCRI);

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
			setErreur(CHAMP_DATENAISS, e.getMessage());
		}	
		
		//Validation du champ code postal de naissance
		try {
			validationCodePostNaiss(codePostNaiss);
		} catch (Exception e) {
			setErreur(CHAMP_CODEPOSTNAISS, e.getMessage());
		}	
		
		//Validation du champ commune de naissance
		try {
			validationComNaiss(comNaiss);
		} catch (Exception e) {
			setErreur(CHAMP_COMNAISS, e.getMessage());
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
			setErreur(CHAMP_NUM, e.getMessage());
		}
		
		//Validation du champ nom de rue
		try {
			validationNomRue(nomRue);
		} catch (Exception e) {
			setErreur(CHAMP_RUE, e.getMessage());
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
			setErreur(CHAMP_COMMUNE, e.getMessage());
		}
		
		//Validation du champ prénom
		try {
			validationDroitImage(droitImage);
		} catch (Exception e) {
			setErreur(CHAMP_DROITIMAGE, e.getMessage());
		}
		
		//Validation du champ discipline (A modifier !)
		/*try {
			validationDisciplines(disciplines);
		} catch (Exception e) {
			setErreur(CHAMP_DISCIPLINES, e.getMessage());
		}
		
		//Validation du champ classe (A modifier !)
		try {
			validationClasses(classes);
		} catch (Exception e) {
			setErreur(CHAMP_CLASSES, e.getMessage());
		}*/
		
		//Validation du champ date d'entrée
		try {
			validationDateEntree(dateEntree);
		} catch (Exception e) {
			setErreur(CHAMP_DATEINSCRI, e.getMessage());
		}
		
		if(erreurs.isEmpty()){
			resultat = "Succès de l'ajout.";
		}
		else{
			resultat = "Échec de l'ajout.";
		}
	}
}
