package fr.gemao.ctrl.personnel;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.personnel.Personnel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonnelDAO;

/**
 * La classe personnel permet de récupérer un personnel ou de tous les lister.
 * 
 * @author Thomas
 *
 */
public class RecupererPersonnelCtrl {
	/**
	 * Le constructeur de RecupererPersonnelCtrl
	 */
	public RecupererPersonnelCtrl() {

	}

	/**
	 * Permet de récupéper un personnel en fonction de son identifiant
	 * 
	 * @param idPersonne
	 *            : identifiant
	 * @return Personnel
	 */
	public Personnel recupererPersonnel(Long idPersonne) {
		DAOFactory factory = DAOFactory.getInstance();
		PersonnelDAO personnelDAO = factory.getPersonnelDAO();

		Personnel personnel = personnelDAO.get(idPersonne);

		return personnel;
	}

	/**
	 * Permet de lister le personnel.
	 * 
	 * @return List Liste du personnel
	 */
	public List<Personnel> recupererTousPersonnels() {
		List<Personnel> listePersonnels = new ArrayList<Personnel>();
		DAOFactory factory = DAOFactory.getInstance();
		PersonnelDAO personnelDAO = factory.getPersonnelDAO();

		listePersonnels = personnelDAO.getAll();

		return listePersonnels;
	}

}
