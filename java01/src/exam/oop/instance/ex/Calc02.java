package exam.oop.instance.ex;

public class Calc02 {

	static int result;
	
	/*
	  public static int plus(int a, int b){
		return a+b;
	}
	public static int minus(int a, int b){
		return a-b;
	}
	public static int multiple(int a, int b){
		return a*b;
	}
	public static int divide(int a, int b){
		return a/b;
	}
	*/
	
	
	/*
	 결과를 클래스 내에서 관리해주니까 값을 return 해줄필요가없지
	 */
	public static void initial_value(int value){
		Calc02.result = value;
	}
	
	public static void plus(int value){
		Calc02.result = result + value;
	}
	public static void minus(int value){
		Calc02.result = result - value;
	}
	public static void multiple(int value){
		Calc02.result = result * value;
	}
	public static void divide(int value){
		Calc02.result = result / value;
	}
	
}
