package fr.gemao.entity.cours;

import java.io.Serializable;
import java.util.List;

/**
 * Classe regroupant une matière et un niveau
 * @author Benoît
 *
 */
public class Discipline implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idDiscipline;
	private Matiere matiere;
	private Niveau niveau;
	private List<Salle> salles;

	public Discipline(Integer idDiscipline, Matiere matiere, Niveau niveau, List<Salle> salles) {
		super();
		this.idDiscipline = idDiscipline;
		this.matiere = matiere;
		this.niveau = niveau;
		this.salles = salles;
	}

	public Integer getIdDiscipline() {
		return idDiscipline;
	}

	public void setIdDiscipline(Integer idDiscipline) {
		this.idDiscipline = idDiscipline;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}	
	
	public boolean ajouterSalle(Salle salle){
		return salles.add(salle);
	}
	
	public boolean removeSalle(Salle salle){
		return salles.remove(salle);
	}
}
