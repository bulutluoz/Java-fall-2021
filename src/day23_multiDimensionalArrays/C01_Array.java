package day23_multiDimensionalArrays;

import java.util.Arrays;

public class C01_Array {

	public static void main(String[] args) {
		// Verilen bir array'den istenen degere sahip elementleri silip
		// kalani yeni bir array olarak kaydedin
		// ve sonra yeni array'i yazdirin
		
		int arr[]= {3,4,5,6,3,5};
		int silinecekEleman=3;
		
		// array'de yeni eleman ekleyemeyiz veya var olan elamanlari silemeyiz
		// cunku array'in declare edilen uzunlugu DEGISMEZ
		
		// Bu soruda istenen elementi sildigimizde geriye kac element kaliyor bulmamiz lazim
		// silinecek sayi adedini bulalim
		
		int sayac=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==silinecekEleman) {
				sayac++;
			}
		}
		
		System.out.println(sayac);
		int yeniArrayUzunluk= arr.length-sayac;
		
		// artik yeni array'i olusturabiliriz
		int yeniArr[]=new int[yeniArrayUzunluk]; 
		
		// simdi eski array deki elemanlari birer birer alip
		// silinecek elemana esit olmayanlari yeni array'e atamaliyiz
		// {3,4,5,6,3,5}
		int index=0;
		for (int i = 0; i < arr.length; i++) { 
			if (arr[i] != silinecekEleman) {
				
				yeniArr[index]=arr[i];
				index++;
			}
			
		}

		System.out.println(Arrays.toString(yeniArr));
	}

}
