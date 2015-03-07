package fr.gemao.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.gemao.entity.Personnel;
import fr.gemao.view.ConnexionServlet;
import fr.gemao.view.JSPFile;

/**
 * Filtre qui teste que la personne connectée possède bien les droits
 * nécessaires pour accéder à la page demandée
 */
public class CheckRightsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckRightsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession();
		
		if(session.getAttribute(AllowAccessFilter.ATTR_ALLOW_ACCESS)!=null){
			// Accès autorisé (CSS, js par exemple)
			chain.doFilter(req, res);
			return;
		}
		
		Personnel personneConnectee = (Personnel) session.getAttribute(ConnexionServlet.ATT_SESSION_USER);
		
		String[] tab = request.getRequestURI().split("/");
		
		
		// Le premier élément de tab est le nom de l'application
		if(tab.length < 4){
			// Page hors d'un module
			// => pas besoin de droits
		} else {
			// Page dans un module
			String[] partiesModule = tab[2].split("-");
			String nomModule = partiesModule[0];
			
			// Problèmes d'accents.equal et d'encodage
			if(nomModule.equals("Adherent")){
				nomModule = "Adhérent";
			}
			if(nomModule.equals("Materiel")){
				nomModule = "Matériel";
			}
			
			if(partiesModule.length == 2){
				// Si le droit d'écriture doit être renseigné
				if(personneConnectee!=null && !personneConnectee.getProfil().recupererTypeDroit(nomModule).equals("Lecture/écriture")){
					// Refus de l'accès
					request.getRequestDispatcher(JSPFile.ERREUR_DROIT).forward(request, res);
					return;
				}
			} else {
				// Seul le droit de lecture est nécessaire
				if(personneConnectee!=null && personneConnectee.getProfil().recupererTypeDroit(nomModule).equals("Aucun")){
					// Refus de l'accès
					request.getRequestDispatcher(JSPFile.ERREUR_DROIT).forward(request, res);
					return;
				}
			}
		}

		// pass the request along the filter chain
		chain.doFilter(req, res);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
