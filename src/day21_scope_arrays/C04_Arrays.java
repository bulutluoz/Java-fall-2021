package day21_scope_arrays;

import java.util.Arrays;

public class C04_Arrays {

	public static void main(String[] args) {
		// Array'in elemanlarini yazdirmak istersek loop ile yazdirabiliriz
		int arr[] = {2,4,5,6,78,89};
		
		// tum elementleri yazdirabiliriz
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("");
		
		// Ya da Arrays Class'indan yardim alip  direk array olarak yazdirabiliriz
		System.out.println(Arrays.toString(arr));

	}

}
