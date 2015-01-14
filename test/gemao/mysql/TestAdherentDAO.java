package gemao.mysql;

import java.sql.Connection;
import java.util.List;

import fr.gemao.entity.Personne;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;

public class TestAdherentDAO {

	public static void main(String[] args) {
		DAOFactory co = DAOFactory.getInstance();
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
