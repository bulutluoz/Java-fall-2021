package day01_02_Variables;

public class C01_Variables {


	public static void main(String[] args) {
		
		// variable olusturmak ve deger atamak farkli islemlerdir
		// istersek variable olusturma ve deger atamayi tek satirda yapabiliriz
		
		String ogrenciIsim = "Celal";
		
		System.out.println(ogrenciIsim); // Celal
		
		// istersek de once olusturur, istedigimiz zaman da deger atayabiliriz
		int sayi;
		sayi=10;
		
		System.out.println(sayi); // 10
		
		// biz daha once olusturulmus ve deger atamasi yapilmis bir degiskene
		// yeni deger atayabiliriz
		// bu durumda java variable'in eski degerini silip yeni degeri variable'a atar
		sayi=25;
		System.out.println(sayi); // 25
		
		ogrenciIsim="Mustafa";
		
		System.out.println(ogrenciIsim); // Mustafa
	}

}
