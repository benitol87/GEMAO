package gemao.IHM.gestionPersonnel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import gemao.IHM.IStartingScreen;

public class Principal implements IStartingScreen {
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

	private Composite haut;
	private Composite centre;
	private Composite bas;

	public Principal() {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX);

		shell.setLayout(new GridLayout(1, true));

		haut = new Composite(shell, SWT.NONE);
		haut.setLayout(new GridLayout(4, true));

		centre = new Composite(shell, SWT.NONE);
		centre.setLayout(new GridLayout(2, true));

		bas = new Composite(shell, SWT.NONE);
		bas.setLayout(new GridLayout(2, true));

		// Composite haut
		label_nom = new Label(haut, SWT.NONE);
		text_nom = new Text(haut, SWT.BORDER);
		label_prenom = new Label(haut, SWT.NONE);
		text_prenom = new Text(haut, SWT.BORDER);
		label_naissance = new Label(haut, SWT.NONE);
		text_naissance = new Text(haut, SWT.BORDER);
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
		label_ville = new Label(groupe_adresse, SWT.NONE);
		label_ville.setText("*Ville : ");
		text_ville = new Text(groupe_adresse, SWT.BORDER);
		label_codePostal = new Label(groupe_adresse, SWT.NONE);
		label_codePostal.setText("*Code Postal : ");
		text_codePostal = new Text(groupe_adresse, SWT.BORDER);

		
		groupe_professionnel = new Group(centre, SWT.NONE);
		groupe_professionnel.setText("Professionnel");
		groupe_professionnel.setLayout(new GridLayout(2, true));
		label_diplome = new Label(groupe_professionnel, SWT.NONE);
		label_diplome.setText("Diplôme : ");
		text_diplome = new Text(groupe_professionnel, SWT.BORDER);
		label_fonction = new Label(groupe_professionnel, SWT.NONE);
		label_fonction.setText("*Fonction : ");
		text_fonction = new Text(groupe_professionnel, SWT.BORDER);
		
		// Composite bas
		button_annuler = new Button(bas, SWT.NONE);
		button_valider = new Button(bas, SWT.NONE);
		button_annuler.setText("Annuler");
		button_valider.setText("Valider");

		shell.setSize(Principal.WINDOW_DEFAULT_WIDTH,
				Principal.WINDOW_DEFAULT_HEIGHT);
		shell.setText("Ajout de personnel 1/2");

		shell.pack();
		shell.open();
		this.start();
	}

	private void start() {
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
