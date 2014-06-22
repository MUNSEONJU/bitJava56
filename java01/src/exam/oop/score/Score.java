// Entity 역할
//	- 성적 정보를 표현하는 역할 : Value Object(VO)

package exam.oop.score;

public class Score {
	// Score가 준비하는 메모리를 선언
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
	
	public Score(){}
	
	public Score(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
		}
	
	
}