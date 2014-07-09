package exam.thread;

public class Atm extends Thread{
	Account account;
	
	public Atm(String name, Account acc){
		super(name);
		this.account = acc;
	}
	
  @Override
  public void run() {
  	long sum = 0;
  	long temp = 0;
  	
  	for(int i = 0 ; i < 10000 ; i++){
  		temp = account.withdraw(100);
  		if(temp>0){
  			sum += temp;
  		} else 
  			break;
  	}
  	
  	System.out.println(this.getName() + "이 찾은 금액의 합계는 " + sum + "입니다");
  }
}
