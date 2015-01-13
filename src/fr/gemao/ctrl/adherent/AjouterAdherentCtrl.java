package fr.gemao.ctrl.adherent;

import java.sql.Connection;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.form.adherent.VerifierSyntaxeAdherent;
import fr.gemao.ancien_mysql.AdherentDAO;
import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.ancien_mysql.PersonneDAO;

public class AjouterAdherentCtrl {

	/**
	 * Constructeur
	 */
	public AjouterAdherentCtrl() {

	}

	/**
	 * Méthode permettant d'ajouter un adhérent dans la BD
	 * @param adherent
	 */
	public void ajoutAdherent(Adherent adherent) {
		VerifierSyntaxeAdherent verifAdherent = new VerifierSyntaxeAdherent();

		if (verifAdherent.verifierInformations(adherent)) {
			Personne test1;
			Adherent test2;

			Connection co = ConnectionMySql.getInstance();
			PersonneDAO personneDAO = new PersonneDAO(co);
			AdherentDAO adherentDAO = new AdherentDAO(co);

			test1 = personneDAO.create(adherent);
			if (test1 == null){
				System.out.println("Une erreur est survenue lors de l'insertion...");
			} else {
				adherent.setIdPersonne(test1.getIdPersonne());
				test2 = adherentDAO.create(adherent);
				if (test2 == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					System.out.println("L'adhérent a bien été ajouté.");
				}
			}

		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valides...");
		}
	}
}
