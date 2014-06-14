package study.report;

class Ex{

}

public class report_0609 {
		public static void main(String[] args) {
	 

    /*1.
		다음 중 Dangling Object에 대한 설명으로 올바른 것은?
			1) Java Language에서는 Garbage Collector라고도 지칭한다.
			2) 레퍼런스 변수가 인스턴스 값을 찾을 수 없는 형태이다.
			3) 발생하게 되면 메모리에 있는 인스턴스 값에 접근이 가능하다.
			4) Dangling Object가 발생하면 사용자가 직접 성능저하를 방지하기 위해 수집하여 처리한다.
		*/
		
		/*2.
		다음 중 생성자에 대한 설명으로 잘못된 것은?
			1) 생성자는 인스턴스가 생성된 후 자동으로 호출되는 메서드이다.
			2) 생성자는 생성자가 속하여 있는 클래스와 이름이 동일하다
			3) 기본 생성자는 인스턴스가 생성될 때 언제나 속한 클래스에 자동으로 생성된다.
			4) 생성자는 return 값이 없는 메서드와 유사한 형태이지만 void는 쓰지않는다.
		*/
		
		/*3.
		다음 중 공백에 알맞은 것은?
		---------------------------------------
		class Ex{
			int year;
			Ex(int age){
				int temp = 19;
				this.year = age - temp;
				System.out.println("나는 성인이 된지"+this.year+"년째.");
			}
		}
		..
		public static void main(String[] args) {
		[		?		] }
		결과 : 나는 성인이 된지 7년째.
		---------------------------------------
		1) Ex.Ex(int 26);
		2) Ex ex = new Ex(26);
		3) Ex(26);
		4) Ex ex = new Ex(); 
			 Ex(26);
		*/
		
		/*4. 다음 중 빈칸에 들어갈 수 있는 것을 모두 고르시오.
		---------------------------------------
			class Ex{
				int num = 10;
				static void method01(int a){
					System.out.println([		?		]);
				}
			}
			..
			public static void main(String[] args) {
	    Ex ex = new Ex();
	    ex.method01(10); }
	    결과 : 20
		---------------------------------------
		1) this.num + a
		2) 20
		3) a*2
		4) num + a
		*/
		
		/*5.
		다음 중 Garbage Collector에 대한 설명으로 잘못된 것은?
		1) 줄여서 GC라고도 한다.
		2) 할당된 메모리 공간이 여유로울때 Garbage Collector가 활동한다
		3) idle time에 Garbage를 수집한다.
		4) 레퍼런스가 잃어버린 메모리를 초기화 하기 위해 존재한다.
		*/
		
		/*6.
		다음 중 클래스변수에 관한 설명으로 올바른 것은?
		1) 호출하는 방법은 레퍼런스변수.변수명 이다
		2) 선언하는 방법은 static 변수명 = 값; (값은 선언하지않아도됨) 이다
		3) 인스턴스를 생성한 후 사용할 수 있다.
		4) 클래스가 로드 되는 순간 메모리에 할당된다.
		*/
		
		/*7.
		인스턴스 변수와 인스턴스 메서드에 관한 설명으로 올바른 것은?
		1) 따로 new 연산자를 이용하지 않아도 바로 사용할 수 있는 변수이다.
		2) 생성된 인스턴스는 변수를 전부 공유하여 유용하다.
		3) 인스턴스 메서드의 선언방법은 레퍼런스변수.메서드명(파라미터);이다
		4) 인스터스 메서드에서는 this를 사용할 수 없다
		*/
		
		/*8.
		다음중 올바르지 않은 부분을 찾아 수정하시오.
		
		---------------------------------------
		class Ex{
		int num;
		}
		...
		public static void main(String[] args){
			new Ex();
			Ex.num = 10;
			System.out.println(Ex.num);
		}
		
		결과 : 10
		---------------------------------------
		*/
		
		/*9. 다음 빈칸을 채우시오
		---------------------------------------
		class Ex{
		int num;
			void Method01(int a){
				[		?		]
			}
		}
		...
		public static void main(String[] args){
			Ex ex1 = new Ex();
			
			ex1.Method01(30);
			System.out.println(ex1.num);
		}
		결과 : 30
		---------------------------------------
		*/
		
		
		/*10.
		---------------------------------------
		class Ex{
		int x=10;
		}
		...
		public static void main(String[] args){
			int a;
			
			Ex ex1 = new Ex();
			a = this.x;
			
			System.out.println(a);
		}
		결과 : 10
		---------------------------------------
		*/
		
		/*
		 1. 2)
		 2. 3) 클래스에 이미 생성자를 선언해 두었다면 기본생성자는 생성되지않는다.
		 3. 2)
		 4. 3)
		 5. 2) 할당된 메모리가 부족할 때 Garbage를 수집한 후 운영체제에 메모리를 요청한다
		 6. 4)
		 7. 3)
		 8. 다음중 택1
		 		1) new Ex(); -> Ex Ex = new Ex(); 혹은 레퍼런스변수 이름을 따로 지정하고 Ex.num을 함께수정
		 		2) int num; -> static int num;
		 9. this.num
		 10. this.x -> 10 또는 ex1.x
		 		
		 */
	}

}
