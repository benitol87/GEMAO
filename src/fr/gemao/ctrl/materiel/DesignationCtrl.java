package fr.gemao.ctrl.materiel;

import java.sql.Connection;

import fr.gemao.entity.materiel.Designation;
import fr.gemao.sql.gestionMateriel.DesignationDAO;
import fr.gemao.ancien_mysql.ConnectionMySql;



public class DesignationCtrl {
	public DesignationCtrl(){
		
	}
	
	public void ajoutDesignation(int idDesination, String libelle){
		if(libelle == null){
			throw new NullPointerException("Le Libelle ne doit pas etre null");
		}
		if(libelle == ""){
			throw new NullPointerException("Le Libelle ne doit pas etre vide");
		}
		Designation designation = new Designation(idDesination,libelle);
		new DesignationDAO(ConnectionMySql.getInstance()).create(designation);
	}
}
