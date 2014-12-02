package gemao.IHM.SWT;

import gemao.Launcher;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class ModuleChooserScreen {
	private Shell shell;
	//private Label l_titre;
	private Button b_adherent, b_materiel, b_personnel;
	private Button b_quitter;
	
	public ModuleChooserScreen() {
		shell = new Shell(Launcher.display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		
		
		Group group = new Group(shell, SWT.NONE);
		GridLayout glayoutShell = new GridLayout();
		glayoutShell.numColumns = 2;
		group.setLayout (glayoutShell);
		
		GridLayout glayout = new GridLayout();
		glayout.numColumns = 1;
		shell.setLayout(glayout);
		
		
		b_adherent = new Button(group, SWT.NONE);
		b_materiel = new Button(group, SWT.NONE);
		b_personnel = new Button(group, SWT.NONE);
		b_quitter = new Button(shell, SWT.NONE);
		
		group.setText ("Modules");
		b_adherent.setText ("Module adhérent");
		b_materiel.setText ("Module matériel");
		b_personnel.setText ("Module personnel");
		b_quitter.setText("Quitter");
		
		
//		b_connect.setText("Se connecter");
//		b_connect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

				
		// shell.setSize(StartingScreenSWT.WINDOW_DEFAULT_WIDTH, StartingScreenSWT.WINDOW_DEFAULT_HEIGHT);
		shell.setText("Choix du module");

		Rectangle rect = Launcher.display.getClientArea();
		Point size = shell.getSize();
		int x = (rect.width - size.x) / 2;
		int y = (rect.height - size.y) / 2;
		shell.setLocation(new Point(x, y));
		
		shell.pack();
		
		shell.open();
		
		this.start();
	}
	
	private void start() {
		while (!shell.isDisposed()) {
			if (!Launcher.display.readAndDispatch()) {
				Launcher.display.sleep();
			}
		}
	}
}
