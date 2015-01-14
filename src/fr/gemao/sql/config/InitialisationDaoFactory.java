package fr.gemao.sql.config;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jolbox.bonecp.BoneCP;
import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import fr.gemao.sql.DAOFactory;

@WebListener
public class InitialisationDaoFactory implements ServletContextListener {
	public static final String ATT_DAO_FACTORY = "daofactory";

	private DAOFactory daoFactory;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		/* Récupération du ServletContext lors du chargement de l'application */
		ServletContext servletContext = event.getServletContext();
		/* Instanciation de notre DAOFactory */
		this.daoFactory = DAOFactory.getInstance();
		/* Enregistrement dans un attribut ayant pour portée toute l'application */
		servletContext.setAttribute(ATT_DAO_FACTORY, this.daoFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		try {
			BoneCP connectionPool = DAOFactory.getConnectionPool();
			System.out.println("contextDestroyed....");
			if (connectionPool != null) {
				connectionPool.shutdown(); 
				System.out
						.println("contextDestroyed.....Connection Pooling shut downed!");
				connectionPool.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}