package exam.oop2.step07;

public class CarTest2 {
	public static void main(String[] args) {
	  Car car = new Car();
	  Truck truck = new Truck();
	  Suv suv = new Suv();
	  
	  // 다형적 변수의 활용 예
	  Car[] cars = new Car[10];
	  cars[0]	= car;
	  cars[1] = truck;
	  cars[2] = suv;
	  
	  //rpg게임의 예로 든다.
	  //인벤토리 안에는 서로 다른 타입의 오만가지 아이템이 들어있음
	  //물약은 물약배열에, 무기는 무기배열에 담는게 아니라 아이템이라는 한가지 성질에 다 담을 수 있다
  }
}
