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
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.administration.ModificationCtrl;
import fr.gemao.ctrl.personnel.AjouterPersonnelCtrl;
import fr.gemao.ctrl.personnel.CalculerDateFinContratCtrl;
import fr.gemao.entity.administration.Modification;
import fr.gemao.entity.personnel.Contrat;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.form.personnel.PersonnelForm;
import fr.gemao.form.util.Form;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("nom") == null){
			this.getServletContext().getRequestDispatcher(JSPFile.ERREUR_404).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Personnel perso = (Personnel) session.getAttribute("personnel");
		Integer typeContrat = null;
		String debcontrat = null;
		String debEnsei = null;
		String duree = null;
		
		perso.setPassword(Password.generatePassword(10));
		
		PersonnelForm personnelForm = new PersonnelForm();
		
		/**
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 */
		/* Si c'est le premier passage */
		if (Form.getValeurChamp(request, "type1") != null) {
	//		Integer typeContrat = Integer.valueOf(request.getParameter("type"));
	//		String debcontrat = request.getParameter("datedeb");
			debEnsei = request.getParameter("datedebEns");
	//	    String duree = request.getParameter("duree");
		    
		    /**
		     * Création du personnel
		     */
	//	    Contrat contrat = new Contrat();
	//	    
	//	    CalculerDateFinContratCtrl calculerDateFinContratCtrl = new CalculerDateFinContratCtrl();
	//	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//        try{
	//        	Date dateDeb = formatter.parse(debcontrat);
	//        	Date dateEnsei = formatter.parse(debEnsei);
	//        	contrat.setDateDebut(dateDeb);
	//        	perso.setDateEntree(dateEnsei);
	//        } catch (ParseException e) {
	//			e.printStackTrace();
	//		}
	//        contrat.setDateFin(calculerDateFinContratCtrl.CalculerDateFinContrat(contrat.getDateDebut(), Integer.parseInt(duree)));
	//        TypeContratCtrl typeContratCtrl = new TypeContratCtrl();
	//        contrat.setTypeContrat(typeContratCtrl.recupererTypeContrat(typeContrat));
	//        
	//        perso.setContrat(contrat);
		    
		    List<Contrat> listContrat = new ArrayList<>();
		    listContrat = personnelForm.lireContrats(request);
		    System.out.println(listContrat);
		    perso.setContrat(listContrat);
		    request.setAttribute("contrats", listContrat);
		    
		    CalculerDateFinContratCtrl calculerDateFinContratCtrl = new CalculerDateFinContratCtrl();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    Date dateEnsei;
			try {
				dateEnsei = formatter.parse(debEnsei);
				perso.setDateEntree(dateEnsei);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
	        session.setAttribute("ajout_personnel", perso);
	        
	        // Archivage
			new ModificationCtrl().ajouterModification(new Modification(
					0,
					(Personnel) session.getAttribute(ConnexionServlet.ATT_SESSION_USER),
					new Date(),
					"Ajout personnel : "+perso.getNom()+" "+perso.getPrenom()
			));
	        
	        /* Transmission à la page JSP en charge de l'affichage des données */
			this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_VALIDATION_AJOUT).forward(request, response);
		} else {
			/* Si c'est le deuxième passage, transmission à la page d'affichage du login/password */
			this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_AJOUT3).forward(request, response);
		}
	}
}
