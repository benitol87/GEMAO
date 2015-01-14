package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.DateUtil;
import fr.gemao.sql.util.NumberUtil;

public class AdherentDAO extends IDAO<Adherent>{

	public AdherentDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Adherent create(Adherent obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas être null");
		}
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO adherent(idPersonne, idMotifSortie, idResponsable, droitImage,"
				+ "	dateEntree, dateSortie, qf, cotisation)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false,
					obj.getIdPersonne(),
					obj.getIdMotif(),
					obj.getIdResponsable(),
					(obj.isDroitImage()?1:0),
					DateUtil.toSqlDate(obj.getDateEntree()),
					DateUtil.toSqlDate(obj.getDateSortie()),
					obj.getQf(),
					obj.getCotisation());
			
			int status = requete.executeUpdate();
			
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création de l'adhérent, aucune ligne ajoutée dans la table." );
	        }

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(obj.getIdPersonne());
	}

	@Override
	public void delete(Adherent obj) {
		
	}

	@Override
	public Adherent update(Adherent obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "UPDATE adherent SET idMotifSortie = ?, idResponsable = ?, droitImage = ?, "
				+ "dateEntree = ?, dateSortie = ?, qf = ?, cotisation = ? "
				+ "WHERE idPersonne = ?;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, 
					obj.getIdMotif(),
					obj.getIdResponsable(),
					(obj.isDroitImage()?1:0),
					DateUtil.toSqlDate(obj.getDateEntree()),
					DateUtil.toSqlDate(obj.getDateSortie()),
					obj.getQf(),
					obj.getCotisation(),
					obj.getIdPersonne());
			requete.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(obj.getIdPersonne());
	}

	@Override
	public Adherent get(long id) {
		Adherent adherent = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM adherent a inner join personne p on a.idPersonne=p.idPersonne WHERE idPersonne = ?;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				adherent = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return adherent;
	}

	@Override
	public List<Adherent> getAll() {
		List<Adherent> liste = new ArrayList<>();

		Adherent adherent = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM adherent a inner join personne p on a.idPersonne=p.idPersonne order by nom, prenom;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false);
			result = requete.executeQuery();
			
			while (result.next()) {
				adherent = this.map(result);
				liste.add(adherent);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	@Override
	public Adherent map(ResultSet result) throws SQLException {
		PersonneDAO personneDAO = factory.getPersonneDAO();
		Adherent adherent = new Adherent(personneDAO.map(result), NumberUtil.getResultInteger(result,
				"idMotifSortie"),
				NumberUtil.getResultLong(result, "idResponsable"),
				result.getBoolean("droitImage"), result.getDate("dateEntree"),
				result.getDate("dateSortie"), NumberUtil.getResultFloat(result,
						"qf"), NumberUtil.getResultFloat(result, "cotisation"));
		return adherent;
	}

}
