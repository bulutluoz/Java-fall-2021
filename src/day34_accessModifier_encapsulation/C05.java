package day34_accessModifier_encapsulation;

public class C05 {
	
	private int asgariMaas=4000;

	public static void main(String[] args) {
		

	}

	public int getAsgariMaas() {
		return asgariMaas;
	}


	
	
	// bir class'daki herhangi bir class uyesine ulasilabilsin ama degistirilemesin diyorsaniz
	// 1- class uyesini PRIVATE yapin 
	// 2- private class uyelerine hic bir sekilde ulasim olmayacagi icin
	//    sadece gorebilme yetkisi verin
	//    getter() olusturun
	
}
