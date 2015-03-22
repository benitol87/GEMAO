package fr.gemao.view.personnel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.TypeContratCtrl;
import fr.gemao.ctrl.administration.ModificationCtrl;
import fr.gemao.ctrl.personnel.AjouterPersonnelCtrl;
import fr.gemao.ctrl.personnel.CalculerDateFinContratCtrl;
import fr.gemao.entity.personnel.Contrat;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.entity.administration.Modification;
import fr.gemao.util.Password;
import fr.gemao.view.ConnexionServlet;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class AjoutPersonnel2Servlet
 */
@WebServlet(Pattern.PERSONNEL_AJOUT2)
public class AjoutPersonnel2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( JSPFile.PERSONNEL_AJOUT2 ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		Personnel perso = (Personnel) session.getAttribute("personnel");
		
		perso.setPassword(Password.generatePassword(10));
		
		/**
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 */
		Integer typeContrat = Integer.valueOf(request.getParameter("type"));
		String debcontrat = request.getParameter("datedeb");
	    String duree = request.getParameter("duree");
	    
	    /**
	     * Création du personnel
	     */
	    Contrat contrat = new Contrat();
	    
	    CalculerDateFinContratCtrl calculerDateFinContratCtrl = new CalculerDateFinContratCtrl();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        try{
        	Date dateDeb = formatter.parse(debcontrat);
        	contrat.setDateDebut(dateDeb);
        } catch (ParseException e) {
			e.printStackTrace();
		}
        contrat.setDateFin(calculerDateFinContratCtrl.CalculerDateFinContrat(contrat.getDateDebut(), Integer.parseInt(duree)));
        TypeContratCtrl typeContratCtrl = new TypeContratCtrl();
        contrat.setTypeContrat(typeContratCtrl.recupererTypeContrat(typeContrat));
        
        perso.setContrat(contrat);
        
        AjouterPersonnelCtrl ajouterPersonnelCtrl = new AjouterPersonnelCtrl();
        ajouterPersonnelCtrl.ajouterPersonnel(perso);
        
        // Archivage
		new ModificationCtrl().ajouterModification(new Modification(
				0,
				(Personnel) session.getAttribute(ConnexionServlet.ATT_SESSION_USER),
				new Date(),
				"Ajout personnel : "+perso.getNom()+" "+perso.getPrenom()
		));
        
        /* Transmission à la page JSP en charge de l'affichage des données */
 		this.getServletContext()
 				.getRequestDispatcher(JSPFile.PERSONNEL_AJOUT3)
 				.forward(request, response);
	}

}
