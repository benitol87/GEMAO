package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Discipline;
import fr.gemao.entity.Fonction;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class FonctionDAO extends IDAO<Fonction> {
	
	public FonctionDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Fonction create(Fonction obj) {
		if (obj == null) {
			throw new NullPointerException("La fonction ne doit pas être null");
		}
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO fonction(nom) "
				+ "VALUES (?);";
		int id;
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getIdFonction(), obj.getNom());

			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création de la fonction, aucune ligne ajoutée dans la table.");
			}
			
			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getInt(1);
				obj.setIdFonction(id);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return obj;
	}

	@Override
	public void delete(Fonction obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Fonction update(Fonction obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fonction get(long id) {
		Fonction fonction = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM fonction WHERE idFonction = ?;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				fonction = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return fonction;
	}

	@Override
	public List<Fonction> getAll() {
		List<Fonction> liste = new ArrayList<>();

		Fonction fonction = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM fonction;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				fonction = this.map(result);
				liste.add(fonction);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}
	
	public List<Fonction> getFonctionParPersonnel(long idPersonnel){
		List<Fonction> list = new ArrayList<>();
		Fonction fonction = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * from fonction f inner join suit s on f.idFonction=s.idFonction WHERE idPersonnel = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, idPersonnel);
			result = requete.executeQuery();
			
			while(result.next()){
				fonction = this.map(result);
				list.add(fonction);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return list;
	}
	
	/**
	 * Associe une fonction et un personnel.
	 * @param idFonction
	 * @param idPersonnel
	 */
	public void addFonctionParPersonnel(int idFonction, long idPersonnel){
		Connection connexion = null;
		PreparedStatement requete = null;
		String sql = "INSERT INTO suit(idPersonnel, idFonction) values ( ?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, idPersonnel, idFonction);
			int status = requete.executeUpdate();
			if(status == 0 ){
				throw new DAOException(
						"Échec de la création de suit, aucune ligne ajoutée dans la table.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally{
			DAOUtilitaires.fermeturesSilencieuses(requete, connexion);
		}
	}
	
	/**
	 * Associe une liste de fonction à un personnel.
	 * @param listFonction
	 * @param idPersonnel
	 */
	public void addAllFonctionParPersonnel(List<Fonction> listFonction, long idPersonnel){
		for(Fonction f : listFonction){
			addFonctionParPersonnel(f.getIdFonction(), idPersonnel);
		}
	}

	@Override
	protected Fonction map(ResultSet result) throws SQLException {
		return new Fonction(NumberUtil.getResultInteger(result, "idFonction"), result.getString("nom"));
	}
}
