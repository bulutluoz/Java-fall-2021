package day38_overriding;

class Derived01{
	public void getDetails() {
		System.out.println("Derived class ");
	}
}


public class S03 extends Derived01{
	
	public void getDetails() {
		System.out.println("Test class ");
		super.getDetails();
	}

	public static void main(String[] args) {
		
		Derived01 obj = new S03();
		obj.getDetails();
	}

}
