package day40;

public class C07_NumberFormatException {

	public static void main(String[] args) {
		
		String str ="123a";
		
		int sayi= Integer.parseInt(str) + 4;
		
		System.out.println(sayi);

	}

}
