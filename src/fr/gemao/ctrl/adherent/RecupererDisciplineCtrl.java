package fr.gemao.ctrl.adherent;

import java.util.List;

import fr.gemao.entity.Discipline;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.DisciplineDAO;

public class RecupererDisciplineCtrl {

	public List<Discipline> recupererAllDiscipline(){
		List<Discipline> list;
		DisciplineDAO disciplineDao = DAOFactory.getInstance().getDisciplineDAO();
		list = disciplineDao.getAll();
		return list;
	}
}
