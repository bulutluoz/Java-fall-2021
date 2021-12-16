package day43_Interface;

public interface C02_Interface {
	
	  void motor(); // normal class'larda access modifier yazmazsaniz java default access mo. kabul eder
	 				// interface'de ise access modifier yazmazsaniz java public olarak kabul eder
	 
	  int sayi=10; // final ve static olarak kabul etti
	  
	  
	  // interface'de body'si olan bir method yazmak isterseniz
	  // Java size 2 alternatif sunar
	  // 1- method'un basina "default" keywor yazabilirsiniz
	  //    ancak burada yazilan default access modifier degil, Javanin interface icin ozel kabul ettigi bir keyword'dur
	  
	  public default  void kaporta() {
		  System.out.println("default keyword sayesinde body olusturabildim");
		  
	  }
	  
	  public static void sanzuman() {
		  System.out.println("static keyword ile body olusturabildim");
	  }

}
