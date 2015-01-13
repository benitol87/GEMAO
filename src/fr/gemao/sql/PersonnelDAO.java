package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Personnel;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

/**
 * Classe PersonnelDAO
 * @author Coco
 *
 */
public class PersonnelDAO extends IDAO<Personnel>{
	
	/**
	 * Constructeur de la classe PersonnelDAO
	 * @param factory
	 */
	public PersonnelDAO(DAOFactory factory) {
		super(factory);
	}

	/**
	 * Redéfinition de lam méthode 
	 */
	@Override
	public Personnel create(Personnel obj) {
		if (obj == null) {
			throw new NullPointerException("Le personnel ne doit pas être null");
		}
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO personnel(idPersonne, idContrat, login, pwd, pointAnciennete)"
				+ "VALUES (?, ?, ?, ?, ?);";
		
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false,
					obj.getIdPersonne(),
					obj.getIdContrat(),
					obj.getLogin(),
					obj.getPassword(),
					obj.getPointsAncien());
			
			int status = requete.executeUpdate();
			
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création du personnel, aucune ligne ajoutée dans la table." );
	        }

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(obj.getIdPersonne());
	}

	/**
	 * Redéfinition de la méthode delete
	 */
	@Override
	public void delete(Personnel obj) {
		
	}

	/**
	 * Redéfinition de la méthode update
	 */
	@Override
	public Personnel update(Personnel obj) {
		if (obj == null) {
			throw new NullPointerException("Le personnel ne doit pas être null");
		}
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		
		String sql = "UPDATE personnel SET idContrat = ?, login = ?, pwd = ?, pointAnciennete = ? "
				+ "WHERE idPersonne = ?;";
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, 
					obj.getIdContrat(),
					obj.getLogin(),
					obj.getPassword(),
					obj.getPointsAncien());
			requete.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(obj.getIdPersonne());
	}

	/**
	 * Redéfinition de la méthode get
	 */
	@Override
	public Personnel get(long id) {
		Personnel personnel = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		
		String sql = "SELECT * FROM personnel WHERE idPersonne = ?;";
		
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				personnel = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		
		return personnel;
	}

	/**
	 * Redéfinition de la méthode getAll
	 */
	@Override
	public List<Personnel> getAll() {
		List<Personnel> liste = new ArrayList<>();
		Personnel personnel = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		
		String sql = "SELECT * FROM personnel;";
		
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false);
			result = requete.executeQuery();
			
			while (result.next()) {
				personnel = this.map(result);
				liste.add(personnel);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}

	/**
	 * Redéinition de la méthode map
	 */
	@Override
	protected Personnel map(ResultSet result) throws SQLException {
		PersonneDAO personneDAO = factory.getPersonneDAO();
		ResponsabiliteDAO responsabiliteDAO = factory.getResponsabiliteDAO();
		Personnel personnel = new Personnel(personneDAO.get(result.getLong("idPersonne")),
				responsabiliteDAO.getResponsabilitesParPersonne(result.getLong("idPersonne")),
				NumberUtil.getResultInteger(result, "idContrat"),
				result.getString("login"),
				result.getString("pwd"),
				NumberUtil.getResultInteger(result, "pointAnciennete"));
		
		return personnel;
	}
	
	/**
	 * Méthode permettant retourner un personnel en fonction de son login
	 */
	public Personnel getLoginParPersonnel(String login) {
		Personnel personnel = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		
		String sql = "SELECT * FROM personnel WHERE login = ?;";
		
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, login);
			result = requete.executeQuery();

			if (result.first()) {
				personnel = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		
		return personnel; 
	}
}