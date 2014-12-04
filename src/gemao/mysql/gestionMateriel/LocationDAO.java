package gemao.mysql.gestionMateriel;

import java.sql.Connection;
import java.util.List;

import gemao.application.gestionMateriel.Etat;
import gemao.mysql.DAOMySql;

public class LocationDAO extends DAOMySql<Etat> {

	public LocationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Etat create(Etat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Etat obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Etat update(Etat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etat get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
