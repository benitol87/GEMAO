package IHM;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
	
	public static void main(String[] args) {
	  
	
		Display display = new Display();
	
		Shell shell = new Shell(display, SWT.CLOSE | SWT.MIN);
		shell.open();
		shell.setSize(2000, 1000);
		shell.setText("Menu Matériel");
    
			Composite compositeTop = new Composite(shell, SWT.BORDER);
			GridLayout glTop = new GridLayout();
			glTop.numColumns = 4;
			compositeTop.setLayout(glTop);
	
				Label l_cat = new Label(compositeTop, SWT.NONE);
				l_cat.setText("Categorie :");
    
				final Combo c_cat = new Combo(compositeTop, SWT.NONE|SWT.READ_ONLY);
				c_cat.add("Instrument");
				c_cat.add("Autre");
				c_cat.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						System.out.println(e.widget);
						
					}

					@Override
					public void widgetSelected(SelectionEvent e) {
						System.out.println(((Combo)e.widget).getText().equals("Autre"));
							
						
					}
					
				});
    
    
				Label l_des = new Label(compositeTop, SWT.NONE);
				l_des.setText("Designation :");
	
				Text t_des = new Text(compositeTop, SWT.BORDER);
	
	
				Label l_val_ach = new Label(compositeTop, SWT.NONE);
				l_val_ach.setText("Valeur d'achat :");
	
				Text t_val_ach = new Text(compositeTop, SWT.BORDER);
	
	
				Label l_date_ach = new Label(compositeTop, SWT.NONE);
				l_date_ach.setText("Date d'achat :");
    
				Text t_date_ach = new Text(compositeTop, SWT.BORDER);
	
	
			Composite compositeCenter = new Composite(shell, SWT.BORDER);
			GridLayout glCenter = new GridLayout();
			glCenter.numColumns = 3;
			compositeCenter.setLayout(glCenter);	
    
    	
	
				Composite compositeCO = new Composite(compositeCenter, SWT.BORDER);
				GridLayout glCenterOuest = new GridLayout();
				glCenterOuest.numColumns = 2;
				compositeCO.setLayout(glCenterOuest);
	
	
					Label l_type = new Label(compositeCO, SWT.NONE|SWT.READ_ONLY);
					l_type.setText("Type :");
    
					Combo c_type = new Combo(compositeCO, SWT.NONE);
    
    
					Label l_qte = new Label(compositeCO, SWT.NONE);
					l_qte.setText("Quantité :");
    
					Text t_qte = new Text(compositeCO, SWT.BORDER);
    
					Label l_marque = new Label(compositeCO, SWT.NONE);
					l_marque.setText("Marque :");
					
					Text t_marque = new Text(compositeCO, SWT.BORDER);
    
					Label l_prixU = new Label(compositeCO, SWT.NONE);
					l_prixU.setText("Prix unitaire :");
    
					Text t_prixU = new Text(compositeCO, SWT.BORDER);

	
				Composite compositeCE = new Composite(compositeCenter, SWT.BORDER);
				GridLayout glCenterEst = new GridLayout();
				glCenterEst.numColumns = 2;
				compositeCE.setLayout(glCenterEst);
	
	
    				Label l_obs = new Label(compositeCE, SWT.NONE);
    				l_obs.setText("Observations :");
    
    				Text t_obs = new Text(compositeCE, SWT.BORDER|SWT.V_SCROLL);
	
    		Composite compositeBottom = new Composite(shell, SWT.BORDER);
    		GridLayout glBottom = new GridLayout();
    		glBottom.numColumns = 3;
    		compositeBottom.setLayout(glBottom);
    		
    			Button b_annuler = new Button(compositeBottom, SWT.NONE);
    			b_annuler.setText("Annuler");
	
    			Button b_valider = new Button(compositeBottom, SWT.NONE);
    			b_valider.setText("Valider");
	
    	GridLayout gridLayout = new GridLayout();
    	shell.setLayout(gridLayout);
    	shell.setLayout(new GridLayout());
    	shell.pack();
    
    
    	while (!shell.isDisposed()) {
    		if (!display.readAndDispatch())
    			display.sleep();
	   	}
	}
}