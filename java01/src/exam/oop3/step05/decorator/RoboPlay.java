package exam.oop3.step05.decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class RoboPlay {
	
		void example() throws Exception{
		/* Data Sink Stream class */
		FileInputStream in = new FileInputStream("text.txt");
		
		/* Data Processing Stream class */
		BufferedInputStream buf = new BufferedInputStream(in);
		DataInputStream da = new DataInputStream(buf);
		buf.read();
	}
	
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		FlyDecorator flyRobot = new FlyDecorator(robot);
		InvisibleDecorator invisibleRobot = new InvisibleDecorator(flyRobot);
		
		invisibleRobot.move();
	}

}
