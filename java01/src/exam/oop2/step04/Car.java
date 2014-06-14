// 상속 받아서 만든 인스턴스 변수의 초기화 절차
//	- 초기화 문장(initializer):
//			class A{
//				int v = 20;
//			}
//	- 생성자 (constructor):
//			class A{
//				int a;
//				public A(){
//					a=20;
//				}
//			}
//	- 인스턴ㅅ 변수는 생성직후, 기본으로 9으로 초기화된다
//			정수 : 0, 실수 : 0.0, 논리 : false, 문자 : '\u0000'
//			결국 모든 비트가 0으로 저장된다

package exam.oop2.step04;

public class Car {
	String 	model;
	int 		cc = 1000;
}
