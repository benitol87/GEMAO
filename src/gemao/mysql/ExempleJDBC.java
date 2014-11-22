package gemao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExempleJDBC {
	private static final String NOM_BASE = "gemao", 
			HOTE = "localhost",
			LOGIN = "root",
			PASSWD = "";
	
	public static void main(String args[]) {
		Connection con = null;

		String connectionURL = "jdbc:mysql://"+HOTE+"/"+NOM_BASE+"?"
	            + "user="+LOGIN+"&password="+PASSWD;
		// Change the connection string according to your db, ip, username and
		// password

		try {

			// Load the Driver class.
			Class.forName("com.mysql.jdbc.Driver");
			// If you are using any other database then load the right driver
			// here.

			// Create the connection using the static getConnection method
			con = DriverManager.getConnection(connectionURL);

			// Create a Statement class to execute the SQL statement
			Statement stmt = con.createStatement();

			// Execute the SQL statement and get the results in a Resultset
			ResultSet rs = stmt
					.executeQuery("SELECT idEtat, libelle from "+NOM_BASE+".etat");

			// Iterate through the ResultSet, displaying two values
			// for each row using the getString method

			while (rs.next())
				System.out.println("ID= " + rs.getString("idEtat")
						+ " lib= " + rs.getString("libelle"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connection
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
