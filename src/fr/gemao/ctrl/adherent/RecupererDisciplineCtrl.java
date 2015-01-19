package fr.gemao.ctrl.adherent;

import java.util.List;

import fr.gemao.entity.Discipline;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.DisciplineDAO;

public class RecupererDisciplineCtrl {
	
	public Discipline recupererDiscipline(int idDiscipline){
		DAOFactory factory = DAOFactory.getInstance();
		DisciplineDAO disciplineDAO = factory.getDisciplineDAO();
		return disciplineDAO.get(idDiscipline);
	}
	
	public Discipline recupererDiscipline(String nom){
		DAOFactory factory = DAOFactory.getInstance();
		DisciplineDAO disciplineDAO = factory.getDisciplineDAO();
		return disciplineDAO.get(nom);
	}

	public List<Discipline> recupererAllDiscipline(){
		List<Discipline> list;
		DisciplineDAO disciplineDao = DAOFactory.getInstance().getDisciplineDAO();
		list = disciplineDao.getAll();
		return list;
	}
}
