package fr.gemao.ctrl.adherent;

import java.util.List;

import fr.gemao.entity.adherent.MotifSortie;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.MotifSortieDAO;

public class RecupererMotifSortieCtrl {
		
	public MotifSortie recupererMotifSortie(int idMotifSortie){
		DAOFactory factory = DAOFactory.getInstance();
		MotifSortieDAO motifSortieDAO = factory.getMotifSortieDAO();
		return motifSortieDAO.get(idMotifSortie);
	}
	
	/*public MotifSortie recupererMotifSortie(String libelle){
		DAOFactory factory = DAOFactory.getInstance();
		MotifSortieDAO motifSortieDAO = factory.getMotifSortieDAO();
		return motifSortieDAO.get(libelle);
	}*/

	public List<MotifSortie> recupererAllMotifSortie(){
		List<MotifSortie> list;
		MotifSortieDAO motifSortieDAO = DAOFactory.getInstance().getMotifSortieDAO();
		list = motifSortieDAO.getAll();
		return list;
	}
}
