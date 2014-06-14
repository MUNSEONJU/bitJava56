package exam.oop2.step09.sub;

import exam.oop2.step09.sub.A;

// A 클래스와 같은 패키지에 있는 Test02에 접근

public class Test02 {

	public static void main(String[] args) {
		A p = new A(); // public 클래스 
		p.a = 20; 
		p.b = 30; 		// default
		p.c = 40;			// protected
		//p.d = 50;		// private : 비공개 되어있음
		
		p.m1();
		p.m2();
		p.m3();
		//p.m4();
		
	}

}
