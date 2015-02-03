package fr.gemao.ctrl;

import fr.gemao.entity.Personne;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.PersonneDAO;

public class ModifierPersonneCtrl {
	
	/**
	 * Constructeur
	 */
	public ModifierPersonneCtrl(){
	}
	
	/**
	 * Méthode permettant de modifier les informations d'une personne dans la BD.
	 * Pour être modifiée, les informations de la personne doivent être valides et la personne doit exister dans la base (sinon levée d'une IllegalArgumentException).
	 * @param personne
	 * @return l'identifiant de la personne modifiée, -1 si la modification n'a pas pu être réalisée
	 */
	public long modifierPersonne(Personne personne){
		AjouterPersonneCtrl ajoutPersonne = new AjouterPersonneCtrl();
		
		//Vérification de la validité des informations
		if(ajoutPersonne.verifierInformations(personne)){
			Personne pers;
			
			DAOFactory co = DAOFactory.getInstance();
			PersonneDAO personneDAO = co.getPersonneDAO();
			
			//Vérification de l'existance de la personne dans la BD
			if(personneDAO.get(personne.getIdPersonne()) != null){
				pers = personneDAO.update(personne);
				if(pers == null){
					System.out.println("Une erreur est survenue lors de la modification...");
					return -1;
				}
				else{
						System.out.println("La personne a bien été modifiée.");
						return pers.getIdPersonne();
				}
			}
			else{
				throw new IllegalArgumentException("La personne n'existe pas dans la base...");
			}		
		}
		else{
			System.out.println("Les informations de la personne ne sont pas valides...");
			return -1;
		}	
	}
}