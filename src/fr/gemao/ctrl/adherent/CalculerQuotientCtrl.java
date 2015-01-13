package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Parametre;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ParametreDAO;

public class CalculerQuotientCtrl {

	public CalculerQuotientCtrl() {

	}

	/**
	 * Cette fonction permet de calculer
	 * 
	 * @param revenus
	 *            Les revenus du foyer (doit �tre sup�rieur � 0)
	 * @param nbPersFoyer
	 *            Le nombre de personnes du foyer (doit �tre sup�rieur � 0)
	 * @param nbEnfFoyer
	 *            Le nombre d'enfants du foyer (doit �tre sup�rieur � 0)
	 * @return Le quotient calcul�
	 */
	public float calculerQuotient(float revenus, int nbPersFoyer, int nbEnfFoyer) {
		float alloc, quotient = 0;
		
		DAOFactory factory = DAOFactory.getInstance();
		ParametreDAO parametreDAO = factory.getParametreDAO();
		Parametre param = new Parametre(parametreDAO.getLast());
		
		switch (nbEnfFoyer) {
		case 0:
		case 1:
			alloc = 0;
			break;
		case 2:
			alloc = param.getAlloc2();
			break;
		case 3:
			alloc = param.getAlloc3();
			break;
		case 4:
			alloc = param.getAlloc4();
			break;
		default:
			alloc = param.getAlloc5();
			break;
		}

		quotient = ((revenus / 12) + alloc) / nbPersFoyer;

		return quotient;
	}

}
