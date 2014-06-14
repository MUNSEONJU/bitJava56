package java01;

public class act{
	public static void main(String[] args){
		human seonju = new human();
		human suyeong = new human();
		
		seonju.age = 26;
		suyeong.age = 27;
		seonju.length = 180;
		suyeong.length = 150;
		seonju.weight= 60;
		suyeong.weight = 30;
		
		seonju.walk();
		System.out.println(seonju.weight);
		int a = 4;
		boolean bool;
		bool = a<0;
		System.out.println(bool);
		
	}
}

class human {
	int age;
	int length;
	int weight;
	String result;
	
	void walk(){
		weight = weight - 1;
	}
	
	String rice_eat(){
		length = length + 1;
		return "ddong";
	}
	
	String jae(){
		return "chim";
	
	}
	

}
