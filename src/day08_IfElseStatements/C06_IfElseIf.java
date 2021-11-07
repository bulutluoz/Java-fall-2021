package day08_IfElseStatements;

import java.util.Scanner;

public class C06_IfElseIf {

	public static void main(String[] args) {
		// Soru 7) Kullanicidan 100 uzerinden notunu isteyin. 
		//			Not’u harf sistemine cevirip yazdirin. 
		//			50’den kucukse “D”, 
		//			50 ye esit ve buyuk  ve 60 dan kucuk ise “C”, 
		//			60 a esit ve buyuk  ve 80 dan kucuk ise “B”, 
		//			80 ve uzerinde ise “A” 


		Scanner scan=new Scanner(System.in);
        System.out.println("Lutfen notunuzu giriniz");
        
        double not=scan.nextDouble();
        
        if (not<0 || not >100) {
			System.out.println("lutfen gecerli bir not yaziniz");
		} else if(not<50){
				System.out.println("Notunuz : D");
		} else if(not<60){   				
				System.out.println("Notunuz : C");
		} else if(not<80){
			System.out.println("Notunuz : B");
		}else {
			System.out.println("Notunuz : A");
		}
        scan.close();
	}

}
