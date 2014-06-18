package exam.oop2.step13;

public class Computer {
	Monitor monitor;
	
	public void start(){
		monitor.display("부팅중...");
		monitor.display("메인화면");
	}
	
	public void timeOut(){
		monitor.mute();
	}
	
	public void wakeUp(){
		 monitor.display("이전화면");
	}
	
	public static void main(String[] args) throws Exception{ // 부팅
	  Computer computer = new Computer();
	  
	  //모니터 규칙(모니터 interface)을 준수하는 클래스 인스턴스라면
	  //모니터 타입의 인스턴스주소(monitor)에 할당 할 수 있다.
	  // : 객체의 대체 가능 범위를 확장 한 것! => 상속을 통한 대체 기법 보다 더 나은 방식
	  computer.monitor = new MyMonitor();
	  
	  computer.start();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.timeOut();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.wakeUp();
	  	  
  }
}
