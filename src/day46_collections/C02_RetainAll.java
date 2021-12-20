package day46_collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class C02_RetainAll {

	public static void main(String[] args) {
		
		Set<String> lhs1= new LinkedHashSet<>();
		
		lhs1.add("Ali");
		lhs1.add("Mehmet Ali");
		lhs1.add("Hasan");
		lhs1.add("Kutlu");
		
		Set<String> lhs2= new LinkedHashSet<>();
		lhs2.add("Ali");
		lhs2.add("Mehmet Ali");
		lhs2.add("Filiz");
		
		/*
		System.out.println(lhs1.retainAll(lhs2)); //true
		
		System.out.println(lhs1); // [Ali, Mehmet Ali]
		System.out.println(lhs2); // [Ali, Mehmet Ali, Filiz]
		
		*/
		
		System.out.println(lhs2.retainAll(lhs1)); // true
		System.out.println(lhs1); // [Ali, Mehmet Ali, Hasan, Kutlu]
		
		System.out.println(lhs2); // [Ali, Mehmet Ali]

		
		
		
		
		

	}

}
