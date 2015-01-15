package fr.gemao.sql.materiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Fournisseur;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class FournisseurDAO extends IDAO<Fournisseur>{

	public FournisseurDAO(DAOFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fournisseur create(Fournisseur obj) {
		if (obj == null) {
			throw new NullPointerException("Le fournisseur ne doit pas etre null");
		}
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO Fournisseur(nom)" + "VALUES (?);";
		
		try{
			connexion = factory.getConnection();
			
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, true, obj.getNomFournisseur());
			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création d'un fournisseur, aucune ligne ajoutée dans la table.");
			}

		}catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		
		return this.get(obj.getNomFournisseur());
	}

	@Override
	public void delete(Fournisseur obj) {
		if (obj == null) {
			throw new NullPointerException("Le Fournisseur ne doit pas etre null");
		}

		if (obj.getIdFournisseur() == 0) {
			throw new NullPointerException("un Fournisseur ne peut pas avoir un id = 0");
		}

		Connection connexion = null;
		Statement stat = null;
		try {
			connexion = factory.getConnection();
			stat = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM Fournisseur WHERE idFournisseur = " + obj.getIdFournisseur()
					+ ";");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(stat, connexion);
		}
	}

	@Override
	public Fournisseur update(Fournisseur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur get(long id) {
		Fournisseur fournisseur = null;

		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM fournisseur WHERE idFournisseur = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				fournisseur = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return fournisseur;
	}
	
	public Fournisseur get(String nomFournisseur){
		Fournisseur fournisseur = null;
		
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM fournisseur WHERE Nom = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, nomFournisseur);
			result = requete.executeQuery();

			if (result.first()) {
				fournisseur = this.map(result);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return fournisseur;
	}

	@Override
	public List<Fournisseur> getAll() {
		List<Fournisseur> liste = new ArrayList<>();

		Fournisseur fournisseur = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM FOURNISSEUR;";
		try {
			connexion = DAOFactory.getInstance().getConnection();
			requete = connexion.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				fournisseur = this.map(result);
				liste.add(fournisseur);
			}
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return liste;
	}

	@Override
	protected Fournisseur map(ResultSet result) throws SQLException {
		return new Fournisseur(result.getInt("IdFournisseur"),result.getString("Nom"));
	}
	
	

}
