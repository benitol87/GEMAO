package fr.gemao.ctrl.administration;

import java.util.ArrayList;
import java.util.List;

import fr.gemao.entity.Personnel;
import fr.gemao.entity.administration.Droit;
import fr.gemao.entity.administration.Module;
import fr.gemao.entity.administration.Profil;
import fr.gemao.entity.administration.TypeDroit;
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
	 * Retourne vrai si le profil à le droit
	 * @param personnel
	 * @param droit
	 * @return true si droit
	 */
	public boolean aDroit(Profil profil, Droit droit){
		List<Droit> droits = profil.getListDroits();
		return droits.contains(droit);
	}
	
	public boolean aDroit(Profil profil, Module module, TypeDroit type){
		Droit droit = new Droit(type, module);
		return this.aDroit(profil, droit);
	}
	
	public boolean aDroit(Profil profil, String nomModule, String nomType){
		Module module = Module.getModule(nomModule);
		TypeDroit type = TypeDroit.getTypeDroit(nomType);
		return this.aDroit(profil, module, type);
	}
	
	public boolean aDroit(String nomProfil, String nomModule, String nomType){
		Profil profil = Profil.getProfil(nomProfil);
		return this.aDroit(profil, nomModule, nomType);
	}
	
	/**
	 * Donne la liste des modules du profil
	 * @param profil
	 * @return
	 */
	public List<Module> getListModuleADroit(Profil profil){
		List<Droit> droits = profil.getListDroits();
		List<Module> modules = new ArrayList<>();
		for(Droit d: droits){
			if(!modules.contains(d.getModule())){
				modules.add(d.getModule());
			}
		}
		return modules;
	}
	
	public List<String> getListeModuleDroit(Profil profil){
		List<Droit> droits = profil.getListDroits();
		List<String> modules = new ArrayList<>();
		for(Droit d: droits){
			if(!modules.contains(d.getModule())){
				modules.add(d.getModule().getNomModule());
			}
		}
		return modules;
	}
	
	public List<String> getListeModuleDroit(String nomProfil){
		Profil profil = Profil.getProfil(nomProfil);
		return this.getListeModuleDroit(profil);
	}
}
