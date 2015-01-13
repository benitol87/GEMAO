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

		Personnel personnel = personnelDAO.getLoginParPersonnel(login);

		if (personnel == null) {
			throw new IllegalArgumentException("Le personnel ne peut être null");
		}

		final String motDePassePersonnel = personnel.getPassword();

		boolean passwdIdentique = motDePassePersonnel.equals(passwd);

		if (!passwdIdentique) {
			throw new IllegalArgumentException("Le mot de passe est différent");
		}

		return personnel;
	}
}
