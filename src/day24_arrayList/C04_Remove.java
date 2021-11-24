package day24_arrayList;

import java.util.ArrayList;
import java.util.List;

public class C04_Remove {

	public static void main(String[] args) {
		List<String> harfler= new ArrayList<>();
		
		harfler.add("A");
		harfler.add("Z");
		harfler.add("F");
		harfler.add("D");
		
		System.out.println(harfler); // [A, Z, F, D]
		
		harfler.remove(1); // bu satir gidip 1 index'indeki elemani remove eder
							// ve (delil olarak) remove ettigi elemani bize getirir
		
		
		// listenin kalanini gormek isterseniz listeyi yazdirabilirsiniz
		System.out.println(harfler); // [A, F, D]
		
		System.out.println(harfler.remove(2)); // D
		
		System.out.println(harfler); // A F
		
		
		System.out.println(harfler.remove("F")); // gidip F yi remove eder ve true dondurur
		
		System.out.println(harfler.remove("B")); // listede B olmadigi icin remove yapamaz
												 // gorevi yapamadigi icin false doner
		
		System.out.println(harfler); // [A]
		harfler.add("A");
		harfler.add("Z");
		harfler.add("F");
		System.out.println(harfler); // [A, A, Z, F]
		
		System.out.println(harfler.remove("A")); // true
		
		System.out.println(harfler); // [A, Z, F]
		harfler.add("A");
		
		System.out.println(harfler); // [A, Z, F, A]
		
		harfler.removeAll(harfler); // verilen bir listeyi siler
		
		System.out.println(harfler);
		
		
		
		
		harfler.add("A");
		harfler.add("Z");
		harfler.add("F");
		harfler.add("D");
		
		List<String> silinecekHarfler= new ArrayList<>();
		silinecekHarfler.add("A");
		silinecekHarfler.add("C");
		silinecekHarfler.add("F");
		
		System.out.println(harfler); // [A, Z, F, D]
		System.out.println(silinecekHarfler); // [A, C, F]
		
		System.out.println(harfler.removeAll(silinecekHarfler)); // true
		System.out.println(harfler); // [Z, D]
		System.out.println(silinecekHarfler); // [A, C, F]
		
		// eger listemiz integer'lardan olusuyorsa
		// Java remove(index) ve remove(Object) method'lari karismasin diye
		// girilen sayiyi index olarak kabul eder.
		

	}

}
