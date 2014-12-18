package gemao.moduleAdherent.ctrl;

import java.sql.Connection;

import gemao.entity.Parametre;
import gemao.mysql.ConnectionMySql;
import gemao.mysql.ParametreDAO;

public class CalculerCotisationCtrl {
	
	public CalculerCotisationCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	public float calculerCotisations(Float qf){
		Connection co = ConnectionMySql.getInstance();
		ParametreDAO parametreDAO = new ParametreDAO(co);
		Parametre param = new Parametre(parametreDAO.getLast());
		
		float cotisation = 200.0F; // param.getCotisation a ajouté dans la base
		
		if (param.getQf_min()>qf)
			return cotisation/2;
		if (param.getQf_max()>qf)
			return cotisation/1.5F;		
		return cotisation;
	}

}
