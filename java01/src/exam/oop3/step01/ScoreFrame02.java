package exam.oop3.step01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

// 절대좌표로 UI Component 배치
// Layout Manager를 설정해 주지 않는다 ( setLayout(null); )
// 각 UI Component(부속, 부품)는 x,y,width,height 값을 가졍ㅎ

public class ScoreFrame02  extends Frame {
	
	public ScoreFrame02() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		this.addWindowListener(new MyWindowListener());
		
		//UI Layout Manager를 고용하지 않는다. ( 절대좌표 배치)
		this.setLayout(null);
		
		Label label = new Label("이름");
		label.setBounds(20,40,40,25); // x,y좌표,width,height크기
		this.add(label);
		
	  TextField tf = new TextField(20);
	  tf.setBounds(70, 40, 80, 25);
	  this.add(tf);
	  
	  Button btn = new Button("추가");
	  btn.setBounds(20, 80, 60, 25);
		this.add(btn);
	  
	}

}






