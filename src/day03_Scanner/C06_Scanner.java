package day03_scanner;

import java.util.Scanner;

public class C06_Scanner {

	public static void main(String[] args) {
		// Scanner isleminde String icin 2 method vardir
		// scan.next() dedigimizde sadece 1 kelime alir (ilk space'e kadar)
		// eger kullanicidan daha fazla kelime gelme ihtimali varsa
		// scan.nextLine() kullanmaliyiz
		
		// Kullanicidan isim ve soyismini ayri ayri isteyip
				// girilen ismi asagidaki gibi yazdiriniz
				
				// girilen isim : Mehmet Bulutluoz
				
				Scanner scan= new Scanner(System.in);
				
				System.out.println("Lutfen isminizi giriniz...");
				
				String isim=scan.nextLine();
				
				System.out.println("Lutfen soyisminizi yaziniz...");
				
				String soyisim=scan.nextLine();
				
				System.out.println("girilen isim : " + isim + " " + soyisim );
				scan.close();
	}

}
