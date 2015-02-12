package fr.gemao.entity.cours;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmploiDuTemps implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idEdt;
	private String nomEdt;
	private Date dateEdt;
	private List<Cours> listeCours;
	
	public EmploiDuTemps(Integer idEdt, String nomEdt, Date dateEdt, List<Cours> listeCours) {
		super();
		this.idEdt = idEdt;
		this.nomEdt = nomEdt;
		this.dateEdt = dateEdt;
		this.listeCours = listeCours;
	}

	public Integer getIdEdt() {
		return idEdt;
	}

	public void setIdEdt(Integer idEdt) {
		this.idEdt = idEdt;
	}

	public String getNomEdt() {
		return nomEdt;
	}

	public void setNomEdt(String nomEdt) {
		this.nomEdt = nomEdt;
	}

	public Date getDateEdt() {
		return dateEdt;
	}

	public void setDateEdt(Date dateEdt) {
		this.dateEdt = dateEdt;
	}
	
	public boolean ajouterCours(Cours cours){
		return listeCours.add(cours);
	}
	
	public boolean removeCours(Cours cours){
		return listeCours.remove(cours);
	}
	
	public List<Cours> getCours() {
		return listeCours;
	}

	public void setCours(List<Cours> cours) {
		this.listeCours = cours;
	}
	
}
