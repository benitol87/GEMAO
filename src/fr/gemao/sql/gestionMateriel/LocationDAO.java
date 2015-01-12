package fr.gemao.sql.gestionMateriel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gemao.application.gestionMateriel.Location;
import gemao.mysql.DAOMySql;

public class LocationDAO extends DAOMySql<Location> {

	public LocationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Location create(Location obj) {
		if (obj == null) {
			throw new NullPointerException("Le materiel ne doit pas �tre null");
		}

		long id = 0;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO LOCATION(idPersonne,"
					+ "idMateriel,"
					+ "idEtatDebut,"
					+ "idEtatFin,"
					+ "dateEmprunt,"
					+ "dateRetour,"
					+ "dureePrevue,"
					+ "montant)" + "VALUES (?,?,?,?,?,?,?,?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setLong(1, obj.getPersonne().getIdPersonne());
			requete.setLong(2,obj.getMateriel().getIdMateriel());
			requete.setInt(3,obj.getEtatDebut().getIdEtat());
			requete.setInt(4,obj.getEtatFin().getIdEtat());
			requete.setDate(5,obj.getDateEmprunt());
			requete.setDate(6,obj.getDateRetour());
			requete.setInt(7,obj.getDuree());
			requete.setFloat(8,obj.getMontant());
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
	public void delete(Location obj) {
		if (obj == null) {
			throw new NullPointerException("La Location ne doit pas �tre null");
		}
		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM LOCATION WHERE idPersonne = "
					+ obj.getPersonne().getIdPersonne()
					+ "AND idMateriel ="+obj.getMateriel().getIdMateriel()
					+"AND dateEmprunt ="+obj.getDateEmprunt());
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
	public Location update(Location obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
