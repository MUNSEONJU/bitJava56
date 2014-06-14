 /* 연습 : 인스턴스 생성
    - 크래스의 인스턴스를 생성하고 인스턴스에 값 할당 방법
    - Garbage : 인스턴스의 주소를 잃어버려(주소를 가진 레퍼런스가 없어) 사용할 수 없는 메모리
    - Garbage Collector(GC) : idle time, 메모리부족
	*/
package exam.oop;

public class Test02_ex1 {
	public static void main(String[] args) {
	  	// 레퍼런스 변수 없음
		new Address(); // 인스턴스 생성
		
	  	// 레퍼런스 변수에 인스턴스 주소 저장
	  Address addr1 = new Address(); // 인스턴스 생성 및 주소를 변수에 보관
	  Address addr2 = new Address(); // 인스턴스 생성 및 주소를 변수에 보관
	  	
	    // 레퍼런스 변수를 통해 인스턴스에 값 할당
	  addr1.name = "홍길동";
	  addr1.email = "hong@test.com";
	  addr2.name = "임꺽정";
	  addr2.email = "lim@test.com";
	  
	  	// 레퍼런스 변수를 통해 인스턴스의 변수의 값 추출
	  	// 레퍼런스.인스턴스 변수명
	  System.out.println(addr1.name);
	  System.out.println(addr1.email);
	  
	  System.out.println(addr2.name);
	  System.out.println(addr2.email);
	  
	  Address addr3 = addr2;
	  addr1 = addr2;
	  System.out.println(addr3.name);
	  System.out.println(addr1.name);
	  	// 레퍼런스변수가 단순히 주소값이라는것을 증명한다
	  	// 생성자를 통하여 addr3주소에 해당하는 인스턴스를 생성하지않았지만 정상적으로출력된다.
	  	// addr2  ---->   [			생성된 인스턴스			]
	  	// addr3,addr1   ---------↗
	  	// addr1이 가리키고 있던 인스턴스는 메모리에는 기억되어있지만 아무도 주소를 몰라서 접근할 수 없다
	  	// 주소를 잃어버린 인스턴스라 하여 Dangling Object -> 자바에서는 Garbage라 한다.
	  	// 잃어버린 메모리를 재활용하기 위하여 Garbage를 재활용하려면 초기화(해제)해야한다
	  	// --> Garbage Collector(GC)
	  	// 1) 한창 차막히는 출근시간에 쓰레기차가 돌아다니면 답답해
	  	// 한가할때 치워야해, 한가할때 GC가 돌아다녀 -> "idle time"
	  	// 2) 인스턴스를 만들어야하는데 할당된 "메모리가 부족"(자취하는데 용돈이 부족해)
	  	// 운영체제에서 새로 메모리를 할당받기전에 Garbage수집(용돈달라고하기전에 잔돈을뒤짐)
	  
	  //용서받지 못할 코드
	  //null : 주소 없음을 의미하는 값
	  //Address addr4;
	  //Address addr4 = null;
	  //System.out.println(addr4.name);
	  
	  //용서받지 못할 코드(by 컴파일러)
	  //Address addr5 = new Board();
	  
  }
	
}


