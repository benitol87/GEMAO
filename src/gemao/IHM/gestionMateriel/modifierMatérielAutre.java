package IHM;


import org.eclipse.swt.SWT;
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

public class modifierMatérielAutre {
	
	public static void main(String[] args) {
	  
	
		Display display = new Display();
	
		Shell shell = new Shell(display, SWT.CLOSE | SWT.MIN);
		shell.open();
		shell.setSize(2000, 1000);
		shell.setText("Menu Matériel");
    
			Composite compositeTop = new Composite(shell, SWT.BORDER);
			GridLayout glTop = new GridLayout();
			glTop.numColumns = 2;
			compositeTop.setLayout(glTop);
	
				Label l_cat = new Label(compositeTop, SWT.NONE);
				l_cat.setText("Categorie :");
    
    
				Label l_des = new Label(compositeTop, SWT.NONE);
				l_des.setText("Designation :");
	
	
				Label l_val_ach = new Label(compositeTop, SWT.NONE);
				l_val_ach.setText("Valeur d'achat :");
	
	
				Label l_date_ach = new Label(compositeTop, SWT.NONE);
				l_date_ach.setText("Date d'achat :");
	
	
			Composite compositeCenter = new Composite(shell, SWT.BORDER);
			GridLayout glCenter = new GridLayout();
			glCenter.numColumns = 3;
			compositeCenter.setLayout(glCenter);	
    
    	
	
				Composite compositeCO = new Composite(compositeCenter, SWT.BORDER);
				GridLayout glCenterOuest = new GridLayout();
				glCenterOuest.numColumns = 2;
				compositeCO.setLayout(glCenterOuest);
	
	
					Label l_type = new Label(compositeCO, SWT.NONE);
					l_type.setText("Type :");
    
    
					Label l_qte = new Label(compositeCO, SWT.NONE);
					l_qte.setText("Quantité :");
    
					Text t_qte = new Text(compositeCO, SWT.BORDER);
					t_qte.setText("La valeur récupérée");
    
					Label l_marque = new Label(compositeCO, SWT.NONE);
					l_marque.setText("Marque :");
    
					Label l_prixU = new Label(compositeCO, SWT.NONE);
					l_prixU.setText("Prix unitaire :");

	
				Composite compositeCE = new Composite(compositeCenter, SWT.BORDER);
				GridLayout glCenterEst = new GridLayout();
				glCenterEst.numColumns = 2;
				compositeCE.setLayout(glCenterEst);
	
	
    				Label l_obs = new Label(compositeCE, SWT.NONE);
    				l_obs.setText("Observations :");
    
    				Text t_obs = new Text(compositeCE, SWT.BORDER|SWT.V_SCROLL);
    				t_obs.setText("La valeur récupérée");
    				
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