package day11_stringManipulations;

public class C02_EqualsIgnoreCase {

	public static void main(String[] args) {
		// equalsIgnorecase iki Stringi karsilastirirken case sensitive olmadan kiyaslama yapar
		
		String str1= "ali";
		String str2= "can";
		String str3= "Ali Can";
		String str4= str1 + " " + str2; 
		
		System.out.println(str4); // ali can
		System.out.println(str3==str4); // False hem degerler hem de referans farkli
		System.out.println(str3.equals(str4));// false degerler farkli
		
		System.out.println(str3.equalsIgnoreCase(str4)); // true icerik ayni, case sensitive degil

	}

}
