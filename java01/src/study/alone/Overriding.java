package study.alone;

class A{
	int a=10;
	int b=20;
	void printB(){
		System.out.println(b);
	}
}

class B extends A{
	int x =50;
	void printB(){
		System.out.println(x);
	}
	void printA(){
		System.out.println(a);
	}
}

public class Overriding {

	public static void main(String[] args) {
		B b = new B();
		//b.printB();
		b.printB();
		
		

	}

}
