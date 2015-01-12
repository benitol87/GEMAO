package fr.gemao.ctrl.materiel;

import java.sql.Connection;

import fr.gemao.entity.materiel.Designation;



public class DesignationCtrl {
	public DesignationCtrl(){
		
	}
	
	public void ajoutDesignation(Designation designation){
		if(designation.getLibelleDesignation() == null){
			throw new NullPointerException("Le Libelle ne doit pas etre null");
		}
		if(designation.getLibelleDesignation() == ""){
			throw new NullPointerException("Le Libelle ne doit pas etre vide");
		}
		
		new DesignationDAO(ConnectionMySql.getInstance()).create(designation);
	}
}
