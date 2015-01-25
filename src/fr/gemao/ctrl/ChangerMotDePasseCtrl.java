package fr.gemao.ctrl;

import fr.gemao.entity.Personnel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonnelDAO;
import fr.gemao.util.Password;

public class ChangerMotDePasseCtrl {
	private DAOFactory daoFactory;
	private PersonnelDAO personnelDAO;

	public ChangerMotDePasseCtrl() {
		daoFactory = DAOFactory.getInstance();
		personnelDAO = daoFactory.getPersonnelDAO();
	}

	public boolean controlerMotDePasse(String login, String passwd) {
		if (login == null) {
			throw new IllegalArgumentException("Le login ne peut être null");
		}
		if (passwd == null) {
			throw new IllegalArgumentException("Le mot de passe ne peut être null");
		}

		Personnel personnel = personnelDAO.getLoginParPersonnel(login);

		// Si le login n'a pas été trouvé dans la base de données
		if (personnel == null) {
			return false;
		}

		return Password.compare(passwd, personnel.getPassword());
	}
	
	public boolean changerMotDePasse(String login, String nouveauMotDePasse){
		Personnel personnel = personnelDAO.getLoginParPersonnel(login);
		personnel.setPassword(nouveauMotDePasse);
		
		return personnelDAO.update(personnel)!=null;
	}
}
