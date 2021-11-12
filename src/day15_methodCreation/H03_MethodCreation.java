package day15_methodCreation;

import java.util.Scanner;

public class H03_MethodCreation {

	public static void main(String[] args) {
		/*
		 Soru 3) Email kontrolu yapan bir program yazin.Kullanicinin girdigi sifre  
			- @ isareti icermiyorsa gecersiz email yazdirin
			- @gmail.com icermiyorsa “lutfen gmail adresinizi girin” yazdirin
			- @gmail.com ile bitmiyorsa “Yazimda bir sorun var, maili kontrol ediniz”

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("lutfen email adresinizi giriniz");
		String sifre=scan.next();
		
		sifreKontrol(sifre);
		scan.close();

	}

	private static void sifreKontrol(String sifre) {
		if (!sifre.contains("@")) {
			System.out.println("gecersiz email ");
		} else if(!sifre.contains("@gmail.com")){

			System.out.println("lutfen gmail adresinizi girin");
		}else if (!sifre.endsWith("@gmail.com")){
			System.out.println("Yazimda bir sorun var, maili kontrol ediniz");
		}
		
	}

}
