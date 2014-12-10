package gemao.mysql;

import gemao.entity.Personne;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class TestPersonneDAO {

	public static void main(String[] args) {
		// On r�cup�re une instance de Connection � la base
		Connection co = ConnectionMySql.getInstance();
		// On cr�er un Objet PersonneDAO qui g�re les op�rations sur la base
		PersonneDAO personneDAO = new PersonneDAO(co);
		
		// On recup�re la personne dans la base avec l'id = 1
		Personne personne = personneDAO.get(1);
		System.out.println(personne);
		 
		//Si on cherche une personne qui n'existe pas un obtient null
		Personne personneNull = personneDAO.get(0);
		System.out.println(personneNull);
		
		//Pour obtenir tous les adh�rent
		List<Personne> liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for(Personne p : liste){
			System.out.println(p);
		}
		
		System.out.println("\nAjout");
		//Pour ajouter une personne � la base on creer l'objet correspondant
		//N.B l'id est �gale � 0 car auto incr�mentation
		Personne personneAdd = new Personne(0L, 1L, 1L, "Test", "Riri", new Date(), 
				"0504030201", "0605040302","riri@unilim.fr");
		//On ajoute � la base la personne, on r�cup�re la personne effectivement ajouter
		Personne rs = personneDAO.create(personneAdd);
		System.out.println(rs);
		
		
		//Pour mettre � jour on passe une Personne avec l'id correspondant avec les nouvelle
		//informations
		rs.setNom("DuChemoile");
		rs = personneDAO.update(rs);
		System.out.println("\n Mise � jour !");
		System.out.println(rs);
		
		liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for(Personne p : liste){
			System.out.println(p);
		}
		
		//Pour supprimer il suffit de passer en param�tre la personne avec l'id correspondant
		//N.B l'objet peut �tre vide mis � part pour l'id
		System.out.println("\nSuppression");
		try{
			personneDAO.delete(rs);
		}catch (UnsupportedOperationException uOe){
			uOe.printStackTrace();
		}
		
		liste = personneDAO.getAll();
		System.out.println("\n Personnes : ");
		for(Personne p : liste){
			System.out.println(p);
		}
	}
}
