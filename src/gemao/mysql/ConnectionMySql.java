package gemao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
	private final static String URL = "jdbc:mysql://localhost/ProjetTut?user=root&password=devsql";

	private static Connection co;
	
	private ConnectionMySql(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ConnectionMySql.co = DriverManager.getConnection(ConnectionMySql.URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Retourne une instance de Connection avec la base de donn�e.
	 * @return Connection avec la BD.
	 */
	public static Connection getInstance(){
		if(co == null){
			new ConnectionMySql();
		}      
		return co;
	}

}
