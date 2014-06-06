//문제
//이름,직위,전화번호,이메일,회사정보를 입력받고 출력하는 프로그램을 짜시오
//단, 새 데이터 타입을 정의해서 값을 입력받으시오
package exam.oop;

import java.util.Scanner;

//1. 새 데이터 타입 정의 : Address
// Address 클래스를 별도의 클래스로 지정하였음
/*
class Address{
	String name;
	String position;
	String telNum;
	String email;
	String company;
}
*/
public class Test01_ex1 {

	public static void main(String[] args) {
		//2. Address 레퍼런스 배열준비
		//3. 키보드 입력 도구 준비
		//4. 주소 정보 입력받기
		//5. 주소 정보 출력하기
		
		Scanner scanner = new Scanner(System.in);
		int num;
		
		System.out.print("주소록을 몇개 작성합니까?");
		num = Integer.parseInt(scanner.nextLine());
		System.out.println(num+"개의 주소록을 작성합니다.");
		
		Address[] addlist = new Address[num]; // 레퍼런스 배열 변수 addlist

		Address add;
		for(int i=0;i<addlist.length;i++){
			add = new Address();
			
			System.out.print("이름?");
			add.name = scanner.nextLine();
			
			System.out.print("직위");
			add.position = scanner.nextLine();
			
			System.out.print("전화번호?");
			add.telNum = scanner.nextLine();
			
			System.out.print("이메일?");
			add.email = scanner.nextLine();
			
			System.out.print("회사이름?");
			add.company = scanner.nextLine();
			
			System.out.println("이름 : " + addlist[i].name);
			System.out.println("직위 : " + addlist[i].position);
			System.out.println("전화번호 : " + addlist[i].telNum);
			System.out.println("이메일 : " + addlist[i].email);
			System.out.println("회사이름 : " + addlist[i].company);

			addlist[i] = add;
		}
			System.out.print("추가로 입력하시겠습니까?(y/n)");
			
			String yn="";
			while(true){
				String text = scanner.nextLine();
				if(text=="n"){
					yn = text;
					break;
				} else if(text=="y"){
					yn = text;
					break;
				} else{
					System.out.print("잘못 입력하셨습니다(y/n)");
					continue;
				}
			}
		
		
		
		
	}

}
