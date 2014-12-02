package gemao.IHM.SWT;

import gemao.Config;
import gemao.Launcher;
import gemao.IHM.IStartingScreen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class StartingScreenSWT implements IStartingScreen {
	// public static int WINDOW_DEFAULT_WIDTH = 800;
	// public static int WINDOW_DEFAULT_HEIGHT = 600;

	private Shell shell;
	private Button b_connect;
	private Label l_login, l_mdp;
	private Text t_login, t_mdp;

	public StartingScreenSWT() {
		shell = new Shell(Launcher.display, SWT.CLOSE | SWT.TITLE | SWT.MIN);

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
		b_connect
				.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

		// shell.setSize(StartingScreenSWT.WINDOW_DEFAULT_WIDTH,
		// StartingScreenSWT.WINDOW_DEFAULT_HEIGHT);
		shell.setText("Connexion");

		Rectangle rect = Launcher.display.getClientArea();
		Point size = shell.getSize();
		int x = (rect.width - size.x) / 2;
		int y = (rect.height - size.y) / 2;
		shell.setLocation(new Point(x, y));

		shell.pack();

		shell.open();

		this.addListeners();

		this.start();
	}

	private void addListeners() {
		b_connect.addMouseListener(new MouseListener() {
			private boolean clicInterieur = false;

			@Override
			public void mouseUp(MouseEvent e) {
				if (clicInterieur) {
					// Ouvrir la fenêtre de choix du module
					new ModuleChooserScreen();

					// Fermer la fenêtre de connexion
					if(!shell.isDisposed())
						shell.close();
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
	}

	private void start() {
		while (!shell.isDisposed()) {
			if (!Launcher.display.readAndDispatch()) {
				Launcher.display.sleep();
			}
		}
	}

	@Override
	public String getLogin() {
		return t_login.getText();
	}

	@Override
	public String getPasswd() {
		return t_mdp.getText();
	}

	@Override
	public void close() {
		shell.dispose();
	}
}
