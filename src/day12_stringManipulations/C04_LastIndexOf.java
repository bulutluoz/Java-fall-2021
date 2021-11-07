package day12_stringManipulations;

import java.util.Scanner;

public class C04_LastIndexOf {

	public static void main(String[] args) {
		// Soru 2) Kullanicidan bir cumle ve bir kelime isteyin, 
				//		kelimenin cumledeki kullanimina bakarak asagidaki 3 cumleden uygun olani yazdirin
				//    	- Girilen kelime cumlede kullanilmamis.
				//		- Girilen kelime cumlede 1 kere kullanilmis.
				//		- Girilen kelime cumlede 1’den fazla kullanilmis.
				
				Scanner scan=new Scanner(System.in);
				System.out.println("Lutfen bir cumle giriniz");
				
				String cumle=scan.nextLine();
				System.out.println("Lutfen varligini kontrol etmek icin bir kelime giriniz");
				
				String kelime=scan.next();
				
				int ilkIndex=cumle.indexOf(kelime);
				int sonIndex=cumle.lastIndexOf(kelime);
				
				if (ilkIndex==(-1)) {
					System.out.println("Girilen kelime cumlede kullanilmamis.");
				} else if(ilkIndex==sonIndex){
					System.out.println("Girilen kelime cumlede 1 kere kullanilmis.");

				}else {
					System.out.println("Girilen kelime cumlede 1’den fazla kullanilmis.");
				}
				scan.close();
				

	}

}
