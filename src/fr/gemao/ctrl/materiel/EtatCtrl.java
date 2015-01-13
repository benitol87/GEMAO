package fr.gemao.ctrl.materiel;

import java.util.List;

import fr.gemao.entity.materiel.Etat;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.EtatDAO;

public class EtatCtrl {
	/**
	 * Permet d'ajouter un etat dans la base
	 * 
	 * @param idEtat
	 * 		id de l'etat a ajouter
	 * @param libelle
	 * 		libelle de l'etat a ajouter
	 */
	public void ajoutEtat(int idEtat, String libelle){
		if(libelle == null){
			throw new NullPointerException("Le Libelle ne doit pas etre null");
		}
		if(libelle == ""){
			throw new NullPointerException("Le Libelle ne doit pas etre vide");
		}
		Etat etat = new Etat(idEtat,libelle);
		new EtatDAO(DAOFactory.getInstance()).create(etat);
	}
	/**
	 * Permet de supprimer un etat dans la base
	 * @param libelle
	 * 		libelle de l'etat a retirer.
	 */
	public void supprimerEtat(String libelle){
		if(libelle == null){
			throw new NullPointerException("Le Libelle ne doit pas etre null");
		}
		if(libelle == ""){
			throw new NullPointerException("Le Libelle ne doit pas etre vide");
		}
		
		EtatDAO etatDAO = new EtatDAO(DAOFactory.getInstance());
		List<Etat> etats = etatDAO.getAll();
		for(Etat etat : etats){
			if(etat.getLibelleEtat().equals(libelle)){
				etatDAO.delete(etat);
				break;
			}
		}
	}
}
