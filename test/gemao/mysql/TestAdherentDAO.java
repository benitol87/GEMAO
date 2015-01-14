package gemao.mysql;

import gemao.entity.Adherent;
import gemao.entity.Personne;

import java.sql.Connection;
import java.util.List;

public class TestAdherentDAO {

	public static void main(String[] args) {
		Connection co = ConnectionMySql.getInstance();
		AdherentDAO adherentDAO = new AdherentDAO(co);
		
		Adherent adherent = adherentDAO.get(2);
		System.out.println(adherent);
		 
		Personne personneNull = adherentDAO.get(0);
		System.out.println(personneNull);
		
		//Pour obtenir tous les adh�rent
		List<Adherent> liste = adherentDAO.getAll();
		System.out.println("\n Personnes : ");
		for(Adherent a : liste){
			System.out.println(a);
		}
	}
}
