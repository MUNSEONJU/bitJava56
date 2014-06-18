package standardJava.abstractClass;

abstract class Player{
	boolean pause;
	int currentPos; // current : 현재의 Pos(ition)
	
	Player(){
		pause = false;
		currentPos = 1;
	}
	
	abstract void play(int pos); // 추상메서드 작성 시 클래스가 추상클래스가 아니면 오류
	abstract void stop();
	
	void play(){ 	// 메서드 오버로딩.
		play(currentPos); // 추상메서드 사용, 정의는 아직안됨.
	}
	
	void pause(){
		if(pause){
			pause = false;
			play(currentPos);
		} else{
			pause = true;
			stop(); // 추상메서드 호출, 아직 정의안됨
		}
		
	}
}