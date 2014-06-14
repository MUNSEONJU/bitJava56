// 클래스변수 : 함수들의 중간 작업결과를 개별적으로 보관하는 변수
// 문법 : 데이터타입 변수명;
// 인스턴스 변수는 new 명령을 통해서만 준비된다
package exam.oop.instance;

public class Calculator03 {
	
	//인스턴스 변수 :데이터를 개별적으로 관리하고 싶다면 클래스변수 대신 인스턴스 변수를 선언하라
	int result;
	
	// 인스턴스 변수를 사용하기위해 인스턴스를 생성(CalcTest03)할거니까 메서드도 인스턴스로 변경
	public void init(Calculator03 that,int value){
		that.result = value;
	}
	
	public void plus(Calculator03 that,int value){
		that.result += value;
	}
	
	public void minus(Calculator03 that,int value){
		that.result -= value;
	}
	
	public void multiple(Calculator03 that,int value){
			that.result *= value;
	}
	public void divide(Calculator03 that,int value){
				that.result /= value;
	}
	
}
