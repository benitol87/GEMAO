package fr.gemao.ctrl.adherent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsableDAO;

public class AjouterResponsableCtrl {

	/**
	 * Constructeur
	 */
	public AjouterResponsableCtrl(){
	}
	
	/**
	 * Méthode permettant de vérifier la validité des informations d'un responsable
	 * @param responsable
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Responsable responsable){
		String masque;
		Pattern pattern;
		Matcher controler;
		
		//Vérification du nom
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getNom());
		if (!controler.matches()) {
			System.out.println("Le format du nom est invalide...");
			return false;
		}
		
		//Vérification du prénom
		controler = pattern.matcher(responsable.getPrenom());
		if (!controler.matches()) {
			System.out.println("Le format du prénom est invalide...");
			return false;
		}
		
		//Vérification du téléphone
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getTelephone());
		if (!controler.matches()) {
			System.out.println("Le format du téléphone est invalide...");
			return false;
		}
		
		//Vérification de l'email
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getEmail());
		if (!controler.matches()) {
			System.out.println("Le format de l'email est invalide...");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Méthode permettant d'ajouter un responsable dans la BD.
	 * La méthode vérifie la validité des informations avant l'ajout.
	 * @param responsable
	 */
	public void ajouterResponsable(Responsable responsable){
		//Vérification des informations du responsable
		if(this.verifierInformations(responsable)){
			Responsable test;

			DAOFactory co = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = co.getResponsableDAO();

			test = responsableDAO.create(responsable);
			if (test == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				responsable.setIdResponsable(test.getIdResponsable());
				System.out.println("Le responsable a bien été ajouté.");
			}
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}
	}
}
