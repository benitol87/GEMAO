package fr.gemao.form.personnel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;

/**
 * Classe de validation du formulaire Personnel
 * @author Coco
 *
 */
public class PersonnelForm {
	
	//Informations relatives à la personne
	private static final String CHAMP_LISTERESPONSABILITE = "fonction";
	private static final String CHAMP_IDCONTRAT = "idContrat";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_POINTSANCIEN = "pointsAncien";
	
	//Informations relatives à la personne
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Integer codePostNaiss;
	private Commune comNaiss;
	private String telFixe;
	private String telPort;
	private String email;
	
	//Adresse
	private Adresse adresse;
	
	//Commune
	private Integer codePostal;
	private String nomCommune;
	
	//Droit à l'image
	private String droitImage;
	
	//Discipline
	private String discipline;
	private String classe;
	
	//Inscription
	private String dateEntree;
	
	private List<Responsabilite> listeResponsabilite;
	private List<Diplome> listeDiplomes;
	private Integer idContrat;
	private String login;
	private String password;
	private int pointsAncien;
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public List<Responsabilite> getListeResponsabilite() {
		return listeResponsabilite;
	}
	
	public List<Diplome> getListeDiplomes() {
		return listeDiplomes;
	}

	public Integer getIdContrat() {
		return idContrat;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public int getPointsAncien() {
		return pointsAncien;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public Integer getCodePostNaiss() {
		return codePostNaiss;
	}

	public Commune getComNaiss() {
		return comNaiss;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public String getTelPort() {
		return telPort;
	}

	public String getEmail() {
		return email;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public String getDroitImage() {
		return droitImage;
	}

	public String getDiscipline() {
		return discipline;
	}

	public String getClasse() {
		return classe;
	}

	public String getDateEntree() {
		return dateEntree;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setCodePostNaiss(Integer codePostNaiss) {
		this.codePostNaiss = codePostNaiss;
	}

	public void setComNaiss(Commune comNaiss) {
		this.comNaiss = comNaiss;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public void setDroitImage(String droitImage) {
		this.droitImage = droitImage;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public void setListeResponsabilite(List<Responsabilite> listeResponsabilite) {
		this.listeResponsabilite = listeResponsabilite;
	}

	public void setListeDiplomes(List<Diplome> listeDiplomes) {
		this.listeDiplomes = listeDiplomes;
	}

	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPointsAncien(int pointsAncien) {
		this.pointsAncien = pointsAncien;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	/* Méthode utilitaire qui retourne null si un champ est vide, et son contenu sinon */
	public static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
	
	/* Ajoute un message correspondant au champ spécifié à la map des erreurs. */
	public void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}
	
	/**
	 * Méthode permettant de valider la liste des responsabilités
	 * @param listeResponsabilites
	 * @throws Exception
	 */
	private void validationListeResponsabilites(List<Responsabilite> listeResponsabilites) throws Exception {
		if (listeResponsabilites == null) {
			throw new Exception("Merci de saisir une liste de responsabilités valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider l'ID du contrat
	 * @param idContrat : l'ID du contrat
	 * @throws Exception
	 */
	private void validationIdContrat(Integer idContrat) throws Exception {
		if (idContrat == null || idContrat < 0) {
			throw new Exception("Merci de saisir un ID de contrat valide.");
		}
	}
	
	/**
	 * Méthode permettant de valider le login du personnel
	 * @param login : le login
	 * @throws Exception
	 */
	private void validationLogin(String login) throws Exception {
		if (login == null || login.equals("")) {
			throw new Exception("Merci de saisir un login valide.");
		}
	}

	/**
	 * Méthode permettant de valider le password du personnel
	 * @param password : le password
	 * @throws Exception
	 */
	private void validationPassword(String password) throws Exception {
		if (password == null || password.equals("")) {
			throw new Exception("Merci de saisir un password valide.");
		}
	}

	/**
	 * Méthode permettant de valider le nombre de points d'ancienneté
	 * @param pointsAncien : le nombre de points d'ancienneté
	 * @throws Exception
	 */
	private void validationPointsAncien(int pointsAncien) throws Exception {
		if (pointsAncien < 0) {
			throw new Exception("Merci de saisir un nombre de points valide.");
		}
	}
	
	/**
	 * Méthode permettant de tester un personnel
	 * @param request
	 */
	public Personnel testerPersonnel(HttpServletRequest request) {

		/* Récupération des champs du formulaire */
		String str = null;
		Responsabilite res;
		int i = 1;
		
		do {
			str = getValeurChamp(request, CHAMP_LISTERESPONSABILITE+i);
			i++;
			
			if (str != null && str.equals("")) {
				res = new Responsabilite();
				res.setLibelle(str);
				listeResponsabilite.add(res);
			}
			
		} while(str != null);
		
		idContrat = Integer.parseInt(getValeurChamp(request, CHAMP_IDCONTRAT));
		login = getValeurChamp(request, CHAMP_LOGIN);
		password = getValeurChamp(request, CHAMP_PASSWORD);
		pointsAncien = Integer.parseInt(getValeurChamp(request, CHAMP_POINTSANCIEN));

		/* Validation de l'ID du contrat */
		try {
			validationIdContrat(idContrat);
		} catch (Exception e) {
			setErreur(CHAMP_IDCONTRAT, e.getMessage());
		}

		/* Validation du login */
		try {
			validationLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_LOGIN, e.getMessage());
		}

		/* Validation du password */
		try {
			validationPassword(password);
		} catch (Exception e) {
			setErreur(CHAMP_PASSWORD, e.getMessage());
		}

		/* Validation du nombre de points d'ancienneté */
		try {
			validationPointsAncien(pointsAncien);
		} catch (Exception e) {
			setErreur(CHAMP_POINTSANCIEN, e.getMessage());
		}
		
		if (getErreurs().isEmpty()) {
			Personnel pers = new Personnel();
			return pers;
		}
		
		return null;
	}
}