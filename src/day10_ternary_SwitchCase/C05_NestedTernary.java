package day10_ternary_SwitchCase;

public class C05_NestedTernary {

	public static void main(String[] args) {
		// Eðer çalýþan kadýnsa 60 yaþýndan büyük olduðunda emekli olabilir,
		// Çalýþan erkekse 65 yaþýndan büyükse emekli olabilir.

		// her seferinde scanner olusturmak yerine 
		// test datalarimizi variable olarak da olusturabiliriz
		// ve kodn yazimi bittiginde bu test datalarini degistirerek 
		// kodlarimizi test edebiliriz
		
		char cinsiyet ='E';
		int yas=71;
		
		String sonuc = cinsiyet=='K' ? 	(yas>=60 ? "Emekli olabilirsin":"Emekli olamazsin") :
										(yas>=65 ? "Emekli olabilirsin":"Emekli olamazsin") ;
		
		System.out.println(sonuc);

	}

}
