package day21_scope_arrays;

public class C03_Arrays {

	public static void main(String[] args) {
		// Soru 1: 	Elemanlari “Ali” , “Veli”, “Ayse” ve “Fatma” olan bir array olusturun ve bu 	array’i yazdirin. 

		
		String arr[]=new String[4];
		arr[0] = "Ali";
		arr[1] = "Veli";
		arr[2] = "Ayse";
		arr[3] = "Fatma";
		
		String arr2[]= {"Ali", "Veli", "Ayse", "Fatma"};
				
		// Soru 2: Soru 1’deki elemanlardan “Ali” yerine “Can”, “Ayse” yerine “Gul” atayin
		
		arr2[0]="Can";
		arr2[2]="Gul";
		
		
		System.out.println(arr2[1]);
		
		// son elementi yazdirin
		System.out.println(arr[arr.length-1]); // String'deki length() idi, burada sadece length
		
		
		// System.out.println(arr[arr.length]); // ArrayIndexOutOfBoundsException
											    // yazdigin index sinirlarin disinda 
		
		

	}

}
