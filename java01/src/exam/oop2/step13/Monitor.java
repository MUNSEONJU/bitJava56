//인터페이스
//	- 두 객체 사이의 호출 "규칙"을 정의하는 문법
//	- 대체 가능성을 높이기 위함 -> 객체를 대체하기 쉽게함 -> 유지 보수를 쉽게.(비용절감)
//	- 인터페이스의 멤버
//	1)상수변수 : 인터페이스는 규칙을 정의한 것이다. -> 인스턴스 생성불가(클래스 아님)
//		- 선언하면 public static final이 자동으로 붙는다.
//	2)메서드의 선언 : 메서드의 규칙을 정의하는 것이기 때문에 메서드를 구현해서는 안된다.
//		- public abstract이 자동으로 붙는다.
package exam.oop2.step13;

public interface Monitor {
	/* public static final */int TYPE_DSUB = 1;
	int TYPE_DVI = 2;
	int TYPE_HDMI = 3;
	
	/* public abstract*/ void display(String contents);
	void mute();
}
