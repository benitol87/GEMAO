package fr.gemao.sql.gestionMateriel;

import gemao.application.gestionMateriel.Categorie;
import gemao.mysql.DAOMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends DAOMySql<Categorie> {

	public CategorieDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Categorie create(Categorie obj) {
		if (obj == null) {
			throw new NullPointerException("La categorie ne doit pas etre null");
		}

		long id = 0;
		
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO Categorie(idCategorie, libelle)"
					+ "VALUES (?, ?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1, obj.getIdCategorie());
			requete.setString(2, obj.getLibelleCat());
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
	public void delete(Categorie obj) {
		if (obj == null) {
			throw new NullPointerException("La categorie ne doit pas etre null");
		}
		
		if (obj.getIdCategorie() <= 0) {
			throw new IllegalArgumentException("La categorie ne peut pas avoir un id = 0");
		}
		
		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
										ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM categorie WHERE idCategorie = " + obj.getIdCategorie() + ";");
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
	public Categorie update(Categorie obj) {
		//TODO Comportement par d�faut, a modifier
		return null;
	}

	@Override
	public Categorie get(long id) {
		Categorie categorie = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM categorie WHERE idCategorie = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				categorie = new Categorie(result.getInt("idCategorie"),
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
		return categorie;
	}

	
	
	@Override
	public List<Categorie> getAll() {
		List<Categorie> liste = new ArrayList<>();

		Categorie categorie = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM categorie;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				categorie = new Categorie(result.getInt("idCategorie"),
						result.getString("libelle"));
				liste.add(categorie);
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
