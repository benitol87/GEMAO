package fr.gemao.view.materiel;

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

import fr.gemao.ctrl.materiel.CategorieCtrl;
import fr.gemao.ctrl.materiel.DesignationCtrl;
import fr.gemao.ctrl.materiel.FournisseurCtrl;
import fr.gemao.ctrl.materiel.MarqueCtrl;
import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Fournisseur;
import fr.gemao.entity.materiel.Marque;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.materiel.MaterielForm;
import fr.gemao.form.util.Form;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.materiel.CategorieDAO;
import fr.gemao.sql.materiel.DesignationDAO;
import fr.gemao.sql.materiel.EtatDAO;
import fr.gemao.sql.materiel.FournisseurDAO;
import fr.gemao.sql.materiel.MarqueDAO;

@WebServlet("/materiel/AjouterMateriel")
public class AjoutMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String ERREUR_AJOUT_CATEGORIE = "erreurCat";
	private static String ERREUR_AJOUT_DESIGNATION = "erreurDes";
	private static String ERREUR_AJOUT_FOURNISSEUR = "erreurFour";
	private static String ERREUR_AJOUT_MARQUE = "erreurMarque";
	private static String VUE = "/WEB-INF/pages/materiel/ajoutMateriel.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> listCat = new ArrayList<Categorie>();
		listCat = new CategorieDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_CATEGORIE", listCat);

		List<Etat> listEtat = new ArrayList<Etat>();
		listEtat = new EtatDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_ETAT", listEtat);

		List<Designation> listDes = new ArrayList<Designation>();
		listDes = new DesignationDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_DESIGNATION", listDes);

		List<Marque> listMarque = new ArrayList<Marque>();
		listMarque = new MarqueDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_MARQUE", listMarque);

		List<Fournisseur> listFourn = new ArrayList<Fournisseur>();
		listFourn = new FournisseurDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_FOURNISSEUR", listFourn);

		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MaterielForm form = new MaterielForm();

		// Récupération des données
		Materiel infoMat = new Materiel();
		infoMat.setTypeMat(Form.getValeurChamp(request, "type"));

		String nombre = Form.getValeurChamp(request, "quantite");
		if (nombre != null)
			infoMat.setQuantite(Integer.parseInt(nombre));

		nombre = Form.getValeurChamp(request, "ValeurAch");
		if (nombre != null)
			infoMat.setValeurAchat(Float.parseFloat(nombre));

		nombre = Form.getValeurChamp(request, "valRea");
		if (nombre != null)
			infoMat.setValeurReap(Float.parseFloat(nombre));

		infoMat.setObservation(Form.getValeurChamp(request, "observation"));
		infoMat.setNumSerie(Form.getValeurChamp(request, "numSerie"));
		session.setAttribute("INFOS", infoMat);

		// Ajout d'une catégorie, le fait qu'elle ne soit pas vide
		// a déjà été testé
		if (Form.getValeurChamp(request, "nomCat") != null) {
			try {
				CategorieCtrl.ajoutCategorie(Form.getValeurChamp(request,
						"nomCat"));
			} catch (DAOException e) {
				form.setErreur(ERREUR_AJOUT_CATEGORIE,
						"La catégorie existe déjà");
			}
		}

		if (Form.getValeurChamp(request, "nomDes") != null) {
			try {
				DesignationCtrl.ajoutDesignation(Form.getValeurChamp(request,
						"nomDes"));
			} catch (DAOException e) {
				form.setErreur(ERREUR_AJOUT_DESIGNATION,
						"La designation existe déjà");
			}
		}

		if (Form.getValeurChamp(request, "nomFour") != null) {
			try {
				FournisseurCtrl.ajoutFournisseur(Form.getValeurChamp(request,
						"nomFour"));
			} catch (DAOException e) {
				form.setErreur(ERREUR_AJOUT_FOURNISSEUR,
						"Le Fournisseur existe déjà");
			}
		}

		if (Form.getValeurChamp(request, "nomMarque") != null) {
			try {
				MarqueCtrl.ajouterMarque(Form.getValeurChamp(request,
						"nomMarque"));
			} catch (DAOException e) {
				form.setErreur(ERREUR_AJOUT_MARQUE,
						"La marque existe déjà");
			}
		}

		List<Categorie> listCat = new ArrayList<Categorie>();
		listCat = new CategorieDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_CATEGORIE", listCat);

		List<Etat> listEtat = new ArrayList<Etat>();
		listEtat = new EtatDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_ETAT", listEtat);

		List<Designation> listDes = new ArrayList<Designation>();
		listDes = new DesignationDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_DESIGNATION", listDes);

		List<Marque> listMarque = new ArrayList<Marque>();
		listMarque = new MarqueDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_MARQUE", listMarque);

		List<Fournisseur> listFourn = new ArrayList<Fournisseur>();
		listFourn = new FournisseurDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute("LISTE_FOURNISSEUR", listFourn);

		if (request.getParameter("nomMarque").equals("")
				&& request.getParameter("nomFour").equals("")
				&& request.getParameter("nomCat").equals("")
				&& request.getParameter("nomDes").equals("")) {

			String fournisseur = request.getParameter("fournisseur");
			String etat = request.getParameter("etat");
			String categorie = request.getParameter("categorie");
			String designation = request.getParameter("designation");
			float valAchat = Float
					.parseFloat(request.getParameter("ValeurAch"));
			float valReap = Float.parseFloat(request.getParameter("valRea"));
			String dateAchat = request.getParameter("dateAch");
			String type = request.getParameter("type");
			String marque = request.getParameter("marque");
			String observation = request.getParameter("observation");
			String numSerie = request.getParameter("numSerie");
			String quantite = request.getParameter("quantite");

			boolean deplacable = false;

			if (request.getParameter("deplacable") != null) {
				if (request.getParameter("deplacable").equals("on")) {
					deplacable = true;
				}
			}

			Materiel materiel = new Materiel();

			EtatDAO etatDAO = new EtatDAO(DAOFactory.getInstance());
			materiel.setEtat(etatDAO.get(Long.parseLong(etat)));

			CategorieDAO catDAO = new CategorieDAO(DAOFactory.getInstance());
			materiel.setCategorie(catDAO.get(Long.parseLong(categorie)));

			DesignationDAO desDAO = new DesignationDAO(DAOFactory.getInstance());
			materiel.setDesignation(desDAO.get(Long.parseLong(designation)));
			FournisseurDAO fourDAO = new FournisseurDAO(
					DAOFactory.getInstance());
			materiel.setFournisseur(fourDAO.get(Long.parseLong(fournisseur)));

			materiel.setValeurAchat(valAchat);
			materiel.setValeurReap(valReap);
			materiel.setObservation(observation);
			materiel.setNumSerie(numSerie);
			materiel.setDeplacable(deplacable);

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				materiel.setDateAchat(new java.sql.Date(formatter.parse(
						dateAchat).getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			materiel.setTypeMat(type);

			MarqueDAO marqDAO = new MarqueDAO(DAOFactory.getInstance());
			materiel.setMarque(marqDAO.get(Long.parseLong(marque)));

			MaterielCtrl.ajoutMateriel(materiel.getEtat(),
					materiel.getCategorie(), materiel.getMarque(),
					materiel.getDesignation(), materiel.getFournisseur(),
					materiel.getTypeMat(), materiel.getNumSerie(),
					materiel.getDateAchat(), materiel.getValeurAchat(),
					materiel.getValeurReap(), materiel.isDeplacable(),
					materiel.getObservation(), Integer.parseInt(quantite),
					materiel.isLouable());
			session.removeAttribute("INFOS");
		}

		request.setAttribute("form", form);
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

}
