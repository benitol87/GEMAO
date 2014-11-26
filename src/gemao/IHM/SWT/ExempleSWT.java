package gemao.IHM.SWT;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ExempleSWT {
	public static void main(String[] argv){
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setText("Hello world");
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
