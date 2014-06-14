// String 클래스 : immutable(변경할수없는, 불변의) 객체이다
// - 인스턴스의 값을 바꿀 수 없다.
// StringBuffer 클래스 : mutable 객체이다.
// - 값을 변경할 수 있다.
package exam.oop;

public class Test05_ex3 {
	
	public static void main(String[] args) {
		String s1 = new String("abcdef"); 
		String s2 = s1.replace('d', 'x');
		
		System.out.println(s1);
		System.out.println(s2);
		// String은 불변의(immutable) 객체이기때문에 값을변경하면 새로인스턴스를 생성
		// 서로다른주소를 참조하는 s1, s2
		
		StringBuffer sb1 = new StringBuffer("abcdef");
		StringBuffer sb2 = sb1.replace(3, 5, "x");
		
		System.out.println(sb1);
		System.out.println(sb2);
		//StringBuffer는 mutable(변하는) 객체를만들기때문에 명령어를통해 내용이 바뀔 수 있다.
	}
	
	
}
