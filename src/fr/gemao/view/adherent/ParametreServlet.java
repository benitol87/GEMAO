package fr.gemao.view.adherent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gemao.ctrl.ParametreCtrl;
import fr.gemao.entity.Parametre;
import fr.gemao.form.ParametreForm;
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

/**
 * Servlet implementation class ParametreServlet
 */
@WebServlet(Pattern.ADHERENT_PARAMETRE)
public class ParametreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ParametreCtrl parametreCtrl = new ParametreCtrl();
		Parametre parametre = parametreCtrl.getLast();
		if(parametre != null){
			request.setAttribute("alloc2", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc2()));
			request.setAttribute("alloc3", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc3()));
			request.setAttribute("alloc4", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc4()));
			request.setAttribute("alloc5", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc5()));
			request.setAttribute("qf_max", parametreCtrl.conversionDeSqlVersAffichage(parametre.getQf_max()));
			request.setAttribute("qf_min", parametreCtrl.conversionDeSqlVersAffichage(parametre.getQf_min()));
			request.setAttribute("tarifInstrument", parametreCtrl.conversionDeSqlVersAffichage(parametre.getTarifInstrument()));
			request.setAttribute("tarifFormation", parametreCtrl.conversionDeSqlVersAffichage(parametre.getTarifFormation()));
		}
		this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_PARAMETRE)
			.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ParametreForm form = new ParametreForm();
		ParametreCtrl parametreCtrl = new ParametreCtrl();
		
		Parametre parametre = form.ajoutParametre(request);
		if (form.getErreurs().isEmpty()) {
			try {
				parametreCtrl.controlerParametre(parametre);
			} catch (Exception e) {
				form.setErreur("Parametre", e.getMessage());
				System.out.println(form.getErreurs());
			}
		} else {
			System.out.println("Erreur");
		}
		request.setAttribute("form", form);
		request.setAttribute("alloc2", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc2()));
		request.setAttribute("alloc3", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc3()));
		request.setAttribute("alloc4", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc4()));
		request.setAttribute("alloc5", parametreCtrl.conversionDeSqlVersAffichage(parametre.getAlloc5()));
		request.setAttribute("qf_max", parametreCtrl.conversionDeSqlVersAffichage(parametre.getQf_max()));
		request.setAttribute("qf_min", parametreCtrl.conversionDeSqlVersAffichage(parametre.getQf_min()));
		request.setAttribute("tarifInstrument", parametreCtrl.conversionDeSqlVersAffichage(parametre.getTarifInstrument()));
		request.setAttribute("tarifFormation", parametreCtrl.conversionDeSqlVersAffichage(parametre.getTarifFormation()));
		this.getServletContext().getRequestDispatcher(JSPFile.ADHERENT_PARAMETRE)
				.forward(request, response);
	}

}
