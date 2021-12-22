package day47_maps;

import java.util.HashMap;
import java.util.Map;

public class C02_NestedMaps {

	public static void main(String[] args) {
		// icice map olusturacaksak en icerdekinden baslamaniz tavsiye olunur
		
		Map<String,String> ogr1Map=new HashMap<>();
		ogr1Map.put("isim", "Ali");
		ogr1Map.put("soyisim", "Can");
		ogr1Map.put("brans", "J.dev");
		
		Map<String,String> ogr2Map=new HashMap<>();
		ogr2Map.put("isim", "Veli");
		ogr2Map.put("soyisim", "Yan");
		ogr2Map.put("brans", "QA");
		
		Map<String,String> ogr3Map=new HashMap<>();
		ogr3Map.put("isim", "Ali");
		ogr3Map.put("soyisim", "Yan");
		ogr3Map.put("brans", "C#");
		
		Map<String,String> ogr4Map=new HashMap<>();
		ogr4Map.put("isim", "Ayse");
		ogr4Map.put("soyisim", "Can");
		ogr4Map.put("brans", "QA");
		
		System.out.println("1. ogrenci : " + ogr1Map);
		System.out.println("2. ogrenci : " + ogr2Map);
		System.out.println("3. ogrenci : " + ogr3Map);
		System.out.println("4. ogrenci : " + ogr4Map);
		
		
		Map<Integer, Map<String,String>> sinifMap= new HashMap<>();
		
		sinifMap.put(101, ogr1Map);
		sinifMap.put(102, ogr2Map);
		sinifMap.put(103, ogr3Map);
		sinifMap.put(104, ogr4Map);
		
		System.out.println(sinifMap);
		
		/*
		 {
		 101={soyisim=Can, brans=J.dev, isim=Ali}, 
		 102={soyisim=Yan, brans=QA, isim=Veli}, 
		 103={soyisim=Yan, brans=C#, isim=Ali}, 
		 104={soyisim=Can, brans=QA, isim=Ayse}
		 }

		 
		 
		 
		 
		 */
		

	}

}
