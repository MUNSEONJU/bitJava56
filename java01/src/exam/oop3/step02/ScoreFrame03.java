package exam.oop3.step02;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// EventListener를 inner class로 만들기
// * local inner class
// 	- method 안에 class 선언
//	- inner class가 선언된 메서드 안에서만 사용가능

public class ScoreFrame03  extends Frame {

	public ScoreFrame03() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);

		//local inner class - 메서드 안에서 호출하기 전에 class를 만들어 주었다.
		class MyWindowListener4 extends WindowAdapter{
			public void windowClosing(WindowEvent e) {
				System.out.println("local inner class - closing");
				System.exit(0);
			}
		}
		
		this.addWindowListener(new MyWindowListener4());
				
		this.setLayout(new FlowLayout()); // import
		
		Label label = new Label("이름");
		//BorderLayout에서는 각 UIcomponent의 좌표와 크기값을 무시한다.
		label.setBounds(20,40,40,25); // 좌표와 크기값
		//FlowLayout에서 UIcomponent의 크기를 설정하고 싶다면
		//다음과 같이 PreferredSize를 설정해야한다.
		label.setPreferredSize(new Dimension(50,40));
		this.add(label);
		
	  TextField tf = new TextField(20);
	  tf.setBounds(70, 40, 80, 25);
	  tf.setPreferredSize(new Dimension(100,40));
	  this.add(tf);
	  
	  Button btn = new Button("추가");
	  btn.setBounds(20, 80, 60, 25);
	  btn.setPreferredSize(new Dimension(80,40));
		this.add(btn);
	  
	}

}






