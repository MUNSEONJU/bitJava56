package exam.oop2.step08;

//1. 다른 패키지의 클래스 사용 Test
//2. import명령
//	- 클래스의 경로를 컴파일러에게 알려주는 명령

//클래스의 경로 지정
//	- import는 컴파일러가 참고하는 정보이다. 따라서 컴파일 후 제거된다.
//	- import문이 많으면 컴파일 한 후 바이트코드(.class)가 커진다는 착각을 하지 말것
import exam.oop2.step08.sub.B;

public class Test01 {

	public static void main(String[] args) {
			//import 사용 전
			//	- 다른 패키지의 클래스를 사용할 때는 반드시 경로를 정확하게 지정해야 한다.
			//	- 단, java.lang 패키지는 컴파일러가 자동으로 인식한다(필요ㄴㄴ)
			//		: java.lang패키지의 클래스는 경로를 지정하지 않고 사용가능)
			//		: ex) String, Object, System 외 클래스들...
		
			//exam.oop2.step08.sub.A p1 // A의 접근 제한자가 default이다
			exam.oop2.step08.sub.B p2; // B의 접근 제한자는 public(공개)이다
			
			
			java.lang.String oho = "오호라";
			String ohora = "ㅇ오ㅗㅗㅎㅎ호ㅗㅗㅗㅗㅗㅗ라ㅏㅏㅏ";
			
			//import 사용 후
			//	- 클래스 선언 위에 import 명령을 사용해서 다음과 같이 클래스 경로를 지정한다.
			//		: ex) import exam.oop2.step08.sub.A;
			//	- 클래스 이름을 빼고 패키지 이름만 지정할 수 있다
			//		: ex) import exam.oop2.step08.sub.*;
			//	- 권고
			//		: 가능하면 클래스 이름까지 지정하라. 
			//		: 소스 리딩할때 쉽게 파악할 수 있다
			//	- ctrl + shift + o
			
			B p3; // import를 했기때문에 package명 생략 가능
	}	

}
