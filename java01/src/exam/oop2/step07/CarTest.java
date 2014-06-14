package exam.oop2.step07;

public class CarTest {
	public static void main(String[] args) {
	  Car car = new Car();
	  Truck truck = new Truck();
	  Suv suv = new Suv();
	  
	  //레퍼런스 변수는 자신의 인스턴스 뿐만 아니라 sub클래스의 인스턴스까지 가리킬 수 있다.
	  
	  Object obj;
	  obj = car;
	  obj = truck;
	  obj = suv;
	  
	  //레퍼런스 변수는 상위 클래스의 인스턴스를 가리킬 수 없다.
	  // -> 레퍼런스 변수의 타입을 기준으로 인스턴스를 사용하기 때문이다.
	  
	  Car c;
	  // c=obj; //상위클래스이기때문에 불가능
	  c= car;
	  c = truck;
	  c = suv;
	  
	  Truck t;
	  // t = obj;
	  // t = c;
	  t = truck;
	  t = suv;
	  
	  Suv s;
	  //s = obj;
	  //s = car;
	  //s = truck;
	  s = suv;
 	  
	  t = (Truck)car; // 트럭 레퍼런스(하위)에 카(상위)인스턴스를 속여서 넣으려고 시도했다
	  t.model = "포터";
	  t.cc = 1800;
	  t.weight = 1500; 
	  // Car인스턴스를 가리키고 있는데 레퍼런스는 Truck형이기때문에
	  // weight 변수를 참조하는 척할수있다. 하지만
	  // 인스턴스에 weight를 위한 메모리공간은 마련되어있찌 않다.속인거임
	  // 상위클래스의 인스턴스를 가리켜선 안된다
  }
}
