package exam.oop.instance.ex;

public class CTest04 {

	public static void main(String[] args) {	
			int x = 5;
			int y = 6;
			
			int i = 7;
			int j = 8;
		
		Calc04 calc01 = new Calc04();
		Calc04 calc02 = new Calc04();
		/*
		calc01.initial_value(calc01, x); 
		calc02.initial_value(calc02, y); 
		
		calc01.plus(calc01, x); 
		calc02.multiple(calc02,i);
		
		System.out.println(calc01.result);
		System.out.println(calc02.result);
		*/
		
		//this로 reference값 줬으니까.. 인스턴스 생성 후 메서드나 변수를 사용하면
		//자동으로 주소설정됨, 메서드가 인스턴스 메서드인지 확인할것
		
		calc01.initial_value(x); // 초기값
		calc02.initial_value(j); 
		
		calc01.plus(i);
		calc02.minus(y);
		
		System.out.println(calc01.result);
		System.out.println(calc02.result);
		
	}

}
