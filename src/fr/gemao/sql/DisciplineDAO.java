package fr.gemao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.gemao.entity.Discipline;
import fr.gemao.entity.adherent.Responsable;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.util.DAOUtilitaires;
import fr.gemao.sql.util.NumberUtil;

public class DisciplineDAO extends IDAO<Discipline> {

	public DisciplineDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Discipline create(Discipline obj) {
		if (obj == null) {
			throw new NullPointerException(
					"La discipline ne doit pas être null");
		}
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "INSERT INTO discipline(nom) " + "VALUES (?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, obj.getNom());

			int status = requete.executeUpdate();

			if (status == 0) {
				throw new DAOException(
						"Échec de la création de la discipline, aucune ligne ajoutée dans la table.");
			}
			

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return this.get(obj.getNom());
	}

	@Override
	public void delete(Discipline obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Discipline update(Discipline obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discipline get(long id) {
		Discipline discipline = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM discipline WHERE idDiscipline = ?;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, id);
			result = requete.executeQuery();

			if (result.first()) {
				discipline = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return discipline;
	}

	@Override
	public List<Discipline> getAll() {
		List<Discipline> liste = new ArrayList<>();

		Discipline discipline = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM discipline;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false);
			result = requete.executeQuery();

			while (result.next()) {
				discipline = this.map(result);
				liste.add(discipline);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return liste;
	}
	
	public Discipline get(String nom) {
		Discipline discipline = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * FROM discipline WHERE nom = ?;";
		try {

			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, nom);
			result = requete.executeQuery();

			if (result.first()) {
				discipline = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return discipline;
	}

	public List<Discipline> getDisciplineParAdherent(long idAdherent) {
		List<Discipline> list = new ArrayList<>();
		Discipline discipline = null;
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * from discipline d inner join suit s on d.idDiscipline=s.idDiscipline WHERE idAdherent = ?;";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, idAdherent);
			result = requete.executeQuery();

			while (result.next()) {
				discipline = this.map(result);
				list.add(discipline);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}
		return list;
	}

	/**
	 * Associe une discipline et un adhérent.
	 * 
	 * @param idDiscipline
	 * @param idAdherent
	 */
	public void addDiscplineParAdherent(int idDiscipline, long idAdherent) {
		Connection connexion = null;
		PreparedStatement requete = null;
		String sql = "INSERT INTO suit(idAdherent, idDiscipline) values ( ?, ?);";
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false, idAdherent, idDiscipline);
			int status = requete.executeUpdate();
			if (status == 0) {
				throw new DAOException(
						"Échec de la création de suit, aucune ligne ajoutée dans la table.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(requete, connexion);
		}
	}

	public void deleteDisciplineParAdherent(int idDiscipline, long adherent) {
		Statement stat = null;
		Connection connect = null;
		try {
			connect = factory.getConnection();
			stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stat.execute("DELETE FROM suit WHERE idAdherent = "
					+ adherent + " and idDiscipline = " + idDiscipline + ";");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(stat, connect);
		}
	}
	
	public void deleteAllDisciplinesParAdherent(List<Discipline> listDisciplines, long idAdherent){
		for (Discipline d : listDisciplines) {
			deleteDisciplineParAdherent(d.getIdDiscipline(), idAdherent);
		}
	}

	public void updateAllDisciplineParAdherent(List<Discipline> listDiscipline,
			long idAdherent) {
		List<Discipline> dejaInscrit = this
				.getDisciplineParAdherent(idAdherent);
		// Permet de supprimer les doublons.
		Set<Discipline> set = new HashSet<>(listDiscipline);
		listDiscipline = new ArrayList<>(set);
		for (Discipline d : listDiscipline) {
			if (!dejaInscrit.contains(d)) {
				this.addDiscplineParAdherent(d.getIdDiscipline(), idAdherent);
			}
			dejaInscrit.remove(d);
		}
		deleteAllDisciplinesParAdherent(dejaInscrit, idAdherent);
	}

	/**
	 * Associe une liste de disciplines à une adhérent.
	 * 
	 * @param listDiscipline
	 * @param idAdherent
	 */
	public void addAllDisciplineParAdherent(List<Discipline> listDiscipline,
			long idAdherent) {
		for (Discipline d : listDiscipline) {
			addDiscplineParAdherent(d.getIdDiscipline(), idAdherent);
		}
	}
	
	public Discipline exist(Discipline discipline) {
		Connection connexion = null;
		PreparedStatement requete = null;
		ResultSet result = null;
		String sql = "SELECT * from discipline where nom = ?";
		Discipline verif = null;
		try {
			connexion = factory.getConnection();
			requete = DAOUtilitaires.initialisationRequetePreparee(connexion,
					sql, false,  discipline.getNom());
			result = requete.executeQuery();

			if (result.first()) {
				verif = this.map(result);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtilitaires.fermeturesSilencieuses(result, requete, connexion);
		}

		return verif;
	}

	@Override
	protected Discipline map(ResultSet result) throws SQLException {
		return new Discipline(NumberUtil.getResultInteger(result,
				"idDiscipline"), result.getString("nom"));
	}

}
