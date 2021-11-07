package day12_stringManipulations;

import java.util.Scanner;

public class C01_IndexOf {

	public static void main(String[] args) {
		// Kullanicidan bir cumle ve bir harf isteyin, 
		// harfin cumlede var olup olmadigini yazdirin
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Lutfen bir cumle giriniz");
		
		String cumle=scan.nextLine();
		System.out.println("Lutfen varligini kontrol etmek icin bir harf giriniz");
		
		char krk=scan.next().charAt(0);
		
		int index= cumle.indexOf(krk); // girilen karakterin cumledeki index'ini verir
		
		if (index==(-1)) {
			System.out.println("Girdiginiz harf verilen cumlede yok");
		} else {
			System.out.println("Girdiginiz harf verilen cumlede var");
		}

		scan.close();
	}

}
