package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.gemao.entity.Contrat;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class ContratDAO extends IDAO<Contrat> {

	public ContratDAO(DAOFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contrat create(Contrat obj) {
		if (obj == null) {
			throw new NullPointerException("Le contrat ne doit pas etre null");
		}

		int id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;

		String sql = "INSERT INTO contrat(idTypeContrat, idMotifFin, dateDebut, dateFin, dateRupture)"
				+ "VALUES (?, ?, ?, ?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getTypeContrat(), obj.getIdMotifContrat(),
					obj.getDateDebut(), obj.getDateFin(), obj.getDateRupture());

			int status = requete.executeUpdate();
			if (status == 0) {
				throw new DAOException(
						"Échec de la création du contrat, aucune ligne ajoutée dans la table.");
			}
			
			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getInt(1);
				obj.setIdContrat(id);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return obj;
	}

	@Override
	public void delete(Contrat obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contrat update(Contrat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrat get(long id) {
		Contrat contrat = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM contrat WHERE idContrat = ?;";
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				contrat = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return contrat;
	}

	@Override
	public List<Contrat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Contrat map(ResultSet result) throws SQLException {
		Contrat contrat = new Contrat();
		contrat.setIdContrat(NumberUtil.getResultInteger(result, "idContrat"));
		contrat.setDateDebut(result.getDate("dateDebut"));
		contrat.setDateFin(result.getDate("dateFin"));
		contrat.setDateRupture(result.getDate("dateRupture"));
		contrat.setIdMotifContrat(result.getInt("idMotifFin"));
		contrat.setTypeContrat(result.getInt("idTypeContrat"));
		return contrat;
	}

}
