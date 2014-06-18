package exam.oop3.step01;

import java.awt.event.WindowEvent;

public class MyWindowListener02 extends AbstractWindowListener{
	public void windowClosing(WindowEvent e) {
		System.out.println("WindowClosing");
		System.exit(0);
	}
	
}
