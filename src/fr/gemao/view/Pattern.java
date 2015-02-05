package fr.gemao.view;

public class Pattern {
	public final static String
		// Divers
			ACCUEIL = "/",
			CHANGER_MOT_DE_PASSE = "/ChangerMotDePasse",
			CONFIGURATION = "/Configuration",
			CONNEXION = "/Connexion",
			DECONNEXION = "/Deconnexion",
			
		// Module adhérent
			ADHERENT_AJOUT = "/adherent/AjoutAdherent",
			ADHERENT_AJOUT_RESPONSABLE = "/adherent/AjoutResponsable",
			ADHERENT_CALCUL_QF = "/adherent/CalculerQF",
			ADHERENT_SIMPLE_CALCUL_QF = "/adherent/SimpleCalculerQF",
			ADHERENT_CONSULTER = "/adherent/ConsulteAdherent",
			ADHERENT_LISTER = "/adherent/ListeAdherents",
			ADHERENT_MODIFIER = "/adherent/ModifierAdherent",
			ADHERENT_DESINSCRIRE = "/adherent/DesinscrireAdherent",
			ADHERENT_PARAMETRE = "/adherent/Parametres",
			ADHERENT_VALIDATION_AJOUT = "/adherent/ValidationAjoutAdherent",
			ADHERENT_VALIDATION_MODIF = "/adherent/ValidationModifAdherent",
			
		// Module administration
			ADMINISTRATION_RESET_PASSWORD = "/administration/ReinitMotDePasse",
			ADMINISTRATION_AJOUT_PROFIL = "/administration/AjouterProfil",
			ADMINISTRATION_LISTER_PROFIL = "/administration/ListerProfils",
			ADMINISTRATION_MODIFIER_PROFIL = "/administration/ModifProfil",
			
		// Module location
			LOCATION_LOCATION = "/location/locationInstrument",
			LOCATION_RETOUR = "/location/retourInstrument",
			
		// Module matériel
			MATERIEL_AJOUT = "/materiel/AjouterMateriel",
			MATERIEL_CONSULTER = "/materiel/ConsulterMateriel",
			MATERIEL_LISTER = "/materiel/ListerMateriel",
			MATERIEL_MODIFIER = "/materiel/ModifierMateriel",
			
		// Module personnel
			PERSONNEL_AJOUT = "/personnel/AjoutPersonnel",
			PERSONNEL_AJOUT2 = "/personnel/AjoutPersonnel2",
			PERSONNEL_CONSULTER = "/personnel/ConsulterPersonnel",
			PERSONNEL_LISTER = "/personnel/ListePersonnel",
			PERSONNEL_MODIFIER = "/personnel/ModifPersonnel",
	
	
		// Module Cours
			COURS_AJOUTEDT = "/cours/AjouterEmploiDuTemps";
}
