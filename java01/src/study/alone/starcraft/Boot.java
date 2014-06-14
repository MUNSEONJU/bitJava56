package study.alone.starcraft;

import java.util.Scanner;

public class Boot {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Contents contents = new Contents();
		
		while(true){
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("유닛생산:U/건물생성:B");
			String cmd = scan.nextLine();
			
			switch(cmd){
			case "U":
				contents.Action("unit");
				break;
			case "B":
				contents.Action("build");
				break;
			}
		}
		
	}

}
