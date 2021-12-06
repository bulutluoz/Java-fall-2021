package day34_accessModifier_encapsulation;

public class C02 {

	public static void main(String[] args) {
		C01 obj=new C01();
		// System.out.println(obj.sayiPrivate); private variable'lara kendi class'i disindan ulasilamaz
		System.out.println(obj.sayiDefault);
		System.out.println(obj.sayiProtected);
		System.out.println(obj.sayiPublic);

	}
	
	
	public void staticOlmayanMethod() {
		C01 obj=new C01();
		// System.out.println(obj.sayiPrivate);
		System.out.println(obj.sayiDefault);
		System.out.println(obj.sayiProtected);
		System.out.println(obj.sayiPublic);
	}

}
