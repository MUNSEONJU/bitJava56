package exam.oop2.step12;

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
	  computer.monitor = new MyMonitor(); // 다형성! ( LG모니터는 모니터라고 부를수 있다)
	  
	  computer.start();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.timeOut();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.wakeUp();
	  	  
  }
}