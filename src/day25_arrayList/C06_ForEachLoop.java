package day25_arrayList;

import java.util.ArrayList;
import java.util.List;

public class C06_ForEachLoop {

	public static void main(String[] args) {
		// bazen index ile hic ugrasmadan bir array veya listedeki tum elemanlari
		// gozden gecirmek isteriz
		
		int arr[]= {1,2,3,5,3,2,7};
		
		// bu array'i esnek bir list yapmak istiyorum
		
		List<Integer> yeniList= new ArrayList<>();
		
		/*
		for (int i = 0; i < arr.length; i++) {
			
			yeniList.add(arr[i]);
		}
		
		System.out.println(yeniList);
		*/
		
		for (int each : arr) { // arr'deki herbir(each) int'i bana getir
			
			yeniList.add(each);
			
		}
		
		System.out.println(yeniList);
		
		// Eger bir list veya array'in tum eelemanlarini elden gecirmek istiyorsak
		// ve siralama onemli degilse
		// for-each loop kullaniriz

	}

}
