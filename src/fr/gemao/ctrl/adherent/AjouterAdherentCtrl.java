package fr.gemao.ctrl.adherent;

import java.util.Date;

import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;

/**
 * La classe AjouterAdherentCtrl permet de contrôler l'ajout d'un adhérent
 * 
 * @author Coco
 *
 */
public class AjouterAdherentCtrl {

	/**
	 * Constructeur
	 */
	public AjouterAdherentCtrl() {

	}
	
	/**
	 * Méthode permettant de vérifier la validité des informations d'un adhérent
	 * @param adherent
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Adherent adherent){
		Date date = new Date();
		
		//Vérification de l'idMotif
//		if(adherent.getMotif() == null || adherent.getMotif().getIdMotif() <= 0){
//			System.out.println("L'idMotif est invalide...");
//			return false;
//		}
		
		//Vérification de l'idResponsable
		if(adherent.getResponsable() != null && adherent.getResponsable().getIdResponsable() <= 0){
			return false;
		}
		
		//Vérification de la date d'entrée
		if(adherent.getDateEntree() == null || adherent.getDateEntree().after(date)){
			System.out.println("La date d'entrée doit être antérieure à la date actuelle...");
			return false;
		}
		
		//Vérification de la date de sortie
		if(adherent.getDateSortie() != null && adherent.getDateSortie().after(date)){
			System.out.println("La date de sortie doit être antérieure à la date actuelle...");
			return false;
		}
		
		//Vérification de la cotisation
		if(adherent.getCotisation() == null){
			System.out.println("La cotisation doit être spécifiée...");
			return false;
		}
		
		//Vérification de la/des disciplines
//		if(adherent.getDisciplines().isEmpty()){
//			System.out.println("L'adhérent doit être inscrit à au moins une discipline...");
//			return false;
//		}
		
		return true;
	}

	/**
	 * Méthode permettant d'ajouter un adhérent dans la BD
	 * @param adherent : l'adhérent à ajouter
	 */
	public boolean ajoutAdherent(Adherent adherent) {
		AjouterPersonneCtrl ajoutPers = new AjouterPersonneCtrl();
		
		//Ajout de la personne dans la base
		if(ajoutPers.ajoutPersonne(adherent) != -1){
			Adherent adh;

			DAOFactory co = DAOFactory.getInstance();
			AdherentDAO adherentDAO = co.getAdherentDAO();

			//Vérification de la validité des informations
			if(this.verifierInformations(adherent)){
				adh = adherentDAO.create(adherent);
				if (adh == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					System.out.println("L'adhérent a bien été ajouté.");
					return true;
				}
			}
			else{
				System.out.println("Les informations de l'adhérent ne sont pas valides...");
			}

		}
		else{
			System.out.println("Une erreur est survenue lors de l'insertion...");

		}
		return false;
	}
}
