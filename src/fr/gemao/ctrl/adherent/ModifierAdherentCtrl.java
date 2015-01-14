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
	 * Méthode permettant de modifier un adhérent
	 * @param adherent
	 */
	public void modifierAdherent(Adherent adherent){
		VerifierSyntaxeAdherent verifAdherent = new VerifierSyntaxeAdherent();
		
		if(verifAdherent.verifierInformations(adherent)){
			Personne test1;
			Adherent test2;
			
			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			AdherentDAO adherentDAO = co.getAdherentDAO();
			
			test1 = personneDAO.update(adherent);
			if(test1 == null){
				System.out.println("Une erreur est survenue lors de la modification...");
			}
			else{
				adherent.setIdResponsable(test1.getIdPersonne());
				test2 = adherentDAO.update(adherent);
				if(test2 == null){
					System.out.println("Une erreur est survenue lors de la modification...");
				}
				else{
					System.out.println("Le responsable a bien été modifié.");
				}
			}
			
		}
		else{
			System.out.println("Les informations du responsable ne sont pas valides...");
		}	
	}

}
