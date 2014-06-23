package exam.oop3.step04;

import java.util.ArrayList;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * HashMap/HashTable
 *	- 
 */
public class CollectionTest00 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(); // 데이터를 순서대로 관리한다.
		list.add("홍길동"); //0
		list.add("임꺽정"); //1
		list.add("장길산"); //2
		list.add("장보고"); //3
		
		displayList(list);
		
		//에러 - 2번 인덱스값을 지우는 순간 장보고가 2번으로 딸려옴
		//list.remove(2); 
		//list.remove(3);
		
		list.remove(3);
		list.remove(2);
		
		displayList(list);
		
		// ArrayList는 중복을 허용한다.
		list.add("홍길동");
		list.add("홍길동");
		
		displayList(list);
	}
	
	public static void displayList(ArrayList list) {
		System.out.println("----------------------------");
		String value;
		for (int i = 0; i < list.size(); i++) {
			value = (String)list.get(i);
			System.out.println(value);
		}
	}

}











