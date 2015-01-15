package fr.gemao.view.personnel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.RecupererAdresseCtrl;
import fr.gemao.ctrl.RecupererCommuneCtrl;
import fr.gemao.ctrl.RecupererContratCtrl;
import fr.gemao.ctrl.personnel.RecupererPersonnelCtrl;
import fr.gemao.entity.Adresse;
import fr.gemao.entity.Commune;
import fr.gemao.entity.Contrat;
import fr.gemao.entity.Diplome;
import fr.gemao.entity.Personnel;
import fr.gemao.entity.Responsabilite;

/**
 * Servlet implementation class ConsulterPersonnelServlet
 */
@WebServlet("/personnel/ConsulterPersonnel")
public class ConsulterPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE = "/WEB-INF/pages/personnel/consulterPersonnel.jsp";
	private String VUE_ERREUR = "/WEB-INF/pages/erreurs/404.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id") == null){
			this.getServletContext().getRequestDispatcher(VUE_ERREUR)
			.forward(request, response);
		}

		long id = Long.parseLong(request.getParameter("id"));
		RecupererPersonnelCtrl recupererPersonnelCtrl = new RecupererPersonnelCtrl();
		Personnel personnel = recupererPersonnelCtrl.recupererPersonnel(id);

		RecupererAdresseCtrl recupererAdresseCtrl = new RecupererAdresseCtrl();
		Adresse adresse = recupererAdresseCtrl.recupererAdresse(personnel
				.getIdAdresse());

		RecupererCommuneCtrl recupererCommuneCtrl = new RecupererCommuneCtrl();
		Commune commune = recupererCommuneCtrl.recupererCommune(adresse
				.getIdCommune());

		RecupererContratCtrl recupererContratCtrl = new RecupererContratCtrl();
		Contrat contrat = recupererContratCtrl.recupererContrat(personnel
				.getContrat());

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateDebutContrat = formatter.format(contrat.getDateDebut());

		String dateFinContrat = null;
		if (contrat.getDateFin() != null) {
			dateFinContrat = formatter.format(contrat.getDateFin());
		}
		
		List<Responsabilite> listeResponsabilite = personnel.getListeResponsabilite();
		if(listeResponsabilite.isEmpty()){
			listeResponsabilite.add(new Responsabilite(0, "Aucune"));
		}
		
		List<Diplome> listeDiplome = personnel.getListeDiplomes();
		if(listeDiplome.isEmpty()){
			listeDiplome.add(new Diplome(0, "Aucun"));
		}

		request.setAttribute("listeDiplome", listeDiplome);
		request.setAttribute("listeResponsabilite", listeResponsabilite);
		request.setAttribute("personnel", personnel);
		request.setAttribute("adresse", adresse);
		request.setAttribute("commune", commune);
		request.setAttribute("contrat", contrat);
		request.setAttribute("dateDebutContrat", dateDebutContrat);
		request.setAttribute("dateFinContrat", dateFinContrat);
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
