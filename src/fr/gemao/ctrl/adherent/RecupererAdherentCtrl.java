package fr.gemao.ctrl.adherent;

import java.util.ArrayList;
import java.util.List;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.entity.adherent.Adherent;

public class RecupererAdherentCtrl {

	/**
	 * Constructeur
	 */
	public RecupererAdherentCtrl(){
		
	}
	
	/**
	 * Méthode permettant de récupérer un adhérent selon son identifiant
	 * @param idPersonne
	 * @return l'adhérent dont l'identifiant est idPersonne
	 */
	public Adherent recupererAdherent(Long idPersonne){
		DAOFactory co = DAOFactory.getInstance();
		AdherentDAO adherentDAO = co.getAdherentDAO();
		
		Adherent adherent = adherentDAO.get(idPersonne);
		
		return adherent;		
	}
	
	/**
	 * Méthode permettant de récupérer l'ensemble des adhérents
	 * @return la liste des adhérents de la BD
	 */
	public List<Adherent> recupererTousAdherents(){
		List<Adherent> listeAdherents = new ArrayList<Adherent>();
		DAOFactory co = DAOFactory.getInstance();
		AdherentDAO adherentDAO = co.getAdherentDAO();
		
		listeAdherents = adherentDAO.getAll();
		
		return listeAdherents;
	}
}
