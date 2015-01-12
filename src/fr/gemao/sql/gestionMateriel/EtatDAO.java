package fr.gemao.sql.gestionMateriel;

import gemao.application.gestionMateriel.Categorie;
import gemao.application.gestionMateriel.Etat;
import gemao.mysql.DAOMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtatDAO extends DAOMySql<Etat> {

	public EtatDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Etat create(Etat obj) {
		if (obj == null) {
			throw new NullPointerException("L'etat ne doit pas etre null");
		}

		long id = 0;
		
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO etat(idEtat, libelle)"
					+ "VALUES (?, ?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1, obj.getIdEtat());
			requete.setString(2, obj.getLibelleEtat());
			requete.executeUpdate();

			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getLong(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(requete != null){
				try {
					if(result != null){
						result.close();
					}
					requete.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return this.get(id);
	}

	@Override
	public void delete(Etat obj) {
		if (obj == null) {
			throw new NullPointerException("L'etat ne doit pas etre null");
		}
		
		if (obj.getIdEtat() == 0) {
			throw new NullPointerException("L'etat ne peut pas avoir un id = 0");
		}
		
		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
										ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM etat WHERE idEtat = " + obj.getIdEtat() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stat != null ){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Etat update(Etat obj) {
		//TODO Comportement par d�faut, a modifier
		return null;
	}

	@Override
	public Etat get(long id) {
		Etat etat = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM etat WHERE idEtat = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				etat = new Etat(result.getInt("idEtat"),
						result.getString("libelle"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (requete != null) {
				try {
					if (result != null) {
						result.close();
					}
					requete.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return etat;
	}

	
	
	@Override
	public List<Etat> getAll() {
		List<Etat> liste = new ArrayList<>();

		Etat etat = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM categorie;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				etat = new Etat(result.getInt("idEtat"),
						result.getString("libelle"));
				liste.add(etat);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (requete != null) {
				try {
					if (result != null) {
						result.close();
					}
					requete.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return liste;
	}

}
