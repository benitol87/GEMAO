package fr.gemao.entity.administration;

import java.util.List;

/**
 * Classe représentant un profil, lié à un ou plusieurs membres
 * du personnel, permettant l'accès à certains modules
 * @author Benoît
 *
 */
public class Profil {
	private int idProfil;
	private String nomProfil;
	private List<Module> listeModules;
	
	public Profil() {

	}

	public Profil(int idProfil, String nomProfil, List<Module> listeModules) {
		super();
		this.idProfil = idProfil;
		this.nomProfil = nomProfil;
		this.listeModules = listeModules;
	}

	public int getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public String getNomProfil() {
		return nomProfil;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

	public List<Module> getListeModules() {
		return listeModules;
	}

	public void setListeModules(List<Module> listeModules) {
		this.listeModules = listeModules;
	}
	
	
	
}
