package day40;

public class C01_exception {

	
	public static void main(String[] args) {
		
		int a=20;
		int b=0;
		
		
	
		try {
			System.out.println("sayilarin bolumu : " + a/b); 
			
		}catch (ArithmeticException e) {
			
			System.out.println("Sifira bolum yapilamaz");
			// System.out.println(e.getMessage()); //    / by zero  exception'in kaynagini
			e.printStackTrace();
			// java.lang.ArithmeticException: / by zero
			//		at day40.C01_exception.main(C01_exception.java:12)
		}

		System.out.println("Gorev tamamlandi");

	}

}
