package exam.oop.instance;

public class CalcTest01 {

	public static void main(String[] args) {
		
		// 5 + 3 * 7 ( 계산기처럼 연산자 우선순위 고려하지 않은 가정하의 연산 )
		int result = 0;
		/*
		result = Calculator01.plus(5, 3);
		result = Calculator01.multiple(result, 7);
		*/
		result = Calculator01.multiple(Calculator01.plus(5,3), 7);
		System.out.println(result);
	}

}
