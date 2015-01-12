package gemao.mysql;

import java.sql.Connection;
import java.util.List;

public abstract class DAOMySql<T> {
	protected Connection connect = null;

	public DAOMySql(Connection conn){
		this.connect = conn;
	}

	/**
	 * Mï¿½thode d'insertion d'objet.
	 * @param obj
	 * 		Objet ï¿½ insï¿½rer.
	 * @return l'objet insï¿½rï¿½ ou null s'il n'est pas trouvï¿½ aprï¿½s l'insertion.
	 * @throws IllegalArgumentException si l'objet existe dï¿½jï¿½.
	 */
	public abstract T create(T obj);

	/**
	 * Mï¿½thode de suppression d'objet.
	 * @param obj
	 * 		Objet ï¿½ supprimer.
	 * @throws IllegalArgumentException si l'objet n'existe pas.
	 */
	public abstract void delete(T obj);

	/**
	 * Mïéthode de mise à jour d'un objet.
	 * @param obj
	 * 		Objet à mettre à jour.
	 * @return l'objet updaté ou null s'il n'est pas trouvé après la mise à jour.
	 */
	public abstract T update(T obj);

	/**
	 * Mï¿½thode de recherche d'un objet.
	 * @param id
	 * 		identifiant de l'objet ï¿½ rechercher.
	 * @return l'objet correspondant ï¿½ l'identifiant ou null si l'objet n'xiste pas.
	 */
	public abstract T get(long id);
	
	/**
	 * Mï¿½thode de recherche de toutes les lignes.
	 * @return la liste de tous les objets.
	 */
	public abstract List<T> getAll();
}
