package fr.gemao.ctrl.adherent;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.ResponsableDAO;

public class RecupererResponsableCtrl {
	
	/**
	 * Constructeur
	 */
	public RecupererResponsableCtrl(){
	}
	
	/**
	 * Méthode permettant de récupérer le responsable correspondant à un identifiant donné
	 * @param idResponsable
	 * @return responsable dont l'identifiant est idResponsable
	 */
	public Responsable recupererResponsable(Long idResponsable){
		
		DAOFactory co = DAOFactory.getInstance();
		ResponsableDAO responsableDAO = co.getResponsableDAO();
		
		Responsable responsable = responsableDAO.get(idResponsable);
		
		return responsable;
	}

	/**
	 * Méthode permettant de récupérer l'ensemble des responsables de la BD
	 * @return la liste des responsables
	 */
	public List<Responsable> recupererTousResponsables(){
		List<Responsable> listeResponsables = new ArrayList<Responsable>();
		DAOFactory co = DAOFactory.getInstance();
		ResponsableDAO responsableDAO = co.getResponsableDAO();
		
		listeResponsables = responsableDAO.getAll();
		
		return listeResponsables;
	}
}
