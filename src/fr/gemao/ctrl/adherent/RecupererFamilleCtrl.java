package fr.gemao.ctrl.adherent;

import java.util.List;

import fr.gemao.entity.adherent.Famille;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.FamilleDAO;

public class RecupererFamilleCtrl {

	public static List<Famille> recupererAllFamille() {
		List<Famille> list;
		FamilleDAO familleDAO = DAOFactory.getInstance().getFamilleDAO();
		list = familleDAO.getAll();
		return list;
	}
}
