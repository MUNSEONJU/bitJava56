// 동시에 여러가지 연산을 수행한다면?
// 클래스변수는 한번에 하나만 기억한다 -> 여러가지 연산 한번에 진행불가
// 인스턴스변수 : 각자 생성된 인스턴트에서 각자 값을 기억하고 관리한다
package exam.oop.instance;

public class CalcTest03 {

	public static void main(String[] args) {
		
		// 5 + 3 * 7 ( 계산기처럼 연산자 우선순위 고려하지 않은 가정하의 연산 )
		// 6 - 2 + 3
		Calculator03 cal1 = new Calculator03();
		Calculator03 cal2 = new Calculator03();
		
		//인스턴스 만든김에 메서드도 인스턴스로할꺼야
		cal1.init(cal1, 5);
		cal2.init(cal2, 6);
		
		cal1.plus(cal1, 3);
		cal2.minus(cal2, 2);
		
		cal1.multiple(cal1, 7);
		cal2.plus(cal2, 3);
		
		System.out.println(cal1.result);
		System.out.println(cal2.result);
		
	}

}
