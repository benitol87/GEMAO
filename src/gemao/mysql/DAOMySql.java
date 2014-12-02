package gemao.mysql;

import java.sql.Connection;
import java.util.List;

public abstract class DAOMySql<T> {
	protected Connection connect = null;

	public DAOMySql(Connection conn){
		this.connect = conn;
	}

	/**
	 * M�thode d'insertion d'objet.
	 * @param obj
	 * 		Objet � ins�rer.
	 * @return l'objet ins�r� ou null s'il n'est pas trouv� apr�s l'insertion.
	 * @throws IllegalArgumentException si l'objet existe d�j�.
	 */
	public abstract T create(T obj);

	/**
	 * M�thode de suppression d'objet.
	 * @param obj
	 * 		Objet � supprimer.
	 * @throws IllegalArgumentException si l'objet n'existe pas.
	 */
	public abstract void delete(T obj);

	/**
	 * M��thode de mise � jour d'un objet.
	 * @param obj
	 * 		Objet � mettre � jour.
	 * @return l'objet updat� ou null s'il n'est pas trouv� apr�s la mise � jour.
	 */
	public abstract T update(T obj);

	/**
	 * M�thode de recherche d'un objet.
	 * @param id
	 * 		identifiant de l'objet � rechercher.
	 * @return l'objet correspondant � l'identifiant ou null si l'objet n'xiste pas.
	 */
	public abstract T get(long id);
	
	/**
	 * M�thode de recherche de toutes les lignes.
	 * @return la liste de tous les objets.
	 */
	public abstract List<T> getAll();
}
