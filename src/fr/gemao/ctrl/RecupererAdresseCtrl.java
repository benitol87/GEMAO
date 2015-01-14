package fr.gemao.ctrl;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Adresse;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.DAOFactory;

public class RecupererAdresseCtrl {
	
	/**
	 * Constructeur
	 */
	public RecupererAdresseCtrl(){
	}
	
	/**
	 * Méthode permettant de récupérer une adresse selon son identifiant
	 * @param id
	 * @return l'adresse dont l'identifiant est idAdresse
	 */
	public Adresse recupererAdresse(int idAdresse){
		DAOFactory co = DAOFactory.getInstance();
		AdresseDAO adresseDAO = co.getAdresseDAO();
		
		Adresse adresse = adresseDAO.get(idAdresse);
		
		return adresse;		
	}
	
	/**
	 * Méthode permettant de récupérer l'ensemble des adresses
	 * @return la liste des adresses de la BD
	 */
	public List<Adresse> recupererTousAdresses(){
		List<Adresse> listeAdresses = new ArrayList<Adresse>();
		DAOFactory co = DAOFactory.getInstance();
		AdresseDAO adresseDAO = co.getAdresseDAO();
		
		listeAdresses = adresseDAO.getAll();
		
		return listeAdresses;
	}

}
