package day34_accessModifier_encapsulation;

public class C01 {
	
	private int sayiPrivate=10;
	int sayiDefault=20;
	protected int sayiProtected=30;
	public int sayiPublic=40;
	

	public static void main(String[] args) {
		
		C01 obj=new C01();
		System.out.println(obj.sayiPrivate);
		System.out.println(obj.sayiDefault);
		System.out.println(obj.sayiProtected);
		System.out.println(obj.sayiPublic);
	}
	
	
	public void staticOlmayanMethod() {
		C01 obj=new C01();
		System.out.println(obj.sayiPrivate);
		System.out.println(obj.sayiDefault);
		System.out.println(obj.sayiProtected);
		System.out.println(obj.sayiPublic);
	}
	
	
	
	

}
