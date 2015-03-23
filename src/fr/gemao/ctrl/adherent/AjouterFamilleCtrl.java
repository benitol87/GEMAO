package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.Famille;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.FamilleDAO;

public class AjouterFamilleCtrl {

	public static Famille AjouterFamile( Famille famille){
		Famille fam;
		FamilleDAO familleDAO = DAOFactory.getInstance().getFamilleDAO();
		
		fam = familleDAO.exits(famille);
		if (fam==null){
			famille = familleDAO.create(famille);
			return famille;
		} else {
			return fam;
		}
	}
}
