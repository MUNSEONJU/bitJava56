 /*
	생성자 : 인스턴스가 생성된 후 자동으로 호출되는 "함수"
 	생성자의 용도 : 
 		인스턴스 변수의 값을 초기화
 		인스턴스가 사용되기 전에 최소한의 값을 설정한다.
 	문법 : 
 		리턴값이 없다. 함수이름이 클래스 이름과 같다
 		클래스명() {...}
	*/
package exam.oop;

public class Test02 {
	public static void main(String[] args) {
		/*
		Score2 s1 = new Score2();
		s1.name = "홍길동";	
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 100;
		s1.total = s1.kor + s1.eng + s1.math;
		s1.average = s1.total / 3.0f;
		*/
		
		//생성자 호출 : 클래스 내에 생성자 파라미터(생성자 메서드 파라미터) 설정해준대로 입력해야.
		//파라미터 순서는 반드시 지켜야한다 (메서드도 포함)
		Score2 s2 = new Score2("홍길동",100,40,50); // 인자(argument)값
		//s2.Score2("홍길동",100,40,50);  // 이렇게 나중에 호출 불가능
		System.out.println(s2.total);
		System.out.println(s2.average);
		
  }
}
