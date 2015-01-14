package fr.gemao.ctrl;

import fr.gemao.entity.Adresse;
import fr.gemao.form.VerifierSyntaxeAdresse;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.DAOFactory;

public class AjouterAdresseCtrl {
	
	/**
	 * Constructeur
	 */
	public AjouterAdresseCtrl(){
	}
	
	/**
	 * Méthode permettant d'ajouter une adresse dans la BD
	 * @param adresse
	 */
	public void ajoutAdresse(Adresse adresse){
		
		VerifierSyntaxeAdresse verifAdresse = new VerifierSyntaxeAdresse();
		
		if(verifAdresse.verifierInformations(adresse)){
			Adresse test;
			
			DAOFactory co = DAOFactory.getInstance();
			AdresseDAO adresseDAO = co.getAdresseDAO();
			
			test = adresseDAO.create(adresse);
			if (test == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				adresse.setIdAdresse(test.getIdAdresse());
				System.out.println("L'adresse a bien été ajoutée.");
			}
		}
		else{
			System.out.println("Les informations de l'adresse ne sont pas valides...");
		}
		
	}

}
