// Entity 역할
//	- 성적 정보를 표현하는 역할 : Value Object(VO)
//	- setter, getter 메서드를 생성하고 외부에서 접근하지 못하도록 캡슐화
//	- total, average는 외부에서 임의의 값을 넣게하지 않기위해 compute라는 특별한 함수를 이용한다.

package exam.oop3.step03;

public class Score {
	// Score가 준비하는 메모리를 선언
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float average;
	
	public Score(){}
	
	public Score(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
		}
	
	private void compute(){
		this.total = this.kor+this.eng+this.math;
		this.average = this.total/3.0f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		compute();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		compute();	
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		compute();
	}

	public int getTotal() {
		return total;
	}

	public float getAverage() {
		return average;
	}

	

}