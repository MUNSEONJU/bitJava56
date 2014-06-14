package exam.oop2.step09;

import exam.oop2.step09.sub.A;

// A 클래스와 다른 패키지에 있는 Test03에 접근
// 그러나  A의 자식 클래스 이다.

public class Test03 extends A{

	public static void main(String[] args) {
		A p = new A();		// public 클래스 
		p.a = 20; 				// public
		//p.b = 30; 			// default : 패키지가 달라서
		//p.c = 40;				// protected : 패키지가 다르다. 자식클래스인데? 오류?
		//p.d = 50;				// private : 비공개 되어있음
		
		p.m1();
		//p.m2();
		//p.m3();
		//p.m4();
	}
	
	public void Test(){
		// 자신이 A로 부터 상속 받은 변수와 메서드 사용
		a = 20;
		//b = 30;
		c = 40; // 자식클래스가 직접 사용해야 사용가능하다.
		//d = 50;
		
		m1();
		//m2();
		m3();
		//m4();
		
		// 정리 :	Test03 안에서 만든 별도의 A와 같은 형태를 한 인스턴스p는
		//			Test03 안에 있는 별도의 객체일뿐.
		//			Test03가 A에게 상속받았으므로 별도의 과정 필요 없이 부모 멤버를 바로사용하도록한다.
	}

}
