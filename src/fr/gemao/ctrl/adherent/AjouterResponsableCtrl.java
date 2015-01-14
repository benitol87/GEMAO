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
	 * Méthode permettant de vérifier les informations d'un responsable
	 * @param responsable
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Responsable responsable){
		String masque;
		Pattern pattern;
		Matcher controler;
		
		//Vérification de l'idResponsable
		if (responsable.getIdResponsable() < 0.0) {
			System.out.println("L'idResponsable doit être positif...");
			return false;
		}
		
		//Vérification du nom
		masque = "^[A-Za-z\\-]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getNom());
		
		if (!controler.matches()) {
			System.out.println("Le format du nom est invalide...");
			return false;
		}
		
		//Vérification du prénom
		masque = "^[A-Za-z\\-]+$";
		controler = pattern.matcher(responsable.getPrenom());
		
		if (!controler.matches()) {
			System.out.println("Le format du prénom est invalide...");
			return false;
		}
		
		//Vérification du numéro de téléphone
		masque = "^[0][0-9]{9}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getTelephone());
		
		if (!controler.matches() && responsable.getTelephone() != null) {
			System.out.println("Le format du numéro de téléphone est invalide...");
			return false;
		}
		
		//Vérification de l'adresse mail
		masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
				+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(responsable.getEmail());
		
		if (!controler.matches() && responsable.getEmail() != null) {
			System.out.println("Le format de l'adresse email est invalide...");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Méthode permettant d'ajouter un responsable dans la BD
	 * @param responsable
	 * @return idResponsable si ajout réalisé, -1 sinon
	 */
	public long ajouterResponsable(Responsable responsable){
		
		if(this.verifierInformations(responsable)){
			
			Responsable resp;

			DAOFactory co = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = co.getResponsableDAO();

			resp = responsableDAO.create(responsable);
			if (resp == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
				return -1;
			} else {
				responsable.setIdResponsable(resp.getIdResponsable());
				System.out.println("Le responsable a bien été ajouté.");
				return resp.getIdResponsable();
			}
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
			return -1;
		}
	}
}
