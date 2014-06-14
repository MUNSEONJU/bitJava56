// 클래스변수 : 함수들의 중간 작업결과를 보관하는 변수
// 문법 : static type 변수명;

package exam.oop.instance;

public class Calculator02 {
	
	//클래스 변수 선언-클래스를 선언하기 전에 자동으로 준비되는 변수
	//new연산자를 사용하지 않아도 된다
	static int result;
	
	public static void init(int value){
		Calculator02.result = value;
	}
	
	public static void plus(int value){
		Calculator02.result += value;
	}
	public static void minus(int value){
		Calculator02.result -= value;
	}
	public static void multiple(int value){
		Calculator02.result *= value;
	}
	public static void divide(int value){
		Calculator02.result /= value;
	}
	
}
