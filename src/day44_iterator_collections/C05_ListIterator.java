package day44_iterator_collections;

import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;


public class C05_ListIterator {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		


		List<String > liste = new ArrayList<>();
		
		liste.add("Ali");
		liste.add("Veli");
		liste.add("Ayse");
		liste.add("Fatma");
		liste.add("Emrah");
		
		System.out.println(liste); // [Ali, Veli, Ayse, Fatma, Emrah]
		
		ListIterator li1= liste.listIterator();
		String temp="";
		
		while (li1.hasNext()) {
			
			temp=(String) li1.next();
			li1.set(temp + "X");
			
			// li1.set(li1.next()+"X");
			
		}
		
		System.out.println(liste);

	}

}
