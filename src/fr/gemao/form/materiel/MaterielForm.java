package fr.gemao.form.materiel;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Marque;
import fr.gemao.entity.materiel.Materiel;

public class MaterielForm {

	private static final String CHAMP_CATEGORIE = "categorie";
	private static final String CHAMP_DESIGNATION = "designation";
	private static final String CHAMP_VALACH = "valeurAch";
	private static final String CHAMP_DATEACH = "dateAch";
	private static final String CHAMP_TYPE = "type";
	private static final String CHAMP_MARQUE = "marque";

	// Partie Instrument
	private static final String CHAMP_INST_ETAT = "etat";
	private static final String CHAMP_INST_NUMSERIE = "numSerie";
	private static final String CHAMP_INST_VALREA = "valRea";
	// DEPLACABLE a prendre en compte
	private static final String CHAMP_INST_OBSERVATION = "observation";

	// Partie Mobilier
	private static final String CHAMP_MOBI_QTE = "quantite";
	private static final String CHAMP_MOBI_PRIXU = "prixU";

	private static final int VAL_INST = 1;
	private static final int VAL_MOBI = 2;

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	/* Variables récupérées */
	// variables communes aux deux categories
	int categorie;
	String designation;
	float valAch;
	String dateAch;

	private int idType;
	private String etat;
	private String marque;
	private long numserie;
	private float valRea;
	private String observation;

	private float prixU;
	private int qte;

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void testerMateriel(HttpServletRequest request) {
		Materiel mat;

		/* Récupération des champs du formulaire */
		categorie = Integer.parseInt(getValeurChamp(request, CHAMP_CATEGORIE));
		designation = getValeurChamp(request, CHAMP_DESIGNATION);
		valAch = Float.parseFloat(getValeurChamp(request, CHAMP_VALACH));
		dateAch = getValeurChamp(request, CHAMP_DATEACH);

		/* Validation du champ categorie. */
		try {
			validationCategorie(categorie);
		} catch (Exception e) {
			setErreur(CHAMP_CATEGORIE, e.getMessage());
		}
		/* Validation du champ categorie. */
		try {
			validationDesignation(designation);
		} catch (Exception e) {
			setErreur(CHAMP_DESIGNATION, e.getMessage());
		}
		/* Validation du champ categorie. */
		try {
			validationValeurAchat(valAch);
		} catch (Exception e) {
			setErreur(CHAMP_VALACH, e.getMessage());
		}
		/* Validation du champ categorie. */
		try {
			validationDateAchat(dateAch);
		} catch (Exception e) {
			setErreur(CHAMP_DATEACH, e.getMessage());
		}

		// Dans le cas ou il s'agit d'un intrument.
		if (categorie == VAL_INST) {
			idType = Integer.parseInt(getValeurChamp(request, CHAMP_TYPE));
			etat = getValeurChamp(request, CHAMP_INST_ETAT);
			marque = getValeurChamp(request, CHAMP_MARQUE);
			numserie = Long.parseLong(getValeurChamp(request,
					CHAMP_INST_NUMSERIE));
			valRea = Float
					.parseFloat(getValeurChamp(request, CHAMP_INST_VALREA));

			// DEPLACABLE a prendre en compte
			observation = getValeurChamp(request, CHAMP_INST_OBSERVATION);

			/* Validation du champ type. */
			try {
				validationType(idType);
			} catch (Exception e) {
				setErreur(CHAMP_TYPE, e.getMessage());
			}

			/* Validation du champ etat */
			try {
				validationEtat(etat);
			} catch (Exception e) {
				setErreur(CHAMP_INST_ETAT, e.getMessage());
			}

			/* Validation du champ marque */
			try {
				validationMarque(marque);
			} catch (Exception e) {
				setErreur(CHAMP_MARQUE, e.getMessage());
			}

			/* Validation du champ numserie */
			try {
				validationNumserie(numserie);
			} catch (Exception e) {
				setErreur(CHAMP_INST_NUMSERIE, e.getMessage());
			}
			/* Validation du champ numserie */
			try {
				validationValeurReapprovisionnement(valRea);
			} catch (Exception e) {
				setErreur(CHAMP_INST_VALREA, e.getMessage());
			}

			/* Initialisation du résultat global de la validation. */
			if (erreurs.isEmpty()) {
				resultat = "Succès de l'ajout.";
			} else {
				resultat = "Échec de l'aout.";
			}
		}
		if (categorie == VAL_MOBI) {
			idType = Integer.parseInt(getValeurChamp(request, CHAMP_TYPE));
			qte = Integer.parseInt(getValeurChamp(request, CHAMP_MOBI_QTE));
			marque = getValeurChamp(request, CHAMP_MARQUE);
			prixU = Float.parseFloat(getValeurChamp(request, CHAMP_MOBI_PRIXU));

			/* Validation du champ type. */
			try {
				validationType(idType);
			} catch (Exception e) {
				setErreur(CHAMP_TYPE, e.getMessage());
			}

			/* Validation du champ etat */
			try {
				validationQuantite(qte);
			} catch (Exception e) {
				setErreur(CHAMP_MOBI_QTE, e.getMessage());
			}

			/* Validation du champ marque */
			try {
				validationMarque(marque);
			} catch (Exception e) {
				setErreur(CHAMP_MARQUE, e.getMessage());
			}

			/* Validation du champ numserie */
			try {
				validationPrixUnitaire(prixU);
			} catch (Exception e) {
				setErreur(CHAMP_MOBI_PRIXU, e.getMessage());
			}
		}
	}

