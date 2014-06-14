//캡슐화 :접근 제한
//	- 멤버(변수,메서드) -> private / (default) / protected / public
//		private 	: 해당 클래스 내부 에서만 접근 가능
//		default 	: 해당 클래스 + 같은 패키지의 클래스
//		protected : 해당 클래스 + 같은 패키지 클래스 + sub(자손)클래스
//		public		: 공개
//	- 클래스 -> (default) / public
//		default		: 같은 패키지의 클래스만 접근 가능
//		public		: 공개(모든클래스)

// 패키지 아래 있는 패키지는 하위 패키지 이니까 접근 가능하지 않느냐???
//	-> java 패키지 디렉토리는 그런거없다. 해당 패키지에 있는거만
package exam.oop2.step08.sub;

//같은 패키지만 접근 가능
class A {

}
