package exam.oop.instance.ex;

public class CTest02 {

	public static void main(String[] args) {
		int x = 5;
		int y = 6;
		
		int i = 7;
		int j = 8;
		
		Calc02.initial_value(x);
		Calc02.multiple(6);
		System.out.println(Calc02.result);
		
		/*
		Calc02.result = Calc02.multiple(x, y);
		System.out.println(Calc02.result);
		*/
		
	}

}
