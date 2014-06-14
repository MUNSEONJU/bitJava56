// 메서드 호출할때마다 인스턴스의 주소를 넘기기가 귀찮다
// 인스턴스메서드
// 호출문법 : 인스턴스주소.메서드명(..);  
// 선언문법 : 리턴타입 메서드명(parameters..){    } / static을 붙이지 않는다
// 인스턴스 주소는 메서드 호출 시 메서드 이름앞에 붙여준다
package exam.oop.instance;

public class CalcTest04 {

	public static void main(String[] args) {
		
		// 5 + 3 * 7 ( 계산기처럼 연산자 우선순위 고려하지 않은 가정하의 연산 )
		// 6 - 2 + 3
		Calculator04 cal1 = new Calculator04();
		Calculator04 cal2 = new Calculator04();
		
		//Calculator04의 init 메소드
		
		//Calculator04의 init메소드를 개별로 호출할거라서 인스턴스메소드로 만들어뒀다
		//public void init(/*Calculator04 this*/int value){ 
		//	this.result = value; }	 // this는 해당메소드가 소속된 클래스의 인스턴스의 주소값이다
		
		cal1.init(5);
		cal2.init(6);
		
		cal1.plus(3);
		cal2.minus(2);
		
		cal1.multiple(7);
		cal2.plus(3);
		
		System.out.println(cal1.result);
		System.out.println(cal2.result);
		
	}

}
