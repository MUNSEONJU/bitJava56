package exam.oop3.step01;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//추상클래스 : 공통 기능을 sub class에 상속 해주는 용도를 위해 존재한다.
//	- WindowListener 인터페이스를 구현을 sub에 상속해주기 위해 다음 클래스 작성
//	- 인스턴스를 만들 수 없다.(클래스 자체로 사용 불가)
//	- 추상클래스는 추상 메서드를 가질 수 있다.( Concreate class는 추상메서드를 가질 수 없다 )

abstract public class AbstractWindowListener implements WindowListener {
	
	
	// - 여기서 구현을 다 해뒀기때문에 AbstractWindowListener를 상속받는 클래스는 Overriding만하면된다.
	// - 만약 여기서 WindowListener(인터페이스)의 추상메서드들을 전부구현안했으면
	//   상속받는 클래스는 나머지를 구현하거나, 추상클래스여야한다.
  public void windowOpened(WindowEvent e) {  }
  public void windowClosing(WindowEvent e) {  }
  public void windowClosed(WindowEvent e) {  }
  public void windowIconified(WindowEvent e) {  }
  public void windowDeiconified(WindowEvent e) {  }
  public void windowActivated(WindowEvent e) {  }
  public void windowDeactivated(WindowEvent e) {  }
	
	
}
