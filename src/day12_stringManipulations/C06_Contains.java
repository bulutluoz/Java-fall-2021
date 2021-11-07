package day12_stringManipulations;

import java.util.Scanner;

public class C06_Contains {

	public static void main(String[] args) {
		//  Soru 1) Kullanicidan email adresini girmesini isteyin, 
		//         - mail @gmail.com icermiyorsa  “lutfen gmail adresi giriniz”, 
		//         - @gmail.com ile bitiyorsa  “Email adresiniz kaydedildi “ , 
		//         - @gmail.com ile bitmiyorsa "lutfen yazimi kontol edin" yazdirin 
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Lutfen gmail adresinizi giriniz");
		
		
		String email=scan.next();
		
		int uzunluk=email.length();
		int index=email.lastIndexOf("@gmail.com");
		
		if (!email.contains("@gmail.com")) {
			
			System.out.println("lutfen gmail adresi giriniz");
		} else if(index==uzunluk-10){
			System.out.println("Email adresiniz kaydedildi");

		}else {
			System.out.println("lutfen yazimi kontol edin");
		}
		
		
		scan.close();

	}

}
