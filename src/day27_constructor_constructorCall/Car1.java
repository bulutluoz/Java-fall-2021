package day27_constructor_constructorCall;

public class Car1 {
	
	int yil=2000;
	String renk;
	String model;
	int km;
	boolean satilikMi;
	
	public Car1(int km, String model, String renk, int yil, boolean satilikMi) {
		// atama yapacagimiz tum ozellikleri parametre olarak yolladik
	}
	


	public Car1() {
		
	}



	public Car1(int i) { // bu satirdaki int km ile class level'daki int km farkli scope'lardadir
		km=i;
	}



	public void hiz(int hiz) {
		System.out.println("araba saatte " + hiz + " km yapar");
	}
	
	public void yakit(String yakit) {
		System.out.println("Araba yakit olarak " + yakit + " kullanir");
	}

}
