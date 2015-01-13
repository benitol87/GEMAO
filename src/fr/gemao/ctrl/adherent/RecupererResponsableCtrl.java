package fr.gemao.ctrl.adherent;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsableDAO;

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
		
		DAOFactory factory = DAOFactory.getInstance();
		ResponsableDAO responsableDAO = factory.getResponsableDAO();
		
		Responsable responsable = responsableDAO.get(idResponsable);
		
		return responsable;
	}

	public List<Responsable> recupererTousResponsables(){
		List<Responsable> listeResponsables = new ArrayList<Responsable>();
		DAOFactory factory = DAOFactory.getInstance();
		ResponsableDAO responsableDAO = factory.getResponsableDAO();
		
		listeResponsables = responsableDAO.getAll();
		
		return listeResponsables;
	}
}
