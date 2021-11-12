package day15_methodCreation;

import java.util.Scanner;

public class H04_MethodCreation {

	public static void main(String[] args) {
		/*
		 Soru 4) Kullanicidan ismini, soyismini 
		 ve bosluk birakmadan 16 hane olarak kredi karti numarasini alin. 
		 Isim ve soyismi ilk harfleri buyuk diger harfler kucuk olacak sekilde, 
		 KK numarasini ise 4 rakamlik 4 blok ve aralarinda bosluk olacak sekilde duzelten 2 method yazin,
		 ve programda kullanabilmek icin duzenlenmis hallerini geri dondurun.

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("lutfen isminizi giriniz");
		String isim=scan.next();
		System.out.println("lutfen soyisminizi giriniz");
		String soyisim=scan.next();
		System.out.println("lutfen bosluk brakmadan 16 haneli kredi karti numaranizi giriniz");
		String kkNo=scan.next();
		
		String duzenlenmisIsim=isimDuzenle(isim,soyisim);
		String duzenlenmisKkNo=kkNoDuzenle(kkNo);
		
		System.out.println(duzenlenmisIsim + "\n"+duzenlenmisKkNo);
		
		scan.close();

	}

	private static String kkNoDuzenle(String kkNo) {
		String kkDuzenlenmis= kkNo.substring(0,4)+" " +kkNo.substring(4,8)
							+" " +kkNo.substring(8,12)+" " +kkNo.substring(12);
		return kkDuzenlenmis;
	}

	private static String isimDuzenle(String isim, String soyisim) {
		
		isim=isim.substring(0,1).toUpperCase()+isim.substring(1).toLowerCase();
		soyisim=soyisim.substring(0,1).toUpperCase()+soyisim.substring(1).toLowerCase();
		return isim+" "+soyisim;
	}

}
