package fr.gemao.ctrl;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Contrat;
import fr.gemao.sql.DAOFactory;

public class RecupererContratCtrl {

	/**
	 * Constructeur
	 */
	public RecupererContratCtrl(){
	}
	
	/**
	 * Méthode permettant de récupérer un contrat selon son identifiant
	 * @param id
	 * @return le contrat dont l'identifiant est idContrat, null si le contrat n'existe pas
	 */
	public Contrat recupererContrat(int idContrat){
		DAOFactory co = DAOFactory.getInstance();
		ContratDAO contratDAO = co.getCommuneDAO();
		
		Contrat contrat = contratDAO.get(idContrat);
		
		return contrat;		
	}
	
	/**
	 * Méthode permettant de récupérer l'ensemble des contrats
	 * @return la liste des contrats de la BD
	 */
	public List<Contrat> recupererTousContrats(){
		List<Contrat> listeContrats = new ArrayList<Contrat>();
		DAOFactory co = DAOFactory.getInstance();
		ContratDAO contratDAO = co.getCommuneDAO();
		
		listeContrats = contratDAO.getAll();
		
		return listeContrats;
	}
}
