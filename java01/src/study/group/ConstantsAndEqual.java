package study.group;
public class ConstantsAndEqual {
	public static void main(String[] args) {
		//constants pool example
		
		String str1 = "ABC";
		String str2 = new String("ABC");
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
	}
}
