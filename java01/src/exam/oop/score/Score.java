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
	
	// 생성자
	//	- 인스턴스를 생성하면 필수로 필요한 파라미터를 입력하여 필수항목의 초기값을 지정해주고
	//	- 함수니까 해당하는 기능까지 수행해준다
	//	- 단 나중에 따로 호출할 수는 없다
	
	/*
	public Score(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
		}
		*/
	
}