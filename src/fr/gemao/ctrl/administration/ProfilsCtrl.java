package fr.gemao.ctrl.administration;

import java.util.List;

import fr.gemao.entity.administration.Droit;
import fr.gemao.entity.administration.Profil;
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

}
