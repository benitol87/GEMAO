package fr.gemao.ctrl;

import java.util.List;

import fr.gemao.entity.Adresse;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.DAOFactory;

public class AdresseCtrl {

	private AdresseCtrl() {
	}

	public static List<Adresse> getListAdresses() {
		DAOFactory factory = DAOFactory.getInstance();
		AdresseDAO adresseDAO = factory.getAdresseDAO();

		return adresseDAO.getAll();
	}
}
