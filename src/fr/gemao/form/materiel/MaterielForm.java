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
	private static final String CHAMP_VALACH = "valeurAch";
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

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	/* Variables récupérées BEGIN */
	// variables communes aux deux categories
	private int categorie;
	private String designation;
	private float valAch;
	private String dateAch;
	private int idType;
	private String marque;

	// variables categorie Instrument
	private String etat;
	private long numserie;
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

		/* Validation de la designation. */
		try {
			validationDesignation(designation);
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
		if (categorie == VAL_INST) {
			idType = Integer.parseInt(getValeurChamp(request, CHAMP_TYPE));
			etat = getValeurChamp(request, CHAMP_INST_ETAT);
			marque = getValeurChamp(request, CHAMP_MARQUE);
			String deplac = getValeurChamp(request, CHAMP_INST_DEPLACABLE);
			numserie = Long.parseLong(getValeurChamp(request,
					CHAMP_INST_NUMSERIE));
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

			/* Validation du champ quantité */
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
		return categorie;
	}

	/**
	 * Retourne la designation du materiel.
	 * 
	 * @return la designation du materiel.
	 */
	public String getDesignation() {
		return designation;
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
	public int getIdType() {
		return idType;
	}

	/**
	 * Retourne l'etat de l'instrument.
	 * 
	 * @return l'etat de l'instrument.
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * Retourne la marque du materiel.
	 * 
	 * @return la marque du materiel.
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Retourne le numero de serie.
	 * 
	 * @return le numero de serie.
	 */
	public long getNumserie() {
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
	 * Valide la marque saisie.
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
	 * Valide le numero de serie saisi.
	 */
	private void validationNumserie(long numserie) throws Exception {
		if (numserie <= 0) {
			throw new Exception("Merci de saisir un numero de serie.");
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