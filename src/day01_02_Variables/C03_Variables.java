package day01_02_Variables;

public class C03_Variables {

	public static void main(String[] args) {
		int sayi1= 10;
		int sayi2= 20;
		
		String sayi3="10";
		String sayi4="20";
		
		
		System.out.println(sayi1+sayi2); // 30
		System.out.println(sayi3+sayi4); // 1020
		
		// Farkli data turleri ayni degeri alabilir
		// burada onemli olan bu degiskenleri degisken turune gore islem yapabilecegimdir.
		String harf1="A";
		char harf2='A';
		

		// yukaridaki degiskenleri kullanarak 30A yazdirin
		
		System.out.println(sayi1+sayi2+harf1); // 30A
		System.out.println(sayi1+sayi2+harf2); // 95
		
		// char ekstra ozelligi sebebiyle matematiksel islemlerde numerik deger alir
		
		System.out.println(harf1+sayi1+sayi2); // A1020
		System.out.println(sayi1+harf1+sayi2); // 10A20
		System.out.println(harf1+(sayi1+sayi2)); // A30
		

		
	}

}
