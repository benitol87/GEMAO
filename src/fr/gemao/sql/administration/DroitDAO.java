package fr.gemao.sql.administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.gemao.entity.administration.Droit;
import fr.gemao.entity.administration.Module;
import fr.gemao.entity.administration.TypeDroit;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class DroitDAO extends IDAO<Droit> {

	public DroitDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Droit create(Droit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Droit obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Droit update(Droit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Droit get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Droit> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Droit> getAllParProfil(Integer idProfil){
		List<Droit> list = new ArrayList<>();
		Droit droit;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM droit where idProfil=?;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, idProfil);
			result = requete.executeQuery();

			while (result.next()) {
				droit = this.map(result);
				list.add(droit);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return list;
	}

	@Override
	protected Droit map(ResultSet result) throws SQLException {
		return new Droit(TypeDroit.getTypeDroit(NumberUtil.getResultInteger(result, "idTypeDroit")),
					Module.getModule(NumberUtil.getResultInteger(result, "idModule")));
	}

}
