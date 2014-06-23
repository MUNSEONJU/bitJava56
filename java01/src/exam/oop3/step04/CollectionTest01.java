package exam.oop3.step04;

import java.util.HashSet;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Hash Set
 * - 인스턴스의 주소들을 배열 형태로 다룬다.
 * - 중복저장을 허용하지 않는다.
 */
public class CollectionTest01 {

	public static void main(String[] args) {
		HashSet list = new HashSet(); // 데이터를 순서에 상관없이 관리한다.
		list.add("홍길동"); //0
		list.add("임꺽정"); //1
		list.add("장길산"); //2
		list.add("장보고"); //3
		
		displayList(list);
		
		list.remove("홍길동");
		list.remove("장길산");
		
		displayList(list);
		
		//Set은 중복을 허용하지 않는다.
		list.add("임꺽정");
    list.add("장보고");
		
		displayList(list);
	}
	
	public static void displayList(HashSet set) {
		System.out.println("----------------------------");
		String value;
		Object[] list = set.toArray();
		for (int i = 0; i < list.length; i++) {
			value = (String)list[i];
			System.out.println(value);
		}
	}

}











