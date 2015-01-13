package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Responsabilite;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class ResponsabiliteDAO extends IDAO<Responsabilite> {
	
	public ResponsabiliteDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Responsabilite create(Responsabilite obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Responsabilite obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Responsabilite update(Responsabilite obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsabilite get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Responsabilite> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Responsabilite map(ResultSet result) throws SQLException {
		
		return new Responsabilite(result.getInt("idResponsabilite"), result.getString("libelle"));
	}
	
	public List<Responsabilite> getResponsabilitesParPersonne(Long idPersonne) {
		Connection co = null;
		PreparedStatement state = null;
		ResultSet result = null;
		Responsabilite responsabilite = null;
		List<Responsabilite> liste = new ArrayList<Responsabilite>();
		
		String sql = "SELECT * FROM responsabilite WHERE idPersonne = ?;";
		
		try {
			co = factory.getConnection();
			state = DAOUtilitaires.initialisationRequetePreparee(co, sql, false, idPersonne);
			result = state.executeQuery();
			
			while (result.next()) {
				responsabilite = this.map(result);
				liste.add(responsabilite);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, state, co);
		}
		
		
		return liste;
	}
}