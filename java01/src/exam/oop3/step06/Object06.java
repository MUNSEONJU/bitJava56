package exam.oop3.step06;

import java.util.HashMap;

/** hashCode()의 용도 **/ 

public class Object06 {

	static class Key{
		
		String 	id;
		int			pwd;
		
		// 자동 오버라이딩
		@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    result = prime * result + pwd;
	    return result;
    }
		@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    Key other = (Key) obj;
	    if (id == null) {
		    if (other.id != null)
			    return false;
	    } else if (!id.equals(other.id))
		    return false;
	    if (pwd != other.pwd)
		    return false;
	    return true;
    }
		
		
		/*
		@Override
		public boolean equals(Object obj) {
			if( obj.getClass() != this.getClass() ) return false;
					
			Key other = (Key)obj;
			
			if(!this.id.equals(other.id)) return false;
			if(this.pwd != other.pwd) return false;
			return true;
		}
		
		//id와 pwd가 같으면 리턴되는 hashCode값이 같도록 overriding
		@Override
		public int hashCode() {
			String temp = id + pwd;
			return temp.hashCode();
		}
		*/
		
		
	}
	
	public static void main(String[] args) {
		// 냉장고 잠그는 키 k1, 키복사 k2
		Key k1 	= new Key();
		k1.id 	= "okokmama";
		k1.pwd 	= 1233;
		
		Key k2 	= new Key();
		k2.id 	= "okokmama";
		k2.pwd 	= 1233;
		
		// Map
		//	- 키로 사용되는 객체는 equals()이 리턴값이 true, hashCode()의 리턴값이 같을 때 같은키로 간주한다
		//	- Map에서 키로 사용되는 클래스는 반드시 equals()와 hashCode()를 재정의해야한다.
		HashMap<Key, String> 냉장고 = new HashMap<>();
		냉장고.put(k1, "개소주");
		System.out.println( 냉장고.get(k1) );
		System.out.println( 냉장고.get(k2) ); // 해시코드가 다르다면 null -> 재정의안하면 null
		
	}

}
