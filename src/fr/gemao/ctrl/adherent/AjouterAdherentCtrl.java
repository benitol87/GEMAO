package fr.gemao.ctrl.adherent;

import java.util.Date;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.form.VerifierSyntaxePersonne;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class AjouterAdherentCtrl {

	/**
	 * Constructeur
	 */
	public AjouterAdherentCtrl() {

	}
	
	/**
	 * Méthode permettant de vérifier les informations d'un adhérent avant ajout
	 * @param adherent
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Adherent adherent){
		//Vérification des informations générales de la personne
		VerifierSyntaxePersonne persCtrl = new VerifierSyntaxePersonne();
		if (!persCtrl.verifierInformations(adherent))
			return false;

		//Vérification de l'idMotif
		if (adherent.getIdMotif() != null) {
			return false;
		}

		//Vérification des dates d'entrée et sortie
		Date date = new Date();

		if (adherent.getDateEntree() == null) {
			System.out
					.println("La date d'entrée doit obligatoirement être saisie...");
			return false;
		} else {
			if (adherent.getDateEntree().after(date)) {
				System.out
						.println("La date d'entrée doit être antérieure à la date actuelle...");
				return false;
			}
			if (adherent.getDateSortie() != null) {
				if (adherent.getDateEntree().after(adherent.getDateSortie())) {
					System.out
							.println("La date de sortie doit être postérieure à la date d'entrée...");
					return false;
				}
				if (adherent.getDateSortie().after(date)) {
					System.out
							.println("La date de sortie doit être antérieure à la date actuelle...");
					return false;
				}
			}
			if (adherent.getDateEntree().before(adherent.getDateNaissance())) {
				System.out
						.println("La date de naissance doit être antérieure à la date d'entrée...");
				return false;
			}
		}

		//Vérification du quotient familial
		if (adherent.getQf() != null && adherent.getQf() < 0.0) {
			System.out
					.println("Le montant du quotient familial ne peut pas être négatif...");
			return false;
		}

		return true;
	}

	/**
	 * Méthode permettant d'ajouter un adhérent dans la BD
	 * @param adherent
	 */
	public void ajoutAdherent(Adherent adherent) {
		if (this.verifierInformations(adherent)) {
			Personne pers;
			Adherent adh;

			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			AdherentDAO adherentDAO = co.getAdherentDAO();

			pers = personneDAO.create(adherent);
			if (pers == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				adherent.setIdPersonne(pers.getIdPersonne());
				adh = adherentDAO.create(adherent);
				if (adh == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					System.out.println("L'adhérent a bien été ajouté.");
				}
			}

		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valides...");
		}
	}
}
