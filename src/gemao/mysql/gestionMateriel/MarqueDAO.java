package gemao.mysql.gestionMateriel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gemao.application.gestionMateriel.Etat;
import gemao.application.gestionMateriel.Marque;
import gemao.mysql.DAOMySql;

public class MarqueDAO extends DAOMySql<Marque> {

	public MarqueDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public Marque create(Marque obj) {
		if (obj == null) {
			throw new NullPointerException("La marque ne doit pas etre null");
		}

		long id = 0;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO MARQUE(idMarque, nomMarque)"
					+ "VALUES (?, ?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1, obj.getIdMarque());
			requete.setString(2, obj.getNomMarque());
			requete.executeUpdate();

			result = requete.getGeneratedKeys();
			if (result != null && result.first()) {
				id = result.getLong(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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

		return this.get(id);
	}

	@Override
	public void delete(Marque obj) {
		if (obj == null) {
			throw new NullPointerException("La marque ne doit pas etre null");
		}
		
		if (obj.getIdMarque() == 0) {
			throw new NullPointerException("La marque ne peut pas avoir un id = 0");
		}
		
		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
										ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM MARQUE WHERE idMarque = " + obj.getIdMarque() + ";");
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
	public Marque update(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marque get(long id) {
		Marque marque = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM marque WHERE idMarque = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				marque = new Marque(result.getInt("idMarque"),
						result.getString("nomMarque"));
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
		return marque;
	}

	@Override
	public List<Marque> getAll() {
		List<Marque> liste = new ArrayList<>();

		Marque marque = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM marque;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				marque = new Marque(result.getInt("idMarque"),
						result.getString("nomMarque"));
				liste.add(marque);
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
