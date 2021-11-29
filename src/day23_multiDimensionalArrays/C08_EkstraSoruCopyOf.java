package day23_multiDimensionalArrays;

import java.util.Arrays;


public class C08_EkstraSoruCopyOf {

	public static void main(String[] args) {
		/*
		 P ve q boyutunda iki sýralanmýþ A ve B dizisi verildiðinde, sýralanmýþ düzeni koruyarak 
		 * A'nýn öðelerini B ile birleþtirmek için bir Java programý yazýn, yani A'yý ilk p en küçük öðelerle doldurun 
		 * ve B'yi kalan öðelerle doldurun.
            Örnek:
        Giriþ :
        int[] A = { 1, 5, 6, 7, 8, 10 }
        int[] B = { 2, 4, 9 }
        Çýkýþ:
        Sýralý Diziler:
         A: [1, 2, 4, 5, 6, 7]
         B: [8, 9, 10]
		 */
		
		int[] A = { 1, 5, 6, 7, 8, 10 };
        int[] B = { 2, 4, 9 };
        
        int birlesmis[]= Arrays.copyOf(A, A.length +B.length);
        
        System.out.println(Arrays.toString(birlesmis)); // [1, 5, 6, 7, 8, 10, 0, 0, 0]
        
        for (int i = A.length; i < birlesmis.length; i++) { // B nin elemanlarini sona ekleyelim
        	birlesmis[i]= B[i-A.length];
			
		}
		
        System.out.println(Arrays.toString(birlesmis)); // [1, 5, 6, 7, 8, 10, 2, 4, 9]
        
        Arrays.sort(birlesmis); // siralayalim
        System.out.println(Arrays.toString(birlesmis)); // [1, 2, 4, 5, 6, 7, 8, 9, 10]
        
        // A nin uzunlugu kadar elemani birlesmisten aLIP a'ya atayalim
        
        for (int i = 0; i < A.length; i++) {
        	A[i]=birlesmis[i];
			
		}
        System.out.println(Arrays.toString(A)); // [1, 2, 4, 5, 6, 7] A nin son hali
        
        // Kalan elemanlari B ye atayalim
        
        for (int i = A.length; i < birlesmis.length; i++) { // B nin elemanlarini sona ekleyelim
        	B[i-A.length]=birlesmis[i];
			
		}
        System.out.println(Arrays.toString(B)); // [8, 9, 10]B nin son hali
        



	}

}
