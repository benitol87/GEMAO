package fr.gemao.entity;

import java.io.Serializable;

/**
 * Classe représentant un ou plusieurs jours de la semaine
 * (un jour en particulier, aucun ou tous)
 * @author Benoît
 *
 */
public class Jour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idJour;
	private String nomJour;
	
	public Jour(Integer idJour, String nomJour) {
		super();
		this.idJour = idJour;
		this.nomJour = nomJour;
	}

	public Integer getIdJour() {
		return idJour;
	}

	public void setIdJour(Integer idJour) {
		this.idJour = idJour;
	}

	public String getNomJour() {
		return nomJour;
	}

	public void setNomJour(String nomJour) {
		this.nomJour = nomJour;
	}
	
	
	
}
