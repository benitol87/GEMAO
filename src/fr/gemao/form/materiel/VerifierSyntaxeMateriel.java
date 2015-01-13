package fr.gemao.form.materiel;

import fr.gemao.entity.materiel.Materiel;

public class VerifierSyntaxeMateriel {

	/**
	 * Permet de verifier si le materiel est correct. Leve une
	 * NullPointerException si le materiel passé en parametre est null.
	 * 
	 * @param mat
	 *            le materiel a verifier.
	 * @return vrai si le materiel est correct, faux sinon.
	 */
	public static boolean verifierSyntaxeMateriel(Materiel mat) {
		boolean isValide = true;

		if (mat == null) {
			throw new NullPointerException("Le materiel ne peut etre null");
		}

		if (mat.getCategorie() == null) {
			System.out.println("La categorie ne peut etre null");
			isValide = false;
		}
		if (mat.getDateAchat() == null) {
			System.out.println("La date d'achat ne peut etre null");
			isValide = false;
		}
		if (mat.getDesignation() == null) {
			System.out.println("La designation ne peut etre null");
			isValide = false;
		}
		if (mat.getEtat() == null) {
			System.out.println("L'etat ne peut etre null");
			isValide = false;
		}
		if (mat.getIdMateriel() <= 0) {
			System.out
					.println("La l'id du materiel ne peut etre inferieur a 1");
			isValide = false;
		}
		if (mat.getMarque() == null) {
			System.out.println("La marque ne peut etre null");
			isValide = false;
		}
		if (mat.getNumSerie() <= 0) {
			System.out.println("Le numero de serie ne peut etre inferieur a 1");
			isValide = false;
		}
		if (mat.getObservation() == null) {
			System.out.println("Le champ observation ne peut etre null");
			isValide = false;
		}
		if (mat.getTypeMat() == null) {
			System.out.println("Le type ne peut etre null");
			isValide = false;
		}
		if (mat.getValeurAchat() <= 0) {
			System.out
					.println("La valeur d'achat ne peut etre inferieure ou egal a 0");
			isValide = false;
		}
		if (mat.getValeurReap() < 0) {
			System.out
					.println("La valeur de reapprovisionnement ne peut etre inferieure a 0");
			isValide = false;
		}

		return isValide;
	}
}
