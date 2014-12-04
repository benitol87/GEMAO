package gemao.IHM.gestionMateriel;


import gemao.Launcher;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AjouterMatériel {
	
	
	private Shell shell;
	
	private Composite compositeTop;
	private Composite compositeCenter;
	private Composite compositeCO;
	private Composite compositeCE;
	private Composite compositeCEN;
	private Composite compositeCES;
	private Composite compositeBottom;
	private Composite compositeDes;

	private FillLayout fl_obs; 

	private RowLayout rlCenterEst;
	
	private GridLayout glPrincipal;
	private GridLayout glTop;
	private GridLayout glCenter;
	private GridLayout glCenterOuest;
	private GridLayout glCenterEstNord;
	private GridLayout glCenterEstSud;
	private GridLayout glBottom;
	
	private Label l_cat;
	private Label l_des;
	private Label l_val_ach;
	private Label l_date_ach;
	private Label l_type;
	private Label l_qte;
	private Label l_marque;
	private Label l_prixU;
	private Label l_obs;
	
	private Text t_des;
	private Text t_val_ach;
	private Text t_date_ach;
	private Text t_qte;
	private Text t_marque;
	private Text t_prixU;
	private Text t_obs;
	
	private Combo c_cat;
	private Combo c_type;
	
	private Button b_valider;
	private Button b_annuler;
	
	public AjouterMatériel(){
		
		shell = new Shell(Launcher.display, SWT.CLOSE | SWT.MIN);
		shell.setSize(2000, 1000);
		shell.setText("Menu Matériel");
    
		compositeTop = new Composite(shell, SWT.BORDER);
		glTop = new GridLayout();
		glTop.numColumns = 4;
		compositeTop.setLayout(glTop);
	
		l_cat = new Label(compositeTop, SWT.NONE);
		l_cat.setText("Categorie :");
    
		c_cat = new Combo(compositeTop, SWT.NONE|SWT.READ_ONLY);
		c_cat.add("Instrument");
		c_cat.add("Autre");
				    
		l_des = new Label(compositeTop, SWT.NONE);
		l_des.setText("Designation :");
	
		t_des = new Text(compositeTop, SWT.BORDER);
	
	
		l_val_ach = new Label(compositeTop, SWT.NONE);
		l_val_ach.setText("Valeur d'achat :");
	
		t_val_ach = new Text(compositeTop, SWT.BORDER);
	
	
		l_date_ach = new Label(compositeTop, SWT.NONE);
		l_date_ach.setText("Date d'achat :");
    
		t_date_ach = new Text(compositeTop, SWT.BORDER);
	
	
		compositeCenter = new Composite(shell, SWT.NONE);
		glCenter = new GridLayout();
		glCenter.numColumns = 3;
		compositeCenter.setLayout(glCenter);	
    
    	
	
		compositeCO = new Composite(compositeCenter, SWT.BORDER);
		glCenterOuest = new GridLayout();
		glCenterOuest.numColumns = 2;
		compositeCO.setLayout(glCenterOuest);
	
	
		l_type = new Label(compositeCO, SWT.NONE|SWT.READ_ONLY);
		l_type.setText("Type :");
    
		c_type = new Combo(compositeCO, SWT.NONE);
    
    
		l_qte = new Label(compositeCO, SWT.NONE);
		l_qte.setText("Quantité :");
    
		t_qte = new Text(compositeCO, SWT.BORDER);
    
		l_marque = new Label(compositeCO, SWT.NONE);
		l_marque.setText("Marque :");
					
		t_marque = new Text(compositeCO, SWT.BORDER);
    
		l_prixU = new Label(compositeCO, SWT.NONE);
		l_prixU.setText("Prix unitaire :");
    
		t_prixU = new Text(compositeCO, SWT.BORDER);

	
		compositeCE = new Composite(compositeCenter, SWT.NONE);
		rlCenterEst = new RowLayout(SWT.VERTICAL);
		compositeCE.setLayout(rlCenterEst);
	
	
    	l_obs = new Label(compositeCE, SWT.NONE);
    	l_obs.setText("Observations :");
    
    	compositeDes = new Composite(compositeCE, SWT.NONE);
    	fl_obs = new FillLayout();
    	compositeDes.setLayout(fl_obs);
    				
    	t_obs = new Text(compositeDes, SWT.BORDER|SWT.V_SCROLL);
	
    	compositeBottom = new Composite(shell, SWT.NONE);
    	glBottom = new GridLayout();
    	glBottom.numColumns = 3;
    	compositeBottom.setLayout(glBottom);
    		
    	b_annuler = new Button(compositeBottom, SWT.NONE);
    	b_annuler.setText("Annuler");
	
    	b_valider = new Button(compositeBottom, SWT.NONE);
    	b_valider.setText("Valider");
	
    	glPrincipal = new GridLayout();
    	shell.setLayout(glPrincipal);
    	shell.setLayout(new GridLayout());
    	
    	shell.pack();
		shell.open();
		this.typeEvent();
		this.start();
	}
    
	public void typeEvent(){
		c_cat.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println(e.widget);
				
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
					
				
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