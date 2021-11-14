package day18_nestedForLoop_whileLoop;

import java.util.Scanner;

public class C02_NestedForLoop {

	public static void main(String[] args) {
		// Kullanicidan 10'dan kucuk pozitif bir tamsayi girmesini isteyin
		// girdigi sayiya gore asagidaki sekli yazdirin
		// orn : 3 girilirse
		// 1
		// 1 2
		// 1 2 3

		Scanner scan = new Scanner(System.in);
		System.out.println("lutfen 10'dan kucuk pozitif bir tam sayi girin...");
		int sayi = scan.nextInt();

		for (int satir = 1; satir <= sayi; satir++) {

			for (int i = 1; i <= satir; i++) {
				System.out.print(i + " ");
			}

			System.out.println("");
		}

		scan.close();

	}

}
