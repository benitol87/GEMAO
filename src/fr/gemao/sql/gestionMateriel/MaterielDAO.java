package fr.gemao.sql.gestionMateriel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gemao.application.gestionMateriel.Materiel;
import gemao.mysql.DAOMySql;

public class MaterielDAO extends DAOMySql<Materiel> {

	public MaterielDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Materiel create(Materiel obj) {
		if (obj == null) {
			throw new NullPointerException("Le materiel ne doit pas �tre null");
		}

		long id = 0;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO Materiel(idMateriel," + "idEtat,"
					+ "idCategorie," + "idMarque," + "designation,"
					+ "typeMateriel," + "numSerie," + "dateAchat,"
					+ "valeurAchat," + "valeurReapprov," + "deplaceConcert,"
					+ "observations)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setLong(1, obj.getIdMateriel());
			requete.setInt(2, obj.getEtat().getIdEtat());
			requete.setInt(3, obj.getCategorie().getIdCategorie());
			requete.setInt(4, obj.getMarque().getIdMarque());
			requete.setString(5, obj.getDesignation());
			requete.setString(6, obj.getTypeMat());
			requete.setLong(7, obj.getNumSerie());
			requete.setDate(8, obj.getDateAchat());
			requete.setFloat(9, obj.getValeurAchat());
			requete.setFloat(10, obj.getValeurReap());
			requete.setBoolean(11, obj.isDeplacable());
			requete.setString(8, obj.getObservation());
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
	public void delete(Materiel obj) {
		if (obj == null) {
			throw new NullPointerException("Le materiel ne doit pas �tre null");
		}

		if (obj.getIdMateriel() == 0) {
			throw new NullPointerException(
					"Le materiel ne peut pas avoir un id = 0");
		}

		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM Materiel WHERE idMateriel = "
					+ obj.getIdMateriel() + ";");
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
	public Materiel update(Materiel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materiel get(long id) {
		Materiel materiel = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM Materiel WHERE idMateriel = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				materiel = new Materiel(result.getLong("idMateriel"),
						new EtatDAO(connect).get(result.getInt("idEtat")),
						new CategorieDAO(connect).get(result.getInt("idCategorie")),
						new MarqueDAO(connect).get(result.getInt("idMarque")),
						result.getString("designation"),
						result.getString("typeMateriel"),
						result.getLong("numSerie"),
						result.getDate("dateAchat"),
						result.getFloat("valeurAchat"),
						result.getFloat("ValeurReapprov"),
						result.getBoolean("deplaceConcert"),
						result.getString("observation"));
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
		return materiel;
	}

	@Override
	public List<Materiel> getAll() {
		List<Materiel> liste = new ArrayList<>();

		Materiel materiel = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM marque;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				materiel = new Materiel(result.getLong("idMateriel"),
						new EtatDAO(connect).get(result.getInt("idEtat")),
						new CategorieDAO(connect).get(result
								.getInt("idCategorie")),
						new MarqueDAO(connect).get(result.getInt("idMarque")),
						result.getString("designation"),
						result.getString("typeMateriel"),
						result.getLong("numSerie"),
						result.getDate("dateAchat"),
						result.getFloat("valeurAchat"),
						result.getFloat("ValeurReapprov"),
						result.getBoolean("deplaceConcert"),
						result.getString("observation"));
				liste.add(materiel);
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
