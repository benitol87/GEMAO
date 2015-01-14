package fr.gemao.ctrl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.Personne;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class AjouterPersonneCtrl {
	
	/**
	 * Constructeur
	 */
	public AjouterPersonneCtrl(){
	}
	
	public boolean verifierInformations(Personne personne){
		String masque;
		Pattern pattern;
		Matcher controler;

		//Vérification de l'idPersonne
		if (personne.getIdPersonne() < 0) {
			System.out.println("L'idPersonne doit être positif");
			return false;
		}

		/**
		 * Vérification de l'idAdresse
		 *
		 * if (pers.getIdAdresse() n'existe pas){
		 * syso("L'idAdresse n'existe pas"); return false; }
		 */

		/**
		 * Vérification de l'idCommuneNaiss
		 *
		 * if (pers.getIdCommune() n'existe pas){
		 * syso("L'idCommune n'existe pas"); return false; }
		 */

		/**
		 * Vérification du nom Masque à définir
		 */
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(personne.getNom());
		if (!controler.matches()) {
			System.out.println("Le format du nom est invalide");
			return false;
		}

		/**
		 * Vérification du prenom Masque à définir
		 */
		controler = pattern.matcher(personne.getPrenom());
		if (!controler.matches()) {
			System.out.println("Le format du prénom est invalide");
			return false;
		}

		/**
		 * Vérification de la date de naissance
		 */
		Date date = new Date();
		if (personne.getDateNaissance() == null) {
			System.out
					.println("La date d'entrée doit obligatoirement être saisie");
			return false;
		} else if (personne.getDateNaissance().after(date)) {
			System.out
					.println("La date de naissance doit être antérieur à la date actuelle");
			return false;
		}

		/**
		 * Vérification de l'email (Vérifier si le masque est correct)
		 */
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(personne.getEmail());
		if (!controler.matches() && personne.getEmail() != null) {
			System.out.println("Le format de l'email est invalide");
			return false;
		}

		/**
		 * Vérification des téléphone fixe et portable
		 */
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(personne.getTelFixe());
		if (!controler.matches() && personne.getTelFixe() != null) {
			System.out.println("Le format du telephone fixe est invalide");
			return false;
		}
		controler = pattern.matcher(personne.getTelPort());
		if (!controler.matches() && personne.getTelPort() != null) {
			System.out.println("Le format du telephone portable est invalide");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Méthode permettant d'ajouter une personne dans la BD
	 * @param personne
	 */
	public long ajoutPersonne(Personne personne){
		if (this.verifierInformations(personne)) {
			Personne pers;

			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();

			pers = personneDAO.create(personne);
			if (pers == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
				return -1;
			} else {
					System.out.println("La personne a bien été ajoutée.");
					return pers.getIdPersonne();
			}

		} else {
			System.out
					.println("Les informations de la personne ne sont pas valides...");
			return -1;
		}
	}

}
