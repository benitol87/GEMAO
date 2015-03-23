package fr.gemao.ctrl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gemao.entity.Commune;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;

public class AjouterCommuneCtrl {
	
	/**
	 * Constructeur
	 */
	public AjouterCommuneCtrl(){
		
	}
	
	/**
	 * Méthode permettant de vérifier les informations d'une commune avant ajout
	 * @param commune
	 * @return true si les informations sont valides, false sinon
	 */
	public static boolean verifierInformations(Commune commune){
		String masque;
		Pattern pattern;
		Matcher controler;
		
		//Vérification du code postal
		if(commune.getCodePostal() <= 0){
			System.out.println("Le code postal doit être strictement positif...");
			return false;
		}
		
		//Vérification du nom de commune
		masque = "^[A-Za-z\\- ]+$";
		pattern = Pattern.compile(masque);
		controler = pattern.matcher(commune.getNomCommune());
		if (!controler.matches()) {
			System.out.println("Le format du nom de la commune est invalide...");
			return false;
		}

		return true;
	}
	
	/**
	 * Méthode permettant d'ajouter une commune dans la BD.
	 * Pour être ajoutée, les informations de la commune doivent être valides et la commune ne doit pas déjà exister dans la base (sinon levée d'une IllegalArgumentException).
	 * @param commune
	 */
	public static void ajoutCommune(Commune commune){
		//Vérification de la validité des informations
		if(verifierInformations(commune)){
			Commune com;
			
			DAOFactory co = DAOFactory.getInstance();
			CommuneDAO communeDAO = co.getCommuneDAO();
			
			//Vérification de l'inexistance de la commune dans la base
			com = communeDAO.existNomCodePostal(commune);
			if(com == null){
				com = communeDAO.create(commune);
				if (com != null){
					commune.setIdCommune(com.getIdCommune());
				}
			}
			else{
				commune.setIdCommune(com.getIdCommune());
				commune.setAvantage(com.isAvantage());
			}
		}
	}
}
