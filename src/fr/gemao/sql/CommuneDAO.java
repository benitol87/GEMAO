package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class CommuneDAO extends IDAO<Commune> {

	public CommuneDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Commune create(Commune obj) {
		if (obj == null) {
			throw new NullPointerException("La commune ne doit pas être null");
		}

		long id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO commune(codePostal, nomCommune, avantage)"
				+ "VALUES (?, ?, ?);";
		try {

			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getCodePostal(), obj.getIdCommune(),
					obj.isAvantage());
			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création d'une commune, aucune ligne ajoutée dans la table.");
			}

			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getLong(1);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(id);
	}

	@Override
	public void delete(Commune obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commune update(Commune obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commune get(long id) {
		Commune commune = null;

		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM commune WHERE idCommune = ?;";
		try {

			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				commune = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return commune;
	}

	@Override
	public List<Commune> getAll() {
		List<Commune> liste = new ArrayList<>();

		Commune commune = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM commune;";
		try {

			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				commune = this.map(result);
				liste.add(commune);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}
	
	public boolean exist(Commune commune){
		return true;
	}

	@Override
	protected Commune map(ResultSet result) throws SQLException {
		return new Commune(result.getInt("idCommune"),
				result.getInt("codePostal"), result.getString("nomCommune"),
				result.getBoolean("avantage"));
	}

}
