package fr.gemao.ctrl.materiel;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.entity.materiel.Reparateur;
import fr.gemao.sql.gestionMateriel.ReparateurDAO;

public class ReparateurCtrl {
	
	public void ajoutReparateur(int idReparateur,String nom){
		if(nom== null){
			throw new NullPointerException("Le nom du reparateur ne doit pas etre null");
			
		}
		
		if(nom==""){
			throw new NullPointerException("Le nom du reparateur doit etre renseigne");
			
		}
		
		Reparateur rep = new Reparateur(idReparateur,nom);
		new ReparateurDAO(ConnectionMySql.getInstance()).create(rep);

	}

}
