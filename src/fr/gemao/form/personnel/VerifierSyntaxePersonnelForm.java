package fr.gemao.form.personnel;

import fr.gemao.entity.Personnel;

/**
 * Classe de vérification des informations d'un personnel
 * @author Coco
 *
 */
public class VerifierSyntaxePersonnelForm {
	
	private boolean isValide;
	
	/**
	 * Constructeur
	 */
	public VerifierSyntaxePersonnelForm() {
		this.isValide = true;
	}
	
	/**
	 * Vérifie les informations d'un personnel
	 * @param personnel : le personnel à vérifier
	 * @return : retourne true si les informations sont cohérentes, false sinon
	 */
	public boolean verifierInformations(Personnel personnel) {
		
		/**
		 * Vérifie si la liste des responsabilités n'est pas vide
		 */
		if (personnel.getIdResponsabilite() == null) {
			System.out.println("Le personnel doit avoir au moins une responsabilité");
			isValide = false;
		}
		
		/**
		 * Vérifié si le numéro de contrat n'est pas null
		 */
		if (personnel.getIdContrat() == null) {
			System.out.println("Le personnel doit avoir un numéro de contrat");
			isValide = false;
		}
		
		/**
		 * Vérifie si le login du personnel n'est pas null
		 */
		if (personnel.getLogin() == null) {
			System.out.println("Le login du personnel ne peut pas être null");
			isValide = false;
		}
		
		/**
		 * Vérifie si le mot de passe du personnel n'est pas null
		 */
		if (personnel.getPassword() == null) {
			System.out.println("Le mot de passe du personnel ne peut pas être null");
			isValide = false;
		}
		
		/**
		 * Vérifie si le nombre de points d'ancienneté n'est pas inférieur à 0
		 */
		if (personnel.getPointsAncien() < 0) {
			System.out.println("Le nombre de point d'ancienneté du personnel ne peut pas être inférieur à 0");
			isValide = false;
		}
		
		return isValide;
	}
}