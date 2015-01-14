package fr.gemao.form.materiel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe pour la validation du formulaire d'ajout de materiel. Seules les
 * variables en rapport avec la categorie (instrument ou mobilier) sont
 * initialisees (faire la verification).
 * 
 * @author kayzen
 *
 */
public class MaterielForm {

	private static final String CHAMP_CATEGORIE = "categorie";
	private static final String CHAMP_DESIGNATION = "designation";
	private static final String CHAMP_VALACH = "ValeurAch";
	private static final String CHAMP_DATEACH = "dateAch";
	private static final String CHAMP_TYPE = "type";
	private static final String CHAMP_MARQUE = "marque";

	// Partie Instrument
	private static final String CHAMP_INST_ETAT = "etat";
	private static final String CHAMP_INST_NUMSERIE = "numSerie";
	private static final String CHAMP_INST_VALREA = "valRea";
	private static final String CHAMP_INST_DEPLACABLE = "deplace";
	private static final String CHAMP_INST_OBSERVATION = "observation";

	// Partie Mobilier
	private static final String CHAMP_MOBI_QTE = "quantite";
	private static final String CHAMP_MOBI_PRIXU = "prixU";

	private static final int VAL_INST = 1;
	private static final int VAL_MOBI = 2;
	private static final int VAL_FOUR = 3;

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	/* Variables récupérées BEGIN */
	// variables communes aux deux categories
	private int idCategorie;
	private int idDesignation; //
	private float valAch;
	private String dateAch;
	private String type;
	private int idMarque;

	// variables categorie Instrument
	private int idEtat;
	private String numserie;
	private float valRea;
	private String observation;
	private boolean deplacable;

	// variables categorie Mobilier
	private float prixU;
	private int qte;

	/* Variables recupérées END */

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void testerMateriel(HttpServletRequest request) {

		/* Récupération des champs du formulaire */
		idCategorie = Integer
				.parseInt(getValeurChamp(request, CHAMP_CATEGORIE));
		idDesignation = Integer.parseInt(getValeurChamp(request,
				CHAMP_DESIGNATION));
		valAch = Float.parseFloat(getValeurChamp(request, CHAMP_VALACH));
		dateAch = getValeurChamp(request, CHAMP_DATEACH);

		/* Validation du champ categorie. */
		try {
			validationCategorie(idCategorie);
		} catch (Exception e) {
			setErreur(CHAMP_CATEGORIE, e.getMessage());
		}

		/* Validation de la designation. */
		try {
			validationDesignation(idDesignation);
		} catch (Exception e) {
			setErreur(CHAMP_DESIGNATION, e.getMessage());
		}

		/* Validation de la valeur d'achat. */
		try {
			validationValeurAchat(valAch);
		} catch (Exception e) {
			setErreur(CHAMP_VALACH, e.getMessage());
		}

		/* Validation de la date d'achat. */
		try {
			validationDateAchat(dateAch);
		} catch (Exception e) {
			setErreur(CHAMP_DATEACH, e.getMessage());
		}

		// Dans le cas ou il s'agit d'un intrument.
		if (idCategorie == VAL_INST) {
			type = getValeurChamp(request, CHAMP_TYPE);
			idEtat = Integer.parseInt(getValeurChamp(request, CHAMP_INST_ETAT));
			idMarque = Integer.parseInt(getValeurChamp(request, CHAMP_MARQUE));
			String deplac = getValeurChamp(request, CHAMP_INST_DEPLACABLE);
			numserie = getValeurChamp(request, CHAMP_INST_NUMSERIE);
			valRea = Float
					.parseFloat(getValeurChamp(request, CHAMP_INST_VALREA));
			observation = getValeurChamp(request, CHAMP_INST_OBSERVATION);

			/* Validation du champ deplacable. */
			try {
				validationDeplacable(deplac);
			} catch (Exception e) {
				setErreur(CHAMP_TYPE, e.getMessage());
			}

			/* Validation du champ type. */
			try {
				validationType(type);
			} catch (Exception e) {
				setErreur(CHAMP_TYPE, e.getMessage());
			}

			/* Validation du champ etat */
			try {
				validationEtat(idEtat);
			} catch (Exception e) {
				setErreur(CHAMP_INST_ETAT, e.getMessage());
			}

			/* Validation du champ marque */
			try {
				validationMarque(idMarque);
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
				if (deplac.equals("oui")) {
					deplacable = true;
				} else {
					deplacable = false;
				}
			} else {
				resultat = "Échec de l'ajout.";
			}
		}

		// Dans le cas d'un mobilier.
		if (idCategorie == VAL_MOBI || idCategorie == VAL_FOUR) {
			type = getValeurChamp(request, CHAMP_TYPE);
			qte = Integer.parseInt(getValeurChamp(request, CHAMP_MOBI_QTE));
			idMarque = Integer.parseInt(getValeurChamp(request, CHAMP_MARQUE));
			prixU = Float.parseFloat(getValeurChamp(request, CHAMP_MOBI_PRIXU));

			/* Validation du champ type. */
			try {
				validationType(type);
			} catch (Exception e) {
				setErreur(CHAMP_TYPE, e.getMessage());
			}

			/* Validation du champ quantité */
			try {
				validationQuantite(qte);
			} catch (Exception e) {
				setErreur(CHAMP_MOBI_QTE, e.getMessage());
			}

			/* Validation du champ marque */
			try {
				validationMarque(idMarque);
			} catch (Exception e) {
				setErreur(CHAMP_MARQUE, e.getMessage());
			}

			/* Validation du champ prix unitaire */
			try {
				validationPrixUnitaire(prixU);
			} catch (Exception e) {
				setErreur(CHAMP_MOBI_PRIXU, e.getMessage());
			}

			/* Initialisation du résultat global de la validation. */
			if (erreurs.isEmpty()) {
				resultat = "Succès de l'ajout.";
			} else {
				resultat = "Échec de l'ajout.";
			}
		}
	}

