package day09_nestedIfElse;

public class C03_Ternary {

	public static void main(String[] args) {
		
		int x=10;
		
		String tekMiCiftMi =  x%2==0 ? "cift sayi" : "tek sayi";
		
		System.out.println(tekMiCiftMi); // cift
		
		
		System.out.println(x%2==0 ? "cift sayi" : "tek sayi");
		
		// ternary iki turlu kullanilabilir
		// ya donen sonuca gore bir variable olusturup assign ederiz
		// veya direk syso icine yazip sonucu yazdiririz
		
		
		
		// eger ternary de donecek sonuclar ayni data turunden degilse
		// atama yapamayiz, sadece syso ile yazdirabiliriz
		
		System.out.println(x>5 ? "Aferin" : 4); // Aferin
		
		 // String sonuc = x>5 ? "Aferin" : 4;

	}

}
