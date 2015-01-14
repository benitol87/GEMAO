package fr.gemao.ctrl;

import fr.gemao.entity.Adresse;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.DAOFactory;

public class AjouterAdresseCtrl {
	
	/**
	 * Constructeur
	 */
	public AjouterAdresseCtrl(){
	}
	
	/**
	 * Méthode permettant de vérifier les informations d'une adresse
	 * @param adresse
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Adresse adresse){			
			//Vérification de l'idCommune
			if(adresse.getIdCommune() < 0){
				System.out.println("L'idCommune doit être positif...");
				return false;
			}
			
			//Vérification du numéro de rue
			if(adresse.getNumRue() <= 0){
				System.out.println("Le numéro de rue doit être strictement positif...");
				return false;
			}
			
			return true;
	}
	
	/**
	 * Méthode permettant d'ajouter une adresse dans la BD
	 * @param adresse
	 */
	public void ajoutAdresse(Adresse adresse){
		if(this.verifierInformations(adresse)){
			Adresse adr;
			
			DAOFactory co = DAOFactory.getInstance();
			AdresseDAO adresseDAO = co.getAdresseDAO();
			
			adr = adresseDAO.create(adresse);
			if (adr == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				adresse.setIdAdresse(adr.getIdAdresse());
				System.out.println("L'adresse a bien été ajoutée.");
			}
		}
		else{
			System.out.println("Les informations de l'adresse ne sont pas valides...");
		}
		
	}

}