	/**
	 * Retourne la categorie du materiel.
	 * 
	 * @return la categorie du materiel.
	 */
	public int getCategorie() {
		return idCategorie;
	}

	/**
	 * Retourne la designation du materiel.
	 * 
	 * @return la designation du materiel.
	 */
	public int getDesignation() {
		return idDesignation;
	}

	/**
	 * Retourne la valeur d'achat du materiel.
	 * 
	 * @return la valeur d'achat du materiel.
	 */
	public float getValAch() {
		return valAch;
	}

	/**
	 * Retourne la date d'achat du materiel.
	 * 
	 * @return la date d'achat du materiel.
	 */
	public String getDateAch() {
		return dateAch;
	}

	/**
	 * Retourne l'id du type.
	 * 
	 * @return l'id du type.
	 */
	public String getIdType() {
		return type;
	}

	/**
	 * Retourne l'etat de l'instrument.
	 * 
	 * @return l'etat de l'instrument.
	 */
	public int getEtat() {
		return idEtat;
	}

	/**
	 * Retourne la marque du materiel.
	 * 
	 * @return la marque du materiel.
	 */
	public int getMarque() {
		return idMarque;
	}

	/**
	 * Retourne le numero de serie.
	 * 
	 * @return le numero de serie.
	 */
	public String getNumserie() {
		return numserie;
	}

	/**
	 * Retourne la valeur de réapprovisionnement de l'instrument.
	 * 
	 * @return la valeur de réapprovisionnement de l'instrument.
	 */
	public float getValRea() {
		return valRea;
	}

	/**
	 * Retourne l'observation sur le materiel.
	 * 
	 * @return l'observation sur le materiel.
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * Retourne le prix unitaire du mobilier.
	 * 
	 * @return le prix unitaire du mobilier.
	 */
	public float getPrixU() {
		return prixU;
	}

	/**
	 * La quantité de mobilier commandée.
	 * 
	 * @return la quantité de mobilier commandée.
	 */
	public int getQte() {
		return qte;
	}

	/**
	 * Retourne la déplacabilité(?) d'un instrument.
	 * 
	 * @return vrai si l'instrument est deplacable, faux sinon.
	 */
	public boolean getDeplacable() {
		return deplacable;
	}

	/**
	 * Valide la deplacabilité(?) saisie.
	 */
	private void validationDeplacable(String deplac) throws Exception {
		if (deplac == null) {
			throw new Exception(
					"Merci de choisir une valeur valide pour deplacable.");
		} else {
			if (!deplac.equals("oui") && !deplac.equals("non")) {
				throw new Exception("Merci de saisir une date d'achat valide.");
			}
		}
	}

	/**
	 * Valide la valeur de reapprovisionnement saisie.
	 */
	private void validationValeurReapprovisionnement(float valRea2)
			throws Exception {
		if (valRea2 <= 0) {
			throw new Exception(
					"Merci de saisir une valeur de reapprovisionnement valide");
		}
	}

	/**
	 * Valide la date d'achat saisie.
	 */
	private void validationDateAchat(String dateAch) throws Exception {
		if (dateAch == null) {
			throw new Exception("Merci de saisir une date d'achat valide.");
		} else {
			if (dateAch.equals("")) {
				throw new Exception("Merci de saisir une date d'achat valide.");
			}
		}
	}

	/**
	 * Valide la valeur d'achat saisie.
	 */
	private void validationValeurAchat(float valAch2) throws Exception {
		if (valAch2 <= 0) {
			throw new Exception("Merci de saisir une valeur d'achat valide");
		}
	}

	/**
	 * Valide la designation saisie.
	 */
	private void validationDesignation(int idDesignation2) throws Exception {
		if (idDesignation2 <= 0) {
			throw new Exception("Merci de saisir une designation valide.");
		}
	}

	/**
	 * Valide le prix unitaire saisi.
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
		if (categorie != VAL_INST && categorie != VAL_MOBI
				&& categorie != VAL_FOUR) {
			throw new Exception("Merci de choisir une categorie valide.");
		}
	}

	/**
	 * Valide le type choisi.
	 */
	private void validationType(String type2) throws Exception {
		if (type2 == null) {
			throw new Exception("Merci de saisir un type valide.");
		} else {
			if (type2.equals("")) {
				throw new Exception("Merci de saisir un type valide.");
			}
		}
	}

	/**
	 * Valide l'etat saisi.
	 */
	private void validationEtat(int idEtat2) throws Exception {
		if (idEtat2 <= 0) {
			throw new Exception("Merci de saisir un etat valide.");
		}
	}

	/**
	 * Valide la marque saisie.
	 */
	private void validationMarque(int idMarque2) throws Exception {
		if (idMarque2 <= 0) {
			throw new Exception("Merci de saisir une marque valide.");
		}
	}

	/**
	 * Valide le numero de serie saisi.
	 */
	private void validationNumserie(String numserie2) throws Exception {
		if (numserie2 == null) {
			throw new Exception("Merci de saisir un numero de serie valide.");
		} else {
			if (numserie2.equals("")) {
				throw new Exception(
						"Merci de saisir un numero de serie valide.");
			}
		}
	}

	/**
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/**
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
