package standardJava.abstractClass;

public class CDP extends Player {

	@Override
	void play(int pos) {
		
	}

	@Override
	void stop() {

	}

	int currentTrack;
	
	void nextTrack(){
		currentTrack++;
	}
	
	void preTrack(){
		if(currentTrack<1){
			System.out.println("첫번째 트랙입니다.");
		} else{
			currentTrack--;
		}
	}
}
