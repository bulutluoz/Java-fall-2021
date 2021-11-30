package day29_staticBlock_passByValue;

import java.util.Arrays;

public class C04_PassByValueArray {

	public static void main(String[] args) {
		
		int sayilar[]= {3,4,5,6};
		
		elemanDegistir(sayilar);
		System.out.println("eleman degistir methodundan sonra : " + Arrays.toString(sayilar));//[10, 4, 5, 6]
		
		arrayiDegistir(sayilar);
		System.out.println("arrayi degistir methodundan sonra : " + Arrays.toString(sayilar));// [10, 4, 5, 6]

	}

	private static void arrayiDegistir(int[] sayilar) {
		sayilar= new int[6]; // [0, 0, 0, 0, 0, 0]
		System.out.println("arrayi degistir methodunda : " + Arrays.toString(sayilar));
		
	}

	private static void elemanDegistir(int[] sayilar) {
		
		sayilar[0]=10;
		System.out.println("eleman degistir methodunda : " + Arrays.toString(sayilar)); // [10, 4, 5, 6]
		
	}

}
