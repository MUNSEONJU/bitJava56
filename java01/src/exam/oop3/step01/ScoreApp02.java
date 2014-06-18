package exam.oop3.step01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreApp02 {

	public static void main02(String[] args) {
		Frame f = new Frame(); // awt의 Frame기능을 사용하기 위해 import
		f.setSize(400,300); 
		// width, height 인스턴스 변수들은 막아두었다. 함부로 값을 넣지않기위해.
		// 때문에 높이넓이를 설정할 수 있는 setSize기능을 호출한다
		// 객체지향관점 : f에게 "야 f, 지금 setSize해" 라는 메세지를 보낸다
		f.setTitle("성적관리시스템");
		// 창을 띄우기 전에 제목을 정한다.
		
		f.addWindowListener(new MyWindowListener());
		// WindowListener 라는 인터페이스양식(규칙)에맞춰 내가 만든 인터페이스
		// MyWL라는 양식을 f에게 addWindowListener하라고 한다.
		
		f.add(new Label("이름")); // import
		f.add(new TextField(20));
		f.add(new Button("버튼"));
		
		f.setVisible(true);
		// setVisible자체가 윈도우를 setVisible하지않는다
		// (Windows의경우)OS에 있는 Win32API에게 창을띄워달라고 부탁하는 메서드이다.
		
	}

}

