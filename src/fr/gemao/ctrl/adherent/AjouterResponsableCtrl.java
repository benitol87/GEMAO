package fr.gemao.ctrl.adherent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.ResponsableDAO;

public class AjouterResponsableCtrl {

	/**
	 * Constructeur
	 */
	public AjouterResponsableCtrl(){
	}
	
	static String masqueNom = "^[A-Za-z âäàéèëêîïìôöòûüùÿ\\-]+$",
			masqueTel = "^[0][0-9]{9}$",
			masqueMail = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
					+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
	
	/**
	 * Méthode permettant de vérifier la validité des informations d'un responsable
	 * @param responsable
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(Responsable responsable){
		Pattern pattern;
		Matcher controler;
		
		//Vérification du nom
		pattern = Pattern.compile(masqueNom);
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
		pattern = Pattern.compile(masqueTel);
		controler = pattern.matcher(responsable.getTelephone());
		if (!controler.matches()) {
			System.out.println("Le format du téléphone est invalide...");
			return false;
		}
		
		//Vérification de l'email
		pattern = Pattern.compile(masqueMail);
		if(responsable.getEmail()=="")
			responsable.setEmail(null);
		if(responsable.getEmail()!=null){
			controler = pattern.matcher(responsable.getEmail());
			if (!controler.matches()) {
				System.out.println("Le format de l'email est invalide...");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Méthode permettant d'ajouter un responsable dans la BD.
	 * La méthode vérifie la validité des informations et si la personne n'existe pas déjà dans la base avant l'ajout.
	 * @param responsable
	 */
	public void ajouterResponsable(Responsable responsable){
		//Vérification des informations du responsable
		if(this.verifierInformations(responsable)){
			Responsable resp;

			DAOFactory co = DAOFactory.getInstance();
			ResponsableDAO responsableDAO = co.getResponsableDAO();

			//Vérification de l'inexistance du responsable dans la base
			resp = responsableDAO.exist(responsable);
			if (resp == null) {
				resp = responsableDAO.create(responsable);
				if (resp == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					responsable.setIdResponsable(resp.getIdResponsable());
					System.out.println("Le responsable a bien été ajouté.");
				}
			}
			else{
				responsable.setIdResponsable(resp.getIdResponsable());
				responsable.setEmail(resp.getEmail());
				responsable.setTelephone(resp.getTelephone());
			}
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}
	}
}
