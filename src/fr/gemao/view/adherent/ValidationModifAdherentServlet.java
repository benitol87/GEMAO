package fr.gemao.view.adherent;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.adherent.ModifierAdherentCtrl;
import fr.gemao.ctrl.adherent.ModifierResponsableCtrl;
import fr.gemao.entity.adherent.Adherent;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ValidationModifAdherentServlet
 */
@WebServlet(Pattern.ADHERENT_VALIDATION_MODIF)
public class ValidationModifAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("modif_adh_adherent");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateNaissance = formatter.format(adherent.getDateNaissance());
		String dateInscription = formatter.format(adherent.getDateEntree());
		
		request.setAttribute("dateNaissance", dateNaissance);
		request.setAttribute("dateInscription", dateInscription);
		request.setAttribute("adherent", adherent);
		
		this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_VALIDATION_MODIF)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Adherent adherent = (Adherent) session
				.getAttribute("modif_adh_adherent");
		
		ModifierResponsableCtrl modifierResponsableCtrl = new ModifierResponsableCtrl();
		modifierResponsableCtrl.modifierResponsable(adherent.getResponsable());
		
		ModifierAdherentCtrl modifierAdherentCtrl = new ModifierAdherentCtrl();
		modifierAdherentCtrl.modifierAdherent(adherent);
		
	}

}
