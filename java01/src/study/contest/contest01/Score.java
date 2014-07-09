package study.contest.contest01;

public class Score {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;
	
	Score(){}
	Score(String n, int k, int e, int m){
		name = n;
		kor = k;
		eng = e;
		math = m;
		compute();
	}
	public void compute(){
		total = kor+eng+math;
		avg = total/3.0f;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public float getAvg() {
		return avg;
	}
	
	
}

