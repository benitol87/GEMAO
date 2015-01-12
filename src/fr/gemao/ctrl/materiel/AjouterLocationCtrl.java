package fr.gemao.ctrl.materiel;

import java.sql.Date;
import java.util.GregorianCalendar;

import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.ancien_mysql.gestionMateriel.LocationDAO;
import fr.gemao.entity.Personne;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Location;
import fr.gemao.entity.materiel.Materiel;

/**
 * 
 * @author kayzen
 *
 */
public class AjouterLocationCtrl {
	/**
	 * Permet de rajouter une Location dans la BdD. La date de fin de l'emprun
	 * est calculée automatiquement en fonction de la duree (en jours).
	 * 
	 * @param personne
	 *            la personne qui loue le materiel.
	 * @param materiel
	 *            le materiel loué.
	 * @param etatDebut
	 *            l'etat du materiel au début de la location.
	 * @param dateEmprunt
	 *            la date de debut de l'emprunt.
	 * @param duree
	 *            la durée de l'emprunt.
	 * @param montant
	 *            le montant de l'emprunt
	 */
	public static void ajouterLocation(Personne personne, Materiel materiel,
			Etat etatDebut, Date dateEmprunt, int duree, float montant) {
		if (personne == null) {
			throw new NullPointerException("L'adherent ne peut etre null");
		}
		if (materiel == null) {
			throw new NullPointerException("Le materiel ne peut etre null");
		}
		if (etatDebut == null) {
			throw new NullPointerException("L'etat ne peut etre null");
		}
		if (dateEmprunt == null) {
			throw new NullPointerException(
					"La date d'emprunt ne peut etre null");
		}
		if (duree <= 0) {
			throw new IllegalArgumentException(
					"La duree doit etre strictement positive");
		}
		if (montant <= 0) {
			throw new IllegalArgumentException(
					"Le montant doit etre strictement positif");
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dateEmprunt);
		gc.add(GregorianCalendar.DAY_OF_YEAR, duree); // Duree en jour
		Date dateRetour = new Date(gc.getTime().getTime());

		Location location = new Location(personne, materiel, etatDebut, null,
				dateEmprunt, dateRetour, duree, montant, null);

		new LocationDAO(ConnectionMySql.getInstance()).create(location);
	}
}
