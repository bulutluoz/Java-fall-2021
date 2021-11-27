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
	
	// ben 5 ozelligi birden degistiren bir constructor urettiugimde
	// java default constructor'i siler
	// bu durumda daha onceden yazilan ve default constructor'i kullanan tum kodlar coker
	// bu durumda kodlari duzeltmek icin Javanin sildigi default constructor yerine
	// parametresiz bir constructor olusturmaliyim
	
	public Car1(){
		
	}
	// parametresiz constructor uretmenin syntax'i clasAdi+() + {}


	public Car1(int i) {
		km=i;
	}

	public Car1(int i, int j) {
		//      yil      km
		yil=i;
		km=j;
	}

	public void hiz(int hiz) {
		System.out.println("araba saatte " + hiz + " km yapar");
	}
	
	public void yakit(String yakit) {
		System.out.println("Araba yakit olarak " + yakit + " kullanir");
	}

}
