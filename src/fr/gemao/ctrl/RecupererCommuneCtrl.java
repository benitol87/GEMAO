package fr.gemao.ctrl;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Commune;
import fr.gemao.sql.DAOFactory;

public class RecupererCommuneCtrl {
	
	/**
	 * Constructeur
	 */
	public RecupererCommuneCtrl(){
	}
	
	/**
	 * Méthode permettant de récupérer une commune selon son identifiant
	 * @param id
	 * @return la commune dont l'identifiant est idCommune
	 */
	public Commune recupererCommune(int idCommune){
		DAOFactory co = DAOFactory.getInstance();
		CommuneDAO communeDAO = co.getCommuneDAO();
		
		Commune commune = communeDAO.get(idCommune);
		
		return commune;		
	}
	
	/**
	 * Méthode permettant de récupérer l'ensemble des communes
	 * @return la liste des communes de la BD
	 */
	public List<Commune> recupererTousCommunes(){
		List<Commune> listeCommunes = new ArrayList<Commune>();
		DAOFactory co = DAOFactory.getInstance();
		CommuneDAO communeDAO = co.getCommuneDAO();
		
		listeCommunes = communeDAO.getAll();
		
		return listeCommunes;
	}

}
