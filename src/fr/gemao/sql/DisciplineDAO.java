package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Discipline;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class DisciplineDAO extends IDAO<Discipline> {

	public DisciplineDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Discipline create(Discipline obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Discipline obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Discipline update(Discipline obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discipline get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discipline> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Discipline> getDisciplineParAdherent(long idAdherent){
		List<Discipline> list = new ArrayList<>();
		Discipline discipline = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * from discipline d inner join suit s on d.idDiscipline=s.idDiscipline WHERE idAdherent = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false, idAdherent);
			result = requete.executeQuery();
			
			while(result.next()){
				discipline = this.map(result);
				list.add(discipline);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return list;
	}

	@Override
	protected Discipline map(ResultSet result) throws SQLException {
		return new Discipline(NumberUtil.getResultInteger(result, "idDiscipline"), result.getString("nom"));
	}

}
