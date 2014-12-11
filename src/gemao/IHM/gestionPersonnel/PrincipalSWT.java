package gemao.IHM.gestionPersonnel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import gemao.Config;
import gemao.Launcher;
import gemao.IHM.IStartingScreen;

public class PrincipalSWT  {
	public static int WINDOW_DEFAULT_WIDTH = 800;
	public static int WINDOW_DEFAULT_HEIGHT = 600;

	private Display display;
	private Shell shell;
	private Label label_nom;
	private Label label_prenom;
	private Label label_naissance;
	private Label label_email;
	private Label label_telFix;
	private Label label_telPor;

	private Label label_adresse;
	private Label label_ville;
	private Label label_codePostal;
	private Label label_diplome;
	private Label label_fonction;

	private Text text_nom;
	private Text text_prenom;
	private Text text_naissance;
	private Text text_email;
	private Text text_telFix;
	private Text text_telPor;

	private Text text_adresse;
	private Text text_ville;
	private Text text_codePostal;
	private Text text_diplome;
	private Text text_fonction;

	private Group groupe_adresse;
	private Group groupe_professionnel;

	private Button button_annuler;
	private Button button_valider;
	/*private Button button_plus;
	private Button button_moins;
	private Button button_plus2;
	private Button button_moins2;*/

	private Composite haut;
	private Composite centre;
	private Composite bas;
	private Composite date;
	/*private Composite boutonPlusMoins; 
	private Composite boutonPlusMoins2;*/

	private Combo combo_jour;
	private Combo combo_mois;
	private Combo combo_annee;

	public PrincipalSWT() {
		
		shell = new Shell(Launcher.display, SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX);

		shell.setLayout(new GridLayout(1, true));

		haut = new Composite(shell, SWT.NONE);
		haut.setLayout(new GridLayout(4, true));
		haut.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

		centre = new Composite(shell, SWT.NONE);
		centre.setLayout(new GridLayout(3, true));
		centre.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

		bas = new Composite(shell, SWT.NONE);
		bas.setLayout(new FillLayout());
		bas.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

		// Composite haut
		label_nom = new Label(haut, SWT.NONE);
		text_nom = new Text(haut, SWT.BORDER);
		text_nom.setTextLimit(Config.MAX_CHAR_INPUT);
		label_prenom = new Label(haut, SWT.NONE);
		text_prenom = new Text(haut, SWT.BORDER);
		label_naissance = new Label(haut, SWT.NONE);
		date = new Composite(haut, SWT.NONE);
		date.setLayout(new FillLayout());
		combo_jour = new Combo(date, SWT.BORDER);
		for (int i = 1; i <= 31; i++) {
			combo_jour.add(Integer.toString(i));
		}
		combo_mois = new Combo(date, SWT.BORDER);
		for (int i = 1; i <= 12; i++) {
			combo_mois.add(Integer.toString(i));
		}
		combo_annee = new Combo(date, SWT.BORDER);
		for (int i = 2014; i >= 1914; i--) {
			combo_annee.add(Integer.toString(i));
		}
		label_email = new Label(haut, SWT.NONE);
		text_email = new Text(haut, SWT.BORDER);
		label_telFix = new Label(haut, SWT.NONE);
		text_telFix = new Text(haut, SWT.BORDER);
		label_telPor = new Label(haut, SWT.NONE);
		text_telPor = new Text(haut, SWT.BORDER);
		label_nom.setText("*NOM : ");
		label_prenom.setText("*Prénom : ");
		label_naissance.setText("*Date de naissance : ");
		label_email.setText("*Adresse Email : ");
		label_telFix.setText("Téléphone fixe : ");
		label_telPor.setText("Téléphone portable : ");

		// Composite centre
		groupe_adresse = new Group(centre, SWT.NONE);
		groupe_adresse.setText("Adresse");
		groupe_adresse.setLayout(new GridLayout(2, true));

		label_adresse = new Label(groupe_adresse, SWT.NONE);
		label_adresse.setText("*Adresse : ");
		text_adresse = new Text(groupe_adresse, SWT.BORDER);
		text_adresse.setTextLimit(Config.MAX_CHAR_INPUT);
		label_ville = new Label(groupe_adresse, SWT.NONE);
		label_ville.setText("*Ville : ");
		text_ville = new Text(groupe_adresse, SWT.BORDER);
		label_codePostal = new Label(groupe_adresse, SWT.NONE);
		label_codePostal.setText("*Code Postal : ");
		text_codePostal = new Text(groupe_adresse, SWT.BORDER);

		new Label(centre, SWT.NONE);

		groupe_professionnel = new Group(centre, SWT.NONE);
		groupe_professionnel.setText("Professionnel");
		groupe_professionnel.setLayout(new GridLayout(2, true));
		label_diplome = new Label(groupe_professionnel, SWT.NONE);
		label_diplome.setText("Dipôme : ");
		text_diplome = new Text(groupe_professionnel, SWT.BORDER);
		/*boutonPlusMoins = new Composite(groupe_professionnel, SWT.NONE);
		boutonPlusMoins.setLayout(new FillLayout());
		button_plus = new Button(boutonPlusMoins, SWT.NONE);
		button_plus.setText("+");
		button_moins = new Button(boutonPlusMoins, SWT.NONE);
		button_moins.setText("-");
		new Label(groupe_professionnel, SWT.NONE);*/
		label_fonction = new Label(groupe_professionnel, SWT.NONE);
		label_fonction.setText("*Fonction : ");
		text_fonction = new Text(groupe_professionnel, SWT.BORDER);
		
		/*boutonPlusMoins2 = new Composite(groupe_professionnel, SWT.NONE);
		boutonPlusMoins2.setLayout(new FillLayout());
		button_plus2 = new Button(boutonPlusMoins2, SWT.NONE);
		button_plus2.setText("+");
		button_moins2 = new Button(boutonPlusMoins2, SWT.NONE);
		button_moins2.setText("-");*/
		

		// Composite bas
		button_annuler = new Button(bas, SWT.NONE);
		new Label(bas, SWT.NONE);
		button_valider = new Button(bas, SWT.NONE);
		button_annuler.setText("Annuler");
		button_valider.setText("Valider");

		shell.setSize(PrincipalSWT.WINDOW_DEFAULT_WIDTH,
				PrincipalSWT.WINDOW_DEFAULT_HEIGHT);
		shell.setText("GEMAO - Ajout de personnel 1/2");

		shell.pack();
		shell.open();
		this.dispatchEvents();
		this.start();
	}

	private void dispatchEvents(){
		button_annuler.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				shell.dispose();
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		button_valider.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				new SecondeSWT(shell);
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void start() {
		while (!shell.isDisposed()) {
			if (!Launcher.display.readAndDispatch()) {
				Launcher.display.sleep();
			}
		}
		//display.dispose();
	}

}
