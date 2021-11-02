package day10_ternary_SwitchCase;

public class C09_SwitchCase {

	public static void main(String[] args) {
		// Harf olarak girilen notu rakama cevirelim
		
		char not='B';
		
		switch(not) {
		
		case 'A':
			System.out.println("85 - 100 arasi");
			break;
		case 'B':
			System.out.println("60 - 85 arasi");
			break;
		case 'C':
			System.out.println("50 - 60 arasi");
			break;
		case 'D':
			System.out.println("50'den dusuk");
			break;
		default:
			System.out.println("gecersiz not");

	}

}
}
