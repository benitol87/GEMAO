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

<<<<<<< HEAD
=======
		ConnexionCtrl connexionCtrl = new ConnexionCtrl();
		Personnel personnel = connexionCtrl.controlerPersonnel(login, motDePasse);

		/* Initialisation du résultat global de la validation. */
>>>>>>> origin/master
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
