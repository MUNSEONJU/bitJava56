package exam.oop3.step01;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

// FlowLayout 배치 관리자 사용
//	- panel의 기본 레이아웃 관리자 -> Frame에서 사용하려면 명시적으로 설정해주어야한다
//		-> setLayout(new FlowLayout());
//	- 왼쪽에서 오른쪽 순으로 배치하고 더이상 배치 불가능하면 아래로 떨어짐.
//	- component의 x,y좌표는 무시하지만 너비 높이정보는 PreferredSize를 사용하여 입력
public class ScoreFrame  extends Frame {
	
	public ScoreFrame() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		
		//Frame의 addWindowListener
		//	- addWindowListener(WindowListener 인터페이스로 구현된 Class의 주소)
		//	- 구현된 Class안의 WindowListener에 해당하는 동작에 반응한다.
		this.addWindowListener(new MyWindowListener());
				
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






