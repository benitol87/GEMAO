package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Adresse;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class AdresseDAO extends IDAO<Adresse> {

	public AdresseDAO(DAOFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Adresse create(Adresse obj) {
		if (obj == null) {
			throw new NullPointerException(
					"Le responsable ne doit pas etre null");
		}

		long id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO adresse(idCommune, numRue, nomRue, infoCompl)"
				+ "VALUES (?, ?, ?, ?);";
		try {

			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getIdCommune(), obj.getNumRue(),
					obj.getNomRue(), obj.getInfoCompl());
			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création d'une adresse, aucune ligne ajoutée dans la table.");
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
	public void delete(Adresse obj) {
		if (obj == null) {
			throw new NullPointerException("L'adresse ne doit pas etre null");
		}

		Connection connexion = null;
		Statement stat = null;
		try {
			connexion = factory.getConnection();
			stat = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM adresse WHERE idAdresse = "
					+ obj.getIdAdresse() + ";");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(stat, connexion);
		}
	}

	@Override
	public Adresse update(Adresse obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse get(long id) {
		Adresse adresse = null;

		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM adresse WHERE idAdresse = ?;";
		try {

			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				adresse = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return adresse;
	}

	@Override
	public List<Adresse> getAll() {
		List<Adresse> liste = new ArrayList<>();

		Adresse adresse = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM adresse;";
		try {

			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				adresse = this.map(result);
				liste.add(adresse);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	@Override
	protected Adresse map(ResultSet result) throws SQLException {
		return new Adresse(result.getInt("idAdresse"),
				result.getInt("idCommune"), result.getInt("numRue"),
				result.getString("nomRue"), result.getString("infoCompl"));
	}

}