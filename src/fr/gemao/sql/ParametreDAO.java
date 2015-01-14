package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.gemao.entity.Parametre;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class ParametreDAO extends IDAO<Parametre> {

	public ParametreDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Parametre create(Parametre obj) {
		
		return null;
	}

	@Override
	public void delete(Parametre obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parametre update(Parametre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parametre get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parametre> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Retourne les derniers paramètres. 
	 * @return paramètres actuels
	 */
	public Parametre getLast(){
		Parametre parametre = null;
		Connection connection = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM parametre "
				+ "WHERE dateModif >= ALL(Select dateModif FROM Parametre);";
		try{
			connection = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connection, sql, false);
			result = requete.executeQuery();
			if(result.first()){
				parametre = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connection);
		}
		return parametre;
	}

	@Override
	protected Parametre map(ResultSet result) throws SQLException {
		return new Parametre(result.getLong("idParam"), 
				result.getFloat("alloc2"), 
				result.getFloat("alloc3"), 
				result.getFloat("alloc4"), 
				result.getFloat("alloc5"), 
				result.getFloat("qf_min"),
				result.getFloat("qf_max"), 
				result.getDate("dateModif"));
	}

}
