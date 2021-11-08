package day13_stringManipulations;

import java.util.Scanner;

public class H03_Homework {

	public static void main(String[] args) {
		/*
		 Soru 3) Kullanicidan isim isteyin. Eger 
			- isim “a” harfi iceriyorsa “Girdiginiz isim a harfi iceriyor”
			- isim “Z” harfi iceriyorsa “Girdiginiz isim Z harfi iceriyor”
			- isim “a” ve  “Z” harfi iceriyorsa “Girdiginiz isim a ve Z harfi iceriyor”
			- ikisi de yoksa “Girdiginiz isim a veya Z harfi icermiyor” yazdirin

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Lutfen isminizi giriniz ");
		String isim = scan.nextLine();
		
		
		if (isim.contains("a") && isim.contains("Z")) {
			System.out.println("Girdiginiz isim a ve Z iceriyor");
		} else if(isim.contains("a")){
			System.out.println("Girdiginiz isim a iceriyor");
		}else if(isim.contains("Z")) {
			System.out.println("Girdiginiz isim Z iceriyor");
		}else {
			System.out.println("Girdiginiz isim a veya Z icermiyor");
		}
		scan.close();
	}

}
