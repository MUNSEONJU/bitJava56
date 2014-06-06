package study.group001;

import java.util.Scanner;

public class study_0605_answer01 {
	
	public static void main(String[] args){
		viewOut();
		
		Scanner scanner = new Scanner(System.in);
		
		String[] words = new String[]{
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"
				,"Q","R","S","T","U","V","W","X","Y","Z"," "
				};
		
		int[] memory = new int[20];
		int count=0;
		
		for(int i=0;i<memory.length;i++){
			System.out.print((i+1)+"번째 음절 : ");
			memory[i] = scanner.nextInt();
			if(memory[i]<0||memory[i]>27){
				System.out.println(memory[i]+"는 유효하지 않은 숫자입니다.");
				i--;
			} else if(memory[i]==0){
				break;
			} 
			count++;
		}
		System.out.println();
		
		System.out.print("결과 :");		
		for(int i=0;i<count;i++){
			if(memory[i]!=0){
			System.out.print(words[memory[i]-1]);
			}
		}
		
	}
	
	static void viewOut(){
		
		System.out.println("************************************");
		System.out.println("A:1/B:2/C:3/D:4/E:5/F:6/G:7/H:8/I:9");
		System.out.println("J:10/K:11/L:12/M:13/N:14/O:15/P:16");
		System.out.println("Q:17/R:18/S:19/T:20/U:21/V:22/W:23");
		System.out.println("X:24/Y:25/Z:26/SpaceBar:27  Exit:0");
		System.out.println("************************************");
		System.out.println("숫자를 입력하세요");
		
	}

}

