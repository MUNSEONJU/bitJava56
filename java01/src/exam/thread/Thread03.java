package exam.thread;

public class Thread03 {

	public static void main(String[] args) {
		Account account = new Account(1000000);
		
		Atm t1 = new Atm("강남", account);
		Atm t2 = new Atm("양재", account);
		Atm t3 = new Atm("종로", account);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
