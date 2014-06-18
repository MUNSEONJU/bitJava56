// 인터페이스 대신 추상클래스로 규칙을 정의한다면?
//	- 못은 사람의 이마로도 박을 수 있다.
//	- 못은 삽으로도 박을 수 있다.
//	- 돌멩이로도 박을 수 있다.
//	- 용서받지못할 미련한 짓
//	- 인터페이스는 규칙을 위한, 추상클래스는 sub클래스에게 공통 기능을 상속해주기 위한.
//	- 

package exam.oop2.step13;

public abstract class AbstractMonitor {
	public static final int TYPE_DSUB = 1;
	public static final int TYPE_DVI = 2;
	public static final int TYPE_HDMI = 3;
	
	public abstract void display(String contents); // 추상메서드
	public abstract void mute(); // 추상메서드
	public void m() {}
	//public void mute(){} // 미구현한 일반메서드
	//public void display(String contents){} //미구현한 일반메서드
}
