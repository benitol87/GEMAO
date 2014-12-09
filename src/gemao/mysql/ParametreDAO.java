package gemao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import gemao.entity.Parametre;
import gemao.mysql.DAOMySql;

public class ParametreDAO extends DAOMySql<Parametre> {

	public ParametreDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Parametre create(Parametre obj) {
		// TODO Auto-generated method stub
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
		
		PreparedStatement requete = null;
		ResultSet result = null;
		try{
			String sql = "SELECT * FROM parametre "
					+ "WHERE dateModif >= ALL(Select dateModif FROM Parametre);";
			requete = this.connect.prepareStatement(sql);
			result = requete.executeQuery();
			if(result.first()){
				parametre = new Parametre(result.getLong("idParam"), 
						result.getFloat("alloc2"), 
						result.getFloat("alloc3"), 
						result.getFloat("alloc4"), 
						result.getFloat("alloc5"), 
						result.getFloat("qf_min"),
						result.getFloat("qf_max"), 
						result.getDate("dateModif"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (requete != null) {
				try {
					if (result != null) {
						result.close();
					}
					requete.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return parametre;
	}

}
