package exam.oop3.step04;

import java.util.Stack;
/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Stack 
 * - 데이터 목록 다루는 것.
 * - 먼저 들어간 데이터가 나중에 나온다. (First In Last Out)
 * - push() / pop()
 */
public class CollectionTest06 {

	public static void main(String[] args) {
		
		/** push() : 순서대로 값 넣음 **/
		Stack<String> stack = new Stack<>();
		stack.push("111");
		stack.push("222");
		stack.push("333");
		stack.push("444");
		/*
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop()); // EmptyStackException
		*/
		System.out.println("----------------------------");
		
		for( String value : stack ){
			System.out.println(value);
		}
		
		System.out.println("----------------------------");
		/**	peek() : stack에서 맨 위의 값을 꺼낸다. ( 삭제 X )**/ 
		for( int i = 0 ; i < stack.size() ; i++){
			System.out.println(stack.peek());
		}
		
		System.out.println("----------------------------");
		/**	pop() : stack에서 맨 위의 값을 꺼낸다. ( 삭제 O )**/
		while( !stack.empty()){
			System.out.println(stack.pop()); // pop() : 값을 꺼낸다. ( remove()를 포함 )
		}
		
		System.out.println("----------------------------");
		/**	pop()으로 다 제거 되어서 .. **/
		while( !stack.empty()){
			System.out.println(stack.pop());
		}
	}
	
}











