package fr.gemao.view.materiel;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import fr.gemao.view.JSPFile;
import fr.gemao.view.Pattern;

@WebServlet(Pattern.MATERIEL_MODIFIER)
public class ModifierMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VUE_LISTE = "/materiel/ListerMateriel";

	/**
	 * Chargement de la page de modification. Le parametre idMateriel doit etre
	 * envoyé pour le doGet (l'id correspond a celui du materiel a modifier.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
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
				
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String dateAchat = df.format(new Date(mat.getDateAchat().getTime()));
				request.setAttribute("dateAchat", dateAchat);

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

				List<Designation> listDes = desctrl
						.recupererToutesDesignations();
				listDes.remove(mat.getDesignation());
				session.setAttribute("listeDes", listDes);

				List<Marque> listMarque = marquectrl.recupererToutesMarques();
				listMarque.remove(mat.getMarque());
				session.setAttribute("listeMarque", listMarque);

				this.getServletContext()
						.getRequestDispatcher(JSPFile.MATERIEL_MODIFIER)
						.forward(request, response);
			} else {
				this.getServletContext()
						.getRequestDispatcher(JSPFile.MATERIEL_LISTER)
						.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
				session.removeAttribute("sessionObjectMateriel");
				session.removeAttribute("materiel");
				session.removeAttribute("listeEtats");
				session.removeAttribute("listeCat");
				session.removeAttribute("listeFourn");
				session.removeAttribute("listeDes");
			} else {
				form.setErreur("Modification", "Problème de session");
			}
		}
		if (form.getErreurs().isEmpty()) {
			response.sendRedirect(request.getContextPath() + VUE_LISTE + "?modifOk=0");
		} else {
			form.getErreurs().put("Modification",
					"Erreur lors de la modification du formulaire");
			
			request.setAttribute("form", form);
			this.getServletContext()
				.getRequestDispatcher(JSPFile.MATERIEL_MODIFIER)
				.forward(request, response);
		}
	}
}
