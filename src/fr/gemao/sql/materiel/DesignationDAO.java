package fr.gemao.sql.materiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.materiel.Designation;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class DesignationDAO extends IDAO<Designation> {
	public DesignationDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Designation create(Designation obj) {
		if (obj == null) {
			throw new NullPointerException(
					"La designation ne doit pas etre null");
		}

		long id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;

		String sql = "INSERT INTO designation(idDesignation, libelle)"
				+ "VALUES (?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, obj.getIdDesignation(),
					obj.getLibelleDesignation());

			int status = requete.executeUpdate();
			if (status == 0) {
				throw new DAOException(
						"Échec de la création de la designation, aucune ligne ajoutée dans la table.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(id);
	}

	@Override
	public void delete(Designation obj) {
		Connection connexion = null;
		ResultSet result = null;
		if (obj == null) {
			throw new NullPointerException(
					"La designation ne doit pas etre null");
		}

		if (obj.getIdDesignation() <= 0) {
			throw new IllegalArgumentException(
					"La designation ne peut pas avoir un id <= 0");
		}

		PreparedStatement stat = null;
		try {
			connexion = factory.getConnection();
			String sql = "DELETE FROM designation WHERE idDesignation = "
					+ obj.getIdDesignation();
			stat = DAOUtilitaires.initialisationRequetePreparee(connexion, sql,
					false);
			
			int status = stat.executeUpdate();
			if (status == 0) {
				throw new DAOException(
						"Échec de la suppression de la Designation, aucune modification dans la table.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, stat, connexion);
		}


	}

	@Override
	public Designation update(Designation obj) {
		if (obj == null) {
			throw new NullPointerException("La Designation ne doit pas etre nul");
		}

		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "UPDATE Designation SET libelle = ?"
				+ "WHERE idDesignation = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false,
					obj.getLibelleDesignation(),
					obj.getIdDesignation());
			requete.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return this.get(obj.getIdDesignation());
	}

	@Override
	public Designation get(long id) {
		Designation designation = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM designation WHERE idDesignation = ?;";
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				designation = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return designation;
	}

	@Override
	public List<Designation> getAll() {
		List<Designation> liste = new ArrayList<>();
		Connection connexion = null;
		Designation designation = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM designation;";
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				designation = this.map(result);
				liste.add(designation);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	@Override
	protected Designation map(ResultSet result) throws SQLException {
		return new Designation(result.getInt("idDesignation"),
				result.getString("libelle"));
	}
}
