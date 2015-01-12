package fr.gemao.sql.gestionMateriel;

import fr.gemao.entity.materiel.Categorie;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;
import fr.gemao.sql.SQLException;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;

public class CategorieDAO extends IDAO<Categorie> {

	public CategorieDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Categorie create(Categorie obj) {
		if (obj == null) {
			throw new NullPointerException("La categorie ne doit pas etre null");
		}

		long id = 0;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;

		String sql = "INSERT INTO Categorie(idCategorie, libelle)"
				+ "VALUES (?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion, sql, false,
			obj.getIdCategorie(),
			obj.getLibelleCat();
			
			int status =  requete.executeUpdate();

			if ( status == 0 ) {
	            throw new DAOException( "Échec de la création de l'adhérent, aucune ligne ajoutée dans la table." );
	        }

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		

		return this.get(id);
	}

	@Override
	public void delete(Categorie obj) {
		if (obj == null) {
			throw new NullPointerException("La categorie ne doit pas etre null");
		}

		if (obj.getIdCategorie() <= 0) {
			throw new IllegalArgumentException(
					"La categorie ne peut pas avoir un id = 0");
		}

		Statement stat = null;
		try {
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM categorie WHERE idCategorie = "
					+ obj.getIdCategorie() + ";");
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
	public Categorie update(Categorie obj) {
		// TODO Comportement par d�faut, a modifier
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
