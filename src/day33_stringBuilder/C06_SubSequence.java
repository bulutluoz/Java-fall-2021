package day33_stringBuilder;

public class C06_SubSequence {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Java ne kadar kolay");
		
		System.out.println(sb.substring(14)); // kolay
		
		System.out.println(sb.subSequence(14, 19));// kolay
		
		// ikisi de ayni sonucu dondurur
		// ancak substring() String class'indan geldigi icin 
		// substring() kullandigimda arkasindan String method'larini kullanabilirim
		// Ancak, subSequence kullandigimda bu mumkun olmaz
		
		
		

	}

}
