package fr.gemao.ctrl.materiel;



import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.gemao.ancien_mysql.AdherentDAO;
import fr.gemao.ancien_mysql.ConnectionMySql;
import fr.gemao.ancien_mysql.PersonneDAO;
import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Marque;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.adherent.VerifierSyntaxeAdherent;
import fr.gemao.ancien_mysql.gestionMateriel.MaterielDAO;

public class MaterielCtrl {
	public MaterielCtrl() {

	}

	public void ajoutMateriel(int idMat,Etat etat,Categorie categorie, Marque marque, Designation designation,String typeMat,long numSerie,Date dateAchat, float valeurAchat,float valeurReap, boolean deplacable,String observation) {
		if(etat == null){
			throw new NullPointerException("L'etat ne doit pas etre null");
		}
		
		if(categorie == null){
			throw new NullPointerException("La categorie ne doit pas etre null");
		}
		
		if(marque == null){
			throw new NullPointerException("la marque ne doit pas etre null");
		}
		
		if(designation == null){
			throw new NullPointerException("La designation ne doit pas etre null");
		}
		
		if(typeMat == null){
			throw new NullPointerException("le type de materiel ne doit pas etre null");
		}
		
		if (typeMat == ""){
			throw new IllegalArgumentException("le type doit etre rempli");
		}
		
		if(dateAchat == null){
			throw new NullPointerException("La date d'achat ne doit pas etre null");
		}
		
		if(valeurAchat < 0.0){
			throw new IllegalArgumentException("la valeur d'achat ne peut pas etre negative");
		}
		
		if(valeurReap < 0.0){
			throw new IllegalArgumentException("la valeur ne peut pas etre negative");
		}
		
		Materiel materiel = new Materiel(idMat, etat, categorie, marque, designation, observation, numSerie, dateAchat, valeurReap, valeurReap, deplacable, observation);
		
		new MaterielDAO(ConnectionMySql.getInstance()).create(materiel);
		
		
	}
	
	public Materiel recupererMateriel(int idMateriel){
		Connection co = ConnectionMySql.getInstance();
		MaterielDAO materielDAO = new MaterielDAO(co);
		
		return materielDAO.get(idMateriel);
	}
	
	public List<Materiel> recupererTousMateriels(){
		List<Materiel> listeMateriel = new ArrayList<Materiel>();
		Connection co = ConnectionMySql.getInstance();
		MaterielDAO materielDAO = new MaterielDAO(co);
		
		listeMateriel = materielDAO.getAll();
		
		return listeMateriel;
	}
}
