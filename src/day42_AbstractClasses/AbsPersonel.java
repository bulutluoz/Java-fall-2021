package day42_AbstractClasses;

public abstract class AbsPersonel {
	
	// class ve method'u abstract olarak tanimladigimda child class'lar mecburen
	// bu method'u override edecekler
	// 
	public abstract void statu();
	

	public abstract void abstractMethod();
	
	public void concreteMethod() {
		System.out.println("Personel class'indaki concrete method calisti");
	}

}
