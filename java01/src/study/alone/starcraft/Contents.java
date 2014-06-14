package study.alone.starcraft;

import java.util.Scanner;

import study.alone.starcraft.unit.Product_unit;


public class Contents {
	Scanner scan = new Scanner(System.in);
	
	void Action(String product){
		String cmd;
		
		switch(product){
			case "unit":
				System.out.println("유닛을 생산합니다. 어떤유닛을 생산 하시겠습니까?");
				cmd = scan.nextLine();
				Product_unit unit = new Product_unit();
				//unit.select_unit();
				break;
			case "build":
			
		}
	}
}
