
package fr.gemao.view.personnel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;
import fr.gemao.entity.util.Civilite;
import fr.gemao.sql.AdresseDAO;
import fr.gemao.sql.CommuneDAO;
import fr.gemao.sql.DAOFactory;

/**
 * Servlet implementation class AjoutPersonnelServlet
 */
@WebServlet("/personnel/AjoutPersonnel")
public class AjoutPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String VUE = "/WEB-INF/pages/personnel/ajoutPersonnel.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 *
		 */
		String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        String dateNaissance = request.getParameter( "date" );
        String telFixe = request.getParameter( "fixe" );
        String telPortable = request.getParameter( "portable" );
        String mail = request.getParameter("email");
        String adresse = request.getParameter("adresse");
        String codePostal = request.getParameter("code");
        String ville = request.getParameter("ville");
        String diplome = request.getParameter("diplome");
        String fonction = request.getParameter("fonction");
        
        String contrat = request.getParameter("type");
        String debcontrat = request.getParameter("datedeb");
        String duree = request.getParameter("duree");
        String fincontrat = request.getParameter("datefin");
        
        /**
         * Création du personnel
         */
        Date dateNaiss = new Date();
        Date dateDebCont = new Date();
        Date dateFinCont = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        try{
        	dateNaiss = formatter.parse(dateNaissance);
        	dateDebCont = formatter.parse(debcontrat);
        	dateFinCont = formatter.parse(fincontrat);
        } catch (ParseException e) {
			e.printStackTrace();
		}
        List<Responsabilite> list = new ArrayList<>();
        Personnel personnel = new Personnel(null, null, null, 
        		nom, prenom, dateNaiss, telFixe, telPortable, mail, Civilite.MONSIEUR, 
        		list, null, null, null, 0);
        
        /**
         * Récupération des données sur l'adresse
         */
        String adr = request.getParameter("adresse");
        String com = request.getParameter("ville");
        String cp = request.getParameter("codePostal");
        
        /**
         * Création de la commune
         */
        DAOFactory factory = DAOFactory.getInstance();
        CommuneDAO communeDAO = factory.getCommuneDAO();
        
        Commune commune = new Commune(null, Integer.parseInt(cp), com, false);
    	if (communeDAO.existNomCodePostal(commune) == null) {
			AjouterCommuneCtrl ajouterCommuneCtrl = new AjouterCommuneCtrl();
			ajouterCommuneCtrl.ajoutCommune(commune);
		}
    	commune = communeDAO.existNomCodePostal(commune);
        
    	/**
    	 * Création de l'adresse
    	 */
    	AdresseDAO adresseDAO = factory.getAdresseDAO();
        Adresse adrss = new Adresse(null, commune.getIdCommune(), null, adr, null);
        if (adresseDAO.exist(adrss) == null) {
			AjouterAdresseCtrl ajouterAdresseCtrl = new AjouterAdresseCtrl();
			ajouterAdresseCtrl.ajoutAdresse(adrss);
		}
		adrss = adresseDAO.exist(adrss);
		
		personnel.setIdCommuneNaiss(commune.getIdCommune());
		personnel.setIdAdresse(adrss.getIdAdresse());
		
		System.out.println(personnel);
        
        /* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext()
				.getRequestDispatcher(VUE)
				.forward(request, response);
	}

}

