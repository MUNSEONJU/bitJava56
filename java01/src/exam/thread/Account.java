package exam.thread;

public class Account {
	long balance; // 잔액
	
	public Account(long balance) {
		this.balance = balance;
	}
	
	 /** MUTEX **/
	// 여러 스레드가 메서드를 동시에 수행하는 경우 공유 메모리에 접근 시 값을 덮어쓰는 문제가 발생한다.
	//	- 이처럼 여러 스레드가 접근했을 때 문제가 발생하는 코드를 다음과 같이 표현한다
	//		: 스레드에게서 안전하지 않은 코드 영역
	//		: 여러 스레드가 동시에 접근하지 말아야 할 코드영역
	//		-> "Critical Section(임계구역)"
	//	- Critical Section이 올바르게 실행 되도록 하는 방법
	//		 ( 스레드 안전(Thread Safe)하게 하는 방법? )
	//		: 한 번에 한 스레드 만이 임계구역에 진입하게 한다.
	//		: 진입한 스레드는 Locking/실행 완료한 후 Unlocking
	//		-> "Mutex(Mutual Exclusion)" 
	//			ex) 공중화장실 대변기 들어가면 잠금, 선풍기 풍량 오로지1개선택, 라디오 주파수 하나의 눈금만 선택
	
	 /** SEMAPHORE **/
	// mutex : 1개 <-> semaphore : n개
	//	ex) 공중화장실 대변기 3대가 있는 화장실 대기줄
	// 임계구역에 진입할 수 있는 스레드 수가 1 이상일 때를 말한다.
	
	 /** DEADLOCK **/
	// Thread가 들어갔다가 빠져나오지못하는거
	
	// mutex 적용 (synchronized : 동기화)
	synchronized public long withdraw(long money){ // 출금
		long temp = this.balance;
		
		if( (temp-money) >=0 ){ // 출금하려는 돈이 잔액보다 많음안댐
			temp = temp - money;
			
			// 시간 지연시켜서 cpu 사용권을 뺏기기 위한 코드..
			long x = (long) (Math.random() * 10) + 1;
			for( long i = 0 ; i < x ; i++){
				double d = i * 3.14159 / 0.34567;
			}
			
			this.balance = temp;
			return money;
		} else return 0;
	}
	
}
