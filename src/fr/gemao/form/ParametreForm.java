package fr.gemao.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.gemao.entity.Parametre;

public class ParametreForm {
	private static final String CHAMP_ALLOC2 = "alloc2";
	private static final String CHAMP_ALLOC3 = "alloc3";
	private static final String CHAMP_ALLOC4 = "alloc4";
	private static final String CHAMP_ALLOC5 = "alloc5";
	private static final String CHAMP_QFMIN = "qfMin";
	private static final String CHAMP_QFMAX = "qfMax";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	private float alloc2, alloc3, alloc4, alloc5, qfMin, qfMax;

	public float getAlloc2() {
		return alloc2;
	}

	public float getAlloc3() {
		return alloc3;
	}

	public float getAlloc4() {
		return alloc4;
	}

	public float getAlloc5() {
		return alloc5;
	}

	public float getQfMin() {
		return qfMin;
	}

	public float getQfMax() {
		return qfMax;
	}

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Parametre ajoutParametre(HttpServletRequest request) {

		alloc2 = Float.parseFloat(getValeurChamp(request, CHAMP_ALLOC2));
		alloc3 = Float.parseFloat(getValeurChamp(request, CHAMP_ALLOC3));
		alloc4 = Float.parseFloat(getValeurChamp(request, CHAMP_ALLOC4));
		alloc5 = Float.parseFloat(getValeurChamp(request, CHAMP_ALLOC5));
		qfMin = Float.parseFloat(getValeurChamp(request, CHAMP_QFMIN));
		qfMax = Float.parseFloat(getValeurChamp(request, CHAMP_QFMAX));

		try {
			validationAlloc(alloc2);
		} catch (Exception e) {
			setErreur(CHAMP_ALLOC2, e.getMessage());
		}
		try {
			validationAlloc(alloc3);
		} catch (Exception e) {
			setErreur(CHAMP_ALLOC3, e.getMessage());
		}
		try {
			validationAlloc(alloc4);
		} catch (Exception e) {
			setErreur(CHAMP_ALLOC4, e.getMessage());
		}
		try {
			validationAlloc(alloc5);
		} catch (Exception e) {
			setErreur(CHAMP_ALLOC5, e.getMessage());
		}

		try {
			validationQF(qfMax);
		} catch (Exception e) {
			setErreur(CHAMP_QFMAX, e.getMessage());
		}
		try {
			validationQF(qfMin);
		} catch (Exception e) {
			setErreur(CHAMP_QFMIN, e.getMessage());
		}

		Parametre parametre = null;

		 /*if (!erreurs.isEmpty()) {*/
		parametre = new Parametre();
		parametre.setAlloc2(alloc2);
		parametre.setAlloc3(alloc3);
		parametre.setAlloc4(alloc4);
		parametre.setAlloc5(alloc5);
		parametre.setQf_max(qfMax);
		parametre.setQf_min(qfMin);

		/* } */

		return parametre;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	public void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/**
	 * Valide l'alloc saisie.
	 */
	private void validationAlloc(float alloc) throws Exception {
		if (alloc < 0) {
			throw new Exception("Merci de saisir une allocation familiale positive.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationQF(float qf) throws Exception {
		if (qf < 0 ) {
			throw new Exception("Merci de saisir un quotient familial positif.");
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
			valeur = valeur.replace(',', '.');
			return valeur;
		}
	}
}
