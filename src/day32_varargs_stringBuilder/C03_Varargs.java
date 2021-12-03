package day32_varargs_stringBuilder;

public class C03_Varargs {

	public static void main(String[] args) {
		
		KafanaGoreTopla(5,10,13,0);
		


	}

	private static void KafanaGoreTopla(int sayi1, int... sayilar) {
		int toplam=0;
		
		for (int each : sayilar) {
			
			toplam+=each;
		}
		
		System.out.println("ilk sayi ile dierlerinin toplaminin carpim sonucu : " + sayi1 * toplam);
		
	}

}
