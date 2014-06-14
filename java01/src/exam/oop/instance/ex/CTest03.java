package exam.oop.instance.ex;

public class CTest03 {

	public static void main(String[] args) {	
			int x = 5;
			int y = 6;
			
			int i = 7;
			int j = 8;
		
			/*
			이렇게하면 한번에 한가지 계산 결과만 넣을수있지
			
			Calc02.initial_value(x);
			Calc02.multiple(6);
			System.out.println(Calc02.result);
			 */
		
		//여러가지 계산을 동시에 진행하기위해...일단 두가지만 진행하도록 두개의인스턴스를만드는거야
		Calc03 calc01 = new Calc03();
		Calc03 calc02 = new Calc03();
		
		//메서드에 레퍼런스 변수값만 넣어주면 알아서 결과를 인스턴스별(인스턴스.result)로 기억할겨
		calc01.initial_value(calc01, x); // calc01 인스턴스에 initial_value는 x여
		calc02.initial_value(calc02, y); // calc01 인스턴스에 initial_value는 y여
		
		calc01.plus(calc01, x); // initial_value에 x를 더할거여, calc01.result == x+x
		calc02.multiple(calc02,i);
		
		System.out.println(calc01.result);
		System.out.println(calc02.result);
		
		
	}

}
