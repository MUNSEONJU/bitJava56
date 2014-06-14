//문제 : 계산기는 그 중간의 결과를 자체적으로 관리한다.
//해결방안 : 클래스변수로 해결한다!
//클래스변수(static)
//	-	클래스가 로딩될 때 준비되는 메모리.
//	- 그 클래스의 모든 메서드가 공유한다.
package exam.oop.instance;

public class CalcTest02 {

	public static void main(String[] args) {
		
		// 5 + 3 * 7 ( 계산기처럼 연산자 우선순위 고려하지 않은 가정하의 연산 )
		
		/*
		int result = 0;
	
		result = Calculator01.plus(5, 3);
		result = Calculator01.multiple(result, 7);
		System.out.println(result);
		*/

		Calculator02.init(5);
		Calculator02.plus(3);
		Calculator02.multiple(7);
		System.out.println(Calculator02.result);
		
	}

}
