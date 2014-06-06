package exam.basic;

import java.util.Scanner;

public class Control01_t01 {
	
	public static void main(String[] args) {
		//문제2.
		//다음과 같이 동작하도록 코드를 구현하세요
		//첫째수를 입력하세요. 10
		//연산자를 입력하세요. +(0), -(1), *(2), /(3) 3
		//둘째수를 입력하세요. 2
		//계산결과는 5입니다
		
		
		int num1, num2;
		String operator;
		System.out.print("첫째수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		num1 = Integer.parseInt(input);
		
		System.out.print("연산자를 입력하세요.");
		operator = scanner.nextLine();
		
		System.out.print("둘째수를 입력하세요.");
		input = scanner.nextLine();
		num2 = Integer.parseInt(input);
		
		
		int result;
		
		switch(operator) {
		case "+": // 문자가 아닌 문자'열'(String)이기때문에 ''이 아닌 "" 사용
			result = num1 + num2;
			break;
		case "-":
			result = num1 + num2;
			break;
		case "*":
			result = num1 + num2;
			break;
		case "/":
			result = num1 + num2;
			break;
		default:
		System.out.print("연산자값이 잘못 입력되었습니다");
			return; // 현재 메소드를 종료
		}
		
		System.out.print("결과는" + result + " 입니다");
	}
	
	
	public static void main03(String[] args) {
		//문제3
		//다음과 같이 동작하도록 코드를 구현하세요
		//첫째수를 입력하세요. 10
		//연산자를 입력하세요. +(0), -(1), *(2), /(3) 3
		//연산자 판별을 switch문으로
		//둘째수를 입력하세요. 2
		//계산결과는 5입니다
		
		
		int num1, num2, operator;
		System.out.print("첫째수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		num1 = Integer.parseInt(input);
		
		System.out.print("연산자를 입력하세요. +(0), -(1), *(2), /(3)");
		input = scanner.nextLine();
		operator = Integer.parseInt(input);
		
		System.out.print("둘째수를 입력하세요.");
		input = scanner.nextLine();
		num2 = Integer.parseInt(input);
		
		int result;
		switch(operator){
		case 0:
			result = num1 + num2;
			break;
		case 1:
			result = num1 - num2;
			break;
		case 2:
			result = num1 * num2;
			break;
		case 3:
			result = num1 / num2;
			break;
	  default:
			System.out.print("연산자값이 잘못 입력되었습니다");
			return; // 현재 메소드를 종료
		}
		
		System.out.print("결과는" + result + " 입니다");
	}
	
	
	public static void main02(String[] args) {
		//문제2.
		//다음과 같이 동작하도록 코드를 구현하세요
		//첫째수를 입력하세요. 10
		//연산자를 입력하세요. +(0), -(1), *(2), /(3) 3
		//둘째수를 입력하세요. 2
		//계산결과는 5입니다
		
		
		int num1, num2, operator;
		System.out.print("첫째수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		num1 = Integer.parseInt(input);
		
		System.out.print("연산자를 입력하세요. +(0), -(1), *(2), /(3)");
		input = scanner.nextLine();
		operator = Integer.parseInt(input);
		
		System.out.print("둘째수를 입력하세요.");
		input = scanner.nextLine();
		num2 = Integer.parseInt(input);
		
		/*
		if(operator == 0){
			System.out.print("계산결과는 " + (num1 + num2) + " 입니다");
		} else if(operator == 1){
			System.out.print("계산결과는 " + (num1 - num2) + " 입니다");
		} else if(operator == 2){
			System.out.print("계산결과는 " + (num1 * num2) + " 입니다");
		} else if(operator == 3){
			System.out.print("계산결과는 " + (num1 / num2) + " 입니다");
		} else{
			System.out.print("연산자값이 잘못 입력되었습니다");
		}
		*/
		
		int result;
		if(operator == 0){
			result = num1 + num2;
		} else if(operator == 1){
			result = num1 - num2;
		} else if(operator == 2){
			result = num1 * num2;
		} else if(operator == 3){
			result = num1 / num2;
		} else{
			System.out.print("연산자값이 잘못 입력되었습니다");
			return; // 현재 메소드를 종료
		}
		
		System.out.print("결과는" + result + " 입니다");
	}

	public static void main01(String[] args) {
		System.out.print("당신의 나이는?");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		int age = Integer.parseInt(text);

		System.out.println("당신의 나이는 "+age+"입니다");
	
		//문제1. 
		// 7세 이하는 "유아입니다"출력
		// 8세 이상부터 18세 미만까지 "청소년입니다"출력
		// 18세 이상부터 30세 미만까지 "청년입니다"출력
		// 30세 이상에서 50세 미만까지 "장년입니다"출력
		// 50세 이상에서 60세 미만까지 "중년입니다"출력
		// 60세 이상은 "노인입니다"출력
		
		if(age <= 7){
			System.out.println("유아입니다");
		} else if(age >= 8 && age < 18){
				System.out.println("청소년입니다");
		} else if(age >= 18 && age < 30){
			System.out.println("중년입니다");
		} else if(age >= 30 && age < 50){
			System.out.println("장년입니다");
		} else if(age >=50 && age < 60){
			System.out.println("중년입니다");
		} else{
			System.out.println("노인입니다");
		}
	}

}
