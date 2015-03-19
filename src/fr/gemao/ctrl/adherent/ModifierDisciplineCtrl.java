package fr.gemao.ctrl.adherent;

import fr.gemao.entity.cours.Discipline;
import fr.gemao.entity.cours.Matiere;
import fr.gemao.entity.cours.Niveau;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.cours.DisciplineDAO;
import fr.gemao.sql.cours.MatiereDAO;
import fr.gemao.sql.cours.NiveauDAO;

public class ModifierDisciplineCtrl {
	
	public static boolean modifierDiscipline(Discipline discipline){
		
		DAOFactory co = DAOFactory.getInstance();
		DisciplineDAO disciplineDAO = co.getDisciplineDAO();
		NiveauDAO niveauDAO = co.getNiveauDAO();
		MatiereDAO matiereDAO = co.getMatiereDAO();
		
		Matiere matiere = matiereDAO.exist(discipline.getMatiere());
		if(matiere == null)
			matiere = matiereDAO.create(discipline.getMatiere());
		discipline.setMatiere(matiere);
		
		Niveau niveau = niveauDAO.exist(discipline.getNiveau());
		if(niveau == null)
			niveau = niveauDAO.create(discipline.getNiveau());
		discipline.setNiveau(niveau);
		
		Discipline disc = disciplineDAO.exist(discipline);
		if(disc==null){
			discipline = disciplineDAO.update(discipline);
			return true;
		} else {
			return false;
		}
	}

}
