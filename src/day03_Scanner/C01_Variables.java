package day03_scanner;

public class C01_Variables {

	public static void main(String[] args) {

		/*
		 * 1- Farkli 3 data turunde variable olusturun ve bunlari yazdirin 
		 * 2- isim ve soyisim icin iki variable olusturun ve bunlari 	
		 * 		isminiz : Mehmet 
		 * 		soyisminiz : Bulutluoz seklinde yazdirin 
		 * 3- Iki farkli tamsayi data turunde 2 variable
		 * olusturun bunlarin toplamini yazdirin 
		 * 4- Bir tamsayi ve bir ondalikli
		 * variable olusturun ve bunlarin toplamini yazdirin 
		 * 5 – char data turunde bir variable olusturun ve yazdirin 
		 * 6- Bir tamsayi, bir de char degisken olusturun
		 * ve bunlarin toplamini yazdirin.
		 * 
		 */
		
		String ismim= "Mehmet Bulutluoz";
		
		System.out.println(ismim);
		
		@SuppressWarnings("unused")
		char ilkHarf='S';
		
		@SuppressWarnings("unused")
		boolean anlasildiMi = true;
		
		String  isminiz = "Ali" ;
		String soyisminiz = "Tuskan";
		
		// isminiz : Mehmet 
		
		System.out.println("isminiz : "+isminiz);
		// soyisminiz : Bulutluoz
		
		System.out.println("soyisminiz : " + soyisminiz);
		
		// Iki farkli tamsayi data turunde 2 variable olusturun bunlarin toplamini yazdirin 
		int a=10;
		short b=20;
		
		System.out.println(a+b); //30
		
		// Bir tamsayi, bir de char degisken olusturun  ve bunlarin toplamini yazdirin.
		int sayi=25;
		char karakter='a';
		
		// char degiskenler matemetiksel isleme sokulursa char degiskenin barindirdigi karakterin 
		// ascii degeri isleme girer
		System.out.println(sayi + karakter); // 122
		
		
	}

}
