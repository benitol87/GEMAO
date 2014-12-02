package gemao.mysql;

import gemao.entity.Personne;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class TestPersonneDAO {

	public static void main(String[] args) {
		// On récupère une instance de Connection à la base
		Connection co = ConnectionMySql.getInstance();
		// On créer un Objet PersonneDAO qui gère les opérations sur la base
		PersonneDAO personneDAO = new PersonneDAO(co);
		
		// On recupère la personne dans la base avec l'id = 1
		Personne personne = personneDAO.get(1);
		System.out.println(personne);
		 
		//Si on cherche une personne qui n'existe pas un obtient null
		Personne personneNull = personneDAO.get(0);
		System.out.println(personneNull);
		
		//Pour obtenir tous les adhérent
		List<Personne> liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for(Personne p : liste){
			System.out.println(p);
		}
		
		System.out.println("\nAjout");
		//Pour ajouter une personne à la base on creer l'objet correspondant
		//N.B l'id est égale à 0 car auto incrémentation
		Personne personneAdd = new Personne(0L, 1L, 1L, "Test", "Riri", new Date(), 
				"0504030201", "0605040302","riri@unilim.fr", 0.5F );
		//On ajoute à la base la personne, on récupère la personne effectivement ajouter
		Personne rs = personneDAO.create(personneAdd);
		System.out.println(rs);
		
		//Pour laisser de verifier :-)
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for(Personne p : liste){
			System.out.println(p);
		}
		
		//Pour supprimer il suffit de passer en paramètre la personne avec l'id correspondant
		//N.B l'objet peut être vide mis à part pour l'id
		System.out.println("\nSuppression");
		personneDAO.delete(rs);
	}
}
