package fr.gemao.ctrl.adherent;

import java.util.Date;

import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;

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
		
		//Vérifications des disciplines
		if(adherent.getDisciplines().isEmpty()){
			System.out.println("L'adhérent doit participer à au moins une discipline...");
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
			Adherent adh;

			AjouterPersonneCtrl ajouterPers = new AjouterPersonneCtrl();
			if(ajouterPers.ajoutPersonne(adherent) != -1){
				DAOFactory co = DAOFactory.getInstance();
				AdherentDAO adherentDAO = co.getAdherentDAO();

				adh = adherentDAO.create(adherent);
				if (adh == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					System.out.println("L'adhérent a bien été ajouté.");
				}
			}
			else{
				System.out.println("Une erreur est survenue lors de l'insertion...");
			}
		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valides...");
		}
	}
}
