//기본생성자
//	- "생성자를 선언하지 않으면" 컴파일러가 자동으로 기본생성자를 추가한다
//	- 생성자를 하나라도 만들었으면 기본생성자는 컴파일시 만들어지지 않는다.-> 필요하면 만들어
// 	- 기본생성자 : 파라미터가 없는 생성자
// 	- 모든 자바의 클래스는 반드시무조건 한개 이상의 생성자가 있어야 한다.

package exam.oop;

public class Score3 {
	// Score가 준비하는 메모리를 선언
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
	
	//public Score3(){}  // 기본 생성자 : 없을경우 컴파일러가 자동으로 생성
	
}