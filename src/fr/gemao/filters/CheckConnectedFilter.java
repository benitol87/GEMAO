package fr.gemao.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckConnectedFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
		/* Récupération de la session depuis la requête */
        HttpSession session = ((HttpServletRequest) request).getSession();
        
        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( "sessionObjectPersonnel" ) == null && session.getAttribute(AllowAccessFilter.ATTR_ALLOW_ACCESS)==null ) {
            /* Redirection vers la page de connexion */
            //response.sendRedirect( request.getContextPath() + "/Connexion" );
            request.getRequestDispatcher( "/Connexion" ).forward( request, response );
        } else {
        	if(session.getAttribute(AllowAccessFilter.ATTR_ALLOW_ACCESS)!=null)
        		session.setAttribute(AllowAccessFilter.ATTR_ALLOW_ACCESS, null);
            /* On continue le filtrage */
            chain.doFilter( request, response );
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
