package day38_overriding;

public class KumesHayvanlari extends Kuslar {

	public static void main(String[] args) {
				
		KumesHayvanlari kms1= new KumesHayvanlari();
		kms1.beslenme(); // Tum hayvanlar beslenir
		kms1.hareket(); // Kumes hayvanlari yuruyerek hareket eder
		kms1.solunum(); // Kuslar akcigerleriyle nefes alir
		
		Kuslar kms2 = new KumesHayvanlari();
		
		kms2.beslenme(); // Animals==>   Tum hayvanlar beslenir
		kms2.hareket(); //  Kuslar==> Kumes hayvanlari yuruyerek hareket eder
		kms2.solunum(); //  Kuslar==> Kuslar akcigerleriyle nefes alir
		// kendi spesifik ozellikleri disinda kuslara tabi oluyor
		// ama spesifik bir durumu varsa farkini ortaya koyuyor
		
		Kuslar kms3 = new Kuslar();
		kms3.beslenme(); // Tum hayvanlar beslenir
		kms3.hareket(); //  Kuslar Ucarak hareket eder
		kms3.solunum(); //  Kuslar akcigerleriyle nefes alir
		
		
		Animals kms4 = new KumesHayvanlari();
		
		kms4.beslenme(); // Animals  Tum hayvanlar beslenir
		kms4.hareket();  // Animals  Kumes hayvanlari yuruyerek hareket eder
		kms4.solunum();  // Animals  Kuslar akcigerleriyle nefes alir
		

	}
	
	public void hareket() {
		System.out.println("Kumes hayvanlari yuruyerek hareket eder");
	}
	
	


}
