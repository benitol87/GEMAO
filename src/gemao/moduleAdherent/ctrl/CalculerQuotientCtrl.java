package gemao.moduleAdherent.ctrl;

public class CalculerQuotientCtrl {

	public CalculerQuotientCtrl() {

	}

	/**
	 * Cette fonction permet de calculer
	 * 
	 * @param revenus
	 *            Les revenus du foyer (doit être supérieur à 0)
	 * @param nbPersFoyer
	 *            Le nombre de personnes du foyer (doit être supérieur à 0)
	 * @param nbEnfFoyer
	 *            Le nombre d'enfants du foyer (doit être supérieur à 0)
	 * @return Le quotient calculé
	 */
	public float calculerQuotient(float revenus, int nbPersFoyer, int nbEnfFoyer) {
		float alloc, quotient = 0;
		switch (nbEnfFoyer) {
		case 0:
		case 1:
			alloc = 0;
			break;
		case 2:
			alloc = 129; // getAlloc2 dans table parametre
			break;
		case 3:
			alloc = 295; // getAlloc3 dans table parametre
			break;
		case 4:
			alloc = 460; // getAlloc4 dans table parametre
			break;
		default:
			alloc = 626; // getAlloc5 dans table parametre
			break;
		}

		quotient = ((revenus / 12) + alloc) / nbPersFoyer;

		return quotient;
	}

}
