package gemao.mysql;

import gemao.entity.Personne;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO extends DAOMySql<Personne> {

	public PersonneDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Personne create(Personne obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}

		long id = 0;
		
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO Personne(idAdresse, idCommuneNaiss, nom, prenom,"
					+ "	dateNaissance, tel_fixe, tel_port, email, qf)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setLong(1, obj.getIdAdresse());
			requete.setLong(2, obj.getIdCommuneNaiss());
			requete.setString(3, obj.getNom());
			requete.setString(4, obj.getPrenom());
			requete.setDate(5, new Date(obj.getDateNaissance().getTime()));
			requete.setString(6, obj.getTelFixe());
			requete.setString(7, obj.getTelPort());
			requete.setString(8, obj.getEmail());
			requete.setFloat(9, obj.getQf());
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
	public void delete(Personne obj) {
		/*if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
		
		if (obj.getIdPersonne() == 0) {
			throw new NullPointerException("La personne ne peut pas avoir un id = 0");
		}
		
		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
										ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM personne WHERE idPersonne = " + obj.getIdPersonne() + ";");
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
		}*/
		throw new UnsupportedOperationException("Vous n'avez pas le droit de supprimer une Personne.");
	}

	@Override
	public Personne update(Personne obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
		
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "UPDATE Personne SET idAdresse = ?, idCommuneNaiss = ?, nom = ?, "
					+ "prenom = ?, dateNaissance = ?, tel_fixe = ?, tel_port = ?, "
					+ "email = ?, qf = ?"
					+ "WHERE idPersonne = ?;";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setLong(1, obj.getIdAdresse());
			requete.setLong(2, obj.getIdCommuneNaiss());
			requete.setString(3, obj.getNom());
			requete.setString(4, obj.getPrenom());
			requete.setDate(5, new Date(obj.getDateNaissance().getTime()));
			requete.setString(6, obj.getTelFixe());
			requete.setString(7, obj.getTelPort());
			requete.setString(8, obj.getEmail());
			requete.setFloat(9, obj.getQf());
			requete.setLong(10, obj.getIdPersonne());
			requete.executeUpdate();

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

		return this.get(obj.getIdPersonne());
	}

	@Override
	public Personne get(long id) {
		Personne personne = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM Personne WHERE idPersonne = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				personne = new Personne(result.getInt("idPersonne"),
						result.getInt("idAdresse"),
						result.getInt("idCommuneNaiss"),
						result.getString("nom"), result.getString("prenom"),
						result.getDate("dateNaissance"),
						result.getString("tel_fixe"),
						result.getString("tel_port"),
						result.getString("email"), result.getFloat("qf"));
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
		return personne;
	}

	@Override
	public List<Personne> getAll() {
		List<Personne> liste = new ArrayList<>();

		Personne personne = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM Personne;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();

			while (result.next()) {
				personne = new Personne(result.getLong("idPersonne"),
						result.getLong("idAdresse"),
						result.getLong("idCommuneNaiss"),
						result.getString("nom"), result.getString("prenom"),
						result.getDate("dateNaissance"),
						result.getString("tel_fixe"),
						result.getString("tel_port"),
						result.getString("email"), result.getFloat("qf"));
				liste.add(personne);
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