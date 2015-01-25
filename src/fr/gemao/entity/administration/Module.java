package fr.gemao.entity.administration;

import java.io.Serializable;


/**
 * Classe représentant un module développé pour cette application
 * @author Benoît
 *
 */
public class Module implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idModule;
	private String nomModule;
	
	public Module() {
		
	}
	
	public Module(int idModule, String nomModule) {
		this.idModule = idModule;
		this.nomModule = nomModule;
	}
	
	public int getIdModule() {
		return idModule;
	}
	
	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}
	
	public String getNomModule() {
		return nomModule;
	}
	
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	
	
}
