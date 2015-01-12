package fr.gemao.ctrl.materiel;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.ancien_mysql.gestionMateriel.CategorieDAO;
import fr.gemao.entity.materiel.Categorie;


public class CategorieCtrl {
	public CategorieCtrl() {

	}

	public void ajoutCategorie(int idCat, String libelle){

		if(libelle == null){
			throw new NullPointerException("Libelle Null");
		}
		if(libelle == ""){
			throw new NullPointerException("Le libelle ne doit pas etre vide");
		}
		Categorie categorie = new Categorie(idCat,libelle);
		new CategorieDAO(ConnectionMySql.getInstance()).create(categorie);
	}
}
