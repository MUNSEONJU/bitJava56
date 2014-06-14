// 다형성(polymorphism) - Overloading
//	- 같은 기능을 수행하는 메서드에 대해 같은이름을 부여함으로써 프로그래밍의 일관성을 확보한다. 
//	- 문법 :
//		메서드 이름은 같아야 한다.
//		파라미터(파라미터의 타입이나 개수)는 달라야한다. 이름은 상관없다.
//		리턴타입은 상관없다 			
//		-> 파라미터가 같고 리턴타입이 다른경우는 불가능. 이름만다른경우 불가능
/*
 class Calc{
 
	int plus(int a,int b){ // 원래메서드
		return a+b;
	}
	
	float plus(int a,int b){ // 오류
		return a+b;
	}
	
	float plus(float a,int b){ // 가능(파라미터타입다름)
		return a+b;
	}
	
	int plus(int x,int y){ // 오류 (이름만다름)
		return x+y;
	}
}
 */
//	- 호출될 메서드는 호출할때 파라미터 값으로 구별한다
//	ex) plus(10,20); plus(20.4f,10);
package exam.oop2.step01;



public class Score {
	// Score가 준비하는 메모리를 선언
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
	
	public Score(){}

	public Score(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
		}
	
}