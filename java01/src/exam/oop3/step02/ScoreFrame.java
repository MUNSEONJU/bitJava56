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
// * anonymous class(익명 중첩 클래스
//	- anonymous inner class를 메서드파라미터값으로 바로 전달하기

public class ScoreFrame  extends Frame {

	public ScoreFrame() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
    
		/*
		WindowAdapter listener; //정의하자마자 생성된 익명innerclass의 인스턴스를 담을 레퍼런스
		
		listener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("anonymous inner class - closing");
				System.exit(0);
			}
		};
		
		this.addWindowListener(listener); // windowAdapter 상속받아 만든 클래스
		*/
		
		// 다음과 같다
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.out.println("anonymous inner class2 - closing");
				System.exit(0);
			}
		});
		
		
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






