package day21_scope_arrays;

public class C01_LocalVariables {
	
	String okulIsmi;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Java local variable'lara default deger atamasi yapmaz
		// Kodlarimizda sorun yasamamak icin 
		// olusturdugumuz local variable'lara uygun bir deger atamamizda fayda var
		
		int sayi=0; // int sayi; dersek java CTE veriyor
		System.out.println(sayi);
		
		
		// int sayi; // bir local'de ayni isimde birden fazla variable OLUSTURULAMAZ
		// String sayi; // data turu farkli olsa da Java buna izin vermez
		
		String isim="Ali";
		
	}
	
	public static void staticMethod() {
		//sayi; 	// bir local'de olusturulan variable (method'larin static olup olmamasina
				// bagli olmaksizin)farkli local'de kullanilamaz
		@SuppressWarnings("unused")
		String isim="Veli";
		
	}
	
	

}
