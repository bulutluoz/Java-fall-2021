package day20_scope;

public class InstanceVar {
	
	int notMat=50;
	int notFen;
	// instance variable'larin scope'unda main method yoktur
	

	public static void main(String[] args) {
		
		// System.out.println(notMat); // main method static oldugu icin static olmayan variable'lar
									// main method'da direk kullanilamaz veya goruntulenemez
		
		// instance variable'lara main method'dan ulasmak istersek obje olusturup
		// obje uzerinden erisim saglayabiliriz
		
		// Scanner scan= new Scanner(System.in)
		// icinde oldugumuz class'dan bir obje ousturalim
		InstanceVar celil=new InstanceVar();
		
		System.out.println(celil.notMat); // 50
		
		InstanceVar nihal=new InstanceVar();
		
		nihal.notMat=70;
		
		System.out.println(nihal.notMat); // 70
		// instance variable'larda deger atamazsak java instance olarak atanan degeri alir
		// bu class icin notMat=50 gibi 
		// ama istersek deger de atayabiliriz, 
		// bu durumda deger atadigimiz obje icin yeni deger gecerli olur
		
		System.out.println(celil.notMat); // 50
		
		// celil'in notunu degistirmek istiyorsak celil.notMat' a deger atamaliyiz
		celil.notMat= 90;
		System.out.println(celil.notMat); // 90
		
		celil.method2();// method2 static olmadigi icin main method'dan direk cagrilamaz
		
	}
	
	
	public static void staticMethod() {
		// System.out.println(notFen); // instance variable'lara static method'lardan direk ulasilamaz
		
		
	}
	
	
	public void method2() {
		System.out.println("method2'deki notfen : "  + notFen); // BU method static olmadigi icin instance variable'lara ulasabilir
		// instance variable olusturulurken deger atanmasa da olur
		// bu durumda java default degerler atar
		// int icin default deger 0'dir
		notFen=100;
		System.out.println("method2'deki duzeltilmis notfen : "  + notFen);
		
	}

}
