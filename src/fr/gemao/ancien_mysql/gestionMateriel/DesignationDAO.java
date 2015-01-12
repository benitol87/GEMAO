package gemao.mysql.gestionMateriel;

import gemao.application.gestionMateriel.Categorie;
import gemao.application.gestionMateriel.Designation;
import gemao.mysql.DAOMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DesignationDAO extends DAOMySql<AjouterDesignationCtrl> {
	public DesignationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public AjouterDesignationCtrl create(AjouterDesignationCtrl obj) {
		if (obj == null) {
			throw new NullPointerException(
					"La designation ne doit pas etre null");
		}

		long id = 0;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO designation(idDesignation, libelle)"
					+ "VALUES (?, ?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1, obj.getIdDesignation());
			requete.setString(2, obj.getLibelleDesignation());
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
	public void delete(AjouterDesignationCtrl obj) {
		if (obj == null) {
			throw new NullPointerException(
					"La designation ne doit pas etre null");
		}

		if (obj.getIdDesignation() == 0) {
			throw new IllegalArgumentException(
					"La designation ne peut pas avoir un id = 0");
		}

		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM designation WHERE idDesignation = "
					+ obj.getIdDesignation() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public AjouterDesignationCtrl update(AjouterDesignationCtrl obj) {
		// TODO Comportement par d�faut, a modifier
		return null;
	}

	@Override
	public AjouterDesignationCtrl get(long id) {
		AjouterDesignationCtrl designation = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM designation WHERE idDesignation = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				designation = new AjouterDesignationCtrl(result.getInt("idDesignation"),
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
		return designation;
	}

	@Override
	public List<AjouterDesignationCtrl> getAll() {
		List<AjouterDesignationCtrl> liste = new ArrayList<>();

		AjouterDesignationCtrl designation = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM designation;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				designation = new AjouterDesignationCtrl(result.getInt("idDesignation"),
						result.getString("libelle"));
				liste.add(designation);
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
