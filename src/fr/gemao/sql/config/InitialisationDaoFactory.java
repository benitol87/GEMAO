package fr.gemao.sql.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.coyote.http11.NpnHandler;

import com.jolbox.bonecp.BoneCP;

import fr.gemao.entity.administration.Module;
import fr.gemao.entity.administration.Profil;
import fr.gemao.entity.administration.TypeDroit;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.administration.ModuleDAO;
import fr.gemao.sql.administration.ProfilDAO;
import fr.gemao.sql.administration.TypeDroitDAO;
import fr.gemao.sql.exception.DAOConfigurationException;
import fr.gemao.sql.exception.DAOException;

@WebListener
public class InitialisationDaoFactory implements ServletContextListener {
	public static final String ATT_DAO_FACTORY = "daofactory";

	private DAOFactory daoFactory;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try{
			/* Récupération du ServletContext lors du chargement de l'application */
			ServletContext servletContext = event.getServletContext();
			/* Instanciation de notre DAOFactory */
			this.daoFactory = DAOFactory.getInstance();
			/* Enregistrement dans un attribut ayant pour portée toute l'application */
			servletContext.setAttribute(ATT_DAO_FACTORY, this.daoFactory);
		} catch(DAOConfigurationException dCe){
			System.out.println("Erreur de configuration : " + dCe.getMessage());
		}
		
		try {
			/* Chargement des profils */
			//TODO à mettre dans un controleur ?
			TypeDroitDAO typeDroitDAO = this.daoFactory.geTypeDroitDAO();
			typeDroitDAO.load();
			ModuleDAO moduleDAO = this.daoFactory.getModuleDAO();
			moduleDAO.load();
			ProfilDAO profilDAO = this.daoFactory.getProfilDAO();
			profilDAO.load();
		} catch (DAOException e) {
			System.out.println("Erreur dao lors du chargement des profils : " + e.getMessage());
		}catch(NullPointerException nPe){
			System.out.println("Erreur, le dao n'est pas chargé, impossible de lire les profils : " + nPe.getMessage());
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		try {
			BoneCP connectionPool = DAOFactory.getConnectionPool();
			System.out.println("contextDestroyed....");
			if (connectionPool != null) {
				connectionPool.shutdown();
				connectionPool.close();
				System.out.println("contextDestroyed.....Connection Pooling shut downed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}