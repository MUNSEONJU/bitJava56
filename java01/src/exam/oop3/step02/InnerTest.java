package exam.oop3.step02;

//Top level inner class 사용 전!
class Layout {
public static final int main_layout = 1;
public static final int input_window_layout = 2;
}

class Icon {
public static final String icon16x16 = "a.png";
public static final String icon64x64 = "b.png";
public static final String icon128x128 = "c.png";
}

class Label {
public static final String hello = "안녕하세요";
public static final String title = "비트 성적관리 시스템";
}

class ResourceX {
static Layout layout;
static Icon icon;
static Label label;
}

class Resource{ // package member class
	
	//Top Level(static) inner class
	//	- 계층 구조로 관리한다. 전부 static. OGNL.( = 안드로이드 R.java )
	//	- OGNL 접근방식( Resource.layout.main_layout )
	//	- top level inner class 사용안하면 클래스 밖에 클래스 만들어줘야함
	static public class layout{
		public static final int main_layout = 1;
		public static final int input_window_layout = 2;
	}
	
	static public class icon{
		public static final String icon16x16 = "a.png";
		public static final String icon64x64 = "b.png";
		public static final String icon128x128 = "c.png";
	}
	
	static public class label{
		public static final String hello = "안녕하세요";
		public static final String title = "비트 성적관리 시스템";
	}
}

public class InnerTest {

	public static void main(String[] args) {
		
		// OGNL(Object Graph Navigation Language)
		// - 자바 프로퍼티의 값을 꺼내고 설정하는 문법

		// top level inner class
		//	- OGNL 표기법 흉내낼수있음
		//	- 작은 클래스들을 묶을 때 사용. 
		System.out.println(Resource.layout.main_layout);
		System.out.println(Resource.icon.icon128x128);
		System.out.println(Resource.label.hello);
		
		// 일반 클래스로 OGNL 흉내 내기
		System.out.println(ResourceX.layout.main_layout);
		System.out.println(ResourceX.icon.icon128x128);
		System.out.println(ResourceX.label.hello);
			
		
	}
	

}
