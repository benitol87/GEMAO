package fr.gemao.view;

public class JSPFile {
	public static final String
			ROOT = "/WEB-INF/pages/",
		// Divers
			CHANGER_MOT_DE_PASSE = ROOT+"changerMotDePasse.jsp",
			CONFIGURATION = ROOT+"configuration.jsp",
			CONNEXION = ROOT+"connexion.jsp",
			RESULTAT = ROOT+"resultat.jsp",
			
		// Module adhérent
			REP_ADHERENT = "adherent/",
			ADHERENT_AJOUT_ADHERENT = ROOT+REP_ADHERENT+"ajoutAdherent.jsp",
			ADHERENT_AJOUT_RESPONSABLE = ROOT+REP_ADHERENT+"ajoutResponsable.jsp",
			ADHERENT_CALCUL_QF = ROOT+REP_ADHERENT+"calculQF.jsp",
			ADHERENT_CONFIRMATION_AJOUT = ROOT+REP_ADHERENT+"confirmationAjoutAdherent.jsp",
			ADHERENT_CONFIRMATION_MODIFICATION = ROOT+REP_ADHERENT+"confirmationModifAdherent.jsp",
			ADHERENT_CONSULTER = ROOT+REP_ADHERENT+"consulteAdherent.jsp",
			ADHERENT_ECHEC_AJOUT = ROOT+REP_ADHERENT+"echecAjoutAdherent.jsp",
			ADHERENT_ECHEC_MODIFICATION = ROOT+REP_ADHERENT+"echecModifAdherent.jsp",
			ADHERENT_LISTER = ROOT+REP_ADHERENT+"listeAdherents.jsp",
			ADHERENT_LISTER_ANCIEN = ROOT+REP_ADHERENT+"listeAnciensAdherents.jsp",
			ADHERENT_MODIFIER_ADHERENT = ROOT+REP_ADHERENT+"modifAdherent.jsp",
			ADHERENT_MODIFIER_RESPONSABLE = ROOT+REP_ADHERENT+"modifResponsable.jsp",
			ADHERENT_DESINSCRIRE_ADHERENT = ROOT+REP_ADHERENT+"desinscrireAdherent.jsp",
			ADHERENT_PARAMETRE = ROOT+REP_ADHERENT+"parametre.jsp",
			ADHERENT_VALIDATION_AJOUT = ROOT+REP_ADHERENT+"validAjoutAdherent.jsp",
			ADHERENT_VALIDATION_MODIF = ROOT+REP_ADHERENT+"validModifAdherent.jsp",
			ADHERENT_SAISIE_COTISATION = ROOT+REP_ADHERENT+"saisieCotisation.jsp",
					
		// Module administration
			REP_ADMINISTRATION = "administration/",
			ADMINISTRATION_AJOUT_PROFIL = ROOT+REP_ADMINISTRATION+"ajouterProfil.jsp",
			ADMINISTRATION_CONSULTER_PROFIL = ROOT+REP_ADMINISTRATION+"consulterProfil.jsp",
			ADMINISTRATION_LISTER_MODIFICATIONS = ROOT+REP_ADMINISTRATION+"listerModifs.jsp",
			ADMINISTRATION_LISTER_PROFILS = ROOT+REP_ADMINISTRATION+"listerProfils.jsp",
			ADMINISTRATION_MODIFIER_PROFIL = ROOT+REP_ADMINISTRATION+"modifierProfil.jsp",
			ADMINISTRATION_RESET_PASSWORD = ROOT+REP_ADMINISTRATION+"resetPassword.jsp",
			
		// Erreurs
			REP_ERREUR = "erreurs/",
			ERREUR = ROOT+REP_ERREUR+"erreur.jsp",
			ERREUR_404 = ROOT+REP_ERREUR+"404.jsp",
			ERREUR_DROIT = ROOT+REP_ERREUR+"erreurDroit.jsp",
			
		// Module location
			REP_LOCATION = "location/",
			LOCATION_LOCATION = ROOT+REP_LOCATION+"locationInstrument.jsp",
			LOCATION_RETOUR = ROOT+REP_LOCATION+"retourInstrument.jsp",
			
		// Module matériel
			REP_MATERIEL = "materiel/",
			MATERIEL_AJOUT = ROOT+REP_MATERIEL+"ajoutMateriel.jsp",
			MATERIEL_CONSULTER = ROOT+REP_MATERIEL+"consulterMateriel.jsp",
			MATERIEL_LISTER = ROOT+REP_MATERIEL+"listerMateriel.jsp",
			MATERIEL_MODIFIER = ROOT+REP_MATERIEL+"modifierMateriel.jsp",
			
		// Module personnel
			REP_PERSONNEL = "personnel/",
			PERSONNEL_AJOUT = ROOT+REP_PERSONNEL+"ajoutPersonnel.jsp",
			PERSONNEL_AJOUT2 = ROOT+REP_PERSONNEL+"ajoutPersonnel2.jsp",
			PERSONNEL_AJOUT3 = ROOT+REP_PERSONNEL+"ajoutPersonnel3.jsp",
			PERSONNEL_CONSULTER = ROOT+REP_PERSONNEL+"consulterPersonnel.jsp",
			PERSONNEL_LISTER = ROOT+REP_PERSONNEL+"listePersonnel.jsp",
			PERSONNEL_MODIFIER = ROOT+REP_PERSONNEL+"modifPersonnel.jsp",
			
		// Module Cours
			REP_COURS = "cours/",
			COURS_AJOUTEDT = ROOT+REP_COURS+"ajoutEDT.jsp",
			COURS_LISTE_DISCIPLINES = ROOT+REP_COURS+"listeDisciplines.jsp";
}