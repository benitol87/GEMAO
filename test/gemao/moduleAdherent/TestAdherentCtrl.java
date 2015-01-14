package gemao.moduleAdherent;

import java.util.List;

import fr.gemao.entity.adherent.Adherent;
import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;

public class TestAdherentCtrl {

	public static void main(String[] args) {

		/**
		 * Test ajout adhérent
		 */
//		Adherent adherent = new Adherent(null, Long.valueOf(1),
//				Long.valueOf(1), "Test", "Jean-Test", new Date("07/08/1995"),
//				"0123456789", "0666666666", "jean.test@test.com", null, null,
//				true, new Date("10/10/2014"), null, null, 0);
//		
//		CalculerQuotientCtrl calculerQuotientCtrl = new CalculerQuotientCtrl();
//		adherent.setQf(calculerQuotientCtrl.calculerQuotient(30000, 5, 3));
//		
//		CalculerCotisationCtrl calculerCotisationCtrl = new CalculerCotisationCtrl();
//		adherent.setCotisation(calculerCotisationCtrl.calculerCotisations(adherent.getQf()));
//		
//		
//		AjouterAdherentCtrl ajouterAdherentCtrl = new AjouterAdherentCtrl();
//		ajouterAdherentCtrl.ajoutAdherent(adherent);
		
		/**
		 * Test récupérer adhérent(s)
		 */
		RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
		
		Adherent adherent2 = recupererAdherentCtrl.recupererAdherent(2);
		List<Adherent> listeAdherents = recupererAdherentCtrl.recupererTousAdherents();

		System.out.println("Adherent (personne 2) :\n"+adherent2+"\n\n");
		System.out.println("Liste des adhérents :\n");
		for(Adherent adherent : listeAdherents){
			System.out.println(adherent);
		}
		
		
	}
}
