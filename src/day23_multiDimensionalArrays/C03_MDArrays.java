package day23_multiDimensionalArrays;

public class C03_MDArrays {

	public static void main(String[] args) {
		// Soru 1 ) Asagidaki multi dimensional array’in 
		// tum elemanlarinin carpimini ekrana yazdiran bir method yaziniz. 
		// { {1,2,3}, {4,5,6} }
		
		int arr[][]={ {1,2}, {4,5}, {3,4,5},{0,3,4,5,6} };
		
		carpimYazdir(arr);
		
		
		

	}

	public static void carpimYazdir(int[][] arr) {
		int carpim=1;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				carpim*=arr[i][j];			
			}	
		}
		System.out.println(carpim);
		
	}

}
