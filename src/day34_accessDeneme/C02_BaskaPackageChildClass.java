package day34_accessDeneme;

import day34_accessModifier_encapsulation.C01;

public class C02_BaskaPackageChildClass extends C01{

	public static void main(String[] args) {
		C01 obj=new C01();
		
		// System.out.println(obj.sayiPrivate);
		// System.out.println(obj.sayiDefault);
		// System.out.println(obj.sayiProtected); // main method'dan ulasamamizin sebebi static klubu ile ilgili
		System.out.println(obj.sayiPublic);
	

	}
	
	
	public void staticOlmayanMethod() {
		C01 obj=new C01();
		// System.out.println(obj.sayiDefault);
		
		System.out.println(sayiProtected); // bu class'da sayiProtected diye bir variable
											// olmadigi halde, parent class'da var oldugu icin
											// Java problem yapmadi
		
		System.out.println(obj.sayiPublic);
	}

}
