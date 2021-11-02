package day10_ternary_SwitchCase;

import java.util.Scanner;

public class C03_Ternary {

	public static void main(String[] args) {
		// Soru3 ) Kullanicidan bir sayi alin ve sayinin mutlak degerini yazdirin
		
		Scanner scan = new Scanner(System.in);
        System.out.println("Lutfen bir sayi giriniz : ");
        double sayi=scan.nextDouble();
        
        
        double mutlakDeger=sayi>=0 ? sayi : (-1)*sayi;
        
        System.out.println(mutlakDeger);
        scan.close();
	}

}
