package fr.gemao.ctrl.materiel;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.ancien_mysql.AdherentDAO;
import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.entity.materiel.Materiel;


public class RecupererMaterielCtrl {
	
	public RecupererMaterielCtrl(){
		
	}
	
	public Materiel recupererMateriel(int idMateriel){
		Connection co = ConnectionMySql.getInstance();
		MaterielDAO materielDAO = new MaterielDAO(co);
		
		return materielDAO.get(idMateriel);
	}
	
	public List<Materiel> recupererTousMateriels(){
		List<Materiel> listeMateriel = new ArrayList<Materiel>();
		Connection co = ConnectionMySql.getInstance();
		MaterielDAO materielDAO = new MaterielDAO(co);
		
		listeMateriel = materielDAO.getAll();
		
		return listeMateriel;
	}
}
