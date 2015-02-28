package fr.gemao.entity.cours;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Contrat;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personne;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;
import fr.gemao.entity.administration.Profil;
import fr.gemao.entity.util.Civilite;

public class Prof extends Personnel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dateDebutEnseignement;
	
	public Prof(Date dateDebutEnseignement) {
		super();
		this.dateDebutEnseignement = dateDebutEnseignement;
	}

	public Prof(Long idPersonne, Adresse adresse, Commune communeNaiss,
			String nom, String prenom, Date dateNaissance, String telFixe,
			String telPort, String email, Civilite civilite,
			List<Responsabilite> listeResponsabilite,
			List<Diplome> listeDiplome, Contrat contrat, String login,
			String password, int pointsAncien, Profil profil, boolean premiereConnexion, Date dateDebutEnseignement) {
		super(idPersonne, adresse, communeNaiss, nom, prenom, dateNaissance, telFixe,
				telPort, email, civilite, listeResponsabilite, listeDiplome, contrat,
				login, password, pointsAncien, profil, premiereConnexion);
		this.dateDebutEnseignement = dateDebutEnseignement;
	}



	public Prof(Personne personne, List<Responsabilite> listeResponsabilite,
			List<Diplome> listeDiplome, Contrat contrat, String login,
			String password, Integer pointsAncien, Profil profil, boolean premiereConnexion, Date dateDebutEnseignement) {
		super(personne, listeResponsabilite, listeDiplome, contrat, login, password,
				pointsAncien, profil, premiereConnexion);
		this.dateDebutEnseignement = dateDebutEnseignement;
	}



	public Date getDateDebutEnseignement() {
		return dateDebutEnseignement;
	}

	public void setDateDebutEnseignement(Date dateDebutEnseignement) {
		this.dateDebutEnseignement = dateDebutEnseignement;
	}
	
	
	
}
