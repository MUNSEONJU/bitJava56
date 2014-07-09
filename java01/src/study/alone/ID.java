package study.alone;

public class ID {
		
	public static void main(String[] args) {

		String[] first = { "MUN", "MOON" };
		String[] middle = { "SEON", "SUN" };
		String[] last = { "JU", "JOO", "JOOO", "ZOO", "ZOOO", "ZU" };
		
		for( int i = 0 ; i < first.length ; i++	){
			
			for( int j = 0 ; j < middle.length ; j++ ){
				
				for( int k = 0 ; k < last.length ; k++){
					
					System.out.println(first[i] + middle[j] + last[k]);
					System.out.println(middle[j] + last[k] + first[i] );
					
					
				}
				
			}
			
		}
		
	}

}
