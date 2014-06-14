package exam.oop2.step10;

public class Customer {
	// fitness center customer 예제
	
	String 	name;
	String 	tel;
	String 	email;
	private int			age;
	private float 	height; 
	private float 	weight;
	private float 	체지방; // 
	String	createdDate; // 가입일
	String	startDate; // 유효기간 시작
	String	endDate; // 유효기간 종료
	
	
	// 인스턴스 변수에 값을 넣고 빼는 메서드 -> property
	// 값을 할당하는 메서드 -> setter (메서드)
	public void setAge(int age){
		if(age>5 && age<100){
			this.age = age;
		}
		else
			this.age = 20;
	}
	
	// 인스턴스 값을 꺼내는 메서드 -> getter (메서드)
	public int getAge(){
		return this.age;
	}
	
	public void setHeight(float height){
		if(height>100 && height<200){
			this.height = height;
		}
		else
			this.height = 175;
	}
	
	public float getHeight(){
		return this.height;
	}
		
	public void setWeight(float weight){
		if(weight>100 && weight<200){
			this.weight = weight;
		}
		else
			this.weight = 175;
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	
}
