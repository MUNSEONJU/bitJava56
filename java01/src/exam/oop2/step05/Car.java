// 상속 관계에서 생성자 호출
//	- super() :
//			모든 생성자에 첫번째로 오는 명령문
//			superclass의 기본 생성자를 호출하는 명령문
//			생략 가능 -> 생략하면 컴파일 시 자동으로 호출됨
//			명시적으로 작성할 수 있다. 하지만 반드시 그 생성자의 첫번째 명령문이어야한다.
//			모든 생성자에 반드시 있다.
package exam.oop2.step05;

public class Car {
	String 	model;
	int 		cc = 1000;
	
	public Car(){
		//super(); // 모든 생성자는 super클래스의 기본 생성자를 호출하게 되어있다.
		System.out.println("CAR()");
	}
	
	public Car(String name){
		System.out.println("CAR()");
		System.out.println(name);
		
	}
}
