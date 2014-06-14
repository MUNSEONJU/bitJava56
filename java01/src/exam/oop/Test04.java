// 변수 및 메서드 용어정리

package exam.oop;


//클래스
public class Test04 { 
	
//클래스 변수 : 클래스가 로딩될 때 자동으로 준비되는 변수
//	- Test04.age = 20;
	static int age; 
	
//인스턴스 변수 : new 연산자를 통해 준비되는 변수
//	- Test04 test = new Test04();
//		test.name = "문선주";
	String name; 
		
//클래스메서드 : 클래스 이름으로 바로 호출할 수 있는 메서드
// 	- Test04.plus(3,4);
	public static int plus(int a, int b){ 
			//파라미터 : 함수의 인자값(argument)을 저장하는 변수->a,b
		
			//함수 내부에 선언된 변수 : 로컬 변수 ( 파라미터도 로컬변수 ) -> result,a,b
		int result = a+b;
		return result;
	}
	
//인스턴스 메서드 : 인스턴스 주소로 호출하는 메서드
//	- Test04 aa = new Test04();
//		aa.minus(5,6);
	public int minus(int a, int b){ 
		return a+b;
	}

//기본생성자 : 인스턴스가 생성된 후 즉시 자동 호출되는 메서드
//	- Test04 bb - new Test04();
	public Test04(){
		
	}
}
