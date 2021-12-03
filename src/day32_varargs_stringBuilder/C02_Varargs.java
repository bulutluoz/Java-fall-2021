package day32_varargs_stringBuilder;

public class C02_Varargs {

	public static void main(String[] args) {
		
		topla(5,10,13,0);
		
		// varargs list gibi davranir ama 
		// array methodlari ile calisir

	}

	private static void topla(int... sayilar) {
		int toplam=0;
		
		for (int each : sayilar) {
			
			toplam+=each;
		}
		
		System.out.println("girilen sayilarin toplami : " + toplam);
		
	}

}
