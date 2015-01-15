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
	public AjouterPersonneCtrl() {
	}

	public boolean verifierInformations(Personne personne) {
		String masque;
		Pattern pattern;
		Matcher controler;

		/**
		 * Vérification de l'idAdresse
		 */
		if (personne.getIdAdresse() == null || personne.getIdAdresse() <= 0) {
			System.out.println("L'idAdresse n'est pas valide...");
			return false;
		}

		/**
		 * Vérification de l'idCommuneNaiss
		 */
		if (personne.getCommuneNaiss() == null || personne.getCommuneNaiss() <= 0) {
			System.out.println("L'idAdresse n'est pas valide...");
			return false;
		}

		/**
		 * Vérification du nom
		 */
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(personne.getNom());
		if (!controler.matches()) {
			System.out.println("Le format du nom est invalide...");
			return false;
		}

		/**
		 * Vérification du prenom
		 */
		controler = pattern.matcher(personne.getPrenom());
		if (!controler.matches()) {
			System.out.println("Le format du prénom est invalide...");
			return false;
		}

		/**
		 * Vérification de la date de naissance
		 */
		Date date = new Date();
		if (personne.getDateNaissance().after(date)) {
			System.out
					.println("La date de naissance doit être antérieure à la date actuelle...");
			return false;
		}

		/**
		 * Vérification de l'email (Vérifier si le masque est correct)
		 */
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(personne.getEmail());
		if (!controler.matches()) {
			System.out.println("Le format de l'email est invalide...");
			return false;
		}

		/**
		 * Vérification des téléphone fixe et portable
		 */
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(personne.getTelFixe());
		if (!controler.matches()) {
			System.out.println("Le format du téléphone fixe est invalide...");
			return false;
		}
		controler = pattern.matcher(personne.getTelPort());
		if (!controler.matches()) {
			System.out.println("Le format du téléphone portable est invalide...");
			return false;
		}

		return true;
	}

	/**
	 * Méthode permettant d'ajouter une personne dans la BD
	 * Pour être ajoutée, les informations de la personne doivent être valides et la personne ne doit pas déjà exister dans la base (sinon levée d'une IllegalArgumentException).
	 * 
	 * @param personne
	 */
	public long ajoutPersonne(Personne personne) {
		//Vérification de la validité des informations
		if (this.verifierInformations(personne)) {
			Personne pers;

			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			
			//Vérification de l'inexistance de la personne dans la base
			if(personneDAO.exist(personne) == null){
				pers = personneDAO.create(personne);
				if (pers == null) {
					System.out
							.println("Une erreur est survenue lors de l'insertion...");
					return -1;
				} else {
					System.out.println("La personne a bien été ajoutée.");
					return pers.getIdPersonne();
				}
			}
			else{
				throw new IllegalArgumentException("La personne existe déjà dans la base...");
			}

		} else {
			System.out
					.println("Les informations de la personne ne sont pas valides...");
			return -1;
		}
	}

}
