package day38_overriding;

class Super{
	
	public Integer getLength() {
		return 4;
	}
}

public class S07 {
	public Integer getLength() {
		return  5;
	}

	public static void main(String[] args) {
		Super sooper=new Super();
		S07 sub=new S07();
		System.out.println(sooper.getLength().toString() + 
				", " + sub.getLength().toString());

	}

}
