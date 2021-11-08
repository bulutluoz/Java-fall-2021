package day14_methodCreation;

public class C01_MethodCreation {

	public static void main(String[] args) {
		// verilen iki sayinin toplamini ve carpimini yapip yazdiran iki ayri method olusturun
		
		// method olusturmak icin 4 adim takip edelim
		// 1. adim method call yazalim
		// 2. adim method'a arguman yazacak miyiz karar vermeliyiz
		int sayi1=44;
		int sayi2=55;
		
		carpma(sayi1,sayi2);
		toplama(sayi1, sayi2); // method call
		// 3. adim 1. ve 2. adimi yaptiktan sonra java'dan yardim alip method'u olustururuz
		
		carpma(sayi1,sayi2);
		
		

	}
	
	
	
	
	
	

	public static void carpma(int sayi1, int sayi2) {
		System.out.println("sayilarin carpimi : " + sayi1*sayi2);
		
	}


	public static void toplama(int sayi1, int sayi2) {
		// 4.adim erisim duzenleyici ve return type'a karar vermeliyiz
		//  erisim duzenleyici axcess modifier : public yaptik
		//  return type : bizden sadece yazdirma istedigi icin void kalabilir
		
		System.out.println("sayilarin toplami : " + (sayi1 +sayi2));
		
	}


}
