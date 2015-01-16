package fr.gemao.ctrl;

import fr.gemao.entity.TypeContrat;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.TypeContratDAO;

public class TypeContratCtrl {

	public TypeContrat recupererTypeContrat(TypeContrat typeContrat){
		DAOFactory co = DAOFactory.getInstance();
		TypeContratDAO typeContratDAO = co.getTypeContratDAO();
		
		return typeContratDAO.exist(typeContrat);
	}
}
