package day35_encapsulation_inheritance;

public class Muhasebe extends Personel{
	protected int saatUcreti;
	protected String statu;
	protected int maas;
	
	public Muhasebe(){
		System.out.println("Muhasebe parametresiz constructor calisti");
	}

	public static void main(String[] args) {
		
		
		Muhasebe clsn1=new Muhasebe();
		
		clsn1.isim="Ali";
		System.out.println(clsn1.soyisim); // null
		
		
		
		
		
		
		
		
		

	}
	
	
	public int maasHesapla() {
		
		int maas= 8*25*saatUcreti;
		
		return maas;
		
	}

}
