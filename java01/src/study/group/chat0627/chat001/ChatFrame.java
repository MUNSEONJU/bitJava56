package study.group.chat0627.chat001;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import com.sun.javafx.scene.EnteredExitedHandler;

public class ChatFrame extends Frame implements KeyListener {
	public static final String nLine = "\n";
	public TextArea tA = new TextArea("    ☆☆☆☆☆ WELCOME ☆☆☆☆☆" + nLine);
	public TextField tf = new TextField(/*"insert message to send"*/);
	public String sendText;
	public String receiveText;
	
	public ChatFrame(){
		
		this.setTitle("BitChat<Client>");
		this.setSize(300,450);
		this.setLayout(new FlowLayout(0));
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		tA.setPreferredSize(new Dimension(275, 370));
		this.add(tA);
		//textArea.append("aa");
		
		tf.setPreferredSize(new Dimension(275,30));
		tf.addKeyListener(this); 
		
		this.add(tf);
	}
	/*
	public void enterPressed(){
		this.sendText = tf.getText();
   	Toolkit.getDefaultToolkit().beep();
    System.out.println("ENTER pressed");
    tA.append("나 : " + this.sendText + nLine);
    tf.setText("");
    
	}
	*/

	@Override
  public void keyTyped(KeyEvent e) {
	  // TODO Auto-generated method stub
	  
  }

	@Override
  public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
    if (key == KeyEvent.VK_ENTER) {
    	this.sendText = tf.getText();
     	Toolkit.getDefaultToolkit().beep();
      System.out.println("ENTER pressed");
      tA.append("나 : " + this.sendText + nLine);
      tf.setText("");
       }	  
  }

	@Override
  public void keyReleased(KeyEvent e) {
	  // TODO Auto-generated method stub
	  
  }
	public static void main(String[] args) {
	  new ChatFrame();
  }
	 
  
}
