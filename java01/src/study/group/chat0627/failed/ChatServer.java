package study.group.chat0627.failed;

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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import study.group.chat0627.ChatFrame;

public class ChatServer extends Frame implements KeyListener {
	public static final String nLine = "\n";
	public TextArea tA = new TextArea("    ☆☆☆☆☆ WELCOME ☆☆☆☆☆" + nLine);
	public TextField tf = new TextField(/*"insert message to send"*/);
	public String sendText;
	public static String receiveText;
	
	public ChatServer() {
		this.setTitle("Chat<Server>");
		this.setSize(300,450);
		this.setLayout(new FlowLayout(0));
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		this.addKeyListener(this);
		
		tA.setPreferredSize(new Dimension(275, 370));
		this.add(tA);
		
		tf.setPreferredSize(new Dimension(275,30));
		tf.addKeyListener(this); 
		
		this.add(tf);
	}
	
	public static void main(String[] args) throws Exception {
		new ChatServer();
		Scanner keyScan = new Scanner(System.in);
		ServerSocket ss = new ServerSocket(9080);
		
		Socket socket = ss.accept();

		InputStream in = socket.getInputStream(); // 데이터 읽기 도구
		Scanner in2 = new Scanner(in);

		OutputStream out = socket.getOutputStream(); // 데이터 출력 도구
		PrintStream out2 = new PrintStream(out);
		
		String request = null;
		String message = null; 
		
		while(true){
			request = in2.nextLine();
			System.out.println("-> " + request);
			if(request.equals("bye")){
				break;
			}
			message = receiveText;
			out2.println(message);
		}
		
		in2.close();
		in.close();
		out2.close();
		out.close();
		socket.close();
		ss.close();
	}

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
		
	  
  }

}
