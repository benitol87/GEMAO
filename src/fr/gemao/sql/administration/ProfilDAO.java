package fr.gemao.sql.administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.administration.Profil;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class ProfilDAO extends IDAO<Profil> {

	public ProfilDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Profil create(Profil obj) {
		if (obj == null) {
			throw new NullPointerException(
					"Le profil ne doit pas etre null");
		}

		Integer id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO profil(nomProfil)"
				+ "VALUES (?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getNomProfil());
			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création d'un profil, aucune ligne ajoutée dans la table.");
			}

			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getInt(1);
				obj.setIdProfil(id);;
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return obj;
	}

	@Override
	public void delete(Profil obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Profil update(Profil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profil get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profil> getAll() {
		List<Profil> liste = new ArrayList<>();

		Profil profil = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM profil p "
				+ "order by nomProfil;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				profil = this.map(result);
				liste.add(profil);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}
	
	public void load(){
		Profil profil;
		List<Profil> list = new ArrayList<>();
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM profil;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				profil = this.map(result);
				list.add(profil);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		
		Profil.load(list);
	}

	@Override
	protected Profil map(ResultSet result) throws SQLException {
		DroitDAO droitDAO = this.factory.getDroitDAO();
		Integer idProfil = NumberUtil.getResultInteger(result, "idProfil");
		return new Profil(idProfil, 
				result.getString("nomProfil"), 
				droitDAO.getAllParProfil(idProfil));
	}

}
