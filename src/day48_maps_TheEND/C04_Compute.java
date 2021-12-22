package day48_maps_TheEND;

import java.util.HashMap;
import java.util.Map;

public class C04_Compute {

	public static void main(String[] args) {
		Map<String, Integer> ornek= new HashMap<>();
		
		ornek.put("A", 2);
		ornek.put("B", 5);
		ornek.put("C", 1);
		ornek.put("Z", 3);
		ornek.put("K", 10);
		
		System.out.println(ornek); // {A=2, B=5, C=1, Z=3, K=10}
		
		ornek.compute("A", (key,value) -> 2*value+5);
		System.out.println(ornek); // {A=2, B=5, C=1, Z=3, K=10}
		
		
		ornek.computeIfAbsent("D", v->20 );
		ornek.computeIfAbsent("C", v->11);
		ornek.computeIfAbsent("L", k->12);
		System.out.println(ornek); //{A=9, B=5, C=1, D=20, Z=3, K=10}
		
		ornek.computeIfPresent("L", (key,value) -> 2*value+5);
		System.out.println(ornek); //
		
		

	}

}
