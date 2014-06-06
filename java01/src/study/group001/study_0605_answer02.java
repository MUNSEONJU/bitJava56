/*
0. int형 배열을 선언/정의하고 각 인덱스에 임의로 입력을 받아,
입력된 값중 가장 큰 값을 찾아 출력하는 프로그램을 작성하시오.

1.
이차원 배열 안에
5   5  5  5  5
10 10 10 10 10
20 20 20 20 20
30 30 30 30 30
값을 넣고
이 배열의 총 합과 평균을 구하시오.

2. 다음 정수형 배열에 들어가 있는 수를 정순으로 정렬하여
출력하는 소스를 구현하시오.
int arr[] = {77, 24, 32};
*/

package study.group001;

import java.util.Scanner;

public class study_0605_answer02 {
	
	public static void main(String[] args){
		int arr[] = {77,24,32,52,90};
		int temp;
		for(int j=0;j<arr.length-1;j++){
			for(int i=0;i<arr.length-1;i++){
				if(arr[i]>arr[i+1]){
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main02(String[] args){
		int arr[][] = new int[][]{{5,5,5,5,5},{10,10,10,10,10},{20,20,20,20,20},{30,30,30,30,30}};
		int sum=0, count=0;
		float avg;
		
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				sum += arr[j][i];
				count++;
			}
		}
		avg = (float)sum/count;
		System.out.println("합 : " + sum + ", 평균 : " + avg);
		
		
		
	}
	

	public static void main001(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		Scanner scan = new Scanner(System.in);
		/*
		int temp;
		int max = ?;
		for(int i=0;i<arr.length;i++){
			temp = Integer.parseInt(scan.nextLine());
			if(temp>max){
				max = temp;
			}
		*/
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(scan.nextLine());
		}
		
		int max = arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		
		System.out.println("최대값은 " + max + "입니다");
		
		
		
	}

}
