package day07_IfStatements;

import java.util.Scanner;

public class C01_BasitIfCumleleri {

	public static void main(String[] args) {
		/*
		 * Soru 2) Kullanicidan gun isimlerinden birinin ilk harfini isteyin 
		 * ve o harfle baslayan gun isimlerini yazdirin 
			Ornek: 	ilkHarf=P output = “Pazar, Pazartesi veya Persembe”				
			ilkHarf=S output = “Sali”
		 *** Buyuk kucuk harf problem olmamasi icin toUpperCase methodunu kullanin

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Lutfen gun isimlerinden birinin ilk harfini yaziniz");
		// Kullanicinin girdigi verinin tamamini kucuk harf veya buyuk harf yapabiliriz
		// scan.next() ten sonra toUpperCase yazarsak kelimeyi buyuk harfe
		// toLowercase yazarsak kelimenin tan=mamini kucuk harfe cevirmis oluruz
		
		char ilkHarf=scan.next().toUpperCase().charAt(0);
		
		
		if (ilkHarf=='P') {
			System.out.println("Pazar, Pazartesi veya Persembe");
		}
		if (ilkHarf=='S') {
			System.out.println("Sali");
		}
		if (ilkHarf=='C') {
			System.out.println("Carsamba, Cuma veya Cumartesi");
		}
		
		if (ilkHarf!='C' && ilkHarf!='P' && ilkHarf!='S') {
			System.out.println("Gecersiz harf girdiniz .Lutfen gun isimlerinden birinin basharfini yazin");
		}
		
		
		scan.close();
	}

}
