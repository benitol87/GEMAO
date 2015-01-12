package gemao.mysql;

import java.sql.Connection;

public class TestPoolConnexion {
	public static void main(String[] args) {
		Connection co = PoolConnexion.getInstance();
	}
}
