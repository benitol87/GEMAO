package gemao.IHM.gestionPersonnel;

import gemao.Launcher;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Classe SecondeSWT intervenant après la classe PrincipalSWT
 * @author Coco
 *
 */
public class SecondeSWT {
	public static int WINDOW_DEFAULT_WIDTH = 100;
	public static int WINDOW_DEFAULT_HEIGHT = 100;

	/* Décalaration Shell */
	private Shell shell;
	private Shell fenetrePersonnelle1;
	
	/* Décalaration Label */

	private Label label_nom;
	private Label label_prenom;
	private Label label_contrat;
	private Label label_date_debut;
	private Label label_duree;
	private Label label_mois;
	private Label label_date_fin;
	private Label label_slash1;
	private Label label_slash2;

	/* Décalaration Text */
	private Text text_nom;
	private Text text_prenom;
	private Text text_duree;
	private Text text_date_fin;

	/* Décalaration Button */
	private Button button_annuler;
	private Button button_valider;

	/* Décalaration Composite */
	private Composite nom;
	private Composite contrat;
	private Composite date_debut;
	private Composite duree;
	private Composite date_fin;
	private Composite boutons;

	/* Décalaration Combo */
	private Combo type_contrat;
	private Combo combo_jour;
	private Combo combo_mois;
	private Combo combo_annee;

	/**
	 * Constructeur par défaut de la classe SecondeSWT

	 * @param fenetrePersonnelle1
	 * 		Le shell de la classe PrincipalSWT
	 */
	public SecondeSWT(Shell fenetrePersonnelle1) {
		if (fenetrePersonnelle1 != null) {
			this.fenetrePersonnelle1 = fenetrePersonnelle1;
			fenetrePersonnelle1.setVisible(false);;
		}
		
		this.shell = new Shell(Launcher.display, SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX);

		shell.setLayout(new GridLayout(1, true));
		
		/* Instanciations des Composites */
		nom = new Composite(shell, SWT.NONE);
		nom.setLayout(new GridLayout(4, true));
		nom.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		
		contrat = new Composite(shell, SWT.NONE);
		contrat.setLayout(new GridLayout(2, true));
		contrat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		
		date_debut = new Composite(shell, SWT.NONE);
		date_debut.setLayout(new GridLayout(6, false));
		date_debut.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		
		duree = new Composite(shell, SWT.NONE);
		duree.setLayout(new GridLayout(3, true));
		duree.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		
		date_fin = new Composite(shell, SWT.NONE);
		date_fin.setLayout(new GridLayout(2, true));
		date_fin.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		
		boutons = new Composite(shell, SWT.NONE);
		boutons.setLayout(new GridLayout(2, true));
		boutons.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

		/* Instanciations Label/Text/Combo/Button */
		label_nom = new Label(nom, SWT.NONE);
		text_nom = new Text(nom, SWT.BORDER);
		label_prenom = new Label(nom, SWT.NONE);
		text_prenom = new Text(nom, SWT.BORDER);
		
		label_contrat = new Label(contrat, SWT.NONE);
		type_contrat = new Combo(contrat, SWT.BORDER);
		
		label_date_debut = new Label(date_debut, SWT.NONE);
		combo_jour = new Combo(date_debut, SWT.BORDER);
		label_slash1 = new Label(date_debut, SWT.NONE);
		combo_mois = new Combo(date_debut, SWT.BORDER);
		label_slash2 = new Label(date_debut, SWT.NONE);
		combo_annee = new Combo(date_debut, SWT.BORDER);
		
		label_duree = new Label(duree, SWT.NONE);
		text_duree = new Text(duree, SWT.BORDER);
		
		label_mois = new Label(duree, SWT.NONE);
		
		label_date_fin = new Label(date_fin, SWT.NONE);
		text_date_fin = new Text(date_fin, SWT.BORDER);
		
		button_annuler = new Button(boutons, SWT.NONE);
		button_valider = new Button(boutons, SWT.NONE);
		
		/* Remplissage des Combos */
		for (int i = 1; i <= 31; i++) {
			combo_jour.add(Integer.toString(i));
		}
		
		for (int i = 1; i <= 12; i++) {
			combo_mois.add(Integer.toString(i));
		}
		
		for (int i = 2014; i >= 1914; i--) {
			combo_annee.add(Integer.toString(i));
		}

		/* Ajout des textes dans les composants */
		label_nom.setText("*NOM : ");
		label_prenom.setText("*Prénom : ");
		
		label_contrat.setText("Type de contrat : ");
		type_contrat.add("CDI");
		type_contrat.add("CDD");
		type_contrat.add("Bénévola");
		
		label_date_debut.setText("*Date de début : ");
		
		label_slash1.setText("/");
		label_slash2.setText("/");
		
		label_duree.setText("Durée du contrat : ");
		
		label_mois.setText("mois");
		
		label_date_fin.setText("Date de fin : ");
		
		button_annuler.setText("Annuler");
		button_valider.setText("Valider");

		shell.setSize(SecondeSWT.WINDOW_DEFAULT_WIDTH, SecondeSWT.WINDOW_DEFAULT_HEIGHT);
		shell.setText("GEMAO - Ajout de personnel 2/2");
		
		shell.pack();
		shell.open();

		this.dispatchEvents();
		this.start();
	}
	
	/**
	 * Méthode d'ajout des écouteurs
	 */
	private void dispatchEvents(){
		button_annuler.addMouseListener(new MouseListener() {
			
			/**
			 * Redéfinition de la méthode de l'écouteur sur le bouton de la souris relaché
			 */
			@Override
			public void mouseUp(MouseEvent arg0) {
				fenetrePersonnelle1.setVisible(true);
				shell.dispose();
			}
			
			/**
			 * Redéfinition de la méthode de l'écouteur sur le bouton de la souris enfoncé
			 */
			@Override
			public void mouseDown(MouseEvent arg0) {
				
			}
			
			/**
			 * Redéfinition de la méthode de l'écouteur sur le double clic
			 */
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				
			}
		});
		
		button_valider.addMouseListener(new MouseListener() {
			
			/**
			 * Redéfinition de la méthode de l'écouteur sur le bouton de la souris relaché
			 */
			@Override
			public void mouseUp(MouseEvent arg0) {
				
			}
			
			/**
			 * Redéfinition de la méthode de l'écouteur sur le bouton de la souris enfoncé
			 */
			@Override
			public void mouseDown(MouseEvent arg0) {
				
			}
			
			/**
			 * Redéfinition de la méthode de l'écouteur sur le double clic
			 */
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				
			}
		});
	}

	/**
	 * Méthode qui permet de mettre en pause le Launcher
	 */
	private void start() {
		while (!shell.isDisposed()) {
			if (!Launcher.display.readAndDispatch()) {
				Launcher.display.sleep();
			}
		}
	}
}
