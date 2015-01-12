package fr.gemao.ctrl.materiel;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.ctrl.adherent.Connection;
import fr.gemao.entity.materiel.Categorie;

public class AjouterCategorieCtrl {
	public AjouterCategorieCtrl() {

	}

	public void ajoutAdherent(Categorie categorie){
		VerifierSyntaxeCategorie verifCate = new verifierSyntaxeXCategorie();
		
		if verifCate.verifierInformations(categorie)){
			Categorie test;
			
			Connection co = ConnectionMySql.getInstance();
			CategorieDAO categorieDAO = new CategorieDAO(co);
			
			test = categorieDAO.create(categorie);
			if(test == null){
				System.out.println("Une erreur est survenue lors de l'insertion");
			}else {
				System.out.println("L'adhérent à bien été ajouté");
			}
			
		}else {
			System.out
			.println("Les informations de l'adhérent ne sont pas valide");
		}
	}
}
