package bitalgorithm;

public class SameSign {

	public static void main(String[] args) {
		
		int x = 100, y = -100;
		if ((x ^ y) < 0) {
			System.out.println("Opposite Sign");
		} else {
			System.out.println("Same Sign");
		}
	}

}
