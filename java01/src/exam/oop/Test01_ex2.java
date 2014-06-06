/*
 * 함수(function=기능) => 객체지향에서는 "메서드"라 부른다. 
 * - 명령어들을 기능단위로 묶은 것
 * - 명령어들을 관리하기 쉽다
 * - 명령어들을 쉽게 재사용 할 수 있다 ☆☆☆
 * 
 * - 문법
 * 	리턴하는(넘겨받을) 데이터 타입 함수명(값을 받을 변수 선언, ...) {명령들}
 * 
 * - 함수에서 값을 리턴받기 위해 선언하는 변수, 넘겨받는 값 -> parameter
 * 	int plus(int a, int b) {return a+b}
 *  파라미터 : a,b
 *  
 * - 함수를 호출할때 넘겨주는 값 -> argument
 * 	int result = plus(10, 20);
 * 	아규먼트(인자) : 10, 20
 * 
 * - ex1) void 리턴(리턴없음), 파라미터 없음
 * 	void print() {...}
 * 
 * - ex2) void 리턴(리턴없음, null이 아님), 파라미터 있음
 *  void print(String msg) {...}
 *  
 * - ex3) 리턴 있음, 파라미터 없음 - 주진않고 뺏는다
 * 	String getName() {return "ok"}
 * 
 * - ex4) 리턴 있음, 파라미터 있음 - 심부름시킨다 줄테니 가져와
 *  int plus(int a, int b) {return a+b;}
 * 
 */

package exam.oop;

import java.util.Scanner;

/*
class Address {
	String name;
	String position;
	String tel;
	String email;
	String company;
}
*/
public class Test01_ex2 {

	public static void main(String[] args) {
		//2. Address 레퍼런스 배열 준비
		Address[] addrs = new Address[100];
		
		//3. 키보드 입력 도구 준비
		Scanner scanner = new Scanner(System.in);
		
		//4. 주소 정보 입력 받기
		Address addr;
		int count = 0;
		for (int i = 0; i < addrs.length; i++) {
			
			count++;
			
			if(!isContinue(scanner))
				break;
		}
		
		//5. 주소 정보 출력 하기
		for (int i = 0; i < count; i++) {
			printAddress(addrs[i]);
		}

	}
	
	//반복해서 출력할 것을 함수로 지정
	static void printAddress(Address addr){
		System.out.println(addr.name + "," + addr.telNum + "," +
				addr.email + "," + addr.position + "," + 
				addr.company);
	}
	
	static boolean isContinue(Scanner scanner){
		System.out.print("계속 입력하시겠습니까?(y/n)");
		String text = scanner.nextLine();
		if (text.equals("n"))
			return false;
		else 
			return true;
	}
	
	static Address inputAddress(Scanner scanner){
		Address addr = new Address();
		
		System.out.print("이름?");
		addr.name = scanner.nextLine();
		
		System.out.print("직위?");
		addr.position = scanner.nextLine();
		
		System.out.print("전화번호?");
		addr.telNum = scanner.nextLine();
		
		System.out.print("이메일?");
		addr.email = scanner.nextLine();
		
		System.out.print("회사?");
		addr.company = scanner.nextLine();
		
		return addr;
	}

}
