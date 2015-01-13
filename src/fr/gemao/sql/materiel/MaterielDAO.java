package fr.gemao.sql.materiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.materiel.Materiel;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.EtatDAO;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class MaterielDAO extends IDAO<Materiel> {

	public MaterielDAO(DAOFactory conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Materiel create(Materiel obj) {
		if (obj == null) {
			throw new NullPointerException("Le materiel ne doit pas �tre null");
		}

		long id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO Materiel(idMateriel," + "idEtat,"
				+ "idCategorie," + "idMarque," + "idDesignation,"
				+ "typeMateriel," + "numSerie," + "dateAchat,"
				+ "valeurAchat," + "valeurReapprov," + "deplaceConcert,"
				+ "observations)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, true, 
			obj.getIdMateriel(),
			obj.getEtat().getIdEtat(),
			obj.getCategorie().getIdCategorie(),
			obj.getMarque().getIdMarque(),
			obj.getDesignation().getIdDesignation(),
			obj.getTypeMat(),
			obj.getNumSerie(),
			obj.getDateAchat(),
			obj.getValeurAchat(),
			obj.getValeurReap(),
			obj.isDeplacable(),
			obj.getObservation());
			
			int status = requete.executeUpdate();
			
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création de matériel, aucune ligne ajoutée dans la table." );
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
	public void delete(Materiel obj) {
		if (obj == null) {
			throw new NullPointerException("Le materiel ne doit pas �tre null");
		}

		if (obj.getIdMateriel() == 0) {
			throw new NullPointerException(
					"Le materiel ne peut pas avoir un id = 0");
		}

		Connection connexion = null;
		Statement stat = null;
		try {
			stat = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM Materiel WHERE idMateriel = "
					+ obj.getIdMateriel() + ";");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (stat != null) {
				DAOUtilitaires.fermeturesSilencieuses(stat, connexion);
			}
		}

	}

	@Override
	public Materiel update(Materiel obj) {
		if (obj == null) {
			throw new NullPointerException("Le Materiel ne doit pas etre nul");
		}
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "UPDATE Materiel SET idEtat = ?,idCategorie = ?,idMarque =?,idDesignation =?,valeurReapprov=?,observation = ?"
				+ "WHERE idmateriel = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false,
					obj.getEtat().getIdEtat(),
					obj.getCategorie().getIdCategorie(),
					obj.getMarque().getIdMarque(),
					obj.getDesignation().getIdDesignation(),
					obj.getValeurReap(),
					obj.getObservation()
					);
			
			requete.executeUpdate();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return this.get(obj.getIdMateriel());
	}

	@Override
	public Materiel get(long id) {
		Materiel materiel = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM Materiel WHERE idMateriel = ?;";
		try {
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				materiel = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return materiel;
	}

	@Override
	public List<Materiel> getAll() {
		List<Materiel> liste = new ArrayList<>();

		Materiel materiel = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM materiel;";
		try {
			
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				materiel = this.map(result);
				liste.add(materiel);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	@Override
	protected Materiel map(ResultSet result) throws SQLException {
		return new Materiel(result.getLong("idMateriel"),
				factory.getEtatDAO().get(result.getInt("idEtat")),
				factory.getCategorieDAO().get(result.getInt("idCategorie")),
				factory.getMarqueDAO().get(result.getInt("idMarque")),
				factory.getDesignationDAO().get(result.getInt("idDesignation")),
				result.getString("typeMateriel"),
				result.getLong("numSerie"),
				result.getDate("dateAchat"),
				result.getFloat("valeurAchat"),
				result.getFloat("ValeurReapprov"),
				result.getBoolean("deplaceConcert"),
				result.getString("observation"));
	}

}
