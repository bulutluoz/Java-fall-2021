package day15_methodCreation;

import java.util.Scanner;

public class C02_MethodCreation {

	public static void main(String[] args) {
		/*
		 Soru 2 ) Kullaniciya kac sayi toplamak istedigini sorun. 
		 Kullanici 2,3 veya 4 degerini girerse, 
		 kullanicidan bu sayilari girmesini isteyin 
		 ve sayilarin toplamini yazdirin. 
		 Kullanici toplamak istedigi sayi adedini 4’den buyuk girerse 
		 “Cok sayi girdiniz, ben toplayamam” yazdirin.

		 */
		

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Lutfen toplamak istediginiz sayi adedini 2,3 veya 4 den biri olarak secin");
		
		int tercih=scan.nextInt();
		if (tercih>4) {
			tercih=5;
		}
		
		switch(tercih) {
		
		case 2:
			ikiSayiTopla();
			break;
		case 3:
			ucsayiTopla();
			break;
		case 4:
			dortSayiTopla();
			break;
		case 5:
			System.out.println("Cok sayi girdiniz, ben toplayamam");
			break;
		default:
			System.out.println("gecersiz tercih");
		}
		
		scan.close();	}

	private static void dortSayiTopla() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen dort sayi girin \nHer sayidan sonra enter'a basin");
		double sayi1=scan.nextDouble();
		double sayi2=scan.nextDouble();
		double sayi3=scan.nextDouble();
		double sayi4=scan.nextDouble();
		
		System.out.println("Girdiginiz 4 sayinin toplami : " + (sayi1+sayi2+sayi3+sayi4));
		scan.close();
		
	}

	private static void ucsayiTopla() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen uc sayi girin \nHer sayidan sonra enter'a basin");
		double sayi1=scan.nextDouble();
		double sayi2=scan.nextDouble();
		double sayi3=scan.nextDouble();
		
		System.out.println("Girdiginiz 3 sayinin toplami : " + (sayi1+sayi2+sayi3));
		scan.close();
		
	}

	private static void ikiSayiTopla() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen iki sayi girin \nHer sayidan sonra enter'a basin");
		double sayi1=scan.nextDouble();
		double sayi2=scan.nextDouble();
		
		System.out.println("Girdiginiz 2 sayinin toplami : " + (sayi1+sayi2));
		scan.close();
		
	}

}
