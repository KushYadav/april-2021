package bitalgorithm;

import java.util.Scanner;

public class MutiplyWith3point5 {

	// Ignore digits after decimal

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		System.out.println((a << 2) - a + (a >> 1));
	}

}
