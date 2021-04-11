package bitalgorithm;

import java.util.Scanner;

public class PositionOfRightmostSetBit {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 1;

		while ((n & 1) != 1) {
			n >>>= 1;
			count++;
		}
		System.out.println(count);
	}
}
