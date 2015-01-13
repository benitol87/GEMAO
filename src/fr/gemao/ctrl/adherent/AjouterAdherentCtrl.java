package fr.gemao.ctrl.adherent;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.form.adherent.VerifierSyntaxeAdherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class AjouterAdherentCtrl {

	/**
	 * Constructeur
	 */
	public AjouterAdherentCtrl() {

	}

	public void ajoutAdherent(Adherent adherent) {
		VerifierSyntaxeAdherent verifAdherent = new VerifierSyntaxeAdherent();

		if (verifAdherent.verifierInformations(adherent)) {
			Personne test1;
			Adherent test2;

			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			AdherentDAO adherentDAO = co.getAdherentDAO();

			test1 = personneDAO.create(adherent);
			if (test1 == null){
				System.out.println("Une erreur est survenue lors de l'insertion");
			} else {
				adherent.setIdPersonne(test1.getIdPersonne());
				test2 = adherentDAO.create(adherent);
				if (test2 == null){
					System.out.println("Une erreur est survenue lors de l'insertion");
				} else {
					System.out.println("L'adhérent à bien été ajouté");
				}
			}

		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valide");
		}
	}
}
