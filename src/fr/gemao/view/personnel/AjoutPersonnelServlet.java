package fr.gemao.view.personnel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.Config;
import fr.gemao.ctrl.AjouterAdresseCtrl;
import fr.gemao.ctrl.AjouterCommuneCtrl;
import fr.gemao.ctrl.adherent.RecupererDisciplineCtrl;
import fr.gemao.ctrl.personnel.AjouterPersonnelCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.personnel.Diplome;
import fr.gemao.entity.personnel.Personnel;
import fr.gemao.entity.personnel.Responsabilite;
import fr.gemao.entity.util.Civilite;
import fr.gemao.form.personnel.PersonnelForm;
import fr.gemao.form.util.Form;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.ResponsabiliteDAO;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;
import fr.gemao.view.util.AutocompletionAdresse;
import fr.gemao.view.util.AutocompletionCommune;

/**
 * Servlet implementation class AjoutPersonnelServlet
 */
@WebServlet(Pattern.PERSONNEL_AJOUT)
public class AjoutPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ResponsabiliteDAO responsabiliteDAO = DAOFactory.getInstance().getResponsabiliteDAO();
		List<Responsabilite> responsabilites = responsabiliteDAO.getAll();
		session.setAttribute("listResponsabilites", responsabilites);
		session.setAttribute("listDiscipline", RecupererDisciplineCtrl.recupererAllDiscipline());
		
		request = AutocompletionCommune.initRequestForAutoCompletionCommune(request);
		request = AutocompletionAdresse.initRequestForAutoCompletionAdresse(request);
		
		session.setAttribute("ajout_pers_personnel", null);
		
		this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_AJOUT).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Récupération des données saisies, envoyées en tant que paramètres de
		 * la requète POST générée à la validation du formulaire
		 *
		 */
		HttpSession session = request.getSession();
		 
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("date");
		String telFixe = request.getParameter("fixe");
		String telPortable = request.getParameter("portable");
		String mail = request.getParameter("email");
		String numrue = request.getParameter("numRue");
		String nomrue = request.getParameter("nomRue");
		String codePostal = request.getParameter("code");
		String ville = request.getParameter("ville");
		String civilite = request.getParameter("civilite");
		String infoComplementaire = request.getParameter("infoComplem");	
		String membreCA = request.getParameter("membreCA");
		String numeroSS = Form.getValeurChamp(request, "numeroSS");

		/**
		 * Création de la commune
		 */
		new AjouterCommuneCtrl();
		Commune commune = new Commune(null, Integer.parseInt(codePostal), ville, false);
		AjouterCommuneCtrl.ajoutCommune(commune);
		
		/**
		 * Création de l'adresse
		 */
		Adresse adrss = new Adresse();
		adrss.setNumRue(numrue);
		adrss.setNomRue(nomrue);
		adrss.setInfoCompl(infoComplementaire);	
		adrss.setCommune(commune);
		
		new AjouterAdresseCtrl();
		AjouterAdresseCtrl.ajoutAdresse(adrss);
		
		
		Personnel personnel = new Personnel();
		personnel.setAdresse(adrss);
		if(civilite.equals("Monsieur")){
			personnel.setCivilite(Civilite.MONSIEUR);
		}
		if(civilite.equals("Madame")){
			personnel.setCivilite(Civilite.MADAME);
		}
		
		//Lecture des listes
		PersonnelForm personnelForm = new PersonnelForm();
		personnel.setListeResponsabilite(personnelForm.lireResponsabilites(request));
		personnel.setListeDiplomes(personnelForm.lireDiplomes(request));
		personnel.setListeDiscipline(personnelForm.lireDisciplines(request));
		
		AjouterPersonnelCtrl apc = new AjouterPersonnelCtrl();
		
		personnel.setCommuneNaiss(commune);
		personnel.setEmail(mail);
		personnel.setNom(nom);
		personnel.setPrenom(prenom);
		personnel.setTelFixe(telFixe);
		personnel.setTelPort(telPortable);	
		personnel.setPassword(Config.params.get(Config.MOT_DE_PASSE));
		personnel.setLogin(apc.genererLogin(nom));
		personnel.setMembreCA(Boolean.parseBoolean(membreCA));
		personnel.setNumeroSS(numeroSS);
		
		System.out.println(personnel);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			personnel.setDateNaissance(formatter.parse(dateNaissance));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("personnel", personnel);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(JSPFile.PERSONNEL_AJOUT2).forward(request, response);
	}
}