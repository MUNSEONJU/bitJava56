package exam.oop3.step04;

import java.util.PriorityQueue;
/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Queue
 * - 데이터 목록 다루는 것.
 * - 먼저 들어간 데이터가 먼저 나온다. (First In First Out)
 * - add() / poll()
 */
public class CollectionTest07 {

	public static void main(String[] args) {
		
		/** add() : 순서대로 값 넣음 **/
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.add("111");
		queue.add("222");
		queue.add("333");
		queue.add("444");
		
		System.out.println("----------------------------");
		for( String value : queue){
			System.out.println(value);
		}
		
		System.out.println("----------------------------");
		/**	poll() : 맨처음 추가한 값을 꺼낸다 ( 삭제 o ) **/
		while( !queue.isEmpty()){
			System.out.println(queue.poll());
		}
	}
	
}











