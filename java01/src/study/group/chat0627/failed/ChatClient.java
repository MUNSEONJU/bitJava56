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
import java.net.Socket;
import java.util.Scanner;

import study.group.chat0627.ChatFrame;
import study.group.chat0627.Sender;

public class ChatClient extends Frame implements KeyListener  {
	public static final String nLine = "\n";
	public TextArea tA = new TextArea("    ☆☆☆☆☆ WELCOME ☆☆☆☆☆" + nLine);
	public TextField tf = new TextField(/*"insert message to send"*/);
	public String sendText;
	public static String receiveText;

	static String message = null;
  static String response = null;
  
  String ipAddr = "192.168.1.44";
  static InputStream in;
  static Scanner in2;
  static OutputStream out;
  static PrintStream out2;
  static Socket socket; 
	public ChatClient() throws Exception{
		socket = new Socket(ipAddr, 9080);
		
		in = socket.getInputStream(); // 데이터 읽기 도구
		in2 = new Scanner(in);

		out = socket.getOutputStream(); // 데이터 출력 도구
		out2 = new PrintStream(out);
		
		this.setTitle("Chat<Client>");
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
		
		while(true){
      response = in2.nextLine();
      System.out.println("서버 => " + response);
      
			if(message.equals("exit")){
				out2.println("bye");
				break;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		new ChatClient();
    
		

		out2.close();
	  out.close();
	  in2.close();
	  in.close();
	  socket.close();
	}
	
	@Override
  public void keyReleased(KeyEvent e) {
		
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
      out2.println(this.sendText);
     	Toolkit.getDefaultToolkit().beep();
      System.out.println("ENTER pressed");
      tA.append("나 : " + this.sendText + nLine);
      tf.setText("");
       }
	  
  }

}

