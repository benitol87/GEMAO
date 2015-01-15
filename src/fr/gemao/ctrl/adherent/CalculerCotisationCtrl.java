package fr.gemao.ctrl.adherent;

import fr.gemao.entity.Parametre;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ParametreDAO;

public class CalculerCotisationCtrl {
	
	/**
	 * Constructeur
	 */
	public CalculerCotisationCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Méthode permettant de calculer le montant des cotisations selon le quotient familial
	 * @param qf
	 * @return montant des cotisations
	 */
	public float calculerCotisations(Float qf){
		
		DAOFactory factory = DAOFactory.getInstance();
		ParametreDAO parametreDAO = factory.getParametreDAO();
		Parametre param = new Parametre(parametreDAO.getLast());
		
		float cotisation = 200.0F; // param.getCotisation a ajouté dans la base
		
		if (param.getQf_min()>qf)
			return cotisation/2;
		if (param.getQf_max()>qf)
			return cotisation/1.5F;		
		return cotisation;
	}

}
