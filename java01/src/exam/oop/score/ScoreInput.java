// Boundary 역할
//	- 사용자로부터 성적 정보를 입력 받는 역할
//	- 

package exam.oop.score;

import java.util.Scanner;

public class ScoreInput {
	Scanner scan;
	ScoreDao scoreDao;
	
	//생성자
	public ScoreInput(Scanner scan,ScoreDao scoreDao){
		this.scan = scan;
		this.scoreDao = scoreDao;
	}
	
	//service메서드
	public void service(Scanner scan){
		//1. 사용자로부터 성적 정보를 입력받는다.
		Score score = new Score();
		
		System.out.print("이름?");
		score.name = scan.nextLine();
		
		System.out.print("국어?");
		score.kor = Integer.parseInt( scan.nextLine() );

		System.out.print("영어?");
		score.eng = Integer.parseInt( scan.nextLine() );
		
		System.out.print("수학?");
		score.math = Integer.parseInt( scan.nextLine() );
		
		score.total = score.kor + score.eng + score.math;
		score.average = score.total/3.0f;
		
		//2. 성적 정보를 ScoreDao에게 전달한다.
		scoreDao.insert(score);
		//
	}
}
