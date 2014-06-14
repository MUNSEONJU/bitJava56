package exam.oop2.step09.sub;

public class A {
	public int a; // 공개
	protected int c;// 같은패키지 + 자식클래스
	int b; // (default) 같은패키지 공개
	private int d; // 비공개
	
	public void m1() {}
	protected void m3() {}
	void m2() {}
	private void m4() {}
	
	
	public void test(){
		a=20; b=30; c=40; d=50;
		 
		m1(); m2(); m3(); m4();
	}
}
