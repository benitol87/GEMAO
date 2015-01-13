package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Responsabilite;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class ResponsabiliteDAO extends IDAO<Responsabilite> {
	
	/**
	 * Constructeur de la classe ResponsabiliteDAO
	 * @param factory
	 */
	public ResponsabiliteDAO(DAOFactory factory) {
		super(factory);
	}

	/**
	 * Redéfinition de la méthode create
	 */
	@Override
	public Responsabilite create(Responsabilite obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Redéfinition de la méthode delete
	 */
	@Override
	public void delete(Responsabilite obj) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Redéfinition de la méthode update
	 */
	@Override
	public Responsabilite update(Responsabilite obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Redéfinition de la méthode get
	 */
	@Override
	public Responsabilite get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Redéfinition de la méthode getAll
	 */
	@Override
	public List<Responsabilite> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Redéinition de la méthode map
	 */
	@Override
	protected Responsabilite map(ResultSet result) throws SQLException {
		
		return new Responsabilite(result.getInt("idResponsabilite"), result.getString("libelle"));
	}
	
	/**
	 * Méthode permettant de retourner la liste des responsabilités en fonction de l'ID d'une personne
	 * @param idPersonne : l'ID de la personne
	 * @return liste : la liste des reponsabilités
	 */
	public List<Responsabilite> getResponsabilitesParPersonne(Long idPersonne) {
		Connection co = null;
		PreparedStatement state = null;
		ResultSet result = null;
		Responsabilite responsabilite = null;
		List<Responsabilite> liste = new ArrayList();
		
		String sql = "SELECT * FROM responsabilite WHERE idPersonne = ?;";
		
		try {
			co = factory.getConnection();
			state = DAOUtilitaires.initialisationRequetePreparee(co, sql, false, idPersonne);
			result = state.executeQuery();
			
			while (result.next()) {
				responsabilite = this.map(result);
				liste.add(responsabilite);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, state, co);
		}
		
		
		return liste;
	}
}