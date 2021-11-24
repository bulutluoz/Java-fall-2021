package day25_arrayList;

import java.util.Arrays;
import java.util.List;

public class C04_ArraysAsList {

	public static void main(String[] args) {
		// verilen array'i Arrays class'indan yardim alarak 
		// liste'e cevirebiliriz
		
		String arr[]= {"A","b","C","d"};
		
		List<String> arraydenList= Arrays.asList(arr);
		
		System.out.println("List : " + arraydenList);
		
		// arraydenList.add("F"); 	// RTE : UnsupportedOperationException : Desteklenmeyen islem
								// CTE olmasi icin sytax'te problem olmasi lazim, ancak bu yazimda 
								// syntax hatasi yok
		
		// bu sekilde Arrays class'indan yardim alarak array'i list'e cevirirsek
		// olusturdugumuz list'in boyutu sabit olur
		// dolayisiyla add() veya clear() gibi method'lari calistirmak istersek 
		// UnsupportedOperationException : Desteklenmeyen islem verir 
		
		
		arr[1] ="Z";
		System.out.println("Array'i degistirdikten sonra, array = " + Arrays.toString(arr));
		System.out.println("Array'i degistirdikten sonra, list = " + arraydenList);
		
		
		arraydenList.set(3, "D");
		System.out.println("List'i degistirdikten sonra, list = " + arraydenList);
		System.out.println("list'i degistirdikten sonra, array = " + Arrays.toString(arr));
		
		
		
		
		
		

	}

}
