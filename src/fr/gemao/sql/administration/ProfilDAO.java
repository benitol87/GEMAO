package fr.gemao.sql.administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.administration.Profil;
import fr.gemao.entity.administration.TypeDroit;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
