package gemao.moduleAdherent;

import java.util.Date;

import gemao.entity.Adherent;
import gemao.moduleAdherent.ctrl.AjouterAdherentCtrl;

public class TestAdherentCtrl {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Adherent adherent = new Adherent(null, Long.valueOf(1),
				Long.valueOf(1), "Test", "Jean-Test", new Date("07/08/1995"),
				"0123456789", "0666666666", "jean.test@test.com", null, null,
				true, new Date("10/10/2014"), null, null, 100);
		
		AjouterAdherentCtrl ajouterAdherentCtrl = new AjouterAdherentCtrl();
		ajouterAdherentCtrl.ajoutAdherent(adherent);
		
		
	}
}
