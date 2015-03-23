package fr.gemao.ctrl.adherent;

import java.util.List;

import fr.gemao.entity.adherent.Famille;
import fr.gemao.entity.cours.Discipline;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.FamilleDAO;
import fr.gemao.sql.cours.DisciplineDAO;

public class RecupererFamilleCtrl {

	public static List<Famille> RecupererAllFamille(){
		List<Famille> list;
		FamilleDAO familleDAO = DAOFactory.getInstance().getFamilleDAO();
		list = familleDAO.getAll();
		return list;
	}
}
