package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.gemao.entity.Contrat;
import fr.gemao.entity.TypeContrat;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class TypeContratDAO extends IDAO<TypeContrat> {

	public TypeContratDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public TypeContrat create(TypeContrat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TypeContrat obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public TypeContrat update(TypeContrat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeContrat get(long id) {
		TypeContrat type = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM typecontrat WHERE idTypeContrat = ?;";
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				type = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return type;
	}

	@Override
	public List<TypeContrat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TypeContrat map(ResultSet result) throws SQLException {
		return new TypeContrat(NumberUtil.getResultInteger(result,
				"idMotifContrat"), result.getString("libelle"));
	}

}
