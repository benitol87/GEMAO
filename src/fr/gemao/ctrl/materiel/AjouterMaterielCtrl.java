package fr.gemao.ctrl.materiel;

import fr.gemao.ancien_mysql.AdherentDAO;
import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.ancien_mysql.PersonneDAO;
import fr.gemao.ctrl.adherent.Adherent;
import fr.gemao.ctrl.adherent.Connection;
import fr.gemao.ctrl.adherent.Personne;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.adherent.VerifierSyntaxeAdherent;

public class AjouterMaterielCtrl {
	public AjouterMaterielCtrl() {

	}

	public void ajoutMateriel(Materiel materiel) {
		VerifierSyntaxeMateriel verifMateriel = new VerifierSyntaxeMateriel();

		if (verifMateriel.verifierInformations(materiel)) {
			Materiel test;

			Connection co = ConnectionMySql.getInstance();
			MaterielDAO materielDAO = new MaterielDAO(co);

			test = materielDAO.create(materiel);
			if (test == null) {
				System.out
						.println("Une erreur est survenue lors de l'insertion");
			} else {
				System.out.println("Le materiel à bien été ajouté");
			}
		} else {
			System.out
					.println("Les informations du materiel ne sont pas valide");
		}

	}
}
