package fr.gemao.sql.administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.administration.TypeDroit;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class TypeDroitDAO extends IDAO<TypeDroit> {

	public TypeDroitDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public TypeDroit create(TypeDroit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TypeDroit obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public TypeDroit update(TypeDroit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDroit get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDroit> getAll() {
		return null;
	}
	
	public void load(){

		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM typedroit;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				TypeDroit.put(NumberUtil.getResultInteger(result, "idType"), result.getString("nomType"));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
	}

	@Override
	protected TypeDroit map(ResultSet result) throws SQLException {
		throw new UnsupportedOperationException("Map de TypeDroit interdit");
	}

}
