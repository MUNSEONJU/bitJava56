package exam.basic;

public class work0604 {

	public static void main(String[] args){
		
		//1//
		/*
		int a=10;
		int b=1;
		int c=0;
		int sum=0;
		while(a>sum){
		  c = a % b;
		  sum += b;
		  b++;
		}
		System.out.println(b+","+sum);
		 */
		
		//2//
		/*
		int i;
		int a=0;
		for(i=1;i<=5;i++){
			a++;
		}
		System.out.println(a);
		*/
		
		//3//
		/*
		int a=0;
		
		switch(a){
			case 1:
				System.out.print("a");
			case 2:
				System.out.print("b");
			case 3:
				System.out.print("c");
				break;
			default:
				System.out.print("!");
		}
		*/
		
		//4//
		/*
		int[] a[] = null;
		System.out.println(a);
		*/
		
		//5//
		/*
		int a=10, b=2, sum;
		sum = a * b;
		if(sum==5){
			System.out.println('A');
		} else if(sum==8){
			System.out.println('B');
		} else if(sum==12){
			System.out.println('C');
		} else if(sum==20){
			System.out.println('D');
		} else
			System.out.println('X');
		*/
		
		//6//
		/*
		int[] a = null;
	  a = new int[5];
	  a[1] = 2;
	  a[2] = 3;
	  a[3] = 4;
	  System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]);
	  */
		
		//7//
		/*
		int a=1;
		int b=0;
		for(int c=0;c<5;c++){
			b += a;
			a++;
		}
		System.out.println(a+b);
	 	*/
		
		//8//
		/*
		int a, sum=0;
		while(true){
			if(a != 10){
				a++;
				sum +=a;
			} else break;
		}
		System.out.println(sum);
		*/
		
		//9//
		/*
		int a=1;
		int sum=0;
		while(true){
			if(a != 10){
				sum=0;
				a++;
			} else break;
		}
		System.out.println(sum);
		*/
		
		//10//
		
		
		//11//
		/*
		int a=1;
		int sum=0;
		while(a<5){
			sum += a++;
		}
		System.out.println(sum);
		//*/
	  
	  //12//
	  /*
		for(int i=0;i<=3;i++){
			for(int j=0;j<=i;j++){
				if(j<=i){
					System.out.print('%');
				}
			}
			System.out.println();
		}
		*/
		
		//13//
		/*
		int[] a = null;
	  a = new int[5];
	  System.out.println(a[1]+a[2]);
	  */
		
		//14//
		/*
		int a = 0;
		while(a<5) {
			if(a%2 !=0){
				a++;
				continue;
			}
			System.out.println('a의 값은'  + a);
			a++;
		}
		*/
		
		//15//
		/*
		int a=0;
		if(a=0){
			System.out.println("0이네");
		} else 
			System.out.println("아니네");
		*/
		
		//16//
		/*
		int[] arr = null;
		int num = 0;
		arr = new int[5];
		
		for(int i=0;i<5;i++){
			num++;
			arr[i] = num;
			System.out.print(arr[i]);
			
			if(i<(arr.length)-1){
				System.out.print(",");
			} else break;
		}
		*/
		
		//17//
		/*
		int a=10, b=0;
		while(a>0){
			switch(a%2){
				case 0:
					b++;
					break;
				case 1:
					b+=2;
					break;
				default:
			}
			a--;
		}
		System.out.println(b);
		*/
		
		//18//
		/*
		int sum=0;
		for(int i=5; ;i++){
			sum += i;
			if(i>10) break;
		}
		System.out.println(sum);
		*/
		
		//19//
		/*
		for(int i=5;i>0;i--){
			switch(i){
				case 0:
					System.out.print("?");
				case 1:
					System.out.print("!");
					break;
				case 2:
					System.out.print("O");
				case 3:
					System.out.print("S");
					break;
				case 4:
					System.out.print("-");
				default:
					System.out.print("T");
			}
		}
		*/
		//20//
		int a = 0;
		flag:
			while(a<3) {
			a++;
			for(int i=0;i<a+5;i++){
				System.out.print("Ha");
				if(i==1) continue flag;
			}
		}
			
		
		
		
	}
}
