package day18_nestedForLoop_whileLoop;

import java.util.Scanner;

public class H01_WhileLoop {

	public static void main(String[] args) {
		// Kullanicidan toplanmak uzere sayilar isteyin
		// sayi adedi 10'u gecerse veya toplam 500'u gecerse
		// "Bu kadar sayi yeter"
		// ".. adet sayi girdin, toplami ..." yazdirin
		
		Scanner scan=new Scanner(System.in);
	
		int sayi=0; 
		int toplam=0;
		int sayac=0;
		
		
		while (sayac<10 && toplam<500) {
			
			System.out.println("Lutfen toplama eklemek icin bir tamsayi yazin ");
			sayi=scan.nextInt();
			toplam+=sayi;
			sayac++;
						
		}
		
		System.out.println("Bu kadar sayi yeter");
		System.out.println(sayac + " adet sayi girdin, toplami: " + toplam);
		scan.close();

	}

}
