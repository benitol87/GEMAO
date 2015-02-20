package fr.gemao.view.administration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.administration.ProfilsCtrl;
import fr.gemao.entity.administration.Droit;
import fr.gemao.entity.administration.Module;
import fr.gemao.entity.administration.Profil;
import fr.gemao.entity.administration.TypeDroit;
import fr.gemao.form.util.Form;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet(Pattern.ADMINISTRATION_MODIFIER_PROFIL)
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PARAM_IDENTIFIANT = "id";
	public static final String ATTR_PROFIL = "profil";
	public static final String ATTR_LISTE_MODULE = "listeModules";
	public static final String ATTR_LISTE_TYPE_DROIT = "listeTypeDroit";
	public static final String ATTR_SESSION_ID_PROFIL = "idProfil";
	public static final String CHAMP_DROIT_MODULE = "module";
	public static final String CHAMP_NOM_PROFIL = "nom";
	
	public static String ATTR_RESULTAT = "resultat",
    		ATTR_LIEN_BOUTON="lienBouton", ATTR_NOM_BOUTON = "nomBouton";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des données du profil dont l'identifiant est passé en paramètre
		String paramId = Form.getValeurChamp(request, PARAM_IDENTIFIANT);
		
		// Accès illégal à la page (pas de paramètre id passé en get)
		if(paramId == null){
			request.getRequestDispatcher(Pattern.ADMINISTRATION_LISTER_PROFIL).forward(request, response);
			return;
		}
			
		int id = Integer.parseInt(paramId);
		Profil p = new ProfilsCtrl().getProfil(id);
		
		// Passage de l'id du profil dans la session
		HttpSession session = request.getSession();
		session.setAttribute(ATTR_SESSION_ID_PROFIL, id);
				
		// Passage des données à la page jsp
		request.setAttribute(ATTR_PROFIL, p);
		request.setAttribute(ATTR_LISTE_MODULE, Module.getAllModules());
		request.setAttribute(ATTR_LISTE_TYPE_DROIT, TypeDroit.getAllTypeDroit());
		request.getRequestDispatcher(JSPFile.ADMINISTRATION_MODIFIER_PROFIL).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupéération de la session
		HttpSession session = request.getSession();
		
		Profil profil = new Profil();
		
		//Récupérer les données du formulaire et les mettre dans un objet Profil
		profil.setIdProfil((Integer) session.getAttribute(ATTR_SESSION_ID_PROFIL));
		
		// Ajout des droits à partir des données du formulaire
		String valeur;
		Collection<Module> listeModules = Module.getAllModules();
		List<Droit> listeDroits = new ArrayList<>();
		for(Module m : listeModules){
			// On récupère la valeur correspondant au module m
			valeur = Form.getValeurChamp(request, CHAMP_DROIT_MODULE + m.getIdModule() );
			
			// Si un droit a été positionné pour ce module, on l'ajoute à la liste
			if(valeur!=null){
				listeDroits.add(new Droit(TypeDroit.getTypeDroit(Integer.parseInt(valeur)), m));
			}
		}
		profil.setListDroits(listeDroits);
		profil.setNomProfil(Form.getValeurChamp(request, CHAMP_NOM_PROFIL));
		
		//Faire la mise à jour
		ProfilsCtrl profilCtrl = new ProfilsCtrl();
		profilCtrl.updateProfil(profil);
		
		request.setAttribute(ATTR_LIEN_BOUTON, Pattern.ADMINISTRATION_CONSULTER_PROFIL+"?id="+profil.getIdProfil());
		request.setAttribute(ATTR_NOM_BOUTON, "Retour");
		request.setAttribute(ATTR_RESULTAT, "La modification a bien été effectuée.");
		request.getRequestDispatcher(JSPFile.RESULTAT).forward(request, response);
	}

}
