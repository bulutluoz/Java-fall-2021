package day05_matematikselIslemler;

import java.util.Scanner;

public class C05_Modulus {

	public static void main(String[] args) {
		// kullanicidan 6 basamakli bir sayi alin
		// ve rakamlar toplamini bulun
		
		Scanner scan = new Scanner(System.in);
		System.out.println("lutfen 6 basamakli bir sayi giriniz");
		int sayi=scan.nextInt();
			
		
		int rakamlarToplami=0;
		int rakam=sayi%10; 	
		rakamlarToplami+=rakam; 
		sayi/=10;
		
		// bu islemi basamak sayisi kadar
		// tekrar edersek rakamlar toplamini buluruz
		rakam=sayi%10; 	
		rakamlarToplami+=rakam; 
		sayi/=10;
		
		rakam=sayi%10; 	
		rakamlarToplami+=rakam; 
		sayi/=10;
		
		rakam=sayi%10; 	
		rakamlarToplami+=rakam; 
		sayi/=10;
		
		rakam=sayi%10; 	
		rakamlarToplami+=rakam; 
		sayi/=10;
		
		rakam=sayi%10; 	
		rakamlarToplami+=rakam; 
		sayi/=10;
		
		System.out.println("Girdiginiz sayinin rakamlar toplami : " + rakamlarToplami);

		scan.close();
	}

}
