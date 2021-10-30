package day06_wrapper;

public class C01_WrapperClass {

	public static void main(String[] args) {
		
		int sayi1=10;
		Integer sayi2=20;
		
		System.out.println(sayi1 +sayi2);
		
		// sayi1. yazdigimizda hic bir method cikmaz, cunku sayi1 int 'dir yani primitive dir
		// sayi2. yazdigimizda ise bircok method geliyor, cunku sayi2 Integer'dir yani wrapper class'dir
		
		String tel1="3578987";
		String tel2="3245434";
		
		System.out.println(tel1 + tel2); // 35789873245434
		
		// bu sayilari toplamak isterseniz
		
		System.out.println(Integer.valueOf(tel1)+Integer.valueOf(tel2)); // 6824421
		
		
		System.out.println(Integer.MIN_VALUE); // -2147483648
		System.out.println(Integer.MAX_VALUE); // 2147483647
		
		System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308
		System.out.println(Short.MAX_VALUE); // 32767
		
		//String caddeNo= "B203";
		String caddeNo="203";
		String sokakNo= "1564";
		
		System.out.println(Integer.valueOf(caddeNo)+Integer.valueOf(sokakNo)); 
		// Integer.valueOf(String numerik ifade) method'u string olarak kaydedilmis 
		// numerik ifadeleri sayiya cevirir
		// ancak String ifadede numerik olmayan bir karakter olursa
		// Java NumberFormatException hatasi verir ve calismayi durdurur
		// stops execution
		
		System.out.println("Hello world");

	}

}
