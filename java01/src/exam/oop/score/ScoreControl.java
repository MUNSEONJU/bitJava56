// Control 역할
//	- Boundary와 Entity의 중계 역할
//	- 사용자가 입력한 명령에 따라 Boundary를 연결해준다
package exam.oop.score;

import java.util.Scanner;

public class ScoreControl {
	ScoreInput scoreInput;
	ScoreDao scoreDao;
	Scanner scan = new Scanner(System.in);

	public ScoreControl(){
		Scanner scan = new Scanner(System.in);
		scoreDao = new ScoreDao();
		scoreInput = new ScoreInput(scan, scoreDao);
	}
	
	public void execute(){
	  String command;
	  System.out.print(">");
	  command = scan.nextLine();
	  if(command.equals("new")){
	  	scoreInput.service(scan);
	  }
	}
	
	public void printScoreall(){
			Score[] scores = scoreDao.toArray();
			int size = scoreDao.size;
			
			for(int i=0;i<size;i++){
				System.out.println(scores[i].name + ":" + scores[i].kor);
			}
	}
	public static void main(String[] args) {
		ScoreControl sc = new ScoreControl();
		sc.execute();
		sc.printScoreall();
  }
}
