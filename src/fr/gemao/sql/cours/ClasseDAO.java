package fr.gemao.sql.cours;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.gemao.entity.cours.Classe;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.IDAO;

public class ClasseDAO extends IDAO<Classe> {

	public ClasseDAO(DAOFactory factory) {
		super(factory);
	}

	@Override
	public Classe create(Classe obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Classe obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Classe update(Classe obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Classe> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Classe map(ResultSet result) throws SQLException {
		return null;
	}

}
