package day15_methodCreation;

import java.util.Scanner;

public class H01_MethodCreation {

	public static void main(String[] args) {
		/*
		 Soru 1 ) Kullanicidan bir sayi alin. 
		 Bu sayinin tek mi cift mi oldugunu, 
		 sifirdan buyuk mu kucuk mu oldugunu, 
		 ayrica ve 100’den buyukse birler,onlar ve yuzler basamagindaki rakamlarin toplamini,
		 	100’den kucukse sadece 1’ler basamagini yazdiran 3 method olusturun.

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("lutfen bir sayi giriniz");
		double sayi=scan.nextDouble();
		
		// method'lar olustu istendigi zaman cagrilabilir
		// ornek olarak
		
		pozitifMiNegatifMi(sayi);
		

		scan.close();
	}

	public static void rakamlarToplami(double sayi) {
		if (sayi>100) {
			int rakam=0;
			int rakamlarToplami=0;
			rakam=(int) (sayi%10);
			rakamlarToplami+=rakam;
			sayi/=10;
			rakam=(int) (sayi%10);
			rakamlarToplami+=rakam;
			sayi/=10;
			rakam=(int) (sayi%10);
			rakamlarToplami+=rakam;
			System.out.println("rakamlar toplami : " + rakamlarToplami);
			
		} else if(sayi>0) {

			int birlerBasamagi= (int) (sayi%10);
			System.out.println("Sayinin birler basamagi : " + birlerBasamagi);
		}else {
			System.out.println("gecersiz sayi");
		}
		
	}

	public static void pozitifMiNegatifMi(double sayi) {
		if (sayi<0) {
			System.out.println("sayi negatif");
		}else if (sayi>0) {
			System.out.println("sayi pozitif");
		}else {
			System.out.println("sayi pozitif veya negatif degil");
		}
		
	}

	public static void tekMiCiftMi(double sayi) {
		if (sayi%2==0) {
			System.out.println("sayi cift");
		}else if (sayi%2==1 || sayi%2==(-1)) {
			System.out.println("sayi tek");
		}else {
			System.out.println("sayi tam sayi degil");
		}
		
	}

}
