package fr.gemao.ctrl;

import fr.gemao.entity.Personnel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonnelDAO;

public class ConnexionCtrl {

	private DAOFactory daoFactory;
	private PersonnelDAO personnelDAO;

	public ConnexionCtrl() {
		daoFactory = DAOFactory.getInstance();
		personnelDAO = daoFactory.getPersonnelDAO();
	}

	public Personnel controlerPersonnel(String login, String passwd) {
		if (login == null) {
			throw new IllegalArgumentException("Le login ne peut être null");
		}
		if (passwd == null) {
			throw new IllegalArgumentException("Le mot de passe ne peut être null");
		}

		Personnel personnel = personnelDAO.getLoginParPersonnel(login);

		if (personnel == null) {
			throw new IllegalArgumentException("Le login n'existe pas");
		}

		final String motDePassePersonnel = personnel.getPassword();

		boolean passwdIdentique = motDePassePersonnel.equals(passwd);

		if (!passwdIdentique) {
			throw new IllegalArgumentException(
					"Le mot de passe n'est pas valide");
		}

		return personnel;
	}
}
