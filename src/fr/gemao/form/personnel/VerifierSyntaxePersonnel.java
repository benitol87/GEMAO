package fr.gemao.form.personnel;

import fr.gemao.entity.Personnel;

public class VerifierSyntaxePersonnel {
	
	private boolean isValide;
	
	public VerifierSyntaxePersonnel() {
		this.isValide = true;
	}
	
	public boolean verifierInformations(Personnel personnel) {
		
		if (personnel.getNom() == null) {
			this.isValide = false;
		}
		
		if (personnel.getPrenom() == null) {
			this.isValide = false;
		}

		if (personnel.getJourNaiss() < 1 || personnel.getJourNaiss() > 31) {
			this.isValide = false;
		}
		
		if (personnel.getMoisNaiss() < 1 || personnel.getMoisNaiss() > 12) {
			this.isValide = false;
		}
		
		if (personnel.getAnneeNaiss() < 1900 || personnel.getAnneeNaiss() > 2100) {
			this.isValide = false;
		}
		
		if (personnel.getTelFix() == null) {
			this.isValide = false;
		}
		
		if (personnel.getTelPort() == null) {
			this.isValide = false;
		}
		
		if (personnel.getMail() == null) {
			this.isValide = false;
		}
		
		if (personnel.getAddresse() == null) {
			this.isValide = false;
		}
		
		if (personnel.getVille() == null) {
			this.isValide = false;
		}
		
		if (personnel.getCp() == null) {
			this.isValide = false;
		}
		
		if (personnel.getDiplome() == null) {
			this.isValide = false;
		}
		
		if (personnel.getFonction() == null) {
			this.isValide = false;
		}
		
		return isValide;
	}
}