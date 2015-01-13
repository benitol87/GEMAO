/*package gemao;

import gemao.IHM.SWT.StartingScreenSWT;
import gemao.IHM.gestionPersonnel.PrincipalSWT;

import org.eclipse.swt.widgets.Display;


public class Launcher {
	public static Display display;

	public static void main(String[] args) {
		launchSWT();
	}
	
	public static void launchSWT(){
		display = Display.getDefault();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					if(!Launcher.display.readAndDispatch())
						Launcher.display.sleep();
				}
			}
		});
		
		new StartingScreenSWT();
	}
	
	/**
	 * M�thode arr�tant l'application
	 
	public static void stop(){
		Launcher.display.dispose();
	}

}


*/