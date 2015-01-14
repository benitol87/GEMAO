package fr.gemao.sql;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Personne;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.DateUtil;
import fr.gemao.sql.util.NumberUtil;


public class PersonneDAO extends IDAO<Personne> {

	public PersonneDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Personne create(Personne obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}

		long id = 0;
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO personne(idAdresse, idCommuneNaiss, nom, prenom,"
				+ "	dateNaissance, tel_fixe, tel_port, email)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, true, 
			obj.getIdAdresse(),
			obj.getIdCommuneNaiss(),
			obj.getNom(),
			obj.getPrenom(),
			DateUtil.toSqlDate(obj.getDateNaissance()),
			obj.getTelFixe(),
			obj.getTelPort(),
			obj.getEmail());
			
			int status = requete.executeUpdate();
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création de la personne, aucune ligne ajoutée dans la table." );
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
	public void delete(Personne obj) {
		/*if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
		
		if (obj.getIdPersonne() == 0) {
			throw new NullPointerException("La personne ne peut pas avoir un id = 0");
		}
		
		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
										ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM personne WHERE idPersonne = " + obj.getIdPersonne() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stat != null ){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}*/
		throw new UnsupportedOperationException("Vous n'avez pas le droit de supprimer une Personne.");
	}

	@Override
	public Personne update(Personne obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "UPDATE personne SET idAdresse = ?, idCommuneNaiss = ?, nom = ?, "
				+ "prenom = ?, dateNaissance = ?, tel_fixe = ?, tel_port = ?, "
				+ "email = ?"
				+ "WHERE idPersonne = ?;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, true, 
					obj.getIdAdresse(),
					obj.getIdCommuneNaiss(),
					obj.getNom(),
					obj.getPrenom(),
					new Date(obj.getDateNaissance().getTime()),
					obj.getTelFixe(),
					obj.getTelPort(),
					obj.getEmail(),
					obj.getIdPersonne());
			int status = requete.executeUpdate();
			
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la mise à jour de la personne, aucune ligne ajoutée dans la table." );
	        }

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(obj.getIdPersonne());
	}

	@Override
	public Personne get(long id) {
		Personne personne = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM personne WHERE idPersonne = ?;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				personne = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return personne;
	}

	@Override
	public List<Personne> getAll() {
		List<Personne> liste = new ArrayList<>();

		Personne personne = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM personne order by nom, prenom;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				personne = this.map(result);
				liste.add(personne);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	@Override
	protected Personne map(ResultSet result) throws SQLException {
		
		return new Personne(Long.valueOf(result.getInt("idPersonne")),
				NumberUtil.getResultLong(result, "idAdresse"),
				NumberUtil.getResultLong(result, "idCommuneNaiss"),
				result.getString("nom"), 
				result.getString("prenom"),
				result.getDate("dateNaissance"),
				result.getString("tel_fixe"),
				result.getString("tel_port"),
				result.getString("email"));
	}

}
