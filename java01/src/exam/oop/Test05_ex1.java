// 자바의 메모리관리
//	- 기본 4가지 영역으로 데이터를 관리한다
//	1) Method Area : 클래스가 놓여진다. 클래스변수
//	2) Heap : 인스턴스가 준비된다
//	3) Stack : 로컬변수가 준비된다
//	4) Constant Pool : 상수값이 놓여진다

// * 힙 영역
//	- 인스턴스가 준비되는 메모리 영역
//	- GC가 관리하는 메모리
//	- 인스턴스는 애플리케이션 종료때까지 유지
//	- 개발자가 임의적으로 인스턴스를 제거할 수 없다
package exam.oop;

public class Test05_ex1 {
	
	static class Student{
		String name;
		int age;
	}
	
	public static void printStudent(Student s) {
		System.out.println("-------------------------");
		System.out.println(s.name);
		System.out.println(s.age);
	}
	
	public static void main(String[] args) {
	  Student s1 = new Student();
	  s1.name = "홍길동";
	  s1.age = 20;
	  printStudent(s1);
	  
	  Student s2 = m1();
	  printStudent(s2);
	  
	  m2(s2);
	  printStudent(s2);
  }
	
	static Student m1(){
		Student s = new Student();
		s.name = "임꺽정";
		s.age = 40;
		return s;
	}
	
	static void m2(Student s){
		s.name = s.name + "ㅋㅋ";
		s.age += 15;
	}
	
}
