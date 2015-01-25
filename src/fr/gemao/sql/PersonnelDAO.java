package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Contrat;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;
import fr.gemao.util.Password;

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
	 * Redéfinition de la méthode 
	 * Appelle create de PersonneDAO {@link PersonneDAO#create(fr.gemao.entity.Personne)}
	 * Et associe la liste des responsabilités et des diplomes à la personne.
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
		
		//PersonneDAO personneDAO = factory.getPersonneDAO();
		
		ResponsabiliteDAO responsabiliteDAO = factory.getResponsabiliteDAO();
		List<Responsabilite> listResponsabilite;
		
		DiplomeDAO diplomeDAO = factory.getDiplomeDAO();
		List<Diplome> listeDiplome;
		
		ContratDAO contratDAO = factory.getContratDAO();
		Contrat contrat = contratDAO.create(obj.getContrat());
		try {
			//obj = (Personnel) personneDAO.create(obj);
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false,
					obj.getIdPersonne(),
					contrat.getIdContrat(),
					obj.getLogin(),
					Password.encrypt(obj.getPassword()),
					obj.getPointsAncien());
			
			int status = requete.executeUpdate();
			
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création du personnel, aucune ligne ajoutée dans la table." );
	        }
			
			listResponsabilite = responsabiliteDAO.addAllResponsabiliteParPersonnel(obj.getIdPersonne(), obj.getListeResponsabilite());
			obj.setListeResponsabilite(listResponsabilite);
			listeDiplome = diplomeDAO.addAllDiplomesParPersonnel(obj.getIdPersonne(), obj.getListeDiplomes());
			obj.setListeDiplomes(listeDiplome);
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return obj;
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
					obj.getContrat().getIdContrat(),
					obj.getLogin(),
					Password.encrypt(obj.getPassword()),
					obj.getPointsAncien(),
					obj.getIdPersonne());
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
		
		String sql = "SELECT * FROM personnel pl inner join personne p on pl.idPersonne = p.idPersonne WHERE p.idPersonne = ?;";
		
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
		
		String sql = "SELECT * FROM personnel pl inner join personne p on pl.idPersonne = p.idPersonne order by nom, prenom;";
		
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
		DiplomeDAO diplomeDAO = factory.getDiplomeDAO();
		ContratDAO contratDAO = factory.getContratDAO();
		
		Integer idContrat = NumberUtil.getResultInteger(result, "idContrat");
		
		Personnel personnel = new Personnel(personneDAO.map(result),
				responsabiliteDAO.getResponsabilitesParPersonne(result.getLong("idPersonne")),
				diplomeDAO.getDiplomesParPersonnel(result.getLong("idPersonne")),
				idContrat==null?null:contratDAO.get(idContrat),
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
		
		String sql = "SELECT * FROM personnel pl inner join personne p on pl.idPersonne = p.idPersonne WHERE login = ?;";
		
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
	
	public int getNbNomPersonnel(String nom){
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		int nb = 0;
		
		String sql = "SELECT * FROM personnel pl inner join personne p on pl.idPersonne = p.idPersonne WHERE nom = ?;";
		
		try {
			
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, nom);
			result = requete.executeQuery();
			result.last();
			nb = result.getRow();
			result.beforeFirst();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		
		return nb; 
	}
}