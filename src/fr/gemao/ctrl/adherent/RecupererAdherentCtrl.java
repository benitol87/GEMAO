package fr.gemao.ctrl.adherent;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.ancien_entity.Adherent;
import fr.gemao.ancien_mysql.AdherentDAO;
import fr.gemao.ancien_mysql.ConnectionMySql;

public class RecupererAdherentCtrl {

	public RecupererAdherentCtrl(){
		
	}
	
	public Adherent recupererAdherent(Long idPersonne){
		Connection co = ConnectionMySql.getInstance();
		AdherentDAO adherentDAO = new AdherentDAO(co);
		
		Adherent adherent = adherentDAO.get(idPersonne);
		
		return adherent;		
	}
	
	public List<Adherent> recupererTousAdherents(){
		List<Adherent> listeAdherents = new ArrayList<Adherent>();
		Connection co = ConnectionMySql.getInstance();
		AdherentDAO adherentDAO = new AdherentDAO(co);
		
		listeAdherents = adherentDAO.getAll();
		
		return listeAdherents;
	}
}
