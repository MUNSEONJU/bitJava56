package exam.oop3AndAwt.step01;

//윈도우 이벤트 처리를 위한 WindowListener 사용
//	- 윈도우 이벤트가 발생 했을때 호출되는 메서드 규칙을 정한것이다.
//	- 자바의 인터페이스 문법으로 정의했다.
//	- 인터페이스 문법
//		: interface 규칙이름{
//			method signature
//				...
//			}


import java.awt.Frame;

public class ScoreApp01 {

	public static void main(String[] args) {
		Frame f = new Frame(); // awt의 Frame기능을 사용하기 위해 import
		f.setSize(400,300); 
		// width, height 인스턴스 변수들은 막아두었다. 함부로 값을 넣지않기위해.
		// 때문에 높이넓이를 설정할 수 있는 setSize기능을 호출한다
		// 객체지향관점 : f에게 "야 f, 지금 setSize해" 라는 메세지를 보낸다
		f.setTitle("성적관리시스템");
		// 창을 띄우기 전에 제목을 정한다.
		f.setVisible(true);
		// setVisible자체가 윈도우를 setVisible하지않는다
		// (Windows의경우)OS에 있는 Win32API에게 창을띄워달라고 부탁하는 메서드이다.
		
	}

}

