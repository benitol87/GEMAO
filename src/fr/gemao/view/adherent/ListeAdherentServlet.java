package fr.gemao.view.adherent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.adherent.RecupererAdherentCtrl;
import fr.gemao.entity.adherent.Adherent;

/**
 * Servlet implementation class ListeAdherentServlet
 */
@WebServlet("/ListeAdherents")
public class ListeAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_LISTEADHERENTS = "/listeAdherents.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeAdherentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecupererAdherentCtrl recupererAdherentCtrl = new RecupererAdherentCtrl();
		List<Adherent> adherents = recupererAdherentCtrl.recupererTousAdherents();
		request.setAttribute("listeAdherents", adherents);
		this.getServletContext().getRequestDispatcher( VUE_LISTEADHERENTS ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
