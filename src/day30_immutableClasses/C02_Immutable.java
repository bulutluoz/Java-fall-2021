package day30_immutableClasses;

public class C02_Immutable {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String str= "Ali";
		
		for (int i = 0; i < 100; i++) {
			
			str+=" ";
		}
		
		
		// bu kod calistiginda java kac obje olusturur ?
		
		
		// bir obje basta olusturuldu
		// loop'da ise 100 obje daha olusturuldu
		// Dolayisiyla bu kod calistiginda biz ekranda hic bir sey gormeyiz ama 
		// Java 101 obje olusturmus olur
		// str'in son degeri ise "Ali           (100 tane bosluk)     "
	}

}
