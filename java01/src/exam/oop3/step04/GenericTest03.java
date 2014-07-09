package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Date;

// ArrayList와 Generic

public class GenericTest03 {
	public static void main(String[] args) {
	  ArrayList list1 = new ArrayList();
	  list1.add(new String("okok"));
	  list1.add(new Date());
	  list1.add(new Integer(10));
	  
	  String v1 = (String)list1.get(0); 
	  // ArrayList는 Object형으로 return하기때문에
	  // 명시적으로 형변환을 반드시 해주어야한다.
	  
	  ArrayList<String> list2 = new ArrayList<>();
	  list2.add(new String("홍길동"));
	  list2.add(new String("임꺽정"));
	  // list2.add(new Date()); // 오류
	  
	  String s1 = list2.get(0); // 자동형변환
  }
}
