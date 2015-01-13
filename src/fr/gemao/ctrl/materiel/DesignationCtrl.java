package fr.gemao.ctrl.materiel;

import java.util.List;

import fr.gemao.entity.materiel.Designation;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.DesignationDAO;



public class DesignationCtrl {
	public DesignationCtrl(){
		
	}
	/**
	 * Permet d'ajouter une designation dans la base.
	 * 
	 * @param idDesignation
	 *            l'id de la designation a rajouter dans la base.
	 * @param libelle
	 * 			Libelle de la designation a ajouter.
	 */
	public void ajoutDesignation(int idDesination, String libelle){
		if(libelle == null){
			throw new NullPointerException("Le Libelle ne doit pas etre null");
		}
		if(libelle == ""){
			throw new NullPointerException("Le Libelle ne doit pas etre vide");
		}
		Designation designation = new Designation(idDesination,libelle);
		
		new DesignationDAO(DAOFactory.getInstance()).create(designation);
	}
	
	/**
	 * Permet de supprimer une designation.
	 * 
	 * @param libelle
	 *            le libelle de la designation a supprimer.
	 */
	public void supprimerDesignation(String libelle){
		if (libelle == null) {
			throw new NullPointerException(
					"Le nom du reparateur ne doit pas etre null");
		}

		if (libelle == "") {
			throw new IllegalArgumentException(
					"Le nom du reparateur doit etre renseigne");
		}

		DesignationDAO desDAO = new DesignationDAO(DAOFactory.getInstance());

		List<Designation> designations = desDAO.getAll();
		for (Designation designation : designations) {
			if (designation.getLibelleDesignation().equals(libelle)) {
				desDAO.delete(designation);
				break;
			}
		}
	}
}
