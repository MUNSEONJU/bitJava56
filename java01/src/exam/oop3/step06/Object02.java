package exam.oop3.step06;

public class Object02 {

	static class Score /* extends Object */{
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float average;
	}
	
	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hi");
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		
		//s1과 s2가 다르다는 증명. 하지만 hashCode값이 동일하게 나온다.
		if(s1 != s2){
			System.out.println("s1 <> s2");
		}
		
		
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
