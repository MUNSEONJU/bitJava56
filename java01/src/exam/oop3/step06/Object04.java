package exam.oop3.step06;

import exam.oop3.step06.Object01.Score;

//Score 클래스도 String 처럼 toString()으로 
//equals() 메서드로 값을 비교하게 하자

public class Object04 {

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
		String s1 = new String("Hello");
		String s2 = new String("Hi");
		

		//s1과 s2가 다르다는 증명. 하지만 hashCode값이 동일하게 나온다.
		if(s1 != s2){
			System.out.println("s1 <> s2 : 주소는 다르다");
		}
				
		if(s1.equals(s2)){
			System.out.println("s1.equals(s2) : 값은 같다");
		}
		
		System.out.println("해시값도 같다");
		System.out.println(Integer.toHexString( s1.hashCode() ));
		System.out.println(Integer.toHexString( s2.hashCode() ));		
		
		
	}

}
