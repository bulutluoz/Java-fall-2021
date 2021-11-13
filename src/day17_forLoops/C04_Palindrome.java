package day17_forLoops;

import java.util.Scanner;

public class C04_Palindrome {

	public static void main(String[] args) {
		// Soru 9 ) Interview Question Kullanicidan bir String isteyin. 
		//			Kullanicinin girdigi String’in palindrome olup olmadigini kontrol eden bir program yazin.

		Scanner scan = new Scanner(System.in);
        System.out.println("lutfen tersten yazdirmak icin bir yazi girin...");
        String str = scan.nextLine();
        
     
        
        if (str.equals(tersineCevir(str))) {
			System.out.println("Girdiginiz String palindrome");
		}else {
			System.out.println("Girdiginiz String palindrome degil");
		}

        scan.close();
	}

	public static String tersineCevir(String str) {
		String tersStr="";
		
		for (int i = str.length()-1; i >=0; i--) {
			
			
			tersStr+=str.substring(i, i+1);
			
		}
		
		
		return tersStr;
	}

}
