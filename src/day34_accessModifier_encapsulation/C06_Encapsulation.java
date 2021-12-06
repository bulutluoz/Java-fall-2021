package day34_accessModifier_encapsulation;

public class C06_Encapsulation {

	public static void main(String[] args) {
		
		C05 obj1=new C05();
		System.out.println(obj1.getAsgariMaas()); // 4000
		// obj1.asgariMaas=3000;
		// C05 class'inda asgariMaas'i private yapip getter() kullandigim icin
		// asgari maasi gorebiliyorum ama degistiremiyorum
		
		// classic acces modifier'larimiz ile bir variable'a ulasabilirsek
		// istedigimiz zaman degistirme secenegimiz de olur
		

	}

}
