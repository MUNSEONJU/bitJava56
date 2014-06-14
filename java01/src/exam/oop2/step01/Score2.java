// 생성자 오버로딩과 this();
//	- 생성자에서 다른 생성자를 호출할 때 사용 -> this()
// 	- 단, 일반 메서드에서는 생성자를 this()를 사용할 수 없다
package exam.oop2.step01;



public class Score2 {
	// Score가 준비하는 메모리를 선언
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
	
	public Score2(){}
	
	public Score2(int score){ // 국영수 점수가 같은경우
		/*
		this.kor = score;
		this.eng = score;
		this.math = score;
		this.total = score*3;
		this.average = score;
		*/
		this(score,score,score);
	}
	
	public Score2(int kor, int eng, int math){  // 이름입력안하는경우
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
	}

	public Score2(String name, int kor, int eng, int math){
		/* 생성자 호출로 대신한다.
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
		*/
		
		//기존의 생성자 기능을 활용한다.
		//다른 생성자를 호출하는 경우는 무조건 첫문장이어야한다. 다른문장이 먼저오면안됨.
		this(kor, eng, math);
		this.name = name;
		//this(); // Constructor call must be the first statement in a constructor
		
		
		
		}
	
	public void m(){
		// 일반 메서드에서는 생성자를 호출할 수 없다
		// this(); // 용서받지 못할 코드 
	}
	
}