package fr.gemao.ctrl.materiel;

import java.sql.Date;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.entity.materiel.Reparateur;
import fr.gemao.entity.materiel.Reparation;
import fr.gemao.sql.gestionMateriel.ReparationDAO;

public class ReparationCtrl {

	public void ajourReparation(int idReparation, Reparateur reparateur,
			Date dateCertificat) {
		if (reparateur == null) {
			throw new NullPointerException("Le repareteur doit etre renseigne");
		}

		if (dateCertificat == null) {
			throw new NullPointerException("La date doit etre renseigne");

		}

		Reparation reparation = new Reparation(idReparation, reparateur,
				dateCertificat);
		new ReparationDAO(ConnectionMySql.getInstance()).create(reparation);
	}
}
