package fr.gemao.ctrl.administration;

import java.util.List;

import fr.gemao.entity.Personnel;
import fr.gemao.entity.administration.Droit;
import fr.gemao.entity.administration.Profil;
import fr.gemao.form.personnel.PersonnelForm;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.administration.DroitDAO;
import fr.gemao.sql.administration.ModuleDAO;
import fr.gemao.sql.administration.ProfilDAO;
import fr.gemao.sql.administration.TypeDroitDAO;

public class ProfilsCtrl {

	private DAOFactory daoFactory;
	
	public ProfilsCtrl() {
		this.daoFactory = DAOFactory.getInstance();
	}
	
	/**
	 * Charge toutes les informations nécessaires pour les profils.
	 * Charge les types de droit, les modules, et les profils.
	 * Attention ne doit être chargé qu'une fois.
	 */
	public void loadProfil(){
		TypeDroitDAO typeDroitDAO = this.daoFactory.geTypeDroitDAO();
		typeDroitDAO.load();
		ModuleDAO moduleDAO = this.daoFactory.getModuleDAO();
		moduleDAO.load();
		ProfilDAO profilDAO = this.daoFactory.getProfilDAO();
		profilDAO.load();
	}
	
	/**
	 * Creer un profil, et associe la liste de droit au profil
	 * @param nom
	 * @param listDroit
	 * @return un profil
	 */
	public Profil creerProfil(String nom, List<Droit> listDroit){
		Profil profil = new Profil(null, nom, listDroit);
		Profil.put(profil);
		ProfilDAO profilDAO = this.daoFactory.getProfilDAO();
		profil = profilDAO.create(profil);
		
		DroitDAO droitDAO = this.daoFactory.getDroitDAO();
		droitDAO.addAllDroitParProfil(profil.getIdProfil(), listDroit);
		
		return profil;
	}
	
	/**
	 * Retourne vrai si le personnel à le droit
	 * @param personnel
	 * @param droit
	 * @return true si droit
	 */
	public boolean aDroit(Personnel personnel, Droit droit){
		Profil profil = personnel.getProfil();
		List<Droit> droits = profil.getListDroits();
		return droits.contains(droit);
	}
}
