package day43_Interface;

public class C03_Concrete implements C02_Interface{

	public static void main(String[] args) {
		
		C03_Concrete concreteObje= new C03_Concrete();
		
		
		
		// Interface'de default keyword kullanarak olusturdugumuz body'si olan method'lara
		// child concrete class'lardan obje vasitasiyla ulasabilirim
		concreteObje.kaporta();
		
		
		// Interface'de static keyword kullanarak olusturdugumuz body'si olan method'lara
		// child concrete class'lardan interface ismi vasitasiyla ulasabilirim
		C02_Interface.sanzuman();

	}

	
	// Bir interface'de static veya default keyword kullanarak body'si olan bir method olusturursak
	// Bu interface'e implements eden concrte child class'lar bu method'lari
	// implement etmek ZORUNDA DEGILDIR
	@Override
	public void motor() {
		
		
	}

}
