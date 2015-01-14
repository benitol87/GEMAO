package fr.gemao.ctrl.adherent;

import fr.gemao.ctrl.AjouterPersonneCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;

public class AjouterAdherentCtrl {

	/**
	 * Constructeur
	 */
	public AjouterAdherentCtrl() {

	}
	
	public boolean verifierInformations(Adherent adherent){
		//A implémenter
		return true;
	}

	/**
	 * Méthode permettant d'ajouter un adhérent dans la BD
	 * @param adherent
	 */
	public void ajoutAdherent(Adherent adherent) {

		if (this.verifierInformations(adherent)) {
			AjouterPersonneCtrl ajoutPers = new AjouterPersonneCtrl();
			if(ajoutPers.ajoutPersonne(adherent) != -1){
				Adherent adh;

				DAOFactory co = DAOFactory.getInstance();
				AdherentDAO adherentDAO = co.getAdherentDAO();

				adh = adherentDAO.create(adherent);
				if (adh == null){
					System.out.println("Une erreur est survenue lors de l'insertion");
				} else {
					System.out.println("L'adhérent à bien été ajouté");
				}
			}
			else{
				System.out.println("Une erreur est survenue lors de l'insertion");
			}

		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valide");
		}
	}
}
