package day03_scanner;

public class C02_SwapVariables {

	public static void main(String[] args) {
		/*
		 * 1- Verilen sayi1 ve sayi2 variable’larinin degerlerini degistiren (SWAP) bir program yaziniz
			Orn : sayi1=10 ve sayi2=20;
		  	kod calistiktan sonra
		 	sayi1=20 ve sayi2=10

		 */
		
		
		int sayi1=10;
		int sayi2=20;
		
		// baslangicta sayi1=10 ve sayi2=20
		
		
		System.out.println("baslangicta sayi1=" + sayi1 + " ve sayi2=" + sayi2);
		
		// ilk once bos bir variable olusturalim
		
		int bos;
		
		// sayi2 yi bos variable'a atayalim
		bos=sayi2;
		
		// sayi2 variable'ina sayi1 degerini atayalim
		sayi2=sayi1;
		
		// bos variable'daki degeri sayi 1'e atayalim
		sayi1=bos;
		
		System.out.println("sonucta sayi1=" + sayi1 + " ve sayi2=" + sayi2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
