package gemao.IHM.SWT;



import gemao.Config;
import gemao.IHM.IStartingScreen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class StartingScreenSWT implements IStartingScreen {
	public static int WINDOW_DEFAULT_WIDTH = 800;
	public static int WINDOW_DEFAULT_HEIGHT = 600;

	private Display display;
	private Shell shell;
	private Button b_connect;
	private Label l_login, l_mdp;
	private Text t_login, t_mdp;
	
	public StartingScreenSWT() {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX);
		
		GridLayout glayout = new GridLayout();
		glayout.numColumns = 1;
		shell.setLayout(glayout);
		
		l_login = new Label(shell, SWT.NONE);
		t_login = new Text(shell, SWT.BORDER);
		l_mdp = new Label(shell, SWT.NONE);
		t_mdp = new Text(shell, SWT.BORDER);
		b_connect = new Button(shell, SWT.NONE);
		
		l_login.setText("Login :");
		l_login.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		t_login.setTextLimit(Config.MAX_CHAR_INPUT);
		t_login.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		l_mdp.setText("Mot de passe :");
		l_mdp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		t_mdp.setTextLimit(Config.MAX_CHAR_INPUT);
		t_mdp.setEchoChar('*');
		t_mdp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		b_connect.setText("Se connecter");
		b_connect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
				
		shell.setSize(StartingScreenSWT.WINDOW_DEFAULT_WIDTH, StartingScreenSWT.WINDOW_DEFAULT_HEIGHT);
		shell.setText("Connexion");
		shell.pack();
		
		shell.open();
		this.start();
	}

	private void start() {
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
