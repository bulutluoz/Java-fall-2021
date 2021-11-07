package day11_stringManipulations;

public class C03_Length {

	public static void main(String[] args) {
		
		String str1= "Ali Kahyaoglu";
		
		System.out.println(str1.length()); // 13
		
		// verilen str1'in son harfini yazdirin
		
		System.out.println(str1.charAt(str1.length()-1)); // u
		
		
		String str2="";
		System.out.println(str2.length()); //0
		
		String str3=null;   // null degeri bizim bu variable'i bilerek olusturdugumuzu
							// ve bilerek deger atamadigimizi belirtiyor
		// System.out.println(str3.length()); // java.lang.NullPointerException
		
		@SuppressWarnings("unused")
		String str4;
		
		
		
		System.out.println(str3); // null
		// System.out.println(str4); // Eger String'i olusturur ama deger atamazsak yazdirdigimizda hata aliriz
		
		// null pointer olusturdugumuz fakat sonra kullanacagimiz bir String'i isaretlemek icin kullanilir
		// Bir String i yazdirdigimizda null cikiyorsa turkce olarak
		// " Ben bu degiskeni olusturdum ama henuz deger atamadim" demek istiyor
		
		
		

	}

}
