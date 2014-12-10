package gemao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gemao.entity.Adherent;

public class AdherentDAO extends DAOMySql<Adherent>{

	public AdherentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Adherent create(Adherent obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
	
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "INSERT INTO Adhérent(idPersonne, idMotifSortie, idResponsable, droitImage,"
					+ "	dateEntree, dateSortie, qf, cotisation)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, obj.getIdPersonne());
			requete.setLong(2, obj.getIdMotif());
			requete.setLong(3, obj.getIdResponsable());
			requete.setInt(4, (obj.isDroitImage()?1:0));
			requete.setDate(5, new Date(obj.getDateEntree().getTime()));
			requete.setDate(6, new Date(obj.getDateSortie().getTime()));
			requete.setFloat(7, obj.getQf());
			requete.setFloat(8, obj.getCotisation());
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
	public void delete(Adherent obj) {
		
	}

	@Override
	public Adherent update(Adherent obj) {
		if (obj == null) {
			throw new NullPointerException("La personne ne doit pas �tre null");
		}
		
		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "UPDATE Adherent SET idMotifSortie = ?, idResponsable = ?, droitImage = ?, "
					+ "dateEntree = ?, dateSortie = ?, qf = ?, cotisation = ? "
					+ "WHERE idPersonne = ?;";
			requete = connect.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			requete.setLong(1, obj.getIdMotif());
			requete.setLong(2, obj.getIdResponsable());
			requete.setInt(3, (obj.isDroitImage()?1:0));
			requete.setDate(4, new Date(obj.getDateEntree().getTime()));
			requete.setDate(5, new Date(obj.getDateSortie().getTime()));
			requete.setFloat(6, obj.getQf());
			requete.setFloat(7, obj.getCotisation());
			requete.setLong(8, obj.getIdPersonne());
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
	public Adherent get(long id) {
		Adherent adherent = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM adherent WHERE idPersonne = ?;";
			requete = connect.prepareStatement(sql);
			requete.setLong(1, id);
			result = requete.executeQuery();

			if (result.first()) {
				PersonneDAO personneDAO = new PersonneDAO(this.connect);
				adherent = new Adherent(personneDAO.get(id),
						result.getInt("idMotifSortie"),
						result.getLong("idResponsable"),
						result.getBoolean("droitImage"), 
						result.getDate("dateEntree"),
						result.getDate("dateSortie"),
						result.getFloat("qf"),
						result.getFloat("cotisation"));
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
		return adherent;
	}

	@Override
	public List<Adherent> getAll() {
		List<Adherent> liste = new ArrayList<>();

		Adherent adherent = null;

		PreparedStatement requete = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM Adherent;";
			requete = connect.prepareStatement(sql);
			result = requete.executeQuery();
			PersonneDAO personneDAO = new PersonneDAO(this.connect);
			while (result.next()) {
				adherent = new Adherent(personneDAO.get(result.getLong("idPersonne")),
						result.getInt("idMotifSortie"),
						result.getLong("idResponsable"),
						result.getBoolean("droitImage"), 
						result.getDate("dateEntree"),
						result.getDate("dateSortie"),
						result.getFloat("qf"),
						result.getFloat("cotisation"));
				liste.add(adherent);
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
