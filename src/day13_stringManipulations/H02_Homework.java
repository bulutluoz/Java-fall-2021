package day13_stringManipulations;

public class H02_Homework {

	public static void main(String[] args) {
		// Soru 2) String seklinde verlen asagidaki fiyatlarin toplamini bulunuz
		//		String str1 = “$13.99”
		//		String str2 = “$10.55”
		//		ipucu : Double.parseDouble() methodunu kullanabilirsiniz.

		String str1 = "$13.99";
		String str2 = "$10.55";
		
		str1=str1.replaceAll("\\W", "");
		str2=str2.replaceAll("\\W", "");
		
		double sayi1=Double.parseDouble(str1)/100;
		double sayi2=Double.parseDouble(str2)/100;
		
		
		System.out.println("Girilen degerlerin toplami : $" + (sayi1 +sayi2) );
		
		

	}

}
