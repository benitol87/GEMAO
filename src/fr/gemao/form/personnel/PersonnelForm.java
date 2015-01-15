package fr.gemao.form.personnel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	private List<Responsabilite> listeResponsabilite;
	private Integer idContrat;
	private String login;
	private String password;
	private int pointsAncien;
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public List<Responsabilite> getListeResponsabilite() {
		return listeResponsabilite;
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