	private void validationValeurReapprovisionnement(float valRea2)
			throws Exception {
		if (valRea2 <= 0) {
			throw new Exception(
					"Merci de saisir une valeur de reapprovisionnement valide");
		}
	}

	public int getCategorie() {
		return categorie;
	}

	public String getDesignation() {
		return designation;
	}

	public float getValAch() {
		return valAch;
	}

	public String getDateAch() {
		return dateAch;
	}

	public int getIdType() {
		return idType;
	}

	public String getEtat() {
		return etat;
	}

	public String getMarque() {
		return marque;
	}

	public long getNumserie() {
		return numserie;
	}

	public float getValRea() {
		return valRea;
	}

	public String getObservation() {
		return observation;
	}

	public float getPrixU() {
		return prixU;
	}

	public int getQte() {
		return qte;
	}

	private void validationDateAchat(String dateAch) throws Exception {
		if (dateAch == null) {
			throw new Exception("Merci de saisir une date d'achat valide.");
		} else {
			if (dateAch.equals("")) {
				throw new Exception("Merci de saisir une date d'achat valide.");
			}
		}
	}

	private void validationValeurAchat(float valAch2) throws Exception {
		if (valAch2 <= 0) {
			throw new Exception("Merci de saisir une valeur d'achat valide");
		}
	}

	private void validationDesignation(String designation) throws Exception {
		if (designation == null) {
			throw new Exception("Merci de saisir une designation valide.");
		} else {
			if (designation.equals("")) {
				throw new Exception("Merci de saisir une designation valide.");
			}
		}
	}

	/**
	 * Valide le prix unitaire saisie.
	 */
	private void validationPrixUnitaire(float prixU) throws Exception {
		if (prixU <= 0) {
			throw new Exception("Merci de saisir un prix unitaire valide.");
		}
	}

	/**
	 * Valide la quantite saisie.
	 */
	private void validationQuantite(int qte) throws Exception {
		if (qte <= 0) {
			throw new Exception("Merci de saisir une quantite valide.");
		}
	}

	/**
	 * Valide la categorie choisie.
	 */
	private void validationCategorie(int categorie) throws Exception {
		if (categorie != VAL_INST && categorie != VAL_MOBI) {
			throw new Exception("Merci de choisir une categorie valide.");
		}
	}

	/**
	 * Valide le type choisi.
	 */
	private void validationType(int type) throws Exception {
		if (type <= 0) {
			throw new Exception("Merci de choisir un type.");
		}
	}

	/**
	 * Valide l'etat saisi.
	 */
	private void validationEtat(String etat) throws Exception {
		if (etat == null) {
			throw new Exception("Merci de saisir un etat valide.");
		} else {
			if (etat.equals("")) {
				throw new Exception("Merci de saisir un etat valide.");
			}
		}
	}

	/**
	 * Valide le type choisi.
	 */
	private void validationMarque(String marque) throws Exception {
		if (marque == null) {
			throw new Exception("Merci de saisir une marque valide.");
		} else {
			if (marque.equals("")) {
				throw new Exception("Merci de saisir une marque valide.");
			}
		}
	}

	/**
	 * Valide le type choisi.
	 */
	private void validationNumserie(long numserie) throws Exception {
		if (numserie <= 0) {
			throw new Exception("Merci de saisir un numero de serie.");
		}
	}

	/**
	 * Valide le type choisi.
	 */
	private void validationValRea(float valRea) throws Exception {
		if (valRea <= 0) {
			throw new Exception(
					"Merci de saisir un montant de reapprovisionnement correct.");
		}
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
