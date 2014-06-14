package exam.oop.instance.ex;

public class Calc04 {
	
	int result;
	String finalResult;
	
	//근데 일일히 reference를 입력하는것조차 귀찮아
	//귀찮아서 this를 쓸거야
	//this를 쓰려면 메서드가 인스턴스메서드여야한다.
	
	public void initial_value(/*Calc03 this,*/ int value){
		this.result = value;
	}
	
	public void plus(int value){
		this.result += value;
	}
	public void minus(int value){
		this.result -= value;
	}
	public void multiple(int value){
		this.result *= value;
	}
	public void divide(int value){
		this.result /= value;
	}
	
}
