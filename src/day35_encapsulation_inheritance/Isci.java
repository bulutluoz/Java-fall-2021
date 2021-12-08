package day35_encapsulation_inheritance;

public class Isci extends Muhasebe {
	protected String statu;
	protected String meslegi;
	protected String Sendika;
	public Isci(){
		System.out.println("Isci parametresiz constructor calisti");
	}

	public static void main(String[] args) {
		
		Isci isci1=new Isci();
		isci1.meslegi="Kaynakci";
		isci1.saatUcreti=20;
		isci1.isim="Emine";
		isci1.maas=isci1.maasHesapla();
		System.out.println(isci1.isim +"'in maasi : " + isci1.maas);

	}
	
	

}
