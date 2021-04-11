package bitalgorithm;

import java.util.Scanner;

public class TurnOfABit {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int b = scn.nextInt();

		System.out.println(Integer.toBinaryString(n));
		System.out.println(n & ~(1 << (b - 1)));
		System.out.println(Integer.toBinaryString(n & ~(1 << (b - 1))));
	}

}
