package day31_dateAndTime;

import java.time.LocalTime;
import java.time.ZoneId;

public class C02_LocalTime {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		LocalTime saat=LocalTime.now();
		
		System.out.println("baslangic saati " + saat); // 21:03:12.594366300
		
		
		int sayi=10;
		
		for (int i = 0; i < 10000; i++) {
			sayi++;
		}
		
		LocalTime saatBitis=LocalTime.now();
		System.out.println("bitis saati " + saatBitis);
		
		// Eger bir islemin baslangic be bitis zamanini kaydetmek istiyorsak
		// Hem basinda , hem de sonunda LocalTime objesi olusturmaliyiz
		
		
		double nano1=saat.getNano();
		double nanobitis=saatBitis.getNano();
		
		System.out.println("For loop " + (nanobitis-nano1) + " nano saniyede tamamlandi");
		
		
		System.out.println(saat.getMinute()); //28 
		System.out.println(saat.plusMinutes(10000)); // 20:10:10.222958200
		
		System.out.println(saat.minusHours(20)); // 01:31:40.072135
		
		
		LocalTime yerelSaat= LocalTime.now(ZoneId.of("Turkey"));
		
		System.out.println(yerelSaat); // 23:35:09.140113600
		

	}

}
