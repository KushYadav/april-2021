package bitalgorithm;

import java.util.Scanner;

public class TurnOffRightmostSetBit {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(n & (n - 1));
	}
}
