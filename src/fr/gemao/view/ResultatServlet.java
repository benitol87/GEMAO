package fr.gemao.view;

import javax.servlet.http.HttpServlet;

/**
 * Classe contenant uniquement le nom des variables utilisées
 * dans la page resultat.jsp.
 * Les méthodes doGet et doPost ne sont pas implémentées car
 * il n'y a, a priori, aucune raison d'accéder directement à
 * cette page.
 * 
 * @author Benoît
 *
 */
public class ResultatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String
		ATTR_TITRE_H1 = "titreH1",
		ATTR_RESULTAT = "resultat",
		ATTR_LIEN_BOUTON = "lienBouton",
		ATTR_NOM_BOUTON = "nomBouton";

}
