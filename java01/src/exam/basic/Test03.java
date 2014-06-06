/*3. 변수 선언
	- 데이터를 저장하기 위한 메모리 준비
	- 사용자가 입력한 값, 중간계산결과를 저장
	- 문법 : 메모리종류 메모리를가리키는이름; -> 데이터타입 변수;
	- 변수 : 메모리를 가리키는 이름
	- 메모리타입 : 어떤 크기의 어떤 종류의 데이터를 저장할 것인지 선언, 
						  메모리를 효율적으로 관리하기 위해 8개의 기본 타입을 제공
	- 정수 : byte(1byte), short(2), int(4), long(8)
	- 실수 : float(4), double(8)
	- 문자 : char(2)
	- 논리값 : boolean(1)
	- 할당연산자 : [ = ] assignment, 변수에 값을 할당하는 연산자
 */
package exam.basic;

public class Test03 {
	public static void main(String[] args){
		/*
		
		문제1. 사람의 나이를 저장할 메모리를 준비
		문제2. 학생의 수학 점수를 저장할 메모리
		문제3. 빌게이츠의 돈(50조)을 저장할 메모리 준비
		문제4. 파이 값(3.14159)을 저장할 메모리를 준비
		문제5. 한글 1음절을 저장할 메모리를 준비
		문제6. 결혼 여부를 저장할 메모리를 준비
		
		*/
		
		//문제1.
		byte age;
		age = 26;
		//문제2.
		short math, kor, eng;
		math = 100;
		kor=250;
		eng=300;
		//문제3.
		long assets;
		assets = 500000000000000L;
		//문제4.
		//float : 유효자리 6자(single - precision, 단정도)
		//double : 유효자리 15자리(double - precision, 배정도)
		float pi = 3.14159f;
		//문제5.
		char ch1 = 44032; // 10진수 -> '가'
		char ch2 = 0xAC00; // 16진수 -> '가'
		char ch3 = 0126000; // 8진수 -> '가'
		char ch4 = '가'; // -> 44032
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		//문제6.
		boolean married;
		married = false;
		
	}
}
