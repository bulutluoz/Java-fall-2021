package day38_overriding;

class Derived02{
	protected  void getDetails() {
		System.out.println("Derived class ");
	}
}

public class S04 extends Derived02{
	
	protected  void getDetails() {
		System.out.println("Test class ");
	}
	

	public static void main(String[] args) {
		Derived02 obj = new Derived02();
		obj.getDetails();
	}

}
