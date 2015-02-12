package gemao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.exception.DAOConfigurationException;

public class TestConnection {

	public static void main(String[] args) throws DAOConfigurationException, SQLException {
		final Connection co = DAOFactory.getInstance().getConnection();
		
		Statement stmt;
		try {
			// Create a Statement class to execute the SQL statement
			stmt = co.createStatement();
			// Execute the SQL statement and get the results in a Resultset
			ResultSet rs = stmt.executeQuery("SELECT idEtat, libelle from "
					 + "etat");

			// Iterate through the ResultSet, displaying two values
			// for each row using the getString method

			while (rs.next())
				System.out.println("ID= " + rs.getString("idEtat") + " lib= "
						+ rs.getString("libelle"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
