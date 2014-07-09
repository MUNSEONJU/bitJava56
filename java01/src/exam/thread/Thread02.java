package exam.thread;

public class Thread02 {

	public static void main(String[] args) {
			// 현재 실행중인 thread
		Thread main = Thread.currentThread();
		System.out.println(main.getName()); 
		
			// main thread가 소속된 thread group
		ThreadGroup mainGroup = main.getThreadGroup();
		System.out.println(mainGroup.getName());
		
			// maingroup이 소속된 thread group
		ThreadGroup systemGroup = mainGroup.getParent();
		System.out.println(systemGroup.getName());
		
			// 임의의 thread 생성 실행 -> main thread의 child thread가 된다는 것을 확인할 수 있다.
		Thread t2 = new Thread("okok");
		t2.start();
		
		// System group, main group 아래에 어떤 그룹이 있는지 확인
		// System.out.println("** 소속된 group **");
		ThreadGroup[] grouptList = new ThreadGroup[50];
		//int count = systemGroup.enumerate(grouptList, false);
		int count = mainGroup.enumerate(grouptList, false);
		for(int i=0;i<count;i++){
			System.out.println(grouptList[i].getName());
		}
		
		// 그룹에 소속된 thread 목록 열기
	  System.out.println("** SystemThreadGroup에 소속된 thread **");
		Thread[] threadList = new Thread[50];
		int count1 = systemGroup.enumerate(threadList, false);
		for(int i=0;i<count1;i++){
			System.out.println(threadList[i].getName());
		}
		System.out.println("** MainThreadGroup에 소속된 thread **");
		Thread[] threadList1 = new Thread[50];
		int count2 = mainGroup.enumerate(threadList, false);
		for(int i=0;i<count2;i++){
			System.out.println(threadList[i].getName());
		}
		
		
		/*// NullPointExceptioni
		ThreadGroup p2 = p1.getParent();
		System.out.println(p2.getName());
		*/
	}

}
