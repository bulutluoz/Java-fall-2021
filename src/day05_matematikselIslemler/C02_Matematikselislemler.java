package day05_matematikselIslemler;

public class C02_Matematikselislemler {

	public static void main(String[] args) {
		int sayi1=10;
		int sayi2=20;
		
		String str1="Ali";
		String str2="Can";
		
		
		System.out.println(sayi1+sayi2+str1); // 30Ali
		
		
		System.out.println(str1+sayi1+sayi2); // Ali1020
		
		
		System.out.println(str2+(sayi1+sayi2)); // Can30
		
		System.out.println(sayi1*sayi2+str1); // 200Ali
		
		System.out.println(str1+sayi1*sayi1); // Ali100

	}

}
