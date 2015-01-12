package gemao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMySql {
	
	private static String url = "jdbc:mysql://";
	private static String host = "localhost";
	private static String base = "gemao";
	private static String user = "anacrous";
	private static String pasword = "Gemao@87!";
	
	private static Connection co;
	
	private ConnectionMySql(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = ConnectionMySql.url + ConnectionMySql.host + "/" + ConnectionMySql.base;  
			ConnectionMySql.co = DriverManager.getConnection(URL, ConnectionMySql.user, ConnectionMySql.pasword);
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
