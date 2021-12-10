package day38_overriding;

class Person{
	public void talk() {
		System.out.println("First Program");
	}
}

class Student extends Person{
	public void talk() {
		System.out.println("Second Program");
	}
}



public class S05 {

	public static void main(String[] args) {
		
		Person p=new Student();
		p.talk();
	}

}
