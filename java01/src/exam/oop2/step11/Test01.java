package exam.oop2.step11;

public class Test01 {
	public static void main(String[] args) {
	  MunInterviewee mun = new MunInterviewee();
	  
	  //Interviewee : 규칙
	  //MunInterviewee : 규칙에 의거해 내가 만든 양식
	  //Interviewer가 Interviewee(규칙)을 따라 메서드를 호출할거다
	  Interviewer iv = new Interviewer();
	  iv.addInterviewee(mun);
	  iv.interview();
  }
}
