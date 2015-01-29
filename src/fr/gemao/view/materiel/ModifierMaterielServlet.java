package fr.gemao.view.materiel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gemao.ctrl.materiel.CategorieCtrl;
import fr.gemao.ctrl.materiel.DesignationCtrl;
import fr.gemao.ctrl.materiel.EtatCtrl;
import fr.gemao.ctrl.materiel.FournisseurCtrl;
import fr.gemao.ctrl.materiel.MarqueCtrl;
import fr.gemao.ctrl.materiel.MaterielCtrl;
import fr.gemao.entity.materiel.Categorie;
import fr.gemao.entity.materiel.Designation;
import fr.gemao.entity.materiel.Etat;
import fr.gemao.entity.materiel.Fournisseur;
import fr.gemao.entity.materiel.Marque;
import fr.gemao.entity.materiel.Materiel;
import fr.gemao.form.materiel.MaterielForm;

@WebServlet("/materiel/ModifierMateriel")
public class ModifierMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String VUE_MODIFICATION = "/WEB-INF/pages/materiel/modifierMateriel.jsp";
	public static final String VUE_LISTE = "/materiel/ListerMateriel";

	/**
	 * Chargement de la page de modification. Le parametre idMateriel doit etre
	 * envoyé pour le doGet (l'id correspond a celui du materiel a modifier.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String param = request.getParameter("idMateriel");

		if (param != null) {
			int idParametre = Integer.parseInt(param);
			MaterielCtrl matctrl = new MaterielCtrl();
			Materiel mat = matctrl.recupererMateriel(idParametre);
			EtatCtrl etatctrl = new EtatCtrl();
			CategorieCtrl catctrl = new CategorieCtrl();
			FournisseurCtrl fournctrl = new FournisseurCtrl();
			DesignationCtrl desctrl = new DesignationCtrl();
			MarqueCtrl marquectrl = new MarqueCtrl();

			session.setAttribute("sessionObjectMateriel", mat);

			List<Etat> listEtats = etatctrl.getListeEtat();
			listEtats.remove(mat.getEtat());
			session.setAttribute("listeEtats", listEtats);

			List<Categorie> listCat = catctrl.recupererToutesCategories();
			listCat.remove(mat.getCategorie());
			session.setAttribute("listeCat", listCat);

			List<Fournisseur> listFourn = fournctrl.getListeFournisseur();
			listFourn.remove(mat.getFournisseur());
			session.setAttribute("listeFourn", listFourn);

			List<Designation> listDes = desctrl.recupererToutesDesignations();
			listDes.remove(mat.getDesignation());
			session.setAttribute("listeDes", listDes);

			
			List<Marque> listMarque = marquectrl.recupererToutesMarques();
			listMarque.remove(mat.getMarque());
			session.setAttribute("listeMarque", listMarque);

			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION)
					.forward(request, response);
		} else {
			request.setAttribute("page", "modifier");
			this.getServletContext().getRequestDispatcher(VUE_LISTE)
					.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		MaterielForm form = new MaterielForm();
		form.testerMateriel(request);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		System.out.print(form.getErreurs());
		if (form.getErreurs().isEmpty()) {
			MaterielCtrl matctrl = new MaterielCtrl();
			Materiel mat = null;
			if (session.getAttribute("sessionObjectMateriel").getClass() == Materiel.class) {
				mat = (Materiel) session.getAttribute("sessionObjectMateriel");

				CategorieCtrl catctrl = new CategorieCtrl();
				FournisseurCtrl fournctrl = new FournisseurCtrl();
				DesignationCtrl desctrl = new DesignationCtrl();
				EtatCtrl etatctrl = new EtatCtrl();
				MarqueCtrl marquectrl = new MarqueCtrl();

				mat.setCategorie(catctrl.recupererCategorie(form.getCategorie()));
				mat.setValeurAchat(form.getValAch());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					mat.setDateAchat(new java.sql.Date(formatter.parse(
							form.getDateAch()).getTime()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				mat.setValeurReap(form.getValRea());
				
				Fournisseur four = fournctrl.recupererFournisseur(form
						.getFournisseur());
				System.out.println(four);
				mat.setFournisseur(four);
				mat.setDesignation(desctrl.recupererDesignationCtrl(form
						.getDesignation()));
				mat.setTypeMat(form.getType());
				mat.setEtat(etatctrl.recupererEtat(form.getEtat()));
				mat.setMarque(marquectrl.recupererMarque(form.getMarque()));
				mat.setQuantite(form.getQuantite());
				mat.setNumSerie(form.getNumserie());
				mat.setDeplacable(form.getDeplacable());
				mat.setLouable(form.getLouable());
				mat.setObservation(form.getObservation());
				mat.setEtat(etatctrl.recupererEtat(form.getEtat()));

				matctrl.modifierMateriel(mat);
				session.removeAttribute("materiel");
				session.removeAttribute("listeEtats");
				session.removeAttribute("listeCat");
				session.removeAttribute("listeFourn");
				session.removeAttribute("listeDes");
			} else {
				form.setErreur("Modification", "Probleme de session");
			}
		}
		if (form.getErreurs().isEmpty()) {
			form.getErreurs().put("Modification",
					"Le materiel à bien été modifié");
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION)
					.forward(request, response);
			// response.sendRedirect(request.getContextPath() + VUE_LISTE);
		} else {
			form.getErreurs().put("Modification",
					"Erreur lors de la modification du formulaire");
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE_MODIFICATION)
					.forward(request, response);
		}
	}
}
