package fr.gemao.ctrl.materiel;

import java.sql.Connection;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.entity.materiel.Categorie;


public class CategorieCtrl {
	public CategorieCtrl() {

	}

	public void ajoutCategorie(Categorie categorie){

		if(categorie.getLibelleCat() == null){
			throw new NullPointerException("Libelle Null");
		}
		if(categorie.getLibelleCat() == ""){
			throw new NullPointerException("Le libelle ne doit pas etre vide");
		}
		
		new CategorieDAO(ConnectionMySql.getInstance()).creat(categorie);
	}
}
