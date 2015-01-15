package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Diplome;
import fr.gemao.entity.Responsabilite;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class DiplomeDAO extends IDAO<Diplome> {

	public DiplomeDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Diplome create(Diplome obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Diplome obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Diplome update(Diplome obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diplome get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diplome> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Diplome> getDiplomesParPersonnel(Long idPersonne){
		Connection co = null;
		PreparedStatement state = null;
		ResultSet result = null;
		Diplome diplome = null;
		List<Diplome> liste = new ArrayList<>();
		
		String sql = "SELECT * FROM dipome d inner join personneXdiplome pd on d.idDiplome = pd.idDiplome WHERE idPersonne = ?;";
		
		try {
			co = factory.getConnection();
			state = DAOUtilitaires.initialisationRequetePreparee(co, sql, false, idPersonne);
			result = state.executeQuery();
			
			while (result.next()) {
				diplome = this.map(result);
				liste.add(diplome);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, state, co);
		}
		
		return liste;
	}

	@Override
	protected Diplome map(ResultSet result) throws SQLException {
		return new Diplome(NumberUtil.getResultInteger(result, "idDiplome"), result.getString("nomDiplome"));
	}

}
