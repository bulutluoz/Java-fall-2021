package day13_stringManipulations;

import java.util.Scanner;

public class H06_Homework {

	public static void main(String[] args) {
		/*
		 Soru 6) Kullanicidan bir sifre girmesini isteyin. 
		 Asagidaki sartlari sagliyorsa “Sifre basari ile tanimlandi”, 
		 sartlari saglamazsa “Islem basarisiz,Lutfen yeni bir sifre girin” yazdirin
			- Ilk harf buyuk harf olmali
			- Son harf kucuk harf olmali
			- Sifre bosluk icermemeli
			- Sifre uzunlugu en az 8 karakter olmali

		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Lutfen bir sifre giriniz ");
		String sifre = scan.next();
		
		// tum eksiklikleri soylemesi icin 4 sart icin ayri ayri if yapacagim
		// basta bir flag tanimlayacagim, eger onda degisim varsa sifre basarisiz
		// degisim yoksa sifre basarili olacak
		
		int flag=0;
		// - Ilk harf buyuk harf olmali
		if (!(sifre.charAt(0)>='A' && sifre.charAt(0)<='Z')) {
			System.out.println("Sifre buyuk harfle baslamalidir");
			flag++;
		}
		
		// - Son harf kucuk harf olmali

		if (!(sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z')) {
			System.out.println("Sifre kucuk harfle bitmelidir");
			flag++;
		}
		
		
		//- Sifre bosluk icermemeli
		if (sifre.contains(" ")) {
			System.out.println("Sifre bosluk icermemelidir");
			flag++;
		}
		
		// - Sifre uzunlugu en az 8 karakter olmali
		if (sifre.length()<8) {
			System.out.println("Sifre en az 8 karakter olmalidir");
			flag++;
		}
		
		// simdi flag'i kontrol edip
		// sifre basarili mi degil mi yazdiracagim
		
		if (flag==0) {
			System.out.println("Sifre basari ile tanimlandi");
		} else {
			System.out.println("Islem basarisiz,Lutfen yeni bir sifre girin");
		}
		scan.close();
		
		

	}

}
