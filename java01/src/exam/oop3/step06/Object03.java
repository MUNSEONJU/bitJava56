package exam.oop3.step06;

import exam.oop3.step06.Object01.Score;

//Score 클래스도 String 처럼 toString()으로 임의의 값을 출력하게 하자

public class Object03 {

	static class Score /* extends Object */{
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float average;
		
		 /** toString() 재정의 **/
		@Override
		public String toString() {
			return "[" + name + "," + kor + "," + eng + "," + math + "," + "]";
		}
	}
	
	public static void main(String[] args) {
		Score s1 = new Score();
		s1.name = "홍길동";
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 100;
		
		Score s2 = new Score();
		s2.name = "홍길동";
		s2.kor = 100;
		s2.eng = 100;
		s2.math = 100;
		

		//s1과 s2가 다르다는 증명. 하지만 hashCode값이 동일하게 나온다.
		if(s1 != s2){
			System.out.println("s1 <> s2");
		}
		
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		 /** Object.toString() **/
		// 클래스 이름( + 패키지명 )@인스턴스ID( 해시코드 )
				
		System.out.println(s1); // println() 내부에서 s1의 toString()을 호출함
		System.out.println(s2);		
		
		 /** Object.hashCode() **/
		// 인스턴스를 구분하는 ID값 리턴
		
		System.out.println(Integer.toHexString( s1.hashCode() ));
		System.out.println(Integer.toHexString( s2.hashCode() ));		
		
		
	}

}
