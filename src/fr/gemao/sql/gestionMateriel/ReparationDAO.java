package fr.gemao.sql.gestionMateriel;

import gemao.application.gestionMateriel.Materiel;
import gemao.application.gestionMateriel.Reparateur;
import gemao.application.gestionMateriel.Reparation;
import gemao.mysql.DAOMySql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReparationDAO extends DAOMySql<Reparation>{
	
	public ReparationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Reparation create(Reparation obj) {
		if (obj == null) {
			throw new NullPointerException("Le materiel ne doit pas �tre null");
		}

		long id = 0;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO REPARATION(idReparation," + "idReparateur,"
					+ "dateCertificat" +"VALUES (?,?,?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1, obj.getIdReparation());
			requete.setInt(2,obj.getReparateur().getIdReparateur());
			requete.setDate(3,obj.getDateCertificat());

			
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
	public void delete(Reparation obj) {
		if (obj == null) {
			throw new NullPointerException("La Reparation ne doit pas �tre null");
		}

		if (obj.getIdReparation() == 0) {
			throw new NullPointerException(
					"La reparation ne peut pas avoir un id = 0");
		}

		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM REPARATION WHERE idReparation = "
					+ obj.getIdReparation() + ";");
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
	public Reparation update(Reparation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reparation get(long id) {
		Reparation reparation = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM REPARATION WHERE idReparation = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				reparation = new Reparation(result.getInt("idReparation"),
						new ReparateurDAO(connect).get(result.getInt("idReparateur")),
						result.getDate("dateCertificat"));
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
		return reparation;
	}

	

	@Override
	public List<Reparation> getAll() {
		List<Reparation> liste = new ArrayList<>();

		Reparation reparation = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM Reparation;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				reparation = new Reparation(result.getInt("idReparation"),
						new ReparateurDAO(connect).get(result.getInt("idReparateur")),
						result.getDate("dateCertificat"));
				liste.add(reparation);
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
