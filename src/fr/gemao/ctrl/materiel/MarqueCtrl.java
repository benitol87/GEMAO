package fr.gemao.ctrl.materiel;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.entity.materiel.Marque;
import fr.gemao.sql.gestionMateriel.MarqueDAO;

public class MarqueCtrl {
	public static void ajouterMarque(String nomMarque){
		if(nomMarque == null){
			throw new NullPointerException("Le nom de la marque ne peut etre vide.");
		}
		Marque marque = new Marque(0, nomMarque);
		new MarqueDAO(ConnectionMySql.getInstance()).create(marque);
	}
	
	public static void supprimerMarque(String nomMarque){
		if(nomMarque == null){
			throw new NullPointerException("Le nom de la marque ne peut etre vide.");
		}
		
		MarqueDAO marquedao = new MarqueDAO(ConnectionMySql.getInstance());
		Marque marque = marquedao.get(nomMarque);
		marquedao.delete(marque);
	}
}
