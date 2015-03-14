package gemao.mysql;

import java.util.Calendar;

import fr.gemao.entity.Parametre;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ParametreDAO;

public class TestParametre {

	public static void main(String[] args) {
		ParametreDAO paDao = DAOFactory.getInstance().getParametreDAO();
		
		Parametre param = new Parametre(0, 52, 54, 55, 55, 55, 555, Calendar.getInstance().getTime());
		
		paDao.create(param);
		
		System.out.println(paDao.getLast());

	}

}
