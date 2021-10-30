package day07_IfStatements;

import java.util.Scanner;

public class C04_BasitIfCumleleri {

	public static void main(String[] args) {
		
		// Soru 4) Kullanicidan dikdortgenin kenar uzunluklarini isteyin 
		//         ve dikdortgenin kare olup olmadigini yazdirin

		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Lutfen dikdorgenin bir kenar uzunlugunu girin");
		
		double kenar1=scan.nextDouble();
		
		System.out.println("Lutfen dikdorgenin diger kenar uzunlugunu girin");
		
		double kenar2=scan.nextDouble();
		
		
		if (kenar1==kenar2) {
			System.out.println("girilen dikdortgen kare");
		}
		
		if (kenar1!=kenar2) {
			System.out.println("girilen dikdortgen kare degil");
		}
		
		scan.close();

	} // main method sonu

} // class sonu
