package exam.oop3.step04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 *  Map의 도우미 Iterator
 *  	- Iterator는 Map의 데이터를 꺼내 주는 역할을 한다.
 *  	- 일관성 있게 꺼내주기 때문에 프로그램이 일관성을 띠게됨
 *  	- Collection의 종류(List,Set,Map)에 상관 없이 일관된 방식으로 데이터 조회
 *  	- hasNext(), next()
 */
public class CollectionTest03 {

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
		Iterator iterator = map.entrySet().iterator();
		/*
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		*/
		Entry entry;
		while (iterator.hasNext()) {
			entry  = (Entry)iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	public static void displayKeyFromMap(HashMap map){
		System.out.println("----------------------------");
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String key = (String)iterator.next(); // next() 할때마다 값넘어가니까 저장할려고..
			System.out.println( key + " : " + map.get( key ) );
		}
	}
	
	public static void displayValueFromMap(HashMap map){
		System.out.println("----------------------------");
		Iterator iterator = map.values().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	

}











