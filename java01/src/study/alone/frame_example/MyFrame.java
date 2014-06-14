package study.alone.frame_example;

import java.awt.Frame;
import java.awt.Graphics;

public class MyFrame extends Frame{
	
	public MyFrame(){
		super("이름");
		
		setSize(200, 200);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
	  // TODO Auto-generated method stub
	  super.paint(g);
	}
	

}
