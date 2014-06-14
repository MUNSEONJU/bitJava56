package exam.oop2.step11;

//인터페이스 구현
//	- 미리 인터페이스에 선언된 모든 메서드를 구현해야한다.

//기본 인터페이스규칙에 맞춰 내가 구현한 인터페이스
//interviewee 라는 규칙에 맞춰 만든 MunInterviewee 인터페이스
public class MunInterviewee implements Interviewee{
	// Interviewer 클래스에 의해서 호출되는 메서드이다
	// 내가 등록한 객체의 메서드가 다른 객체에 의해 호출된다면
	// 	-->> Call back 메서드
	public void hi(){
		System.out.println("ㅇㅇ");
	}
	public void bye(){
		System.out.println("ㅂㅂ");
	}
}
