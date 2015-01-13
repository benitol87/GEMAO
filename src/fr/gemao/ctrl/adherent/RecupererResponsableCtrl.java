package fr.gemao.ctrl.adherent;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Responsable;

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
		Connection co = ConnectionMySql.getInstance();
		ResponsableDAO responsableDAO = new ResponsableDAO(co);
		
		Responsable responsable = responsableDAO.get(idResponsable);
		
		return responsable;
	}

	public List<Responsable> recupererTousResponsables(){
		List<Responsable> listeResponsables = new ArrayList<Responsable>();
		Connection co = ConnectionMySql.getInstance();
		ResponsableDAO responsableDAO = new ResponsableDAO(co);
		
		listeResponsables = responsableDAO.getAll();
		
		return listeResponsables;
	}
}
