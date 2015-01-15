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
			if(adresse.getCommune() == null){
				System.out.println("L'objet commune ne doit pas être null...");
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
	 * Méthode permettant d'ajouter une adresse dans la BD.
	 * Pour être ajoutée, les informations de l'adresse doivent être valides et l'adresse ne doit pas déjà exister dans la base (sinon levée d'une IllegalArgumentException).
	 * @param adresse
	 */
	public void ajoutAdresse(Adresse adresse){
		//Vérification de la validité des informations
		if(this.verifierInformations(adresse)){
			Adresse adr;
			
			DAOFactory co = DAOFactory.getInstance();
			AdresseDAO adresseDAO = co.getAdresseDAO();
			
			//Vérification de l'inexistance de l'adresse dans la base
			adr = adresseDAO.exist(adresse);
			if(adr == null){
				adr = adresseDAO.create(adresse);
				if (adr == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					adresse.setIdAdresse(adr.getIdAdresse());
					System.out.println("L'adresse a bien été ajoutée.");
				}
			}
			else{
				adresse.setIdAdresse(adr.getIdAdresse());
			}
		}
		else{
			System.out.println("Les informations de l'adresse ne sont pas valides...");
		}
		
	}

}
