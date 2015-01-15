package fr.gemao.ctrl.adherent;

import javax.servlet.http.HttpServletRequest;

import fr.gemao.entity.Parametre;
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
	public float calculerQuotient(HttpServletRequest request) {
		float alloc, quotient = 0;
		
		DAOFactory co = DAOFactory.getInstance();
		ParametreDAO parametreDAO = co.getParametreDAO();
		Parametre param = new Parametre(parametreDAO.getLast());
		int nbPers = Integer.parseInt(request.getParameter("nbPers"));
		int nbEnfants = Integer.parseInt(request.getParameter("nbEnf"));
		float revenus = Float.parseFloat((request.getParameter("revenues")).replace(',', '.'));
		
		switch (nbEnfants) {
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

		quotient = ((revenus / 12) + alloc) / nbPers;

		return quotient;
	}

}
