package fr.gemao.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.gemao.ctrl.ConnexionCtrl;
import fr.gemao.entity.Personnel;

public class ConnexionForm {

	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "motdepasse";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Personnel connecterPersonnel(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);

		Personnel personnel = null;

		try {
			validationLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_LOGIN, e.getMessage());
		}

		try {
			validationMotDePasse(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}

		if (erreurs.isEmpty()) {
			ConnexionCtrl connexionCtrl = new ConnexionCtrl();
			try {
				personnel = connexionCtrl.controlerPersonnel(login, motDePasse);
			} catch (Exception e) {
				setErreur("Connexion", e.getMessage());
				personnel = new Personnel(null, null, null, null, null, null,
						null, null, null, null, null, login, null, 0);
			}
		} else {
			personnel = new Personnel(null, null, null, null, null, null, null,
					null, null, null, null, login, null, 0);
		}

		return personnel;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/**
	 * Valide le login saisie.
	 */
	private void validationLogin(String login) throws Exception {
		if (login == null) {
			throw new Exception("Merci de saisir un login.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse) throws Exception {
		if (motDePasse == null) {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
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
}
