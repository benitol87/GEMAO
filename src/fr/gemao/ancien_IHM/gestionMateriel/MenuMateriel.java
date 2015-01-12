package gemao.IHM.gestionMateriel;

import gemao.Launcher;
import gemao.IHM.gestionPersonnel.PrincipalSWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class MenuMateriel {
	
	private Shell shell;
	
	private GridLayout glPrincipal;
	
	private Button b_ajoutMateriel;
	private Button b_saveLoc;
	
	private Composite comp;
	
	public MenuMateriel(){
		shell = new Shell(Launcher.display, SWT.CLOSE | SWT.MIN);
		shell.setSize(2000, 1000);
		shell.setText("Menu Materiel");
    	shell.setLayout(new GridLayout());
    	
    	comp = new Composite(shell, SWT.NONE);
    	glPrincipal = new GridLayout();
    	comp.setLayout(glPrincipal);
    	glPrincipal.numColumns = 2; 
    	b_ajoutMateriel = new Button(comp, SWT.BUTTON1);
    	b_ajoutMateriel.setText("Ajouter Materiel");
    	
    	b_saveLoc = new Button(comp, SWT.BUTTON1);
    	b_saveLoc.setText("Enregistrer Location");
    	
    	shell.pack();
		shell.open();
		this.start();
	}
	
	private void dispatchEvents(){
		b_saveLoc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				new EnregistrerLocation(shell);
				
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
		
		b_ajoutMateriel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				new AjouterMateriel();
				
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
