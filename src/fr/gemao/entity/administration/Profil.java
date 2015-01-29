package fr.gemao.entity.administration;

import java.io.Serializable;
import java.util.List;

/**
 * Classe représentant un profil, lié à un ou plusieurs membres
 * du personnel, permettant l'accès à certains modules
 * @author Benoît
 *
 */
public class Profil implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idProfil;
	private String nomProfil;
	private List<Droit> listDroits;
	
	public Profil() {

	}

	public Profil(int idProfil, String nomProfil, List<Droit> listDroit) {
		super();
		this.idProfil = idProfil;
		this.nomProfil = nomProfil;
		this.listDroits = listDroit;
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

	public List<Droit> getListDroits() {
		return listDroits;
	}

	public void setListDroits(List<Droit> listDroits) {
		this.listDroits = listDroits;
	}
	
	public boolean removeDroit(Droit droit){
		return this.listDroits.remove(droit);
	}
	
	public boolean addDroit(Droit droit){
		return this.listDroits.add(droit);
	}
	
	public boolean addAlldroit(List<Droit> droits){
		return this.listDroits.addAll(droits);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProfil;
		result = prime * result
				+ ((listDroits == null) ? 0 : listDroits.hashCode());
		result = prime * result
				+ ((nomProfil == null) ? 0 : nomProfil.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profil other = (Profil) obj;
		if (idProfil != other.idProfil)
			return false;
		if (listDroits == null) {
			if (other.listDroits != null)
				return false;
		} else if (!listDroits.equals(other.listDroits))
			return false;
		if (nomProfil == null) {
			if (other.nomProfil != null)
				return false;
		} else if (!nomProfil.equals(other.nomProfil))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profil [idProfil=" + idProfil + ", nomProfil=" + nomProfil
				+ ", listDroits=" + listDroits + "]";
	}
	
	
	
}
