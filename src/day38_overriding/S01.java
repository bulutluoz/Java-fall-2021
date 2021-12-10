package day38_overriding;

class ParentClass {
	public void getDetails(String temp) {
		System.out.println("Derived class " + temp);
	}
}

public class S01 extends ParentClass {
	public void getDetails(String temp) {
		System.out.println("Test class  " + temp);
		
	}

	public static void main(String[] args) {
		S01 obj = new S01();
		obj.getDetails("GFG");
	}
}
