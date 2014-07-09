package study.group.chat0627.chat002;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import study.group.chat0627.Receiver;


public class Server extends Frame implements KeyListener {
	public static final String nLine = "\n";
	public TextArea tA = new TextArea("    ☆☆☆☆☆ WELCOME ☆☆☆☆☆" + nLine);
	public TextField tf = new TextField(/*"insert message to send"*/);
	public String sendText;
	public String request;
	static Scanner input;
	static PrintStream output;
	
	public Server(){

		this.setTitle("BitChat<Server>");
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

	public static Socket getSocket(ServerSocket ss) throws IOException{
		Socket socket = ss.accept();
		return socket;
	}
	
	public static void setSocket(Socket socket) throws Exception{
    input = getInputStream(socket);
    output = getOutputStream(socket);
	}
	
	public static Scanner getInputStream(Socket socket) throws IOException{
    InputStream in = socket.getInputStream(); // 데이터 읽기 도구
    Scanner in2 = new Scanner(in);
		return in2;
	}
	
	public static PrintStream getOutputStream(Socket socket) throws IOException{
    OutputStream out = socket.getOutputStream(); // 데이터 출력 도구
    PrintStream out2 = new PrintStream(out);
    return out2;
	}
	
	public static void receiveThread(Receiver r){
		r.start();
	}
	
	public void setServerTextArea(String m){
		if(m.equals("bye")){
			tA.append("* * * * * E N D  C H A T * * * * *");
		}
		else {
			tA.append("->" + m + nLine);
		}
}
	
	
  public static void main(String[] args) throws Exception {
  	new Server();
    setSocket( getSocket(new ServerSocket(9080)) );
    receiveThread(new Receiver(input));
    
    
    
    
    
    /*
    keyScan.close();
    in2.close();
    in.close();
    out2.close();
    out.close();
    socket.close();
    ss.close();
    */
  }

	@Override
  public void keyTyped(KeyEvent e) {
	  // TODO Auto-generated method stub
	  
  }

	@Override
  public void keyPressed(KeyEvent e) {
	  // TODO Auto-generated method stub
	  
  }

	@Override
  public void keyReleased(KeyEvent e) {
	  // TODO Auto-generated method stub
	  
  }

}

















