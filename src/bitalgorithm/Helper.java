package bitalgorithm;

public class Helper {

	public static void main(String[] args) {

		int a = 4;
		
		System.out.println(String.format("%32s", Integer.toBinaryString(10)).replace(' ', '0'));
		System.out.println(String.format("%32s", Integer.toBinaryString(9)).replace(' ', '0'));
		System.out.println(String.format("%32s", Integer.toBinaryString(10&9)).replace(' ', '0'));
		System.out.println(String.format("%32s", Integer.toBinaryString(12345)).replace(' ', '0'));

	}
	

}
