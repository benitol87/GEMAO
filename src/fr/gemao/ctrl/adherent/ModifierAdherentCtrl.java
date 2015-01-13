package fr.gemao.ctrl.adherent;


import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.form.adherent.VerifierSyntaxeAdherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class ModifierAdherentCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierAdherentCtrl(){
		
	}
	
	/**
	 * Méthode permettant de modifier un adhérent dans la BD
	 * @param adherent
	 */
	public void modifierAdherent(Adherent adherent){
		VerifierSyntaxeAdherent verifAdherent = new VerifierSyntaxeAdherent();

		if (verifAdherent.verifierInformations(adherent)) {
			Personne test1;
			Adherent test2;

			DAOFactory factory = DAOFactory.getInstance();
			PersonneDAO personneDAO = factory.getPersonneDAO();
			AdherentDAO adherentDAO = factory.getAdherentDAO();

			test1 = personneDAO.update(adherent);
			if (test1 == null){
				System.out.println("Une erreur est survenue lors de la modification...");
			} else {
				adherent.setIdPersonne(test1.getIdPersonne());
				test2 = adherentDAO.update(adherent);
				if (test2 == null){
					System.out.println("Une erreur est survenue lors de la modification...");
				} else {
					System.out.println("L'adhérent a bien été modifié.");
				}
			}

		} else {
			System.out
					.println("Les informations de l'adhérent ne sont pas valides...");
		}
	}
}
