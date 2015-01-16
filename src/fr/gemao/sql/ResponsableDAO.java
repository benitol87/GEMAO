package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class ResponsableDAO extends IDAO<Responsable> {

	public ResponsableDAO(DAOFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Responsable create(Responsable obj) {
		if (obj == null) {
			throw new NullPointerException(
					"Le responsable ne doit pas etre null");
		}

		long id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO responsable(idResponsable, nom, prenom, tel, email)"
				+ "VALUES (?, ?, ?, ?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getIdResponsable(), obj.getNom(),
					obj.getPrenom(), obj.getTelephone(), obj.getEmail());
			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création d'un responsable, aucune ligne ajoutée dans la table.");
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
	public void delete(Responsable obj) {
		if (obj == null) {
			throw new NullPointerException(
					"Le responsable ne doit pas etre null");
		}

		if (obj.getIdResponsable() == 0) {
			throw new NullPointerException(
					"Le responsable ne peut pas avoir un id = 0");
		}

		Connection connexion = null;
		Statement stat = null;
		try {
			connexion = factory.getConnection();
			stat = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM responsable WHERE idEtat = "
					+ obj.getIdResponsable() + ";");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(stat, connexion);
		}
	}

	@Override
	public Responsable update(Responsable obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsable get(long id) {
		Responsable responsable = null;

		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM responsable WHERE idResponsable = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				responsable = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return responsable;
	}

	@Override
	public List<Responsable> getAll() {
		List<Responsable> liste = new ArrayList<>();

		Responsable responsable = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM responsable;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				responsable = this.map(result);
				liste.add(responsable);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	public Responsable exist(Responsable responsable) {
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * from responsable where nom = ? and prenom = ?"
				+ " and tel = ? and email = ?";
		Responsable verif = null;
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, responsable.getNom(), responsable.getPrenom(),
					responsable.getTelephone(), responsable.getEmail());
			result = requete.executeQuery();

			if (result.first()) {
				verif = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return verif;
	}

	@Override
	protected Responsable map(ResultSet result) throws SQLException {
		return new Responsable(result.getLong("idResponsable"),
				result.getString("nom"), result.getString("prenom"),
				result.getString("tel"), result.getString("email"));
	}

}
