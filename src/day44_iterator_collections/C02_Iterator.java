package day44_iterator_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C02_Iterator {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
List <Integer> liste = new ArrayList<>();
		
		liste.add(5);
		liste.add(3);
		liste.add(7);
		liste.add(1);
		liste.add(9);
		liste.add(8);
		liste.add(2);
		
		System.out.println(liste); // [5,    3,    7,    1,    9,    8,   2]
		
		Iterator ite1=liste.iterator();
		
		
		for (int i = 0; i < liste.size(); i++) {
			
			System.out.println(ite1.hasNext() + " ==== " + ite1.next());
		}
		
		
		System.out.println(ite1.hasNext()); // false
		System.out.println(ite1.next()); // java.util.NoSuchElementException
		
		
		
		
		
		
		
		
		
		
	}

}
