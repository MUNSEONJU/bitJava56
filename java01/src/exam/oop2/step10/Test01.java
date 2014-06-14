package exam.oop2.step10;

// 캡슐화가 왜 필요한가?
//	- 추상화의 의미와 관련 없는 무효한 데이터의 입력을 제한
//		: 추상화를 무너트리지 않기 위해 필요하다.
//		: 유효하지 않은 값이 들어가면 추상화(객체지향의 근간 - 클래스역할을 식별하고 정의함)에 의미가 퇴색된다.

public class Test01 {

	public static void main(String[] args) {
		Customer c = new Customer();
		// 이건 사람이 아니다.... customer의 기대값에 벗어난다
		c.name = "홍길동";
		c.tel = "010-1011-0100";
		//c.age = 300;
		//c.height = 1800;
		//c.weight = 700;
		
		//접근권한을 통해 함부로 접근하지도록 막았다.. 그럼 어떻게 접근?
		//접근할수 있는 "방법"을 제공한다 --> 메서드
		
		c.setAge(300);
		c.setHeight(400);
		c.setWeight(500);
		
		System.out.println(c.getAge());
		System.out.println(c.getHeight());
		System.out.println(c.getWeight());
	}

}
