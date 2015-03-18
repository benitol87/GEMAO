package fr.gemao.view;

public class Pattern {
	public final static String
		// Module
			MODULE_ADHERENT = "/Adherent",
			MODULE_ADMINISTRATION = "/Administration",
			MODULE_LOCATION = "/Location",
			MODULE_MATERIEL = "/Materiel",
			MODULE_PERSONNEL= "/Personnel",
			MODULE_COURS= "/Cours",
			
		// Droit
			DROIT_ECRITURE = "-w",
	
		// Divers
			ACCUEIL = "/",
			CHANGER_MOT_DE_PASSE = "/ChangerMotDePasse",
			CONFIGURATION = "/Configuration",
			CONNEXION = "/Connexion",
			DECONNEXION = "/Deconnexion",
			
		// Module adhérent
			ADHERENT_AJOUT = MODULE_ADHERENT+DROIT_ECRITURE+"/AjoutAdherent",
			ADHERENT_AJOUT_RESPONSABLE = MODULE_ADHERENT+DROIT_ECRITURE+"/AjoutResponsable",
			ADHERENT_CALCUL_QF = MODULE_ADHERENT+DROIT_ECRITURE+"/CalculerQF",
			ADHERENT_SIMPLE_CALCUL_QF = MODULE_ADHERENT+"/SimpleCalculerQF",
			ADHERENT_CONSULTER = MODULE_ADHERENT+"/ConsulteAdherent",
			ADHERENT_LISTER = MODULE_ADHERENT+"/ListeAdherents",
			ADHERENT_LISTER_ANCIEN = MODULE_ADHERENT+"/ListeAnciensAdherents",
			ADHERENT_MODIFIER = MODULE_ADHERENT+DROIT_ECRITURE+"/ModifierAdherent",
			ADHERENT_DESINSCRIRE = MODULE_ADHERENT+DROIT_ECRITURE+"/DesinscrireAdherent",
			ADHERENT_PARAMETRE = MODULE_ADHERENT+DROIT_ECRITURE+"/Parametres",
			ADHERENT_VALIDATION_AJOUT = MODULE_ADHERENT+"/ValidationAjoutAdherent",
			ADHERENT_VALIDATION_MODIF = MODULE_ADHERENT+"/ValidationModifAdherent",
			ADHERENT_SAISIE_COTISATION = MODULE_ADHERENT+DROIT_ECRITURE+"/SaisieCotisation",
			ADHERENT_EXPORTER = MODULE_ADHERENT+"/exporter",
			ADHERENT_EXPORTER_ANCIENS = MODULE_ADHERENT+"/exporterAnciens",
			COURS_LISTE_DISCIPLINES = MODULE_ADHERENT+"/ListeDisciplines",
			ADHERENT_APAYE = MODULE_ADHERENT + "/APaye",
			
		// Module administration
			ADMINISTRATION_RESET_PASSWORD = MODULE_ADMINISTRATION+DROIT_ECRITURE+"/ReinitMotDePasse",
			ADMINISTRATION_AJOUT_PROFIL = MODULE_ADMINISTRATION+DROIT_ECRITURE+"/AjouterProfil",
			ADMINISTRATION_CONSULTER_PROFIL = MODULE_ADMINISTRATION+"/ConsulterProfil",
			ADMINISTRATION_LISTER_MODIFICATION = MODULE_ADMINISTRATION+"/ListerModifications",
			ADMINISTRATION_LISTER_PROFIL = MODULE_ADMINISTRATION+"/ListerProfils",
			ADMINISTRATION_MODIF_EXPORTER = MODULE_ADMINISTRATION+"/ExporterModifs",
			ADMINISTRATION_MODIFIER_PROFIL = MODULE_ADMINISTRATION+DROIT_ECRITURE+"/ModifierProfil",
			ADMINISTRATION_SUPPRIMER_PROFIL = MODULE_ADMINISTRATION+DROIT_ECRITURE+"/SupprimerProfil",

			
		// Module location
			LOCATION_LOCATION = MODULE_LOCATION+DROIT_ECRITURE+"/locationInstrument",
			LOCATION_RETOUR = MODULE_LOCATION+DROIT_ECRITURE+"/retourInstrument",
			
		// Module matériel
			MATERIEL_AJOUT = MODULE_MATERIEL+DROIT_ECRITURE+"/AjouterMateriel",
			MATERIEL_CONSULTER = MODULE_MATERIEL+"/ConsulterMateriel",
			MATERIEL_LISTER = MODULE_MATERIEL+"/ListerMateriel",
			MATERIEL_MODIFIER = MODULE_MATERIEL+DROIT_ECRITURE+"/ModifierMateriel",
			MATERIEL_EXPORTER = MODULE_MATERIEL+"/Exporter",
			
		// Module personnel
			PERSONNEL_AJOUT = MODULE_PERSONNEL+DROIT_ECRITURE+"/AjoutPersonnel",
			PERSONNEL_AJOUT2 = MODULE_PERSONNEL+DROIT_ECRITURE+"/AjoutPersonnel2",
			PERSONNEL_CONSULTER = MODULE_PERSONNEL+"/ConsulterPersonnel",
			PERSONNEL_LISTER = MODULE_PERSONNEL+"/ListePersonnel",
			PERSONNEL_MODIFIER = MODULE_PERSONNEL+DROIT_ECRITURE+"/ModifPersonnel",
			PERSONNEL_EXPORTER = MODULE_PERSONNEL+"/Exporter",
	
		// Module Cours
			COURS_AJOUTEDT = "/cours/AjouterEmploiDuTemps";
}
