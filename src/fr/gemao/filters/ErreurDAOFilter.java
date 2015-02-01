package fr.gemao.filters;

import java.io.IOException;

import javax.naming.spi.InitialContextFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.sql.DAOFactory;
import fr.gemao.sql.config.InitialisationDaoFactory;


public class ErreurDAOFilter implements Filter {

	private boolean erreur;
	public static final String VUE_ERREUR = "/WEB-INF/pages/erreurs/daoErreur.jsp";
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
		if(this.erreur){
			request.getServletContext().getRequestDispatcher(VUE_ERREUR).forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		DAOFactory factory = (DAOFactory) servletContext.getAttribute(InitialisationDaoFactory.ATT_DAO_FACTORY);
		this.erreur = (factory == null);
	}

}
