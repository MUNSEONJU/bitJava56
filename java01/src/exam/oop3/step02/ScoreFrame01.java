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
// * Toplevel inner class
//	- static으로 선언된 inner class
//	- 바깥에서도 클래스 이름을 사용하여 접근할 수 있다.
//	- 바깥 클래스가 패키지 역할을 담당한다.
//	- 안드로이드 클래스의 R.java에서 사용.
//	- 간단히 상수 값만을 가진 클래스를 여러 개 생성하고 싶을 때 적합하다.

public class ScoreFrame01  extends Frame {
	
	static class MyWindowListener2 extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("Top level inner class - closing");
			System.exit(0);
		}
	}
	
	public ScoreFrame01() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);

		this.addWindowListener(new MyWindowListener2());
				
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






