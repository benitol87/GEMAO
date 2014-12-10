package gemao.moduleAdherent.ctrl;

import java.sql.Connection;

import gemao.entity.Adherent;
import gemao.entity.Personne;
import gemao.mysql.AdherentDAO;
import gemao.mysql.ConnectionMySql;
import gemao.mysql.PersonneDAO;

public class AjouterAdherentCtrl {

	public AjouterAdherentCtrl() {

	}

	public void ajoutAdherent(Adherent adherent) {
		VerifierAdherentCtrl verifAdherent = new VerifierAdherentCtrl();

		if (verifAdherent.verifierInformations(adherent)) {
			Personne test1;
			Adherent test2;

			Connection co = ConnectionMySql.getInstance();
			PersonneDAO personneDAO = new PersonneDAO(co);
			AdherentDAO adherentDAO = new AdherentDAO(co);

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
