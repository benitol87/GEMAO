package gemao.moduleAdherent.ctrl;

import gemao.entity.Adherent;

public class AjouterAdherentCtrl {

	public AjouterAdherentCtrl(){
		
	}
	
	public void ajoutAdherent(Adherent adherent){
		VerifierAdherentCtrl verifAdherent = new VerifierAdherentCtrl();
		
		if(verifAdherent.verifierInformations(adherent)){
			/**
			 *  ajout de l'adherent dans la bd
			 *  if (ca a marché) {
			 *  	syso ("L'adhérent à bien été ajouté");
			 *  } else {
			 *  	syso ("Une erreur est survenue lors de l'ajout de l'adhérent");
			 *  }
			 */
		} else {
			System.out.println("Les informations de l'adhérent ne sont pas valide");
		}
	}
}
