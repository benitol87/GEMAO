package gemao.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.exception.DAOConfigurationException;

public class TestPoolConnexion {
	public static void main(String[] args) throws DAOConfigurationException, SQLException {
		Connection co = DAOFactory.getInstance().getConnection();
	}
}
