// 자바의 메모리관리
//	- 기본 4가지 영역으로 데이터를 관리한다
//	1) Method Area : 클래스가 놓여진다. 클래스변수
//	2) Heap : 인스턴스가 준비된다
//	3) Stack : 로컬변수가 준비된다
//	4) Constant Pool : 상수값이 놓여진다

// * 상수 풀 영역
//	- 상수 개체가 준비되는 영역
//  - 메모리 절약을 위해 같은 값을 갖는 상수는 중복해서 생성되지 않는다.
//	- 상수 문자열 : "문자열" >> 내부적으로 String 인스턴스를 상수 풀에 생성한다.
//	- String#intern() : [String클래스의 intern 메서드] 상수풀에 String인스턴스 생성
package exam.oop;

public class Test05_ex2 {
	
	public static void main(String[] args) {
		String s1 = new String("홍길동"); // heap 영역에 생성
		String s2 = new String("홍길동");// heap 영역에 생성
		String s3 = "홍길동";//상수 풀 영역에 생성
		String s4 = "홍길동";//기존 상수 풀 영역에 생성된 객체를 가리킴
		
		if(s1==s2){
		// heap 영역에 s1과 s2 각자 인스턴스가 따로만들어지기때문에
		// reference값이 같지않음
			System.out.println("s2==s1");  
		}
		
		
		if(s3==s4){
		// 상수풀(constants Pool)영역에 자동으로 생성된 s3의 주소를 참조하여
		// 동일한 데이터가 있는 객체를 s4가 그대로 참조하기때문에 
		// 주소가 같음
			System.out.println("s3==s4");
		}
		
		
		String s5 = s1.intern();
		if(s3==s5){
		// 
			System.out.println("s3==s5");
		}
	}
	
	
}
