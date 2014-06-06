package exam.basic;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 44032;
		int i2 = 0xAC00; // 16진수에 가장 많이 사용하는 형태 
		int i3 = 0XAC00;
		int i4 = 0xac00;
		int i5 = 0Xac00;
		int i6 = 0126000;
		
		//문제
		//float a = 2.5f;
		//float b = 3.5f;
		//float result = (int)a + (int)b;
		//System.out.println(result);
		//System.out.println(a);
		
		
		 		/*
		int a = 10;
		int b = 10;
		a = a++;
		b = ++b;		
		System.out.println("a = " + a);
		System.out.println("a = " + a);
		*/
		
		/*
		boolean r = true;
		boolean b2 = true;
		boolean s = (r = false) && b2;
		
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		*/
		
		/*
		int num3 = 7;
		int num4 = 3;
		int r1 = num3 & num4;
		int r2 = num3 | num4;
		System.out.println(r1+","+r2);
		*/

	   int a, b, result;
	   a = 10;
	   b = 15;
	   result = a++ + ++a + ++b + b++;

	   System.out.println(result);System.out.println(b);
	}

}
