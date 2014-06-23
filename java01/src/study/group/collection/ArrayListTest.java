package study.group.collection;

import java.util.ArrayList;

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class ArrayListTest {

	public static void main(String[] args) {

		/*
		 * ArrayList<String> list = new ArrayList<>(); list.add("문선주");
		 * list.add("강민수"); list.add("하수영"); list.add("조성욱"); list.add(2, "바뀜");
		 * list.add("윤재윤"); list.add("박주은"); for(int i=0;i<list.size();i++){
		 * System.out.println(list.get(i));
		 */
		// ArrayList list = new ArrayList();
		// list = new Score();

		Person p1 = new Person("문선주", 26);
		Person p2 = new Person("강민수", 21);
		Person p3 = new Person("조성욱", 25);

		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		//list.removeAll(list);
		//System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals("강민수")) { // refactoring ( == 비교연산자 -> equals(문자열))
				System.out.println(list.get(i).name + " : " + list.get(i).age);
				break;
			}
		}
		 
	}
}
