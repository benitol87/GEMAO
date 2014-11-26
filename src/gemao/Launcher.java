package gemao;

import gemao.IHM.SWT.StartingScreenSWT;

import org.eclipse.swt.widgets.Display;


public class Launcher {
	public static Display display;

	public static void main(String[] args) {
		//Instanciation de la classe implémentant l'interface IStartingScreen
		new StartingScreenSWT();
	}

}
