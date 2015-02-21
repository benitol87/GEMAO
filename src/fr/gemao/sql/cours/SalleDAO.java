package fr.gemao.sql.cours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.cours.Salle;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class SalleDAO extends IDAO<Salle> {

    public SalleDAO(DAOFactory factory) {
	super(factory);
    }

    @Override
    public Salle create(Salle obj) {
	if (obj == null) {
	    throw new NullPointerException("La salle ne doit pas être null");
	}
	Connection connexion = null;
	PreparedStatement requete = null;
	ResultSet result = null;
	Integer id = null;
	String sql = "INSERT INTO salle(nomSalle) " + "VALUES (?);";
	try {
	    connexion = factory.getConnection();
	    requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
		    sql, true, obj.getNomSalle());

	    int status = requete.executeUpdate();

	    if (status == 0) {
		throw new DAOException(
			"Échec de la création de la salle, aucune ligne ajoutée dans la table.");
	    }

	    result = requete.getGeneratedKeys();
	    if (result != null && result.first()) {
		id = result.getInt(1);
		obj.setIdSalle(id);
	    }

	} catch (SQLException e) {
	    throw new DAOException(e);
	} finally {
	    DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
	}

	return obj;
    }

    @Override
    public void delete(Salle obj) {
	// TODO Auto-generated method stub

    }

    @Override
    public Salle update(Salle obj) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Salle get(long id) {
	Salle salle = null;
	Connection connexion = null;
	PreparedStatement requete = null;
	ResultSet result = null;
	String sql = "SELECT * FROM salle WHERE idSalle = ?;";
	try {

	    connexion = factory.getConnection();
	    requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
		    sql, false, id);
	    result = requete.executeQuery();

	    if (result.first()) {
		salle = this.map(result);
	    }
	} catch (SQLException e) {
	    throw new DAOException(e);
	} finally {
	    DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
	}
	return salle;
    }

    @Override
    public List<Salle> getAll() {
	List<Salle> liste = new ArrayList<>();

	Salle salle = null;
	Connection connexion = null;
	PreparedStatement requete = null;
	ResultSet result = null;
	String sql = "SELECT * FROM salle;";
	try {

	    connexion = factory.getConnection();
	    requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
		    sql, false);
	    result = requete.executeQuery();

	    while (result.next()) {
		salle = this.map(result);
		liste.add(salle);
	    }
	} catch (SQLException e) {
	    throw new DAOException(e);
	} finally {
	    DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
	}
	return liste;
    }

    @Override
    protected Salle map(ResultSet result) throws SQLException {
	return new Salle(NumberUtil.getResultInteger(result, "idSalle"),
		result.getString("nomSalle"));
    }

}
