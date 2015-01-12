package gemao.IHM.gestionMateriel;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import gemao.Launcher;

public class EnregistrerLocation {
	
	private Shell shell;
	
	private Composite compcentre;
	
	private GridLayout glPrincipal;
	
	private Label l_nom;
	private Label l_prenom;
	private Label l_instrument;
	private Label l_date;
	
	private Combo c_instrument;
	private Combo c_nom;
	private Combo c_prenom;
	
	private Text t_date;
	
	public EnregistrerLocation(Shell shell2){
		
		this.shell = new Shell(Launcher.display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell = new Shell(Launcher.display, SWT.CLOSE | SWT.MIN);
		shell.setSize(2000, 1000);
		shell.setText("Menu Materiel");
    	shell.setLayout(new GridLayout());
    	
    	compcentre = new Composite(shell,SWT.BORDER);
    	glPrincipal = new GridLayout();
    	glPrincipal.numColumns = 4;
    	compcentre.setLayout(glPrincipal);
    	
    	l_instrument = new Label(compcentre,SWT.NONE);
    	
    	c_instrument = new Combo(compcentre,SWT.BORDER);
    	
    	l_date = new Label(compcentre,SWT.NONE);
    	
    	t_date = new Text(compcentre,SWT.NONE);
    	
    	l_nom = new Label(compcentre,SWT.NONE);
    	
    	c_nom = new Combo(compcentre,SWT.BORDER);
    	
    	l_prenom = new Label(compcentre,SWT.NONE);
    	
    	c_prenom = new Combo(compcentre,SWT.BORDER);
    	
    	
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
    		//display.dispose();
    }

}
