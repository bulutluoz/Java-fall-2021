package day13_stringManipulations;

public class C03_Replace {

	public static void main(String[] args) {
		
		String str = "Java ogrenmek cok zevkli";
		
		System.out.println(str.replace(" ", "")); // Javaogrenmekcokzevkli
		
		System.out.println(str.replace("ogrenmek", "kod yazmak")); 
		
		System.out.println(str.replace("e", "a"));
		
		

	}

}
