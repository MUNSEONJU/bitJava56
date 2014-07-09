package study.group.chat0627;

import java.util.Scanner;

import study.group.chat0627.chat001.Server;

public class Receiver extends Thread{
	Scanner in;
	
	public Receiver(Scanner in){
		this.in = in;
	}
	
	
	public void run(){
		String message = null;
		Server s= new Server();
		while(true){
			message = in.nextLine();
			if(message.equals("bye")){
				s.setServerTextArea(message);
				break;
			}else {
				s.setServerTextArea(message);
			}
			//System.out.println("---> "+ message);
			
			
		}
	}
}
