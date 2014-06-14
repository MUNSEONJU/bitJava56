//클래스 변수의 용도

package exam.oop;

public class Test06_ex2 {

	public static void main(String[] args) {
		Car c1 = new Car("소나타","경기 40가 1252");
		Car c2 = new Car("티코", "서울 45허 2153");
		Car c3 = new Car("아반떼","인천 25모 5314");
		
		printCarInfo(c1);
		printCarInfo(c2);
		printCarInfo(c3);
	}
	
	static void printCarInfo(Car c){
		System.out.println(c.serialNo + "," + c.model + "," + c.carNo);
	}
}
