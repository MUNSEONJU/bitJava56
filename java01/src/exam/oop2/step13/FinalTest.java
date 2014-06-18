
package exam.oop2.step13;

//--final--
//	: Lock

//1) 클래스의 final : 상속불가
final class A{}
// class B extends A{} 오류

//2) 메서드의 final : 재정의(overriding)불가
class A2{
	final void m(){	}
}

class B2 extends A2{
	// void m(){} // Overriding 할 수 없음
}

public class FinalTest {
	
	public static void main(String[] args) {
		//3) 변수의final : 변수의 값이 단 한번만 할당될 수 있다.
		final int a2; // 상수를 정의할 때 수로 쓴다.
		a2 = 10;// 첫값 할당 ok
		//a2 = 20; // 오류
	}

}
