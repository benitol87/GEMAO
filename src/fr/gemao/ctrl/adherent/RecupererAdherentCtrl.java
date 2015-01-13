package fr.gemao.ctrl.adherent;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;

public class RecupererAdherentCtrl {

	public RecupererAdherentCtrl(){
		
	}
	
	public Adherent recupererAdherent(Long idPersonne){
		
		DAOFactory factory = DAOFactory.getInstance();
		AdherentDAO adherentDAO = factory.getAdherentDAO();
		
		Adherent adherent = adherentDAO.get(idPersonne);
		
		return adherent;		
	}
	
	public List<Adherent> recupererTousAdherents(){
		List<Adherent> listeAdherents = new ArrayList<Adherent>();
		DAOFactory factory = DAOFactory.getInstance();
		AdherentDAO adherentDAO = factory.getAdherentDAO();
		
		listeAdherents = adherentDAO.getAll();
		
		return listeAdherents;
	}
}
