package fr.gemao.ctrl;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Commune;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;

public class CommuneCtrl {

	public CommuneCtrl() {

	}

	public ArrayList<String> getListNomCommune() {
		DAOFactory factory = DAOFactory.getInstance();
		CommuneDAO commuenDAO = factory.getCommuneDAO();

		List<Commune> listCommune = commuenDAO.getAll();
		ArrayList<String> nomCommune = new ArrayList<>();

		for (Commune c : listCommune) {
			// Pour être directement ajouté dans les jsp
			nomCommune.add(c.getNomCommune());
		}

		return nomCommune;
	}

	public List<Commune> getListCommunes() {
		DAOFactory factory = DAOFactory.getInstance();
		CommuneDAO commuenDAO = factory.getCommuneDAO();

		return commuenDAO.getAll();
	}

}
