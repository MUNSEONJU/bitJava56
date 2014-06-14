package exam.oop;

public class Car {
	//공통 데이터 : 클래스변수
	static int count;
	
	//클래스 변수 초기화 : static블록
	static{
		/*Car.*/count = 100;
	}
	
	//개별 데이터 : 인스턴스변수
	String	model; // 차이름
	String	carNo; // 차대번호
	int			cc; // 배기량
	int			weight; // 수용인원
	int			capacity;
	int			serialNo; // 일련번호
	
	//인스턴스변수 초기화 : 생성자
	public Car(String model, String carNo){
		this.serialNo = ++/*Car.*/count;  // 같은 클래스 내의 인스턴스를 다룰때도 클래스명 생략가능
		this.model = model;
		this.carNo = carNo;
		
	}
}
