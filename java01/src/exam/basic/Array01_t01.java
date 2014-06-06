// 배열 : 같은 종류의 메모리를 여러개 만드는것

package exam.basic;

import java.util.Scanner;

public class Array01_t01 {
	
	
public static void main(String[] args) {		
		
		//다음과 같이 실행되도록 작성하시오
		//이름? 홍길동
		//국어? 100
		//수학? 100
		//영어? 100
		//총점? 300
		//이름? 홍길동
		//국어? 100
		//수학? 100
		//영어? 100
		//총점? 300
		//이름? 홍길동
		//국어? 100
		//수학? 100
		//영어? 100
		//총점? 300
		//홍길동 : 총점 = 300, 평균 = 100.0
		//홍길동 : 총점 = 300, 평균 = 100.0
		//홍길동 : 총점 = 300, 평균 = 100.0
		
		Scanner scanner = new Scanner(System.in);
		
		String[] name = new String[10];
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] math = new int[10];
		int[] tot = new int[10];
		float[] aver = new float [10];
		
		int num;
		//Yes:
		while(true){ 
			String input;
			
			System.out.print("몇명 입력하시겠습니까?");
			num = Integer.parseInt(scanner.nextLine());
			
			for(int i=0;i<num;i++){
				System.out.print("이름?");
				name[i] = scanner.nextLine();
				
				System.out.println("과목당 점수를 입력하세요(0~100)");
				
				System.out.print("국어?");
				Re: while(true){
					input = scanner.nextLine();
					kor[i] = Integer.parseInt(input);
					if(kor[i]<0 || kor[i]>100){
						System.out.print("국어 다시 입력하세요");
						continue Re;
					}
					else break;
				}
				
				System.out.print("영어?");
				Re: while(true){
					input = scanner.nextLine();
					eng[i] = Integer.parseInt(input);
					if(eng[i]<0 || eng[i]>100){
						System.out.print("영어 다시 입력하세요");
						continue Re;
					}
					else break;
				}

				System.out.print("수학?");
				Re: while(true){
					input = scanner.nextLine();
					math[i] = Integer.parseInt(input);
					if(math[i]<0 || math[i]>100){
						System.out.print("수학 다시 입력하세요");
						continue Re;
					}
					else break;
				}
				
				tot[i] = kor[i] + eng[i] + math[i];
				aver[i] = tot[i] / 3.0f;
			}
			
			for(int i=0;i<num;i++){
				System.out.println(name[i]+"님의 총점과 평균은 다음과 같습니다.");
				System.out.println("총점 : " + tot[i] + ", 평균 :" + aver[i]);
			}
			/*
			//내가한거
			
			System.out.print("추가로 입력하시겠습니까?(y/n)");			
			String yn="";
			yn = scanner.nextLine();
			if(yn=="y") continue Yes;//Yes: while 반복
			
			break; //while 탈출
			*/
			
			//강사님꺼 + 응용
			String yn=""; // 초기값을 주어야한다. 아래 while문에서 값을 못얻을 경우가 있기때문에.
			System.out.print("추가로 입력하시겠습니까?(y/n)");
			
			while(true){
				input = scanner.nextLine();
				if(input.equals("n")){
					yn="n";
					break;
				} else if(input.equals("y")){
					break;
				} else {
						System.out.println("잘못 입력하셨습니다(y/n)");
						continue;
				}
			}
			
			if(yn=="n") {
				break;
			}
			
		}
		
	}
	
	
public static void main05(String[] args) {		
	
		//다음과 같이 실행되도록 작성하시오
		//이름? 홍길동
		//국어? 100
		//수학? 100
		//영어? 100
		//총점? 300
		//홍길동님의 총점과 평균은 다음과 같습니다.
		//총점 = 300, 평균 = 100.0
		
		Scanner scanner = new Scanner(System.in);
		
		String[] name = new String[10];
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] math = new int[10];
		int[] tot = new int[10];
		float[] aver = new float [10];
		
		String input;
		
		System.out.print("이름?");
		name[0] = scanner.nextLine();
		
		System.out.print("국어?");
		input = scanner.nextLine();
		kor[0] = Integer.parseInt(input);
		
		System.out.print("영어?");
		input = scanner.nextLine();
		eng[0] = Integer.parseInt(input);
		
		System.out.print("수학?");
		input = scanner.nextLine();
		kor[0] = Integer.parseInt(input);
		

		tot[0] = kor[0] + eng[0] + math[0];
		aver[0] = tot[0] / 3.0f;
		
		System.out.println(name[0]+"님의 총점과 평균은 다음과 같습니다.");
		System.out.println("총점 : " + tot[0] + ", 평균 :" + aver[0]);
		
		
	}
	
	public static void main03(String[] args){
		//배열 선언과 동시에 값 초기화 할당
		
		int[] arr = new int[]{10,20,30};
		//값초기화를 할당하면 배열의 크기는 적지않는다. 배열의 크기는 값의 갯수이다

		// arr[3] = 40; // ArrayIndexOutOfBoundsException
		
		/* 불가능
		int[] arr2 = new int[3];
		arr2 = {10,20,30};
		*/
		
		int[] arr3;
		arr3 = new int[]{10,20,30};
		
		
		//배열의 index값을 조정하는 반복문은 for문이 제격
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static void main02(String[] args){
		int[] arr = new int[3];
		// 배열 선언 규칙 상세
		// new int[3] -> ☆연속☆된 4바이트(int형) 메모리 3개 준비
		// arr -> int 배열의 주소를 저장하는 레퍼런스(변수) (= C언어 : 포인터변수, C++ : 레퍼런스)
		// arr = 20; // 주소가 아닌 값을 넣을 수 없다. 임의의 주소도 넣을 수 없다.
		
		// C 공부할때 포인터는 주소라고 생각하면 쉽게 접근 가능
		// 포인터는 포인터 변수명이 p이고 10의 크기를 갖을때 p+1, p+2.. 처럼 자유롭게 사용할수있다
		// 크기가10인데 p+20 처럼 지정되지않은 변수를 사용하면 Access Violet(접근 충돌)발생
		// Java와 C++과같이 주소를 저장하는방식이 레퍼런스인 경우 이를 방지하기위해 자유롭게 사용할수없음
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		// arr[3] = 40; // ArrayIndexOutOfBoundsException
		
		//배열의 index값을 조정하는 반복문은 for문이 제격
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main04(String[] args) {		
		
		String[] name = new String[10];
		int[] kor = new int[10];
		//int kor[] = new int[10]; //괜찮지만 위에걸 권장
		int[] eng = new int[10];
		int[] math = new int[10];
		int[] tot = new int[10];
		float[] aver = new float [10];
		
		name[0] = "홍길동";
		kor[0] = 100;
		eng[0] = 90;
		math[0] = 80;
		tot[0] = kor[0] + eng[0] + math[0];
		aver[0] = tot[0] / 3.0f;
		
		System.out.println(name[0] + "님의 평균 점수는" + aver[0] + "입니다.");
		
		
	}
	
	
	public static void main01(String[] args) {
		int kor, eng, math, soc, sci, tot;
		//int kor1, eng1, math1, soc1, sci1, tot1;
		float aver;
		
		kor = 100;
		eng = 90;
		math = 80;
		soc = 85;
		sci = 95;
		
		tot = kor + eng + math + soc + sci;
		// aver = (float)tot / (float)5;  // 명시적 형변환
		// aver = (float)tot / 5;  // 명시적, 암시적 형변환
		aver = tot / 5.0f; // 암시적 형변환 적용, int와 float의 연산 -> float
		
		System.out.println("평균 : " + aver);
	}

}
