package fr.gemao.ctrl.adherent;

import fr.gemao.entity.adherent.MotifSortie;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.adherent.MotifSortieDAO;

public class AjouterMotifSortieCtrl {
	
	/**
	 * Constructeur
	 */
	public AjouterMotifSortieCtrl(){
	}

	/**
	 * Méthode permettant de vérifier les informations d'un motif de sortie
	 * @param motif
	 * @return true si les informations sont valides, false sinon
	 */
	public boolean verifierInformations(MotifSortie motif){			
			//Vérification de l'idCommune
			if(motif.getLibelle() == null){
				System.out.println("L'objet MotifSortie ne doit pas être null...");
				return false;
			}
			
			return true;
	}
	
	/**
	 * Méthode permettant d'ajouter un motif de sortie dans la BD.
	 * Pour être ajoutée, les informations du motif doivent être valides et le motif ne doit pas déjà exister dans la base (sinon levée d'une IllegalArgumentException).
	 * @param adresse
	 */
	public void ajoutMotif(MotifSortie motif){
		//Vérification de la validité des informations
		if(this.verifierInformations(motif)){
			MotifSortie mot;
			
			DAOFactory co = DAOFactory.getInstance();
			MotifSortieDAO motifSortieDAO = co.getMotifSortieDAO();
			
			//Vérification de l'inexistance du motif dans la base
			mot = motifSortieDAO.exist(motif);
			if(mot == null){
				mot = motifSortieDAO.create(motif);
				if (mot == null){
					System.out.println("Une erreur est survenue lors de l'insertion...");
				} else {
					motif.setIdMotif(mot.getIdMotif());
					System.out.println("Le motif a bien été ajouté.");
				}
			}
			else{
				motif.setIdMotif(mot.getIdMotif());
			}
		}
		else{
			System.out.println("Les informations du motif ne sont pas valides...");
		}
		
	}
}
