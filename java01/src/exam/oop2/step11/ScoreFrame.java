package exam.oop2.step11;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import exam.oop3AndAwt.step01.MyWindowListener;

public class ScoreFrame extends Frame{
	
	public ScoreFrame(){
		this.setSize(400,300); 
		this.setTitle("성적관리시스템");
		this.addWindowListener(new MyWindowListener());
		
		this.add(new Label("이름"));
		this.add(new TextField(20));
		this.add(new Button("버튼"));
		
	}

}
