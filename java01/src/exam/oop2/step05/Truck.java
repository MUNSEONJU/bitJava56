package exam.oop2.step05;

public class Truck extends Car {
	int weight = 1000; // 적재중량
	/*public Truck(){
		System.out.println("TRUCK()");
	}*/
	public Truck(int weight){
		//super();
		super("오호라"); // super클래스의 생성자 중에서 호출될 생성자를 선택할 수 있따.
		System.out.println("TRUCK()");
		this.weight = weight;
	}
}
