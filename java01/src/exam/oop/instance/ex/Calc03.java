package exam.oop.instance.ex;

public class Calc03 {
	
	
	/*
	static(클래스변수)에는 변수 1개당 1가지 결과만 넣을수 있지.
	여러가지 결과를 대입하고싶으면 static변수를 계속 만들어야하지.
	그럴거면 번거롭지만 인스턴스를 생성할 때마다 새로운 변수가 할당되는 방식이 낫겠어
	*/
	//static int result;
	int result;
	
	/*
	인스턴스 변수 result를 찾아쓰려면 메서드를 사용하는 클래스내 함수(Test03)에서
	새로 계산기(Calc03)인스턴스를 만들고, 계산기메서드에는 인스턴스의 파라미터값을 받아올 구문이 필요해졌어
	*/
	
	public static void initial_value(Calc03 reference, int value){
		reference.result = value;
	}
	
	public static void plus(Calc03 reference, int value){
		reference.result = reference.result + value;
	}
	public static void minus(Calc03 reference, int value){
		reference.result -= value;
	}
	public static void multiple(Calc03 reference, int value){
		reference.result *= value;
	}
	public static void divide(Calc03 reference, int value){
		reference.result /= value;
	}
	
}
