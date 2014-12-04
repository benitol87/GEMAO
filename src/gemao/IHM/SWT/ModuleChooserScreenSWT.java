package gemao.IHM.SWT;

import gemao.Launcher;
import gemao.IHM.gestionPersonnel.PrincipalSWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class ModuleChooserScreenSWT {
	private Shell shell;
	//private Label l_titre;
	private Button b_adherent, b_materiel, b_personnel, b_ca, b_partenaires, b_archives, b_cours, b_pedagogique, b_compta, b_salaires, b_profils;
	private Button b_quitter;
	
	public ModuleChooserScreenSWT(Shell fenetreConnexion) {
		if(fenetreConnexion!=null)
			fenetreConnexion.dispose();
		this.shell = new Shell(Launcher.display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		
		
		Group group = new Group(this.shell, SWT.NONE);
		GridLayout glayoutShell = new GridLayout();
		glayoutShell.numColumns = 2;
		group.setLayout (glayoutShell);
		
		GridLayout glayout = new GridLayout();
		glayout.numColumns = 1;
		this.shell.setLayout(glayout);
		
		
		b_adherent = new Button(group, SWT.NONE);
		b_archives = new Button(group, SWT.NONE);
		b_ca = new Button(group, SWT.NONE);
		b_compta = new Button(group, SWT.NONE);
		b_cours = new Button(group, SWT.NONE);
		b_materiel = new Button(group, SWT.NONE);
		b_partenaires = new Button(group, SWT.NONE);
		b_pedagogique = new Button(group, SWT.NONE);
		b_personnel = new Button(group, SWT.NONE);
		b_profils = new Button(group, SWT.NONE);
		b_salaires = new Button(group, SWT.NONE);
		
		b_quitter = new Button(this.shell, SWT.NONE);
		
		
		group.setText ("Modules");
		b_adherent.setText ("Module adhérent");
		b_archives.setText("Module archives");
		b_ca.setText("Module conseil d'administration");
		b_compta.setText("Module comptabilité");
		b_cours.setText("Module cours");
		b_materiel.setText ("Module matériel");
		b_personnel.setText ("Module personnel");
		b_partenaires.setText("Module partenaires");
		b_pedagogique.setText("Module pédagogie");
		b_profils.setText("Module profils");
		b_salaires.setText("Module salaires");
		b_quitter.setText("Quitter");
		
		
		
//		b_connect.setText("Se connecter");
//		b_connect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

				
		// shell.setSize(StartingScreenSWT.WINDOW_DEFAULT_WIDTH, StartingScreenSWT.WINDOW_DEFAULT_HEIGHT);
		this.shell.setText("Choix du module");

		Rectangle rect = Launcher.display.getClientArea();
		Point size = this.shell.getSize();
		int x = (rect.width - size.x) / 2;
		int y = (rect.height - size.y) / 2;
		this.shell.setLocation(new Point(x, y));
		
		this.shell.pack();
		
		shell.open();
		this.dispatchEvents();
		this.start();
	}
	
	private void start() {
		while (!shell.isDisposed()) {
			if (!Launcher.display.readAndDispatch()) {
				Launcher.display.sleep();
			}
		}
	}
	
	/**
	 * Méthode attribuant les listeners
	 */
	private void dispatchEvents(){
		b_quitter.addMouseListener(new MouseListener() {
			private boolean clicInterieur = false;

			@Override
			public void mouseUp(MouseEvent e) {
				if (clicInterieur) {
					shell.dispose();
				}
			}

			@Override
			public void mouseDown(MouseEvent e) {
				clicInterieur = true;
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// Rien
			}
		});
		
		b_personnel.addMouseListener(new MouseListener() {
					
			@Override
			public void mouseUp(MouseEvent arg0) {
				new PrincipalSWT();
				
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
}
