package fr.gemao.ctrl.adherent;

import fr.gemao.ctrl.ParametreCtrl;
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
		
		ParametreCtrl parametreCtrl = new ParametreCtrl();
		Parametre parametre = parametreCtrl.getLast();
		float cotisation = parametre.getTarifFormation();
		
		if(qf != null){
			//si on applique le quotient familial (habitants des communes bénéficiaires des avantages)
			if (parametre.getQf_min()>qf)
				return cotisation/2;
			if (parametre.getQf_max()>qf)
				return cotisation/1.5F;		
		}

		return cotisation;
	}

}
