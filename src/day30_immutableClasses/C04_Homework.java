package day30_immutableClasses;

public class C04_Homework {

	public static void main(String[] args) {
		
		String a="";
		
		a+=2;
		
		a+='c';
		
		a+= false;
		
		String b="2cfalse";
		
		if (a==b) {
			 System.out.println("==");
		}
		
		if (a.equals("2cfalse")) {
			System.out.println("equals");
		}

	}

}
