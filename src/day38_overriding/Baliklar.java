package day38_overriding;

public class Baliklar extends Animals{

	public static void main(String[] args) {
		
		Baliklar balik1= new Baliklar();
		balik1.beslenme(); // Tum hayvanlar beslenir
		balik1.hareket(); //Baliklar yuzerek hareket eder
		balik1.solunum(); // Baliklar solungaclariyla nefes alir

	}
	@Override
	// Child class'daki bir method parent class'dan bir method'u override ediyorsa
	// bunu istersek @Override notasyonu ile deklare edebiliriz
	// Deklare etmesek de kodlarimiz calisir
	// Ancak deklare ettigimizde Java overriden method'u surekli kontrol eder
	// ve o method'da overriding'e uymayan bir degisiklik olursa CTE verir
	public void hareket() {
		System.out.println("Baliklar yuzerek hareket eder");
	}
	
	
	public void solunum() {
		System.out.println("Baliklar solungaclariyla nefes alir");
	}
	



}
