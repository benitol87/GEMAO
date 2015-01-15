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
		if (obj == null) {
			throw new NullPointerException("Le  ne doit pas être null");
		}
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO diplome(idDiplome, nomDiplome)"
				+ "VALUES (?, ?);";
		Integer id = null;
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, true,
					obj.getIdDiplome(),
					obj.getNomDiplome());
			
			int status = requete.executeUpdate();
			
			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création du diplome, aucune ligne ajoutée dans la table." );
	        }
			
			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getInt(1);
				obj.setIdDiplome(id);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return obj;
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
		
		String sql = "SELECT * FROM diplome d inner join personneXdiplome pd on d.idDiplome = pd.idDiplome WHERE idPersonne = ?;";
		
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
