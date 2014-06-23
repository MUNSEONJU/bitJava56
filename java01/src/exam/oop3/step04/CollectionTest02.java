package exam.oop3.step04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Hash Map / Hash Table
 * 	- 인스턴스의 주소를 Key-value 형식으로 다룬다
 * 	- 키를 사용하여 값을 조회한다
 * 	- HashMap은 키와 값에 대해 null을 허용한다.
 * 	- Hashtable은 키와 값이 null이 될 수 없다. 동기화 지원.
 */
public class CollectionTest02 {

	public static void main(String[] args) {
		HashMap map = new HashMap(); // 데이터를 순서에 상관없이 관리한다.
		map.put("1010","홍길동"); //0
		map.put("2020","임꺽정"); //1
		map.put("3030","장길산"); //2
		map.put("4040","장보고"); //3
		
		displayEntryFromMap(map);
		displayKeyFromMap(map);
		displayValueFromMap(map);
	}
	
	public static void displayEntryFromMap(HashMap map) {
		System.out.println("----------------------------");
		Set set = map.entrySet();
		Object[] list = set.toArray();
		
		Entry entry;
		for (int i = 0; i < list.length; i++) {
			entry = (Entry)list[i];
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public static void displayKeyFromMap(HashMap map){
		System.out.println("----------------------------");
		Set set = map.keySet();
		Object[] list = set.toArray();
		
		for(int i=0;i < list.length ; i++){
			System.out.println(list[i] + " : " + map.get(list[i]));
		}

	}
	
	public static void displayValueFromMap(HashMap map){
		System.out.println("----------------------------");
		Collection coll = map.values();
		Object[] list = coll.toArray();
		
		for(int i = 0 ; i < list.length ; i++){
			System.out.println(list[i]);
		}
	}
	

}











