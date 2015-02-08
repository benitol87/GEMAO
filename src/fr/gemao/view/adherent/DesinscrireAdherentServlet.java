package fr.gemao.view.adherent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.adherent.AjouterMotifSortieCtrl;
import fr.gemao.ctrl.adherent.RecupererMotifSortieCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.entity.adherent.MotifSortie;
import fr.gemao.form.adherent.DesinscrireAdherentForm;
import fr.gemao.form.util.Form;
import fr.gemao.sql.AdherentDAO;
import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.MotifSortieDAO;
import fr.gemao.sql.exception.DAOException;
import fr.gemao.sql.materiel.EtatDAO;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class DesinscrireAdherentServlet
 */
@WebServlet(Pattern.ADHERENT_DESINSCRIRE)
public class DesinscrireAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_IDADHERENT = "id";
	private static final String ATTR_LISTE_MOTIF = "listMotifSortie";
	private static final String ATTR_CACHE_LIBELLEMOTIF = "libelleMotif";
	private static final String ERREUR_AJOUT_MOTIFSORTIE = "erreurMotif";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = Form.getValeurChamp(req, CHAMP_IDADHERENT);
		if(id == null){
			req.getRequestDispatcher(Pattern.ACCUEIL).forward(req, resp);
		}else{
			HttpSession session = req.getSession();
			session.setAttribute(CHAMP_IDADHERENT, id);
			
			RecupererMotifSortieCtrl ctrl = new RecupererMotifSortieCtrl();
			List<MotifSortie> list = ctrl.recupererAllMotifSortie();
			
			req.setAttribute(ATTR_LISTE_MOTIF, list);
			req.getRequestDispatcher(JSPFile.ADHERENT_DESINSCRIRE_ADHERENT).forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		DesinscrireAdherentForm form = new DesinscrireAdherentForm();
		
		//Récupération des données
		MotifSortie infosMotif = new MotifSortie();
		String libelle = Form.getValeurChamp(request, ATTR_LISTE_MOTIF);
		if(libelle != null)
		{
			infosMotif.setLibelle(libelle);
		}
		
		session.setAttribute("INFOS", infosMotif);
		
		// Ajout d'un motif, le fait qu'elle ne soit pas vide
		// a déjà été testé
		if (Form.getValeurChamp(request, ATTR_CACHE_LIBELLEMOTIF) != null) {
			try {
				MotifSortie motif = new MotifSortie(null, Form.getValeurChamp(request,
						ATTR_CACHE_LIBELLEMOTIF));
				AjouterMotifSortieCtrl ajouterMotifCtrl = new AjouterMotifSortieCtrl();
				ajouterMotifCtrl.ajoutMotif(motif);
			} catch (DAOException e) {
				form.setErreur(ERREUR_AJOUT_MOTIFSORTIE,
						"Le motif de sortie existe déjà");
			}
		}
		
		List<MotifSortie> listMotif = new ArrayList<MotifSortie>();
		listMotif = new MotifSortieDAO(DAOFactory.getInstance()).getAll();
		request.setAttribute(ATTR_LISTE_MOTIF, listMotif);
		
		if(request.getParameter(ATTR_CACHE_LIBELLEMOTIF).equals(""))
		{
			libelle = request.getParameter(ATTR_LISTE_MOTIF);
			
			AdherentDAO adherentDAO = new AdherentDAO(DAOFactory.getInstance());
			Adherent adherent = new Adherent();
			adherent = adherentDAO.get((session.getAttribute(CHAMP_IDADHERENT)));
			
			MotifSortieDAO motifSortieDAO = new MotifSortieDAO(DAOFactory.getInstance());
			adherent.setMotif(motifSortieDAO.get(Long.parseLong(libelle)));
		}
		
		request.setAttribute("form", form);
		this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_DESINSCRIRE_ADHERENT)
				.forward(request, response);
	}
}
