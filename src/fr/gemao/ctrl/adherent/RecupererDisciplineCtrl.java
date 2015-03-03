package fr.gemao.ctrl.adherent;

import java.util.List;

import fr.gemao.entity.cours.Discipline;
import fr.gemao.entity.cours.Matiere;
import fr.gemao.entity.cours.Niveau;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.cours.DisciplineDAO;
import fr.gemao.sql.cours.MatiereDAO;
import fr.gemao.sql.cours.NiveauDAO;

public class RecupererDisciplineCtrl {
	
	public Discipline recupererDiscipline(int idDiscipline){
		DAOFactory factory = DAOFactory.getInstance();
		DisciplineDAO disciplineDAO = factory.getDisciplineDAO();
		return disciplineDAO.get(idDiscipline);
	}
	
	public Discipline recupererDiscipline(String matiere, String niveau){
		DAOFactory factory = DAOFactory.getInstance();
		DisciplineDAO disciplineDAO = factory.getDisciplineDAO();
		MatiereDAO matiereDAO = factory.getMatiereDAO();
		NiveauDAO niveauDAO = factory.getNiveauDAO();
		Matiere mat = matiereDAO.get(matiere);
		Niveau niv = niveauDAO.get(niveau);
		Discipline discipline = new Discipline(null, mat, niv, null);
		return disciplineDAO.exist(discipline);
	}

	public List<Discipline> recupererAllDiscipline(){
		List<Discipline> list;
		DisciplineDAO disciplineDao = DAOFactory.getInstance().getDisciplineDAO();
		list = disciplineDao.getAll();
		return list;
	}
}
