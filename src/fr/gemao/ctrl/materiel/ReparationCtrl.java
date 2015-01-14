package fr.gemao.ctrl.materiel;

import java.sql.Date;



import java.util.List;

import fr.gemao.entity.materiel.Reparateur;
import fr.gemao.entity.materiel.Reparation;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.materiel.ReparateurDAO;
import fr.gemao.sql.materiel.ReparationDAO;

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
		new ReparationDAO(DAOFactory.getInstance()).create(reparation);
	}
	
	public void supprimerReparation(int idReparation){
		if(idReparation <=0){
			throw new IllegalArgumentException("id invalide");
		}
		
		ReparationDAO repDAO = new ReparationDAO(DAOFactory.getInstance());

		List<Reparation> reps = repDAO.getAll();
		for (Reparation rep : reps) {
			if (rep.getIdReparation() == (idReparation)) {
				repDAO.delete(rep);
				break;
			}
		}
		
	}
	
	public Reparation recupererReparation(int idReparation){
		if(idReparation <=0){
			throw new IllegalArgumentException("id invalide");
		}
		
		ReparationDAO repDAO = new ReparationDAO(DAOFactory.getInstance());
		return repDAO.get(idReparation);
	}
}
	
