package exam.oop2.step09;

import exam.oop2.step09.sub.A;

// A 클래스와 다른 패키지에 있는 Test01에 접근

public class Test01 {

	public static void main(String[] args) {
		A p = new A(); // public 클래스 
		p.a = 20; 
		//p.b = 30; 	// default : 패키지가 달라서
		//p.c = 40;		// protected : 패키지도 다르고, 자식클래스도 아님
		//p.d = 50;		// private : 비공개 되어있음
		
		p.m1();
		//p.m2();
		//p.m3();
		//p.m4();
		
	}

}
