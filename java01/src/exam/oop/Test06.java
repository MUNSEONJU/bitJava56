// 클래스 로딩
// - JVM은 file system에서 읽은 바이트코드를 Method Area에 올린다.
// ( JVM은 하드디스크에서 읽은 .class파일을 Method Area에 올린다. )
// - 실행 순서
//		1) 파일 시스템에서 클래스를 찾는다(classpath 환경변수에 설정된 디렉토리를 뒤진다)
//		2) 바이트코드를 검증한 후, Method Area에 로딩한다.
//			- 클래스 변수(static변수) 및 클래스 블록(static블록)을 "순차적"으로 실행한다.
//		3) 로딩된 바이트코드에서 main() 메서드를 찾아 호출한다.

package exam.oop;

public class Test06 {
	// 클래스변수
	//	- 모든 인스턴스들이 공유하는 데이터 보관
	static int a = 20;
	
	// 스태틱블록
	//	- 클래스가 로딩될 때 클래스변수를 초기화 하는 작업(생성자와 비슷)
	static {
		System.out.println(a);
		//System.out.println(b);
	}
	
	static int b = 30;
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}

	//스태틱블록
	static{
		System.out.println(b);
	}
}
// 클래스안에 스태틱블록이 여러개있는것은 바람직하지 않음.