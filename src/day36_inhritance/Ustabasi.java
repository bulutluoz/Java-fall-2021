package day36_inhritance;

import day35_encapsulation_inheritance.Isci;

public class Ustabasi extends Isci{
	
	Ustabasi(){
		System.out.println("Ustabasi parametresiz constructor calisti");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Ustabasi ust1=new Ustabasi();
		
		// Java da her class olusturuldugunda otomatik olarak
		// default constructor olustugu GIBI
		// Child class'da olusturulan her bir constructor'in
		// ilk satirinda gizli super() olusturur
		

	}

}
