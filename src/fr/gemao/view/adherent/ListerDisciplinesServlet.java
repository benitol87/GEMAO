package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.adherent.AjouterDisciplineCtrl;
import fr.gemao.ctrl.adherent.ModifierDisciplineCtrl;
import fr.gemao.ctrl.adherent.RecupererDisciplineCtrl;
import fr.gemao.entity.cours.Discipline;
import fr.gemao.entity.cours.Matiere;
import fr.gemao.entity.cours.Niveau;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ListerDisciplinesServlet
 */
@WebServlet(Pattern.ADHERENT_LISTE_DISCIPLINES)
public class ListerDisciplinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.setAttribute("listDiscipline",
				RecupererDisciplineCtrl.recupererAllDiscipline());

		this.getServletContext()
				.getRequestDispatcher(JSPFile.ADHERENT_LISTE_DISCIPLINES)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		
		if(id==0){
			Matiere matiere = new Matiere(null, request.getParameter("matiere"));
			Niveau niveau = new Niveau(null, request.getParameter("niveau"));
			Discipline discipline = new Discipline(null, matiere, niveau, null);
			if(AjouterDisciplineCtrl.ajouterDiscipline(discipline)){
				request.setAttribute("ajoutOK", true);
				session.setAttribute("listDiscipline",
						RecupererDisciplineCtrl.recupererAllDiscipline());
			} else {
				request.setAttribute("ajoutKO", true);
			}
		}else{
			Discipline discipline = RecupererDisciplineCtrl.recupererDiscipline(id);
			Matiere matiere = new Matiere(null, request.getParameter("matiere"));
			Niveau niveau = new Niveau(null, request.getParameter("niveau"));
			discipline.setMatiere(matiere);
			discipline.setNiveau(niveau);
			if(ModifierDisciplineCtrl.modifierDiscipline(discipline)){
				request.setAttribute("modifOK", true);
				session.setAttribute("listDiscipline",
						RecupererDisciplineCtrl.recupererAllDiscipline());
			} else {
				request.setAttribute("modifKO", true);
			}
		}
		
		this.getServletContext()
				.getRequestDispatcher(JSPFile.ADHERENT_LISTE_DISCIPLINES)
				.forward(request, response);
	}

}
